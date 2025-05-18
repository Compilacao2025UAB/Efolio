import java.util.*;
import org.antlr.v4.runtime.ParserRuleContext;
import parser.MOCBaseVisitor;
import parser.MOCParser;
import org.antlr.v4.runtime.tree.ParseTree;

// Analisador Semantico  linguagem MOCC

public class SemanticAnalyzer extends MOCBaseVisitor<String> {
    // Tabela de simbolos que mapeia nomes de variaveis/funcoes para seus simbolos
    private Map<String, Symbol> symbolTable;
    // Mapa global para manter todas as variaveis
    private Map<String, Symbol> globalSymbolTable;
    // Pilha de escopos para gerenciar variaveis locais
    private Stack<Map<String, Symbol>> scopeStack;
    // Lista de erros semanticos encontrados
    private List<String> errors;
    // Flag para verificar se existe funcao main
    private boolean hasMainFunction;
    // Nome da funcao atual sendo analisada
    private String currentFunction;
    // Mapa de tipos validos na linguagem
    private Map<String, String> typeMap;
    // Limite maximo de erros para evitar listas muito grandes
    private static final int MAX_ERRORS = 100;

    // Inicializa estrutura de dados
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

   // Define set de tipos validos, ambos para funcoes e para Variaveis
   // Previno o uso de variaveis invalidas

    private void initializeTypeMap() {
        typeMap.put("int", "int");
        typeMap.put("double", "double");
        typeMap.put("void", "void");
        typeMap.put("char", "int");  // char e tratado como int
        typeMap.put("string", "int[]");  // string e tratada como array de int
    }

   // Representa variaveis ou funcoes declaradas no codigo, guardando informacao semantica
    public static class Symbol {
        @SuppressWarnings("unused")
        String name;        // Nome do simbolo
        String type;        // Tipo do simbolo
        boolean isArray;    // Se e um array
        boolean isFunction; // Se e uma funcao
        List<String> paramTypes; // Tipos dos parametros (se for funcao)
        boolean isInitialized;   // Se foi inicializado
        @SuppressWarnings("unused")
        boolean isUsed;          // Se foi usado
        String value;            // Valor da variavel

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

    // Guarda a tabela de simbolos atual
    private void enterScope() {
        // Cria uma copia completa da tabela de simbolos atual
        Map<String, Symbol> newScope = new HashMap<>();
        for (Map.Entry<String, Symbol> entry : symbolTable.entrySet()) {
            newScope.put(entry.getKey(), entry.getValue());
        }
        scopeStack.push(symbolTable);  // Guarda a tabela atual
        symbolTable = newScope;        // Usa a copia como nova tabela
    }


    // Remove a tabela de simbolos do escopo atual
    private void exitScope() {
        if (!scopeStack.isEmpty()) {
            // Antes de restaurar o escopo anterior, salva as variaveis locais no mapa global
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
     * Adiciona um erro semantico a lista, evitando duplicados e excesso de erros.
     */
    private void addError(ParserRuleContext ctx, String message) {
        if (errors.size() >= MAX_ERRORS) {
            if (!errors.contains("Erro: Numero maximo de erros excedido")) {
                errors.add("Erro: Numero maximo de erros excedido");
            }
            return;
        }
        String errorMsg = ctx != null ?
            "Linha " + ctx.getStart().getLine() + ": " + message :
            message;
        if (!errors.contains(errorMsg)) {
            errors.add(errorMsg);
        }
    }

    /**
     * Verifica se uma variavel foi inicializada antes de ser usada.
     */
    private void checkVariableInitialized(String varName, ParserRuleContext ctx) {
        Symbol symbol = symbolTable.get(varName);
        if (symbol != null && !symbol.isInitialized) {
            addError(ctx, "Erro: Variavel '" + varName + "' nao inicializada");
        }
    }

    /**
     * Verifica se dois tipos sao compativeis (int <-> double permitido).
     */
    private boolean areTypesCompatible(String type1, String type2) {
        if (type1.equals(type2)) return true;
        if ((type1.equals("int") && type2.equals("double")) || (type1.equals("double") && type2.equals("int"))) return true;
        return false;
    }

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

    // Visita o programa atual, verifica se a funcao main existe
    @Override
    public String visitProgram(MOCParser.ProgramContext ctx) {
        // Visita todas as declaracoes de funcao
        for (MOCParser.FuncDeclarationContext decl : ctx.funcDeclaration()) {
            visit(decl);
        }
        // Visita todas as definicoes de funcao
        for (MOCParser.FuncDefinitionContext def : ctx.funcDefinition()) {
            visit(def);
        }
        // Visita todos os statements globais
        for (MOCParser.StatementContext stmt : ctx.statement()) {
            visit(stmt);
        }
        // Verifica se existe funcao main
        if (!hasMainFunction) {
            addError(ctx, "Erro: Funcao 'main' nao encontrada");
        }
        return "void";
    }

    // Funcao auxiliar para verificar se a lista de parâmetros e void
    private boolean isVoidParamList(List<String> params) {
        return params.size() == 1 && params.get(0).equals("void");
    }

    // Verifica a definao de funcoes
    @Override
    public String visitFuncDefinition(MOCParser.FuncDefinitionContext ctx) {
        String funcName = ctx.IDENTIFIER().getText();
        String returnType = ctx.funcType().getText();
        boolean hasBody = ctx.blockStatement() != null;  // declarations end in ';', defs have a block

        // Marca se e uma funcao main
        if (funcName.equals("main")) {
            hasMainFunction = true;
        }

        // ——— Prototype (declaration only) ———
        if (!hasBody) {
            Symbol existing = symbolTable.get(funcName);
            // already something by that name?
            if (existing != null) {
                if (!existing.isFunction) {
                    addError(ctx, "Erro: '" + funcName + "' ja declarado como variavel");
                } else if (existing.isInitialized) {
                    addError(ctx, "Erro: Funcao '" + funcName + "' ja foi definida");
                } else {
                    // optional: check signature matches previous prototype
                    if (!existing.type.equals(returnType))
                        addError(ctx, "Erro: Tipo de retorno incompativel com a declaracao de '" + funcName + "'");

                    int paramCount = ctx.parameterList() != null ? ctx.parameterList().parameter().size() : 0;
                    List<String> existingParamTypes = existing.paramTypes;
                    // Trata main(void) e main() como equivalentes
                    boolean paramsEquivalentes =
                        (existingParamTypes.isEmpty() && paramCount == 1 && ctx.parameterList().parameter(0).funcType().getText().equals("void")) ||
                        (paramCount == 0 && isVoidParamList(existingParamTypes)) ||
                        (existingParamTypes.size() == paramCount);
                    if (!paramsEquivalentes) {
                        addError(ctx, "Erro: Número de parâmetros incompatível com a declaracao da funcao '" + funcName + "'");
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
                addError(ctx, "Erro: '" + funcName + "' ja declarado como variavel");
                return returnType;
            }
            if (existing.isInitialized) {
                addError(ctx, "Erro: Funcao '" + funcName + "' ja foi definida");
                return returnType;
            }

            if (!existing.type.equals(returnType)) {
                addError(ctx, "Erro: Tipo de retorno incompativel com a declaracao da funcao '" + funcName + "'");
            }

            int paramCount = ctx.parameterList() != null ? ctx.parameterList().parameter().size() : 0;
            List<String> existingParamTypes = existing.paramTypes;
            // Trata main(void) e main() como equivalentes
            boolean paramsEquivalentes =
                (existingParamTypes.isEmpty() && paramCount == 1 && ctx.parameterList().parameter(0).funcType().getText().equals("void")) ||
                (paramCount == 0 && isVoidParamList(existingParamTypes)) ||
                (existingParamTypes.size() == paramCount);
            if (!paramsEquivalentes) {
                addError(ctx, "Erro: Número de parâmetros incompatível com a declaracao da funcao '" + funcName + "'");
            } else if (ctx.parameterList() != null && !existingParamTypes.isEmpty()) {
                for (int i = 0; i < existingParamTypes.size(); i++) {
                    String declared = existingParamTypes.get(i);
                    String here = ctx.parameterList().parameter(i).funcType().getText()
                            + (ctx.parameterList().parameter(i).LEFTBRACKET() != null ? "[]" : "");
                    if (!declared.equals(here)) {
                        addError(ctx, "Erro: Tipo do parâmetro " + (i+1) + " incompatível com a declaracao de '" + funcName + "'");
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
                if (p.IDENTIFIER() != null) {  // Verifica se o parametro tem um identificador
                    String pname = p.IDENTIFIER().getText();
                    String ptype = p.funcType().getText();
                    boolean isArr = p.LEFTBRACKET() != null;
                    Symbol psym = new Symbol(pname, ptype, isArr, false);
                    psym.isInitialized = true;
                    psym.isUsed = true;  // Parametros sao considerados usados
                    symbolTable.put(pname, psym);
                }
            }
        }

        visit(ctx.blockStatement());



        // Verifica se a funcao tem return quando necessário
        if (!returnType.equals("void") && !returnType.isEmpty()) {
            if (!containsReturn(ctx.blockStatement())) {
                addError(ctx, "Erro: Funcao '" + funcName +
                        "' deve retornar um valor do tipo '" + returnType + "'");
            }
        }

        existing.isInitialized = true;
        exitScope();
        currentFunction = null;

        return returnType;
    }


    // Verifica se a funcao ja foi declarada e adiciona a tabela de simbolos.
    @Override
    public String visitFuncDeclaration(MOCParser.FuncDeclarationContext ctx) {
        String funcName = ctx.IDENTIFIER().getText();
        String returnType = ctx.funcType().getText();

        // Verifica se e uma funcao main
        if (funcName.equals("main")) {
            if (hasMainFunction) {
                addError(ctx, "Erro: Funcao 'main' ja foi declarada anteriormente");
            }
            hasMainFunction = true;
        }

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


     // Verifica se variaveis ja foram declaradas e adiciona a tabela de simbolos
     @Override
     public String visitDeclaration(MOCParser.DeclarationContext ctx) {
         MOCParser.VarTypeContext varTypeCtx = ctx.varType();
         String varType = varTypeCtx.getText();

         for (MOCParser.VariableInitContext varInit : ctx.variableInit()) {
             String varName = varInit.IDENTIFIER().getText();
             boolean isArray = varInit.LEFTBRACKET() != null;
             
             // Verifica se ja existe uma variavel com este nome no escopo atual
             Symbol existingSymbol = symbolTable.get(varName);
             if (existingSymbol != null && !existingSymbol.isFunction) {
                 addError(ctx, "Erro: Variavel '" + varName + "' ja declarada no escopo atual");
                 continue;
             }
             
             Symbol varSymbol = new Symbol(varName, varType, isArray, false);

             if (isArray) {
                 // Verificar inicializacao explicita de array
                 if (varInit.arrayLiteral() != null) {
                     List<String> elementTypes = new ArrayList<>();
                     for (MOCParser.ExpressionContext expr : varInit.arrayLiteral().expressionList().expression()) {
                         elementTypes.add(visit(expr));
                     }
                     // Verificar consistência dos tipos
                     for (String type : elementTypes) {
                         String mappedType = typeMap.getOrDefault(type, type);
                         if (!mappedType.equals(varType)) {
                             addError(ctx, "Erro: Elementos do array têm tipos inconsistentes");
                         }
                     }
                     varSymbol.isInitialized = true;
                 }
             } else {
                 // Verificar inicializacao de variável simples
                 if (varInit.expression().isEmpty()) {
                     varSymbol.isInitialized = true; // Assume valor padrao
                     varSymbol.value = "0"; // Valor padrao
                 } else {
                     MOCParser.ExpressionContext exprCtx = varInit.expression().get(0);
                     String exprType = visit(exprCtx);
                     String mappedExprType = typeMap.getOrDefault(exprType, exprType);

                     if (!mappedExprType.equals(varType)) {
                         // Permite conversões implícitas
                         boolean isCompatible = false;
                         
                         // int -> double (promoção numérica)
                         if (varType.equals("double") && exprType.equals("int")) {
                             isCompatible = true;
                         }
                         
                         if (!isCompatible) {
                             addError(ctx, "Erro: Tipo incompativel na inicializacao de '" + varName + "'");
                         }
                     }
                     
                     varSymbol.value = exprCtx.getText(); // Captura o valor inicial
                     varSymbol.isInitialized = true;
                 }
             }

             symbolTable.put(varName, varSymbol);
         }
         
         return varType;
     }


    @Override
    public String visitPrimeExpr(MOCParser.PrimeExprContext ctx) {
        if (ctx.intLiteral() != null) {
            return "int";
        } else if (ctx.doubleLiteral() != null) {
            return "double";
        } else if (ctx.charLiteral() != null) {
            // Retorna "int" em vez de "char" para indicar que será convertido para ASCII
            return "int";
        } else if (ctx.stringLiteral() != null) {
            // Retorna "int[]" em vez de "string" para indicar que será convertido para array de ASCII
            return "int[]";
        } else if (ctx.IDENTIFIER() != null) {
            String varName = ctx.IDENTIFIER().getText();
            Symbol symbol = symbolTable.get(varName);
            
            if (symbol == null) {
                addError(ctx, "Erro: Variavel '" + varName + "' nao declarada");
                return "void";
            }
            
            if (ctx.LEFTBRACKET() != null) {
                if (!symbol.isArray) {
                    addError(ctx, "Erro: '" + varName + "' nao e um array");
                    return "void";
                }
                String indexType = visit(ctx.expression());
                if (!indexType.equals("int")) {
                    addError(ctx, "Erro: Indice do array deve ser do tipo 'int'");
                }
                return symbol.type.replace("[]", "");
            }
            
            return symbol.type;
        } else if (ctx.expression() != null) {
            return visit(ctx.expression());
        }
        return "void";
    }

    // Helper method to determine the return type of read functions
    private String getReadFunctionReturnType(String readFunc) {
        return switch (readFunc) {
            case "read" -> "int";
            case "readc" -> "int";
            case "reads" -> "int";
            default -> "void";
        };
    }

    // Verifica a correcao semantica da expressao.
    @Override
    public String visitExpression(MOCParser.ExpressionContext ctx) {
        return visitChildren(ctx);
    }

    // Verifica se os operandos sao do tipo correto numa adicao, permite a promocao em estilo c
    @Override
    public String visitAddExpr(MOCParser.AddExprContext ctx) {
        String resultType = visit(ctx.mulExpr(0));

        for (int i = 1; i < ctx.mulExpr().size(); i++) {
            String rightType = visit(ctx.mulExpr(i));
            // permite conversao
            if (resultType.equals("int") && rightType.equals("double") ||
                    resultType.equals("double") && rightType.equals("int")) {
                resultType = "double";
            } else if (!resultType.equals(rightType)) {
                addError(ctx, "Erro: Tipos incompativeis na operacao aritmetica");
                return "void";
            }
        }

        return resultType;
    }

     // Multiplicacao, suportando promocao
    @Override
    public String visitMulExpr(MOCParser.MulExprContext ctx) {
        String resultType = visit(ctx.unaryExpr(0));

        for (int i = 1; i < ctx.unaryExpr().size(); i++) {
            String rightType = visit(ctx.unaryExpr(i));
            // permite conversao
            if (resultType.equals("int") && rightType.equals("double") ||
                    resultType.equals("double") && rightType.equals("int")) {
                resultType = "double";
            } else if (!resultType.equals(rightType)) {
                addError(ctx, "Erro: Tipos incompativeis na operacao aritmetica");
                return "void";
            }
        }

        if (ctx.getChild(0).getText().equals("/")) {
            if (ctx.unaryExpr(1).getText().equals("0")) {
                addError(ctx, "Erro: Divisao por zero detectada, KAPUT");
            }
        }

        // Garante que a multiplicacao de inteiros retorna inteiro
        if (resultType.equals("int")) {
            return "int";
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
            // Verifica se o tipo da expressao e compativel com o tipo de retorno da funcao
            if (returnType.equals("void") || returnType.equals("")) {
                addError(ctx, "Erro: Funcao de tipo void nao pode retornar valor");
            } else if (!exprType.equals(returnType)) {
                // Permite conversao implicita de int para double
                if (!(exprType.equals("int") && returnType.equals("double"))) {
                    addError(ctx, "Erro: Tipo de retorno incompativel na funcao '" + currentFunction +
                            "'. Esperado '" + returnType + "', encontrado '" + exprType + "'");
                }
            }
        } else if (!returnType.equals("void")) {
            addError(ctx, "Erro: Funcao '" + currentFunction + "' deve retornar um valor");
        }

        return returnType;
    }

    // Visita write statements, nao permite writes vazios
    @Override
    public String visitWriteStatement(MOCParser.WriteStatementContext ctx) {
        if (ctx.expression() != null) {
            String valueType = visit(ctx.expression());
            if (!valueType.equals("int") && !valueType.equals("double") && !valueType.equals("int[]")) {
                addError(ctx, "Erro: Tipo invalido para write. Esperado 'int', 'double' ou 'int[]'");
            }
        } else {
            addError(ctx, "Erro: write() sem expressao");
        }
        return "void";
    }


    // Visita read statements
    @Override
    public String visitReadStatement(MOCParser.ReadStatementContext ctx) {
        // Determina qual funcao de leitura esta sendo usada
        String readFunction;
        if (ctx.READ() != null) {
            readFunction = ctx.READ().getText(); // "read"
        } else if (ctx.READC() != null) {
            readFunction = ctx.READC().getText(); // "readc"
        } else if (ctx.READS() != null) {
            readFunction = ctx.READS().getText(); // "reads"
        } else {
            readFunction = "read";
        }

        String varName = ctx.IDENTIFIER().getText();
        Symbol varSymbol = symbolTable.get(varName);

        if (varSymbol == null) {
            addError(ctx, "Erro: Variavel '" + varName + "' nao declarada");
            return "void";
        }

        // Mapeia funcao de leitura para o tipo esperado
        String expectedType;
        switch (readFunction) {
            case "read":
                expectedType = "int";
                break;
            case "readc":
                expectedType = "int";
                break;
            case "reads":
                expectedType = "int";
                break;
            default:
                expectedType = "void";
                addError(ctx, "Erro: Funcao de leitura '" + readFunction + "' desconhecida");
        }

        // Verifica compatibilidade de tipos
        if (!varSymbol.type.equals(expectedType)) {
            addError(ctx, "Erro: Funcao '" + readFunction + "' retorna '" + expectedType +
                    "', mas variavel '" + varName + "' e do tipo '" + varSymbol.type + "'");
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

        // Verificar conversoes permitidas
        if ((targetType.equals("int") && exprType.equals("double")) ||
                (targetType.equals("double") && exprType.equals("int")) ||
                (targetType.equals("int") && exprType.equals("int[]")) ||  // array de char para int
                (targetType.equals("int[]") && exprType.equals("int"))) {  // int para array de char
            return targetType;
        } else {
            addError(ctx, "Erro: Cast invalido de '" + exprType + "' para '" + targetType + "'");
            return "void";
        }
    }


    // Visita uma instrucao condicional. A estrutura e fixa igual a nossa gramatica
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
            enterScope(); // Cria novo escopo para variaveis do loop

            // Primeira expressao e inicializacao (ex: i = 0)
            if (ctx.expression(0) != null) {
                visit(ctx.expression(0));
            }

            // Segunda expressao e condicao (deve ser int)
            String conditionType = visit(ctx.expression(1));
            if (!conditionType.equals("int")) {
                addError(ctx, "Erro: Condicao de loop FOR deve ser do tipo 'int'");
            }

            // Terceira expressao e incremento (ex: i++)
            if (ctx.expression(2) != null) {
                visit(ctx.expression(2));
            }

            visit(ctx.blockStatement());
            exitScope(); // Sai do escopo do loop
        }
        else if (ctx.WHILE() != null) {

            String conditionType = visit(ctx.expression(0));
            if (!conditionType.equals("int")) {
                addError(ctx, "Erro: Condicao do loop WHILE deve ser do tipo 'int'");
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
        
        // Converte o tipo da expressao usando o typeMap
        String mappedExprType = typeMap.getOrDefault(exprType, exprType);

        // Verifica se e uma atribuicao a um elemento de array
        if (ctx.assignable().LEFTBRACKET() != null) {
            if (!targetSymbol.isArray) {
                addError(ctx, "Erro: '" + targetName + "' nao e um array");
                return "void";
            }
            // Remove [] do tipo do array para comparar com o tipo da expressao
            String arrayElementType = targetSymbol.type.replace("[]", "");
            if (!arrayElementType.equals(mappedExprType)) {
                addError(ctx, "Erro: Tipo incompativel na atribuicao. Esperado '" + arrayElementType + "', encontrado '" + exprType + "'");
            }
        } else {
            // Atribuicao a variavel simples
            if (!targetSymbol.type.equals(mappedExprType)) {
                // Permite conversoes implicitas
                boolean isCompatible = false;
                
                // char -> int (codigo ASCII)
                if (targetSymbol.type.equals("int") && mappedExprType.equals("int")) {
                    isCompatible = true;
                }
                // string -> int[] (array de codigos ASCII)
                else if (targetSymbol.type.equals("int[]") && mappedExprType.equals("int[]")) {
                    isCompatible = true;
                }
                // int -> double (promocao numerica)
                else if (targetSymbol.type.equals("double") && mappedExprType.equals("int")) {
                    isCompatible = true;
                }
                
                if (!isCompatible) {
                    addError(ctx, "Erro: Tipo incompativel na atribuicao. Esperado '" + targetSymbol.type + "', encontrado '" + exprType + "'");
                }
            }
        }

        targetSymbol.isInitialized = true;
        targetSymbol.isUsed = true;
        return "void";
    }

    //Verifica se existem erros semanticos.
    public boolean hasErrors() {
        return !errors.isEmpty();
    }

    // Retorna a lista de erros semanticos encontrados
    public List<String> getErrors() {
        return errors;
    }

    public Map<String, Symbol> getSymbolTable() {
        // Combina a tabela de simbolos atual com o mapa global
        Map<String, Symbol> combinedTable = new HashMap<>(globalSymbolTable);
        for (Map.Entry<String, Symbol> entry : symbolTable.entrySet()) {
            combinedTable.put(entry.getKey(), entry.getValue());
        }
        return combinedTable;
    }
}

