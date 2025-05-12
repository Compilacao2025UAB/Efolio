import java.util.*;
import org.antlr.v4.runtime.tree.*;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.ParserRuleContext;

 // Analisador Semântico  linguagem MOCC

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

   // Define set de tipos validos, ambos para funcoes e para Variaveis
   // Previno o uso de variaveis invalidas

    private void initializeTypeMap() {
        typeMap.put("int", "int");
        typeMap.put("double", "double");
        typeMap.put("void", "void");
    }

   // Represente variaveis ou funções declaradas no codigo, guardando informação semantica
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

    // Guarda a tabela de simbolos atual
    private void enterScope() {
        scopeStack.push(new HashMap<>(symbolTable));
    }


    // Remove a tabela de símbolos do escopo atual
    private void exitScope() {
        if (!scopeStack.isEmpty()) {
            symbolTable = scopeStack.pop();
        }
    }

    // Gera informaçao sobre erro semantico
    private void addError(ParserRuleContext ctx, String message) {
        int line = ctx.getStart().getLine();
        errors.add("Linha " + line + ": " + message);
    }

    // Visita o programa atual, verifica se a funçao main existe
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
            addError(ctx, "Erro: Funcao 'main' nao encontrada");
        }
        return "void";
    }

    // Verifica a definao de funcoes
    @Override
    public String visitFuncDefinition(MOCParser.FuncDefinitionContext ctx) {
        String funcName = ctx.IDENTIFIER().getText();
        String returnType = ctx.funcType().getText();
        
        // Verifica se é a função main
        if (funcName.equals("main")) {
            if (!returnType.equals("int") && !returnType.equals("double") && !returnType.equals("void")) {
                addError(ctx, "Erro: Funcao 'main' deve retornar int, double ou void");
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
        
        // Adiciona parâmetros a scope
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

    // Verifica se a função já foi declarada e adiciona à tabela de símbolos.
    @Override
    public String visitFuncDeclaration(MOCParser.FuncDeclarationContext ctx) {
        String funcName = ctx.IDENTIFIER().getText();
        String returnType = ctx.funcType().getText();
        
        if (symbolTable.containsKey(funcName)) {
            addError(ctx, "Erro: Funcao '" + funcName + "' ja foi declarada previamente");
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


     // Verifica se variaveis já foram declaradas e adiciona a tabela de simbolos
    @Override
    public String visitDeclaration(MOCParser.DeclarationContext ctx) {
        MOCParser.VarTypeContext varTypeCtx = ctx.varType(0);
        String varType = varTypeCtx.getText();

        for (MOCParser.VariableInitContext varInit : ctx.variableInit()) {
            String varName = varInit.IDENTIFIER().getText();
            boolean isArray = varInit.LEFTBRACKET() != null;

            if (symbolTable.containsKey(varName)) {
                addError(ctx, "Erro: Variavel '" + varName + "' ja declarada");
                continue;
            }

            Symbol varSymbol = new Symbol(varName, varType, isArray, false);
            symbolTable.put(varName, varSymbol);

            // Check initialization
            if (varInit.expression() != null) {
                String exprType = visit(varInit.expression());
                if (!exprType.equals(varType)) {
                    addError(ctx, "Erro: Tipo incompativel na inicializacao de '" + varName + "'");
                } else {
                    varSymbol.isInitialized = true;
                }
            }
        }

        return varType;
    }


    // Verifica literais, identificadores e expressões entre parênteses.
    @Override
    public String visitPrimeExpr(MOCParser.PrimeExprContext ctx) {
        if (ctx.INT_LITERAL() != null) {
            return "int";
        } else if (ctx.DOUBLE_LITERAL() != null) {
            return "double";
        } else if (ctx.expressionList() != null && ctx.IDENTIFIER() != null) {
            // Chamada de função
            String funcName = ctx.IDENTIFIER().getText();
            Symbol funcSymbol = symbolTable.get(funcName);

            if (funcSymbol == null) {
                addError(ctx, "Erro: Funcao '" + funcName + "' nao declarada");
                return "void";
            }

            if (!funcSymbol.isFunction) {
                addError(ctx, "Erro: '" + funcName + "' nao é uma funcao");
                return "void";
            }

            List<String> argTypes = new ArrayList<>();
            for (MOCParser.ExpressionContext expr : ctx.expressionList().expression()) {
                argTypes.add(visit(expr));
            }

            if (argTypes.size() != funcSymbol.paramTypes.size()) {
                addError(ctx, "Erro: Numero incorreto de argumentos na chamada de '" + funcName + "'");
                return funcSymbol.type;
            }

            // permite conversao ??

            for (int i = 0; i < argTypes.size(); i++) {
                String expected = funcSymbol.paramTypes.get(i);
                String actual = argTypes.get(i);
                boolean isCompatible = actual.equals(expected) || (actual.equals("int") && expected.equals("double"));

                if (!isCompatible)
                    addError(ctx, "Erro: Tipo incompativel no argumento " + (i + 1) + " da chamada de '" + funcName + "'. Esperado '" + expected + "', encontrado '" + actual + "'");
            }

            return funcSymbol.type;
        } else if (ctx.IDENTIFIER() != null) {
            String varName = ctx.IDENTIFIER().getText();
            Symbol varSymbol = symbolTable.get(varName);

            if (varSymbol == null) {
                addError(ctx, "Erro: Variavel ou funcao '" + varName + "' nao declarada");
                return "void";
            }

            varSymbol.isUsed = true;
            return varSymbol.type;
        } else if (ctx.expression() != null) {
            return visit(ctx.expression());
        }

        return "void";
    }

    // Verifica a correção semântica da expressão.
    @Override
    public String visitExpression(MOCParser.ExpressionContext ctx) {
        return visitChildren(ctx);
    }

    // Verifica se os operandos são do tipo correto numa adiçao, permite a promocao em estilo c
    @Override
    public String visitAddExpr(MOCParser.AddExprContext ctx) {
        String resultType = visit(ctx.mulExpr(0));

        for (int i = 1; i < ctx.mulExpr().size(); i++) {
            String rightType = visit(ctx.mulExpr(i));
            // permite conversão
            if (resultType.equals("int") && rightType.equals("double") ||
                    resultType.equals("double") && rightType.equals("int")) {
                resultType = "double";
            } else if (!resultType.equals(rightType)) {
                addError(ctx, "Erro: Tipos incompativeis na operaçao aritmetica");
                return "void";
            }
        }

        return resultType;
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
                addError(ctx, "Erro: Tipos incompatíveis na operação aritmética");
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
            addError(ctx, "Erro: Operador unário '-' requer tipo numérico");
            return "void";
        }
        
        return operandType;
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
            addError(ctx, "Erro: 'return' fora de uma função");
            return "void";
        }
        
        Symbol funcSymbol = symbolTable.get(currentFunction);
        String returnType = funcSymbol.type;
        
        if (ctx.expression() != null) {
            String exprType = visit(ctx.expression());
            if (!exprType.equals(returnType)) {
                addError(ctx, "Erro: Tipo de retorno incompatível na função '" + currentFunction + "'");
            }
        } else if (!returnType.equals("void")) {
            addError(ctx, "Erro: Função '" + currentFunction + "' deve retornar um valor");
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
            addError(ctx, "Erro: Variável '" + varName + "' não declarada");
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
            addError(ctx, "Erro: Condição deve ser do tipo 'int'");
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
            addError(ctx, "Erro: Condição do loop deve ser do tipo 'int'");
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