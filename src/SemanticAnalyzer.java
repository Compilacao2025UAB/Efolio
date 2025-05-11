import java.util.*;
import org.antlr.v4.runtime.tree.*;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.ParserRuleContext;

/**
 * Analisador Semântico para a linguagem MOC.
 * Responsável por verificar a correção semântica do código fonte.
 */
public class SemanticAnalyzer extends MOCBaseVisitor<String> {
    // Tabela de símbolos que mapeia nomes de variáveis/funções para seus símbolos
    private Map<String, Symbol> symbolTable;
    // Pilha de escopos para gerenciar variáveis locais
    private Stack<Map<String, Symbol>> scopeStack;
    // Lista de erros semânticos encontrados
    private List<String> errors;
    // Flag para verificar se existe função main
    private boolean hasMainFunction;
    // Nome da função atual sendo analisada
    private String currentFunction;
    // Mapa de tipos válidos na linguagem
    private Map<String, String> typeMap;

    /**
     * Construtor do analisador semântico.
     * Inicializa todas as estruturas de dados necessárias.
     */
    public SemanticAnalyzer() {
        this.symbolTable = new HashMap<>();
        this.scopeStack = new Stack<>();
        this.errors = new ArrayList<>();
        this.hasMainFunction = false;
        this.currentFunction = null;
        this.typeMap = new HashMap<>();
        initializeTypeMap();
        enterScope(); // Inicia com o escopo global
    }

    /**
     * Inicializa o mapa de tipos válidos na linguagem.
     */
    private void initializeTypeMap() {
        typeMap.put("int", "int");
        typeMap.put("double", "double");
        typeMap.put("void", "void");
    }

    /**
     * Classe interna que representa um símbolo na tabela de símbolos.
     * Pode ser uma variável ou função.
     */
    private static class Symbol {
        String name;        // Nome do símbolo
        String type;        // Tipo do símbolo
        boolean isArray;    // Se é um array
        boolean isFunction; // Se é uma função
        List<String> paramTypes; // Tipos dos parâmetros (se for função)
        boolean isInitialized;   // Se foi inicializado
        boolean isUsed;          // Se foi usado

        Symbol(String name, String type, boolean isArray, boolean isFunction) {
            this.name = name;
            this.type = type;
            this.isArray = isArray;
            this.isFunction = isFunction;
            this.paramTypes = new ArrayList<>();
            this.isInitialized = false;
            this.isUsed = false;
        }
    }

    /**
     * Entra em um novo escopo.
     * Cria uma nova tabela de símbolos para o escopo atual.
     */
    private void enterScope() {
        scopeStack.push(new HashMap<>(symbolTable));
    }

    /**
     * Sai do escopo atual.
     * Remove a tabela de símbolos do escopo atual.
     */
    private void exitScope() {
        if (!scopeStack.isEmpty()) {
            symbolTable = scopeStack.pop();
        }
    }

    /**
     * Visita o programa principal.
     * Verifica todas as declarações e definições de funções.
     */
    @Override
    public String visitProgram(MOCParser.ProgramContext ctx) {
        // Visita todas as declarações de função
        for (MOCParser.FuncDeclarationContext decl : ctx.funcDeclaration()) {
            visit(decl);
        }
        // Visita todas as definições de função
        for (MOCParser.FuncDefinitionContext def : ctx.funcDefinition()) {
            visit(def);
        }
        // Visita todos os statements globais
        for (MOCParser.StatementContext stmt : ctx.statement()) {
            visit(stmt);
        }
        // Verifica se existe função main
        if (!hasMainFunction) {
            errors.add("Erro: Função 'main' não encontrada");
        }
        return "void";
    }

    /**
     * Visita uma definição de função.
     * Verifica o tipo de retorno, parâmetros e corpo da função.
     */
    @Override
    public String visitFuncDefinition(MOCParser.FuncDefinitionContext ctx) {
        String funcName = ctx.IDENTIFIER().getText();
        String returnType = ctx.funcType().getText();
        
        // Verifica se é a função main
        if (funcName.equals("main")) {
            if (!returnType.equals("int")) {
                errors.add("Erro: Função 'main' deve retornar 'int'");
            }
            hasMainFunction = true;
        }

        currentFunction = funcName;
        Symbol funcSymbol = new Symbol(funcName, returnType, false, true);
        
        // Adiciona parâmetros à lista de tipos
        if (ctx.parameterList() != null) {
            for (MOCParser.ParameterContext param : ctx.parameterList().parameter()) {
                String paramType = param.funcType().getText();
                boolean isArray = param.LEFTBRACKET() != null;
                funcSymbol.paramTypes.add(paramType + (isArray ? "[]" : ""));
            }
        }
        
        symbolTable.put(funcName, funcSymbol);
        enterScope();
        
        // Adiciona parâmetros ao escopo
        if (ctx.parameterList() != null) {
            for (MOCParser.ParameterContext param : ctx.parameterList().parameter()) {
                String paramName = param.IDENTIFIER().getText();
                String paramType = param.funcType().getText();
                boolean isArray = param.LEFTBRACKET() != null;
                
                Symbol paramSymbol = new Symbol(paramName, paramType, isArray, false);
                paramSymbol.isInitialized = true;
                symbolTable.put(paramName, paramSymbol);
            }
        }
        
        // Visita o corpo da função
        visit(ctx.blockStatement());
        
        exitScope();
        currentFunction = null;
        
        return returnType;
    }

    /**
     * Visita uma declaração de função.
     * Verifica se a função já foi declarada e adiciona à tabela de símbolos.
     */
    @Override
    public String visitFuncDeclaration(MOCParser.FuncDeclarationContext ctx) {
        String funcName = ctx.IDENTIFIER().getText();
        String returnType = ctx.funcType().getText();
        
        if (symbolTable.containsKey(funcName)) {
            errors.add("Erro: Função '" + funcName + "' já declarada");
            return returnType;
        }
        
        Symbol funcSymbol = new Symbol(funcName, returnType, false, true);
        
        if (ctx.parameterList() != null) {
            for (MOCParser.ParameterContext param : ctx.parameterList().parameter()) {
                String paramType = param.funcType().getText();
                boolean isArray = param.LEFTBRACKET() != null;
                funcSymbol.paramTypes.add(paramType + (isArray ? "[]" : ""));
            }
        }
        
        symbolTable.put(funcName, funcSymbol);
        return returnType;
    }

    /**
     * Visita uma declaração de variável.
     * Verifica se a variável já foi declarada e adiciona à tabela de símbolos.
     */
    @Override
    public String visitVarDeclaration(MOCParser.VarDeclarationContext ctx) {
        String varName = ctx.IDENTIFIER().getText();
        String varType = ctx.funcType().getText();
        boolean isArray = ctx.LEFTBRACKET() != null;
        
        if (symbolTable.containsKey(varName)) {
            errors.add("Erro: Variável '" + varName + "' já declarada");
            return varType;
        }
        
        Symbol varSymbol = new Symbol(varName, varType, isArray, false);
        symbolTable.put(varName, varSymbol);
        
        if (ctx.expression() != null) {
            String exprType = visit(ctx.expression());
            if (!exprType.equals(varType)) {
                errors.add("Erro: Tipo incompatível na inicialização de '" + varName + "'");
            }
            varSymbol.isInitialized = true;
        }
        
        return varType;
    }

    /**
     * Visita uma atribuição.
     * Verifica se a variável existe e se os tipos são compatíveis.
     */
    @Override
    public String visitAssignment(MOCParser.AssignmentContext ctx) {
        String varName = ctx.assignable().getText();
        Symbol varSymbol = symbolTable.get(varName);
        
        if (varSymbol == null) {
            errors.add("Erro: Variável '" + varName + "' não declarada");
            return "void";
        }
        
        String exprType = visit(ctx.expression());
        if (!exprType.equals(varSymbol.type)) {
            errors.add("Erro: Tipo incompatível na atribuição de '" + varName + "'");
        }
        
        varSymbol.isInitialized = true;
        varSymbol.isUsed = true;
        return varSymbol.type;
    }

    /**
     * Visita uma expressão.
     * Verifica a correção semântica da expressão.
     */
    @Override
    public String visitExpression(MOCParser.ExpressionContext ctx) {
        return visitChildren(ctx);
    }

    /**
     * Visita uma expressão de adição.
     * Verifica se os operandos são do tipo correto.
     */
    @Override
    public String visitAddExpr(MOCParser.AddExprContext ctx) {
        String leftType = visit(ctx.mulExpr(0));
        
        for (int i = 1; i < ctx.mulExpr().size(); i++) {
            String rightType = visit(ctx.mulExpr(i));
            if (!leftType.equals(rightType)) {
                errors.add("Erro: Tipos incompatíveis na operação aritmética");
                return "void";
            }
        }
        
        return leftType;
    }

    /**
     * Visita uma expressão de multiplicação.
     * Verifica se os operandos são do tipo correto.
     */
    @Override
    public String visitMulExpr(MOCParser.MulExprContext ctx) {
        String leftType = visit(ctx.unaryExpr(0));
        
        for (int i = 1; i < ctx.unaryExpr().size(); i++) {
            String rightType = visit(ctx.unaryExpr(i));
            if (!leftType.equals(rightType)) {
                errors.add("Erro: Tipos incompatíveis na operação aritmética");
                return "void";
            }
        }
        
        return leftType;
    }

    /**
     * Visita uma expressão unária.
     * Verifica se o operando é do tipo correto.
     */
    @Override
    public String visitUnaryExpr(MOCParser.UnaryExprContext ctx) {
        if (ctx.getChildCount() == 1) {
            return visit(ctx.getChild(0));
        }
        
        String operandType = visit(ctx.getChild(1));
        if (!operandType.equals("int") && !operandType.equals("double")) {
            errors.add("Erro: Operador unário '-' requer tipo numérico");
            return "void";
        }
        
        return operandType;
    }

    /**
     * Visita uma expressão primária.
     * Verifica literais, identificadores e expressões entre parênteses.
     */
    @Override
    public String visitPrimeExpr(MOCParser.PrimeExprContext ctx) {
        if (ctx.INT_LITERAL() != null) {
            return "int";
        } else if (ctx.DOUBLE_LITERAL() != null) {
            return "double";
        } else if (ctx.IDENTIFIER() != null) {
            String varName = ctx.IDENTIFIER().getText();
            Symbol varSymbol = symbolTable.get(varName);
            
            if (varSymbol == null) {
                errors.add("Erro: Variável '" + varName + "' não declarada");
                return "void";
            }
            
            varSymbol.isUsed = true;
            return varSymbol.type;
        } else if (ctx.expression() != null) {
            return visit(ctx.expression());
        }
        
        return "void";
    }

    /**
     * Visita uma chamada de função.
     * Verifica se a função existe e se os argumentos são do tipo correto.
     */
    @Override
    public String visitFuncCall(MOCParser.FuncCallContext ctx) {
        String funcName = ctx.IDENTIFIER().getText();
        Symbol funcSymbol = symbolTable.get(funcName);
        
        if (funcSymbol == null) {
            errors.add("Erro: Função '" + funcName + "' não declarada");
            return "void";
        }
        
        if (!funcSymbol.isFunction) {
            errors.add("Erro: '" + funcName + "' não é uma função");
            return "void";
        }
        
        List<String> argTypes = new ArrayList<>();
        if (ctx.expressionList() != null) {
            for (MOCParser.ExpressionContext expr : ctx.expressionList().expression()) {
                argTypes.add(visit(expr));
            }
        }
        
        if (argTypes.size() != funcSymbol.paramTypes.size()) {
            errors.add("Erro: Número incorreto de argumentos na chamada de '" + funcName + "'");
            return funcSymbol.type;
        }
        
        for (int i = 0; i < argTypes.size(); i++) {
            if (!argTypes.get(i).equals(funcSymbol.paramTypes.get(i))) {
                errors.add("Erro: Tipo incompatível no argumento " + (i+1) + " da chamada de '" + funcName + "'");
            }
        }
        
        return funcSymbol.type;
    }

    /**
     * Visita um bloco de código.
     * Gerencia o escopo do bloco.
     */
    @Override
    public String visitBlockStatement(MOCParser.BlockStatementContext ctx) {
        enterScope();
        String result = visitChildren(ctx);
        exitScope();
        return result;
    }

    /**
     * Visita uma instrução de retorno.
     * Verifica se o tipo de retorno é compatível com o tipo da função.
     */
    @Override
    public String visitReturnStatement(MOCParser.ReturnStatementContext ctx) {
        if (currentFunction == null) {
            errors.add("Erro: 'return' fora de uma função");
            return "void";
        }
        
        Symbol funcSymbol = symbolTable.get(currentFunction);
        String returnType = funcSymbol.type;
        
        if (ctx.expression() != null) {
            String exprType = visit(ctx.expression());
            if (!exprType.equals(returnType)) {
                errors.add("Erro: Tipo de retorno incompatível na função '" + currentFunction + "'");
            }
        } else if (!returnType.equals("void")) {
            errors.add("Erro: Função '" + currentFunction + "' deve retornar um valor");
        }
        
        return returnType;
    }

    /**
     * Visita uma instrução de escrita.
     * Verifica se a expressão é válida.
     */
    @Override
    public String visitWriteStatement(MOCParser.WriteStatementContext ctx) {
        if (ctx.expression() != null) {
            visit(ctx.expression());
        }
        return "void";
    }

    /**
     * Visita uma instrução de leitura.
     * Verifica se a variável existe e é do tipo correto.
     */
    @Override
    public String visitReadStatement(MOCParser.ReadStatementContext ctx) {
        String varName = ctx.IDENTIFIER().getText();
        Symbol varSymbol = symbolTable.get(varName);
        
        if (varSymbol == null) {
            errors.add("Erro: Variável '" + varName + "' não declarada");
            return "void";
        }
        
        varSymbol.isInitialized = true;
        varSymbol.isUsed = true;
        return "void";
    }

    /**
     * Visita uma instrução condicional.
     * Verifica a condição e os blocos then/else.
     */
    @Override
    public String visitConditional(MOCParser.ConditionalContext ctx) {
        String conditionType = visit(ctx.expression());
        if (!conditionType.equals("int")) {
            errors.add("Erro: Condição deve ser do tipo 'int'");
        }
        
        visit(ctx.getChild(4)); // Bloco then
        
        if (ctx.getChildCount() > 6) {
            visit(ctx.getChild(6)); // Bloco else
        }
        
        return "void";
    }

    /**
     * Visita uma instrução de loop.
     * Verifica a condição e o corpo do loop.
     */
    @Override
    public String visitLoop(MOCParser.LoopContext ctx) {
        String conditionType = visit(ctx.expression().get(0));
        if (!conditionType.equals("int")) {
            errors.add("Erro: Condição do loop deve ser do tipo 'int'");
        }
        
        visit(ctx.getChild(4)); // Corpo do loop
        
        return "void";
    }

    /**
     * Verifica se existem erros semânticos.
     * @return true se existirem erros, false caso contrário
     */
    public boolean hasErrors() {
        return !errors.isEmpty();
    }

    /**
     * Retorna a lista de erros semânticos encontrados.
     * @return Lista de mensagens de erro
     */
    public List<String> getErrors() {
        return errors;
    }
} 