import java.util.*;
import org.antlr.v4.runtime.ParserRuleContext;
import parser.MOCBaseVisitor;
import parser.MOCParser;
import org.antlr.v4.runtime.tree.ParseTree;

/**
 * Analisador Semântico para a linguagem MOCC
 * Responsável por verificar a correção semântica do código fonte
 * e manter a tabela de símbolos durante a análise
 */
public class SemanticAnalyzer extends MOCBaseVisitor<String> {
    // Tabela de símbolos que mapeia nomes de variáveis/funções para seus símbolos
    private Map<String, Symbol> symbolTable;
    // Mapa global para manter todas as variáveis
    private Map<String, Symbol> globalSymbolTable;
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
     * Construtor do Analisador Semântico
     * Inicializa todas as estruturas de dados necessárias
     */
    public SemanticAnalyzer() {
        this.symbolTable = new HashMap<>();
        this.globalSymbolTable = new HashMap<>();
        this.scopeStack = new Stack<>();
        this.errors = new ArrayList<>();
        this.hasMainFunction = false;
        this.currentFunction = null;
        this.typeMap = new HashMap<>();
        initializeTypeMap();
        enterScope(); // Inicia com o escopo global
    }

    /**
     * Define o conjunto de tipos válidos na linguagem
     * Previne o uso de tipos inválidos em variáveis e funções
     */
    private void initializeTypeMap() {
        typeMap.put("int", "int");
        typeMap.put("double", "double");
        typeMap.put("void", "void");
        typeMap.put("char", "int");  // char é tratado como int
        typeMap.put("string", "int[]");  // string é tratada como array de int
    }

    /**
     * Classe que representa um símbolo na tabela de símbolos
     * Pode ser uma variável ou função, guardando suas informações semânticas
     */
    public static class Symbol {
        @SuppressWarnings("unused")
        String name;        // Nome do símbolo
        String type;        // Tipo do símbolo
        boolean isArray;    // Se é um array
        boolean isFunction; // Se é uma função
        List<String> paramTypes; // Tipos dos parâmetros (se for função)
        boolean isInitialized;   // Se foi inicializado
        @SuppressWarnings("unused")
        boolean isUsed;          // Se foi usado
        String value;            // Valor da variável

        /**
         * Construtor de um símbolo
         * @param name Nome do símbolo
         * @param type Tipo do símbolo
         * @param isArray Se é um array
         * @param isFunction Se é uma função
         */
        Symbol(String name, String type, boolean isArray, boolean isFunction) {
            this.name = name;
            this.type = type;
            this.isArray = isArray;
            this.isFunction = isFunction;
            this.paramTypes = new ArrayList<>();
            this.isInitialized = false;
            this.isUsed = false;
            this.value = null;
        }
    }

    /**
     * Entra em um novo escopo
     * Cria uma cópia da tabela de símbolos atual para o novo escopo
     */
    private void enterScope() {
        // Cria uma cópia completa da tabela de símbolos atual
        Map<String, Symbol> newScope = new HashMap<>();
        for (Map.Entry<String, Symbol> entry : symbolTable.entrySet()) {
            newScope.put(entry.getKey(), entry.getValue());
        }
        scopeStack.push(symbolTable);  // Guarda a tabela atual
        symbolTable = newScope;        // Usa a cópia como nova tabela
    }

    /**
     * Sai do escopo atual
     * Restaura a tabela de símbolos do escopo anterior
     */
    private void exitScope() {
        if (!scopeStack.isEmpty()) {
            // Antes de restaurar o escopo anterior, salva as variáveis locais no mapa global
            for (Map.Entry<String, Symbol> entry : symbolTable.entrySet()) {
                if (!entry.getValue().isFunction) {
                    globalSymbolTable.put(entry.getKey(), entry.getValue());
                }
            }
            // Restaura o escopo anterior
            symbolTable = scopeStack.pop();
        }
    }

    /**
     * Adiciona um erro semântico à lista de erros
     * @param ctx Contexto do parser onde o erro ocorreu
     * @param message Mensagem de erro
     */
    private void addError(ParserRuleContext ctx, String message) {
        int line = ctx.getStart().getLine();
        errors.add("Linha " + line + ": " + message);
    }

    /**
     * Verifica se uma árvore de análise contém uma instrução return
     * @param node Nó da árvore de análise
     * @return true se contém return, false caso contrário
     */
    private boolean containsReturn(ParseTree node) {
        if (node instanceof MOCParser.ReturnStatementContext) {
            return true;
        }
        for (int i = 0; i < node.getChildCount(); i++) {
            if (containsReturn(node.getChild(i))) {
                return true;
            }
        }
        return false;
    }

    /**
     * Visita o programa principal
     * Verifica a existência da função main e analisa todas as declarações e definições
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
            addError(ctx, "Erro: Função 'main' não encontrada");
        }
        return "void";
    }

    /**
     * Verifica se uma lista de parâmetros é void
     * @param params Lista de tipos de parâmetros
     * @return true se a lista representa void, false caso contrário
     */
    private boolean isVoidParamList(List<String> params) {
        return params.size() == 1 && params.get(0).equals("void");
    }

    /**
     * Verifica a definição de funções
     * Analisa a assinatura da função, seus parâmetros e corpo
     * @param ctx Contexto da definição de função
     * @return Tipo de retorno da função
     */
    @Override
    public String visitFuncDefinition(MOCParser.FuncDefinitionContext ctx) {
        String funcName = ctx.IDENTIFIER().getText();
        String returnType = ctx.funcType().getText();
        boolean hasBody = ctx.blockStatement() != null;  // declarações terminam em ';', definições têm um bloco

        // Marca se é uma função main
        if (funcName.equals("main")) {
            hasMainFunction = true;
        }

        // ——— Protótipo (apenas declaração) ———
        if (!hasBody) {
            Symbol existing = symbolTable.get(funcName);
            // Já existe algo com este nome?
            if (existing != null) {
                if (!existing.isFunction) {
                    addError(ctx, "Erro: '" + funcName + "' já declarado como variável");
                } else if (existing.isInitialized) {
                    addError(ctx, "Erro: Função '" + funcName + "' já foi definida");
                } else {
                    // Opcional: verifica se a assinatura corresponde ao protótipo anterior
                    if (!existing.type.equals(returnType))
                        addError(ctx, "Erro: Tipo de retorno incompatível com a declaração de '" + funcName + "'");

                    int paramCount = ctx.parameterList() != null ? ctx.parameterList().parameter().size() : 0;
                    List<String> existingParamTypes = existing.paramTypes;
                    // Trata main(void) e main() como equivalentes
                    boolean paramsEquivalentes =
                        (existingParamTypes.isEmpty() && paramCount == 1 && ctx.parameterList().parameter(0).funcType().getText().equals("void")) ||
                        (paramCount == 0 && isVoidParamList(existingParamTypes)) ||
                        (existingParamTypes.size() == paramCount);
                    if (!paramsEquivalentes) {
                        addError(ctx, "Erro: Número de parâmetros incompatível com a declaração da função '" + funcName + "'");
                    } else if (ctx.parameterList() != null && !existingParamTypes.isEmpty()) {
                        for (int i = 0; i < existingParamTypes.size(); i++) {
                            String declared = existingParamTypes.get(i);
                            String here = ctx.parameterList().parameter(i).funcType().getText()
                                    + (ctx.parameterList().parameter(i).LEFTBRACKET() != null ? "[]" : "");
                            if (!declared.equals(here)) {
                                addError(ctx, "Erro: Tipo do parâmetro " + (i+1) + " incompatível em '" + funcName + "'");
                            }
                        }
                    }
                }
            } else {
                // Primeira vez que vemos o protótipo: registra, mas não entra no corpo
                Symbol proto = new Symbol(funcName, returnType, /*isArray*/false, /*isFunction*/true);
                if (ctx.parameterList() != null) {
                    for (MOCParser.ParameterContext p : ctx.parameterList().parameter()) {
                        String pt = p.funcType().getText() + (p.LEFTBRACKET() != null ? "[]" : "");
                        proto.paramTypes.add(pt);
                    }
                }
                // Não marca como inicializado aqui
                symbolTable.put(funcName, proto);
            }
            return returnType;
        }

        // ——— Definição completa ———
        Symbol existing = symbolTable.get(funcName);
        if (existing != null) {
            if (!existing.isFunction) {
                addError(ctx, "Erro: '" + funcName + "' já declarado como variável");
                return returnType;
            }
            if (existing.isInitialized) {
                addError(ctx, "Erro: Função '" + funcName + "' já foi definida");
                return returnType;
            }

            if (!existing.type.equals(returnType)) {
                addError(ctx, "Erro: Tipo de retorno incompatível com a declaração da função '" + funcName + "'");
            }

            int paramCount = ctx.parameterList() != null ? ctx.parameterList().parameter().size() : 0;
            List<String> existingParamTypes = existing.paramTypes;
            // Trata main(void) e main() como equivalentes
            boolean paramsEquivalentes =
                (existingParamTypes.isEmpty() && paramCount == 1 && ctx.parameterList().parameter(0).funcType().getText().equals("void")) ||
                (paramCount == 0 && isVoidParamList(existingParamTypes)) ||
                (existingParamTypes.size() == paramCount);
            if (!paramsEquivalentes) {
                addError(ctx, "Erro: Número de parâmetros incompatível com a declaração da função '" + funcName + "'");
            } else if (ctx.parameterList() != null && !existingParamTypes.isEmpty()) {
                for (int i = 0; i < existingParamTypes.size(); i++) {
                    String declared = existingParamTypes.get(i);
                    String here = ctx.parameterList().parameter(i).funcType().getText()
                            + (ctx.parameterList().parameter(i).LEFTBRACKET() != null ? "[]" : "");
                    if (!declared.equals(here)) {
                        addError(ctx, "Erro: Tipo do parâmetro " + (i+1) + " incompatível com a declaração de '" + funcName + "'");
                    }
                }
            }
        } else {
            // Sem protótipo: cria um símbolo novo
            existing = new Symbol(funcName, returnType, /*isArray*/false, /*isFunction*/true);
            if (ctx.parameterList() != null) {
                for (MOCParser.ParameterContext p : ctx.parameterList().parameter()) {
                    existing.paramTypes.add(p.funcType().getText()
                            + (p.LEFTBRACKET() != null ? "[]" : ""));
                }
            }
            symbolTable.put(funcName, existing);
        }

        // Marca a função como inicializada
        existing.isInitialized = true;
        currentFunction = funcName;

        // Entra em um novo escopo para os parâmetros e variáveis locais
        enterScope();

        // Adiciona os parâmetros ao escopo atual
        if (ctx.parameterList() != null) {
            for (MOCParser.ParameterContext p : ctx.parameterList().parameter()) {
                String paramName = p.IDENTIFIER().getText();
                String paramType = p.funcType().getText();
                boolean isArray = p.LEFTBRACKET() != null;
                Symbol param = new Symbol(paramName, paramType, isArray, false);
                param.isInitialized = true;  // Parâmetros são considerados inicializados
                symbolTable.put(paramName, param);
            }
        }

        // Visita o corpo da função
        if (ctx.blockStatement() != null) {
            visit(ctx.blockStatement());
        }

        // Verifica se todas as funções não-void têm return
        if (!returnType.equals("void") && !containsReturn(ctx.blockStatement())) {
            addError(ctx, "Erro: Função '" + funcName + "' não retorna valor em todos os caminhos");
        }

        // Sai do escopo da função
        exitScope();
        currentFunction = null;

        return returnType;
    }

    /**
     * Verifica a declaração de funções
     * Analisa apenas a assinatura da função
     * @param ctx Contexto da declaração de função
     * @return Tipo de retorno da função
     */
    @Override
    public String visitFuncDeclaration(MOCParser.FuncDeclarationContext ctx) {
        String funcName = ctx.IDENTIFIER().getText();
        String returnType = ctx.funcType().getText();

        // Marca se é uma função main
        if (funcName.equals("main")) {
            hasMainFunction = true;
        }

        Symbol existing = symbolTable.get(funcName);
        if (existing != null) {
            if (!existing.isFunction) {
                addError(ctx, "Erro: '" + funcName + "' já declarado como variável");
            } else if (existing.isInitialized) {
                addError(ctx, "Erro: Função '" + funcName + "' já foi definida");
            } else {
                // Verifica se a assinatura corresponde ao protótipo anterior
                if (!existing.type.equals(returnType)) {
                    addError(ctx, "Erro: Tipo de retorno incompatível com a declaração de '" + funcName + "'");
                }

                int paramCount = ctx.parameterList() != null ? ctx.parameterList().parameter().size() : 0;
                List<String> existingParamTypes = existing.paramTypes;
                // Trata main(void) e main() como equivalentes
                boolean paramsEquivalentes =
                    (existingParamTypes.isEmpty() && paramCount == 1 && ctx.parameterList().parameter(0).funcType().getText().equals("void")) ||
                    (paramCount == 0 && isVoidParamList(existingParamTypes)) ||
                    (existingParamTypes.size() == paramCount);
                if (!paramsEquivalentes) {
                    addError(ctx, "Erro: Número de parâmetros incompatível com a declaração da função '" + funcName + "'");
                } else if (ctx.parameterList() != null && !existingParamTypes.isEmpty()) {
                    for (int i = 0; i < existingParamTypes.size(); i++) {
                        String declared = existingParamTypes.get(i);
                        String here = ctx.parameterList().parameter(i).funcType().getText()
                                + (ctx.parameterList().parameter(i).LEFTBRACKET() != null ? "[]" : "");
                        if (!declared.equals(here)) {
                            addError(ctx, "Erro: Tipo do parâmetro " + (i+1) + " incompatível em '" + funcName + "'");
                        }
                    }
                }
            }
        } else {
            // Primeira vez que vemos o protótipo: registra
            Symbol proto = new Symbol(funcName, returnType, /*isArray*/false, /*isFunction*/true);
            if (ctx.parameterList() != null) {
                for (MOCParser.ParameterContext p : ctx.parameterList().parameter()) {
                    String pt = p.funcType().getText() + (p.LEFTBRACKET() != null ? "[]" : "");
                    proto.paramTypes.add(pt);
                }
            }
            symbolTable.put(funcName, proto);
        }

        return returnType;
    }

    /**
     * Verifica a declaração de variáveis
     * @param ctx Contexto da declaração
     * @return Tipo da variável declarada
     */
    @Override
    public String visitDeclaration(MOCParser.DeclarationContext ctx) {
        String type = ctx.varType().getText();
        boolean isArray = ctx.variableInit().get(0).LEFTBRACKET() != null;
        String name = ctx.variableInit().get(0).IDENTIFIER().getText();

        // Verifica se o tipo é válido
        if (!typeMap.containsKey(type)) {
            addError(ctx, "Erro: Tipo '" + type + "' não é válido");
            return "void";
        }

        // Verifica se a variável já foi declarada
        Symbol existing = symbolTable.get(name);
        if (existing != null) {
            addError(ctx, "Erro: '" + name + "' já foi declarado");
            return type;
        }

        // Cria e adiciona o símbolo
        Symbol symbol = new Symbol(name, type, isArray, false);
        if (ctx.variableInit().get(0).expression() != null) {
            // Verifica a inicialização
            String initType = visit(ctx.variableInit().get(0).expression());
            if (!initType.equals(type)) {
                addError(ctx, "Erro: Tipo incompatível na inicialização de '" + name + "'");
            }
            symbol.isInitialized = true;
        }
        symbolTable.put(name, symbol);

        return type;
    }

    /**
     * Verifica expressões primárias (identificadores, literais, etc.)
     * @param ctx Contexto da expressão primária
     * @return Tipo da expressão
     */
    @Override
    public String visitPrimeExpr(MOCParser.PrimeExprContext ctx) {
        if (ctx.intLiteral() != null) {
            return "int";
        } else if (ctx.doubleLiteral() != null) {
            return "double";
        } else if (ctx.IDENTIFIER() != null) {
            String identifier = ctx.IDENTIFIER().getText();
            Symbol symbol = symbolTable.get(identifier);

            if (symbol == null) {
                addError(ctx, "Erro: Identificador '" + identifier + "' não declarado");
                return "void";
            }

            symbol.isUsed = true;

            if (ctx.LEFTPARENTESIS() != null) {
                // Caso de chamada de função
                if (!symbol.isFunction) {
                    addError(ctx, "Erro: '" + identifier + "' não é uma função");
                    return "void";
                }

                // Verifica os argumentos da chamada
                List<String> argTypes = new ArrayList<>();
                if (ctx.expressionList() != null) {
                    for (MOCParser.ExpressionContext expr : ctx.expressionList().expression()) {
                        String type = visit(expr);

                        // Verifica se o argumento é um array (nome do array)
                        Symbol argSymbol = symbolTable.get(expr.getText());
                        if (argSymbol != null && argSymbol.isArray) {
                            type = argSymbol.type + "[]"; // Ex: "double[]"
                        }

                        argTypes.add(type);
                    }
                }

                if (argTypes.size() != symbol.paramTypes.size()) {
                    addError(ctx, "Erro: Número incorreto de argumentos na chamada de '" + identifier + "'");
                    return symbol.type;
                }

                // Verifica os tipos dos argumentos
                for (int i = 0; i < argTypes.size(); i++) {
                    String argType = argTypes.get(i);
                    String paramType = symbol.paramTypes.get(i);
                    if (!argType.equals(paramType)) {
                        addError(ctx, "Erro: Tipo do argumento " + (i+1) + " incompatível em '" + identifier + "'");
                    }
                }

                return symbol.type;
            } else if (ctx.LEFTBRACKET() != null) {
                // Caso de acesso a array
                if (!symbol.isArray) {
                    addError(ctx, "Erro: '" + identifier + "' não é um array");
                    return "void";
                }

                // Verifica o índice
                String indexType = visit(ctx.expression());
                if (!indexType.equals("int")) {
                    addError(ctx, "Erro: Índice de array deve ser inteiro");
                }

                return symbol.type.substring(0, symbol.type.length() - 2); // Remove "[]"
            }

            return symbol.type;
        }

        return "void";
    }

    /**
     * Obtém o tipo de retorno de uma função de leitura
     * @param readFunc Nome da função de leitura
     * @return Tipo de retorno da função
     */
    private String getReadFunctionReturnType(String readFunc) {
        switch (readFunc) {
            case "read": return "int";
            case "readc": return "int";
            case "reads": return "int[]";
            default: return "void";
        }
    }

    /**
     * Verifica expressões
     * @param ctx Contexto da expressão
     * @return Tipo da expressão
     */
    @Override
    public String visitExpression(MOCParser.ExpressionContext ctx) {
        if (ctx.getChildCount() > 1) {
            String type = visit(ctx.getChild(1));
            if (!type.equals("int")) {
                addError(ctx, "Erro: Expressão deve ser inteira");
            }
            return "int";
        }
        return visit(ctx.getChild(0));
    }

    /**
     * Verifica expressões de adição/subtração
     * @param ctx Contexto da expressão
     * @return Tipo da expressão
     */
    @Override
    public String visitAddExpr(MOCParser.AddExprContext ctx) {
        String type = visit(ctx.mulExpr(0));
        for (int i = 1; i < ctx.mulExpr().size(); i++) {
            String rightType = visit(ctx.mulExpr(i));
            if (!type.equals(rightType)) {
                addError(ctx, "Erro: Tipos incompatíveis na operação");
                return "void";
            }
        }
        return type;
    }

    /**
     * Verifica expressões de multiplicação/divisão
     * @param ctx Contexto da expressão
     * @return Tipo da expressão
     */
    @Override
    public String visitMulExpr(MOCParser.MulExprContext ctx) {
        String type = visit(ctx.unaryExpr(0));
        for (int i = 1; i < ctx.unaryExpr().size(); i++) {
            String rightType = visit(ctx.unaryExpr(i));
            if (!type.equals(rightType)) {
                addError(ctx, "Erro: Tipos incompatíveis na operação");
                return "void";
            }
        }
        return type;
    }

    /**
     * Verifica expressões unárias
     * @param ctx Contexto da expressão
     * @return Tipo da expressão
     */
    @Override
    public String visitUnaryExpr(MOCParser.UnaryExprContext ctx) {
        if (ctx.getChildCount() > 1) {
            String type = visit(ctx.getChild(1));
            if (!type.equals("int")) {
                addError(ctx, "Erro: Operador unário requer operando inteiro");
                return "void";
            }
            return "int";
        }
        return visit(ctx.getChild(0));
    }

    /**
     * Verifica blocos de código
     * @param ctx Contexto do bloco
     * @return Tipo do bloco (sempre void)
     */
    @Override
    public String visitBlockStatement(MOCParser.BlockStatementContext ctx) {
        enterScope();
        for (MOCParser.StatementContext stmt : ctx.statement()) {
            visit(stmt);
        }
        exitScope();
        return "void";
    }

    /**
     * Verifica instruções de retorno
     * @param ctx Contexto do retorno
     * @return Tipo do retorno
     */
    @Override
    public String visitReturnStatement(MOCParser.ReturnStatementContext ctx) {
        if (currentFunction == null) {
            addError(ctx, "Erro: Return fora de função");
            return "void";
        }

        Symbol func = symbolTable.get(currentFunction);
        if (ctx.expression() != null) {
            String returnType = visit(ctx.expression());
            if (!returnType.equals(func.type)) {
                addError(ctx, "Erro: Tipo de retorno incompatível");
            }
            return returnType;
        } else if (!func.type.equals("void")) {
            addError(ctx, "Erro: Função deve retornar valor");
        }
        return func.type;
    }

    /**
     * Verifica instruções de escrita
     * @param ctx Contexto da escrita
     * @return Tipo da escrita (sempre void)
     */
    @Override
    public String visitWriteStatement(MOCParser.WriteStatementContext ctx) {
        if (ctx.expression() != null) {
            visit(ctx.expression());
        }
        return "void";
    }

    /**
     * Verifica instruções de leitura
     * @param ctx Contexto da leitura
     * @return Tipo da leitura (sempre void)
     */
    @Override
    public String visitReadStatement(MOCParser.ReadStatementContext ctx) {
        String identifier = ctx.IDENTIFIER().getText();
        Symbol symbol = symbolTable.get(identifier);

        if (symbol == null) {
            addError(ctx, "Erro: Identificador '" + identifier + "' não declarado");
            return "void";
        }

        if (symbol.isFunction) {
            addError(ctx, "Erro: '" + identifier + "' é uma função");
            return "void";
        }

        if (symbol.isArray) {
            addError(ctx, "Erro: Não é possível ler em array");
            return "void";
        }

        symbol.isInitialized = true;
        return "void";
    }

    /**
     * Verifica expressões de conversão de tipo
     * @param ctx Contexto da conversão
     * @return Tipo resultante da conversão
     */
    @Override
    public String visitCastExpr(MOCParser.CastExprContext ctx) {
        String targetType = ctx.varType().getText();
        String sourceType = visit(ctx.unaryExpr());

        if (!typeMap.containsKey(targetType)) {
            addError(ctx, "Erro: Tipo '" + targetType + "' não é válido");
            return "void";
        }

        if (!sourceType.equals("int") && !sourceType.equals("double")) {
            addError(ctx, "Erro: Conversão de tipo inválida");
            return "void";
        }

        return targetType;
    }

    /**
     * Verifica instruções condicionais (if)
     * @param ctx Contexto da condicional
     * @return Tipo da condicional (sempre void)
     */
    @Override
    public String visitConditional(MOCParser.ConditionalContext ctx) {
        String condType = visit(ctx.expression());
        if (!condType.equals("int")) {
            addError(ctx, "Erro: Condição deve ser inteira");
        }

        visit(ctx.blockStatement(0));  // Bloco then
        if (ctx.blockStatement().size() > 1) {
            visit(ctx.blockStatement(1));  // Bloco else
        }

        return "void";
    }

    /**
     * Verifica instruções de loop (while)
     * @param ctx Contexto do loop
     * @return Tipo do loop (sempre void)
     */
    @Override
    public String visitLoop(MOCParser.LoopContext ctx) {
        String condType = visit(ctx.expression().get(0));
        if (!condType.equals("int")) {
            addError(ctx, "Erro: Condição do loop deve ser inteira");
        }

        visit(ctx.blockStatement());

        return "void";
    }

    /**
     * Verifica atribuições
     * @param ctx Contexto da atribuição
     * @return Tipo da atribuição
     */
    @Override
    public String visitAssignment(MOCParser.AssignmentContext ctx) {
        String identifier = ctx.assignable().IDENTIFIER().getText();
        Symbol symbol = symbolTable.get(identifier);

        if (symbol == null) {
            addError(ctx, "Erro: Identificador '" + identifier + "' não declarado");
            return "void";
        }

        if (symbol.isFunction) {
            addError(ctx, "Erro: '" + identifier + "' é uma função");
            return "void";
        }

        if (ctx.assignable().LEFTBRACKET() != null) {
            // Atribuição em array
            if (!symbol.isArray) {
                addError(ctx, "Erro: '" + identifier + "' não é um array");
                return "void";
            }

            String indexType = visit(ctx.assignable().expression());
            if (!indexType.equals("int")) {
                addError(ctx, "Erro: Índice de array deve ser inteiro");
            }

            String valueType = visit(ctx.expression());
            String elementType = symbol.type.substring(0, symbol.type.length() - 2);
            if (!valueType.equals(elementType)) {
                addError(ctx, "Erro: Tipo incompatível na atribuição de array");
            }
        } else {
            // Atribuição simples
            String valueType = visit(ctx.expression());
            if (!valueType.equals(symbol.type)) {
                addError(ctx, "Erro: Tipo incompatível na atribuição");
            }
        }

        symbol.isInitialized = true;
        return symbol.type;
    }

    /**
     * Verifica se existem erros semânticos
     * @return true se existem erros, false caso contrário
     */
    public boolean hasErrors() {
        return !errors.isEmpty();
    }

    /**
     * Obtém a lista de erros semânticos
     * @return Lista de mensagens de erro
     */
    public List<String> getErrors() {
        return errors;
    }

    /**
     * Obtém a tabela de símbolos
     * @return Mapa com todos os símbolos
     */
    public Map<String, Symbol> getSymbolTable() {
        return symbolTable;
    }
}

