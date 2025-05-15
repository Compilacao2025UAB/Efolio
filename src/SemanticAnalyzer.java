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

    // Initializa estrutura de dados
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
        // Cria uma cópia completa da tabela de símbolos atual
        Map<String, Symbol> newScope = new HashMap<>();
        for (Map.Entry<String, Symbol> entry : symbolTable.entrySet()) {
            newScope.put(entry.getKey(), entry.getValue());
        }
        scopeStack.push(symbolTable);  // Guarda a tabela atual
        symbolTable = newScope;        // Usa a cópia como nova tabela
    }


    // Remove a tabela de símbolos do escopo atual
    private void exitScope() {
        if (!scopeStack.isEmpty()) {
            // Restaura o escopo anterior
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
        boolean hasBody = ctx.blockStatement() != null;  // declarations end in ';', defs have a block

        // ——— Prototype (declaration only) ———
        if (!hasBody) {
            Symbol existing = symbolTable.get(funcName);
            // already something by that name?
            if (existing != null) {
                if (!existing.isFunction) {
                    addError(ctx, "Erro: '" + funcName + "' já declarado como variável");
                } else if (existing.isInitialized) {
                    addError(ctx, "Erro: Função '" + funcName + "' já foi definida");
                } else {
                    // optional: check signature matches previous prototype
                    if (!existing.type.equals(returnType))
                        addError(ctx, "Erro: Tipo de retorno incompatível com a declaração de '" + funcName + "'");

                    int paramCount = ctx.parameterList() != null ? ctx.parameterList().parameter().size() : 0;
                    if (existing.paramTypes.size() != paramCount)
                        addError(ctx, "Erro: Número de parâmetros incompatível com a declaração de '" + funcName + "'");
                    else if (ctx.parameterList() != null) {
                        for (int i = 0; i < existing.paramTypes.size(); i++) {
                            String declared = existing.paramTypes.get(i);
                            String here = ctx.parameterList().parameter(i).funcType().getText()
                                    + (ctx.parameterList().parameter(i).LEFTBRACKET() != null ? "[]" : "");
                            if (!declared.equals(here)) {
                                addError(ctx, "Erro: Tipo do parâmetro " + (i+1) + " incompatível em '" + funcName + "'");
                            }
                        }
                    }
                }
            } else {
                // first time we see the prototype: record it, but don't enter its body
                Symbol proto = new Symbol(funcName, returnType, /*isArray*/false, /*isFunction*/true);
                if (ctx.parameterList() != null) {
                    for (MOCParser.ParameterContext p : ctx.parameterList().parameter()) {
                        String pt = p.funcType().getText() + (p.LEFTBRACKET() != null ? "[]" : "");
                        proto.paramTypes.add(pt);
                    }
                }
                // no isInitialized = true here
                symbolTable.put(funcName, proto);
            }
            return returnType;
        }


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
            if (existing.paramTypes.size() != paramCount) {
                addError(ctx, "Erro: Número de parâmetros incompatível com a declaração da função '" + funcName + "'");
            } else if (ctx.parameterList() != null && !existing.paramTypes.isEmpty()) {
                for (int i = 0; i < existing.paramTypes.size(); i++) {
                    String declared = existing.paramTypes.get(i);
                    String here = ctx.parameterList().parameter(i).funcType().getText()
                            + (ctx.parameterList().parameter(i).LEFTBRACKET() != null ? "[]" : "");
                    if (!declared.equals(here)) {
                        addError(ctx, "Erro: Tipo do parâmetro " + (i+1) + " incompatível com a declaração de '" + funcName + "'");
                    }
                }
            }
        } else {
            // no prototype at all: create a fresh symbol
            existing = new Symbol(funcName, returnType, /*isArray*/false, /*isFunction*/true);
            if (ctx.parameterList() != null) {
                for (MOCParser.ParameterContext p : ctx.parameterList().parameter()) {
                    existing.paramTypes.add(p.funcType().getText()
                            + (p.LEFTBRACKET() != null ? "[]" : ""));
                }
            }
            symbolTable.put(funcName, existing);
        }

        // now add it, enter its scope & params, visit body, mark initialized
        hasMainFunction |= funcName.equals("main");
        currentFunction = funcName;
        enterScope();

        if (ctx.parameterList() != null) {
            for (MOCParser.ParameterContext p : ctx.parameterList().parameter()) {
                String pname = p.IDENTIFIER().getText();
                String ptype = p.funcType().getText();
                boolean isArr = p.LEFTBRACKET() != null;
                Symbol psym = new Symbol(pname, ptype, isArr, false);
                psym.isInitialized = true;
                psym.isUsed = true;  // Parâmetros são considerados usados
                symbolTable.put(pname, psym);
            }
        }

        visit(ctx.blockStatement());
        
        // Verifica se a função tem return quando necessário
        if (!returnType.equals("void")) {
            boolean hasReturn = false;
            for (MOCParser.StatementContext stmt : ctx.blockStatement().statement()) {
                if (stmt.returnStatement() != null) {
                    hasReturn = true;
                    break;
                }
            }
            if (!hasReturn) {
                addError(ctx, "Erro: Função '" + funcName + "' deve retornar um valor do tipo '" + returnType + "'");
            }
        }
        
        existing.isInitialized = true;
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

             // Verifica se já existe uma variável com este nome no escopo atual
             Symbol existingSymbol = symbolTable.get(varName);
             if (existingSymbol != null && !existingSymbol.isFunction) {
                 addError(ctx, "Erro: Variavel '" + varName + "' ja declarada no escopo atual");
                 continue;
             }

             Symbol varSymbol = new Symbol(varName, varType, isArray, false);
             symbolTable.put(varName, varSymbol);

             if (isArray) {
                 // Verificar inicialização explícita de array
                 if (varInit.arrayLiteral() != null) {
                     List<String> elementTypes = new ArrayList<>();
                     for (MOCParser.ExpressionContext expr : varInit.arrayLiteral().expressionList().expression()) {
                         elementTypes.add(visit(expr));
                     }
                     // Verificar consistência dos tipos
                     for (String type : elementTypes) {
                         if (!type.equals(varType)) {
                             addError(ctx, "Erro: Elementos do array têm tipos inconsistentes");
                         }
                     }
                     varSymbol.isInitialized = true;
                 }
             } else {
                 // Verificar inicialização de variável simples
                 if (varInit.expression() == null) {
                     varSymbol.isInitialized = true; // Assume valor padrão
                 } else {
                     String exprType = visit(varInit.expression());
                     if (!exprType.equals(varType)) {
                         addError(ctx, "Erro: Tipo incompativel na inicializacao de '" + varName + "'");
                     } else {
                         varSymbol.isInitialized = true;
                     }
                 }
             }
         }

         return varType;
     }


    @Override
    public String visitPrimeExpr(MOCParser.PrimeExprContext ctx) {
        if (ctx.INT_LITERAL() != null) {
            return "int";
        } else if (ctx.DOUBLE_LITERAL() != null) {
            return "double";
        } else if (ctx.IDENTIFIER() != null) {
            String identifier = ctx.IDENTIFIER().getText();
            Symbol symbol = symbolTable.get(identifier);

            if (symbol == null) {
                addError(ctx, "Erro: Identificador '" + identifier + "' nao declarado");
                return "void";
            }

            symbol.isUsed = true;

            if (ctx.LEFTPARENTESIS() != null) {
                // Function call case
                if (!symbol.isFunction) {
                    addError(ctx, "Erro: '" + identifier + "' nao é uma funcao");
                    return "void";
                }

                // Check function call arguments
                List<String> argTypes = new ArrayList<>();
                if (ctx.expressionList() != null) {
                    for (MOCParser.ExpressionContext expr : ctx.expressionList().expression()) {
                        String type = visit(expr);
                        // Se o tipo for int e o símbolo for um array, adiciona []
                        if (type.equals("int")) {
                            Symbol argSymbol = symbolTable.get(expr.getText());
                            if (argSymbol != null && argSymbol.isArray) {
                                type = "int[]";
                            }
                        }
                        argTypes.add(type);
                    }
                }

                if (argTypes.size() != symbol.paramTypes.size()) {
                    addError(ctx, "Erro: Numero incorreto de argumentos na chamada de '" + identifier + "'");
                    return symbol.type;
                }

                // Check argument types
                for (int i = 0; i < argTypes.size(); i++) {
                    String expected = symbol.paramTypes.get(i);
                    String actual = argTypes.get(i);
                    boolean isCompatible = actual.equals(expected) || (actual.equals("int") && expected.equals("double"));

                    if (!isCompatible) {
                        addError(ctx, "Erro: Tipo incompativel no argumento " + (i + 1) + " da chamada de '" + identifier +
                                "'. Esperado '" + expected + "', encontrado '" + actual + "'");
                    }
                }

                if (symbol.type.equals("void")) {
                    ParserRuleContext parent = ctx.getParent();

                    // Step 1: climb until ExpressionContext
                    while (parent != null && !(parent instanceof MOCParser.ExpressionContext)) {
                        parent = parent.getParent();
                    }

                    // Step 2: climb further until StatementContext
                    ParserRuleContext exprCtx = parent;
                    while (parent != null && !(parent instanceof MOCParser.StatementContext)) {
                        parent = parent.getParent();
                    }

                    boolean usedAsValue = true;

                    // Step 3: only allow if ExpressionContext is *direct* child of StatementContext
                    if (parent instanceof MOCParser.StatementContext stmtCtx &&
                            exprCtx != null &&
                            stmtCtx.getChildCount() == 2 && // expression ';'
                            stmtCtx.getChild(0) == exprCtx) {
                        usedAsValue = false;
                    }

                    if (usedAsValue) {
                        addError(ctx, "Erro: Funcao de tipo 'void' '" + identifier + "' nao pode ser usada como valor em uma expressao");
                    }
                }

                return symbol.type;

            } else if (ctx.LEFTBRACKET() != null) {
                // Array access case
                if (!symbol.isArray) {
                    addError(ctx, "Erro: '" + identifier + "' nao é um array");
                    return "void";
                }

                // Check if the index is an integer
                String indexType = visit(ctx.expression());
                if (!indexType.equals("int")) {
                    addError(ctx, "Erro: Indice de array deve ser do tipo 'int'");
                }

                return symbol.type;

            } else {
                // Variable access case
                if (symbol.isFunction) {
                    // Se for uma função, verifica se está sendo usada como variável
                    addError(ctx, "Erro: Funcao '" + identifier + "' usada como variavel");
                    return "void";
                }

                if (!symbol.isInitialized) {
                    addError(ctx, "Erro: Variavel '" + identifier + "' usada antes de ser inicializada");
                }

                return symbol.type;
            }
        } else if (ctx.expression() != null) {
            // Parenthesized expression
            return visit(ctx.expression());
        } else if (ctx.expressionList() != null) {
            // Array literal or other expression list
            // For now, assume all elements have the same type
            String exprType = null;
            for (MOCParser.ExpressionContext expr : ctx.expressionList().expression()) {
                String currentType = visit(expr);
                if (exprType == null) {
                    exprType = currentType;
                } else if (!exprType.equals(currentType)) {
                    addError(ctx, "Erro: Tipos inconsistentes em lista de expressoes");
                    return "void";
                }
            }
            return exprType;
        } else if (ctx.readFunc() != null) {
            // Read function
            return getReadFunctionReturnType(ctx.readFunc().getText());
        }

        return "void";
    }

    // Helper method to determine the return type of read functions
    private String getReadFunctionReturnType(String readFunc) {
        return switch (readFunc) {
            case "read" -> "int";
            case "readc" -> "int";  // Assuming readc returns a character as int
            case "reads" -> "int";  // Assuming reads returns a string reference or int
            default -> "void";
        };
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

     // Multiplicação, suportando promoçao
    @Override
    public String visitMulExpr(MOCParser.MulExprContext ctx) {
        String resultType = visit(ctx.unaryExpr(0));

        for (int i = 1; i < ctx.unaryExpr().size(); i++) {
            String rightType = visit(ctx.unaryExpr(i));

            if ((resultType.equals("int") && rightType.equals("double")) ||
                    (resultType.equals("double") && rightType.equals("int"))) {
                // promoçao
                resultType = "double";
            } else if (!resultType.equals(rightType)) {
                addError(ctx, "Erro: Tipos incompativeis na operaçao aritmetica");
                return "void";
            }
        }

        if (ctx.getChild(0).getText().equals("/")) {
            if (ctx.unaryExpr(1).getText().equals("0")) {
                addError(ctx, "Erro: Divisão por zero detectada, KAPUT");
            }
        }

        return resultType;
    }

    // Visita expressoes primarias
    @Override
    public String visitUnaryExpr(MOCParser.UnaryExprContext ctx) {
        // No unary operator — just castExpr or primeExpr
        if (ctx.getChildCount() == 1) {
            return visit(ctx.getChild(0));
        }

        String operator = ctx.getChild(0).getText();
        String operandType = visit(ctx.getChild(1));

        if (operator.equals("-")) {
            if (!operandType.equals("int") && !operandType.equals("double")) {
                addError(ctx, "Erro: Operador unario '-' requer tipo numerico");
                return "void";
            }
            return operandType;
        }

        // NAO ELIMINAR para casos como !0 e !1, sendo 0 falso, supportado em C!
        if (operator.equals("!")) {
            if (!operandType.equals("int")) {
                addError(ctx, "Erro: Operador unario '!' requer tipo 'int' (como booleano)");
                return "void";
            }
            return "int";
        }

        // fallback
        return "void";
    }

    // Visita blockstatements, cria scope de bloco
    @Override
    public String visitBlockStatement(MOCParser.BlockStatementContext ctx) {
        enterScope();
        String result = visitChildren(ctx);
        exitScope();
        return result;
    }

    // Visita return functions
    // NOTA, nao permite implicit de double -> int
    @Override
    public String visitReturnStatement(MOCParser.ReturnStatementContext ctx) {
        if (currentFunction == null) {
            addError(ctx, "Erro: 'return' fora de uma funcao");
            return "void";
        }

        Symbol funcSymbol = symbolTable.get(currentFunction);
        String returnType = funcSymbol.type;

        if (ctx.expression() != null) {
            String exprType = visit(ctx.expression());
            if (!exprType.equals(returnType)) {
                addError(ctx, "Erro: Tipo de retorno incompativel na funcao '" + currentFunction + "'");
            }
        } else if (!returnType.equals("void")) {
            addError(ctx, "Erro: Funcao '" + currentFunction + "' deve retornar um valor");
        }

        return returnType;
    }

    // Visita write statements, nao permite writes vazios
    @Override
    public String visitWriteStatement(MOCParser.WriteStatementContext ctx) {
        if (ctx.WRITE() != null) {
            // Handle write() - for simple variables (int/double)
            String exprType = visit(ctx.expression());
            if (!exprType.equals("int") && !exprType.equals("double")) {
                addError(ctx, "Erro: write() requer tipo 'int' ou 'double'");
            }
        }
        else if (ctx.WRITEC() != null) {
            // Handle writec() - for character output (must be int representing ASCII)
            String exprType = visit(ctx.expression());
            if (!exprType.equals("int")) {
                addError(ctx, "Erro: writec() requer tipo 'int' (ASCII code)");
            }
        }
        else if (ctx.WRITEV() != null) {
            // Handle writev() - for array output
            String exprType = visit(ctx.expression());
            Symbol symbol = symbolTable.get(ctx.expression().getText());

            if (symbol == null || !symbol.isArray) {
                addError(ctx, "Erro: writev() requer um array como argumento");
            }
        }
        else if (ctx.WRITES() != null) {
            // Handle writes() - for strings (either string literal or char array)
            if (ctx.STRING_LITERAL() != null) {
                // String literal case - always valid
                return "void";
            }
            else if (ctx.expression() != null) {
                // Array case - must be array of int (char)
                String exprType = visit(ctx.expression());
                Symbol symbol = symbolTable.get(ctx.expression().getText());

                if (symbol == null || !symbol.isArray || !symbol.type.equals("int")) {
                    addError(ctx, "Erro: writes() requer string literal ou array de 'int'");
                }
            }
            else {
                addError(ctx, "Erro: writes() requer argumento");
            }
        }

        return "void";
    }


    // Visita read statements
    @Override
    public String visitReadStatement(MOCParser.ReadStatementContext ctx) {
        // Determina qual função de leitura está sendo usada
        String readFunction;
        if (ctx.READ() != null) {
            readFunction = ctx.READ().getText(); // "read"
        } else if (ctx.READC() != null) {
            readFunction = ctx.READC().getText(); // "readc"
        } else if (ctx.READS() != null) {
            readFunction = ctx.READS().getText(); // "reads"
        } else {
            readFunction = "read"; // padrão (não deve acontecer)
        }

        String varName = ctx.IDENTIFIER().getText();
        Symbol varSymbol = symbolTable.get(varName);

        if (varSymbol == null) {
            addError(ctx, "Erro: Variável '" + varName + "' não declarada");
            return "void";
        }

        // Mapeia função de leitura para o tipo esperado
        String expectedType;
        switch (readFunction) {
            case "read":
                expectedType = "int";
                break;
            case "readc":
                expectedType = "int"; // ou "char" se sua linguagem suportar
                break;
            case "reads":
                expectedType = "int"; // assumindo que retorna um inteiro (como tamanho)
                break;
            default:
                expectedType = "void";
                addError(ctx, "Erro: Função de leitura '" + readFunction + "' desconhecida");
        }

        // Verifica compatibilidade de tipos
        if (!varSymbol.type.equals(expectedType)) {
            addError(ctx, "Erro: Função '" + readFunction + "' retorna '" + expectedType +
                    "', mas variável '" + varName + "' é do tipo '" + varSymbol.type + "'");
        }

        varSymbol.isInitialized = true;
        varSymbol.isUsed = true;
        return "void";
    }

    @Override
    public String visitCastExpr(MOCParser.CastExprContext ctx) {
        // Get the target type from varType (not funcType)
        String targetType = ctx.varType().getText();

        // Get the expression type from unaryExpr (not expression)
        String exprType = visit(ctx.unaryExpr());

        // Verificar conversões permitidas
        if ((targetType.equals("int") && exprType.equals("double")) ||
                (targetType.equals("double") && exprType.equals("int"))) {
            return targetType;
        } else {
            addError(ctx, "Erro: Cast invalido de '" + exprType + "' para '" + targetType + "'");
            return "void";
        }
    }


    // Visita uma instrução condicional. A estrutura é fixa igual a nossa gramatica
    @Override
    public String visitConditional(MOCParser.ConditionalContext ctx) {
        String conditionType = visit(ctx.expression());
        // NAO ELIMIAR, Exemplos como int x = 5; if (x) Baseado em C
        if (!conditionType.equals("int")) {
            addError(ctx, "Erro: Condicao deve ser do tipo 'int'");
        }

        if (!ctx.getChild(4).getText().startsWith("{")) {
            addError(ctx, "Erro: Bloco do 'if' deve estar entre {}");
        }
        if (ctx.getChildCount() > 6 && !ctx.getChild(6).getText().startsWith("{")) {
            addError(ctx, "Erro: Bloco do 'else' deve estar entre {}");
        }

        // Bloco then
        visit(ctx.getChild(4));

        // Bloco else
        if (ctx.getChildCount() > 6) {
            visit(ctx.getChild(6));
        }

        return "void";
    }

    @Override
    public String visitLoop(MOCParser.LoopContext ctx) {
        if (ctx.FOR() != null) {
            enterScope(); // Create new scope for potential loop variables

            // First expression is initialization (e.g., i = 0)
            if (ctx.expression(0) != null) {
                visit(ctx.expression(0));
            }

            // Second expression is condition (must be int)
            String conditionType = visit(ctx.expression(1));
            if (!conditionType.equals("int")) {
                addError(ctx, "Erro: Condiçao de loop FOR deve ser do tipo 'int'");
            }

            // Third expression is increment (e.g., i++)
            if (ctx.expression(2) != null) {
                visit(ctx.expression(2));
            }

            visit(ctx.blockStatement());
            exitScope(); // Exit the loop scope
        }
        else if (ctx.WHILE() != null) {
            // WHILE loop - only condition check
            String conditionType = visit(ctx.expression(0));
            if (!conditionType.equals("int")) {
                addError(ctx, "Erro: Condiçao do loop WHILE deve ser do tipo 'int'");
            }
            visit(ctx.blockStatement());
        }

        return "void";
    }

    @Override
    public String visitAssignment(MOCParser.AssignmentContext ctx) {
        String targetName = ctx.assignable().IDENTIFIER().getText();
        Symbol targetSymbol = symbolTable.get(targetName);

        if (targetSymbol == null) {
            addError(ctx, "Erro: Variavel '" + targetName + "' nao declarada");
            return "void";
        }

        String exprType = visit(ctx.expression());

        // Verifica se é uma atribuição a um elemento de array
        if (ctx.assignable().LEFTBRACKET() != null) {
            if (!targetSymbol.isArray) {
                addError(ctx, "Erro: '" + targetName + "' nao é um array");
                return "void";
            }
            // Remove [] do tipo do array para comparar com o tipo da expressão
            String arrayElementType = targetSymbol.type.replace("[]", "");
            if (!arrayElementType.equals(exprType)) {
                addError(ctx, "Erro: Tipo incompativel na atribuicao. Esperado '" + arrayElementType + "', encontrado '" + exprType + "'");
            }
        } else {
            // Atribuição a variável simples
            if (!targetSymbol.type.equals(exprType)) {
                addError(ctx, "Erro: Tipo incompativel na atribuicao. Esperado '" + targetSymbol.type + "', encontrado '" + exprType + "'");
            }
        }

        targetSymbol.isInitialized = true;
        targetSymbol.isUsed = true;
        return "void";
    }

    //Verifica se existem erros semânticos.

    public boolean hasErrors() {
        return !errors.isEmpty();
    }

    // Retorna a lista de erros semanticos encontrados
    public List<String> getErrors() {
        return errors;
    }
}

