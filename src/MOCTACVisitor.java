import org.antlr.v4.runtime.tree.ParseTree;
import java.util.Stack;
import parser.MOCBaseVisitor;
import parser.MOCParser;
import java.util.Map;

public class MOCTACVisitor extends MOCBaseVisitor<String> {
    private TACGenerator generator;
    private Stack<String> valueStack;

    public MOCTACVisitor() {
        this.generator = new TACGenerator();
        this.valueStack = new Stack<>();
    }

    public void setSymbolTable(Map<String, SemanticAnalyzer.Symbol> symbolTable) {
        for (Map.Entry<String, SemanticAnalyzer.Symbol> entry : symbolTable.entrySet()) {
            SemanticAnalyzer.Symbol symbol = entry.getValue();
            if (!symbol.isFunction) {
                String type = symbol.type;
                if (symbol.isArray) {
                    type = type + "[]";
                }
                
                // Adiciona a variável à tabela de símbolos
                generator.addSymbol(entry.getKey(), type);
                
                // Se a variável tem um valor inicial, adiciona uma instrução de atribuição
                if (symbol.value != null) {
                    generator.addInstruction(new TACInstruction(
                        TACInstruction.OpType.ASSIGN,
                        entry.getKey(),
                        symbol.value,
                        null
                    ));
                }
            }
        }
    }

    @Override
    public String visitProgram(MOCParser.ProgramContext ctx) {
        for (ParseTree child : ctx.children) {
            visit(child);
        }
        return null;
    }

    @Override
    public String visitStatement(MOCParser.StatementContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public String visitBlockStatement(MOCParser.BlockStatementContext ctx) {
        for (ParseTree child : ctx.children) {
            visit(child);
        }
        return null;
    }

    @Override
    public String visitAssignment(MOCParser.AssignmentContext ctx) {
        String value = visit(ctx.expression());
        String target = ctx.assignable().getText();
        generator.addInstruction(new TACInstruction(
            TACInstruction.OpType.ASSIGN,
            target,
            value,
            null
        ));
        return null;
    }

    @Override
    public String visitExpression(MOCParser.ExpressionContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public String visitAddExpr(MOCParser.AddExprContext ctx) {
        String result = generator.newTemp();
        String left = visit(ctx.mulExpr(0));
        
        for (int i = 1; i < ctx.mulExpr().size(); i++) {
            String right = visit(ctx.mulExpr(i));
            String op = ctx.getChild(2*i-1).getText();
            
            TACInstruction.OpType opType = op.equals("+") ? 
                TACInstruction.OpType.ADD : TACInstruction.OpType.SUB;
            
            generator.addInstruction(new TACInstruction(
                opType,
                result,
                left,
                right
            ));
            left = result;
            result = generator.newTemp();
        }
        
        valueStack.push(left);
        return left;
    }

    @Override
    public String visitMulExpr(MOCParser.MulExprContext ctx) {
        String result = generator.newTemp();
        String left = visit(ctx.unaryExpr(0));
        
        for (int i = 1; i < ctx.unaryExpr().size(); i++) {
            String right = visit(ctx.unaryExpr(i));
            String op = ctx.getChild(2*i-1).getText();
            
            TACInstruction.OpType opType;
            switch (op) {
                case "*": opType = TACInstruction.OpType.MUL; break;
                case "/": opType = TACInstruction.OpType.DIV; break;
                default: opType = TACInstruction.OpType.MOD;
            }
            
            generator.addInstruction(new TACInstruction(
                opType,
                result,
                left,
                right
            ));
            left = result;
            result = generator.newTemp();
        }
        
        valueStack.push(left);
        return left;
    }

    @Override
    public String visitUnaryExpr(MOCParser.UnaryExprContext ctx) {
        if (ctx.getChildCount() == 1) {
            return visit(ctx.getChild(0));
        }
        
        String result = generator.newTemp();
        String operand = visit(ctx.getChild(1));
        
        generator.addInstruction(new TACInstruction(
            TACInstruction.OpType.SUB,
            result,
            "0",
            operand
        ));
        
        return result;
    }

    @Override
    public String visitOrExpr(MOCParser.OrExprContext ctx) {
        String result = generator.newTemp();
        String left = visit(ctx.andExpr(0));
        
        for (int i = 1; i < ctx.andExpr().size(); i++) {
            String right = visit(ctx.andExpr(i));
            
            generator.addInstruction(new TACInstruction(
                TACInstruction.OpType.OR,
                result,
                left,
                right
            ));
            left = result;
            result = generator.newTemp();
        }
        
        valueStack.push(left);
        return left;
    }

    @Override
    public String visitAndExpr(MOCParser.AndExprContext ctx) {
        String result = generator.newTemp();
        String left = visit(ctx.relExpr(0));
        
        for (int i = 1; i < ctx.relExpr().size(); i++) {
            String right = visit(ctx.relExpr(i));
            
            generator.addInstruction(new TACInstruction(
                TACInstruction.OpType.AND,
                result,
                left,
                right
            ));
            left = result;
            result = generator.newTemp();
        }
        
        valueStack.push(left);
        return left;
    }

    @Override
    public String visitRelExpr(MOCParser.RelExprContext ctx) {
        String result = generator.newTemp();
        String left = visit(ctx.addExpr(0));
        
        for (int i = 1; i < ctx.addExpr().size(); i++) {
            String right = visit(ctx.addExpr(i));
            String op = ctx.getChild(2*i-1).getText();
            
            TACInstruction.OpType opType;
            switch (op) {
                case "<": opType = TACInstruction.OpType.LT; break;
                case ">": opType = TACInstruction.OpType.GT; break;
                case "<=": opType = TACInstruction.OpType.LEQ; break;
                case ">=": opType = TACInstruction.OpType.GEQ; break;
                case "==": opType = TACInstruction.OpType.EQUAL; break;
                default: opType = TACInstruction.OpType.NOTEQUAL;
            }
            
            generator.addInstruction(new TACInstruction(
                opType,
                result,
                left,
                right
            ));
            left = result;
            result = generator.newTemp();
        }
        
        valueStack.push(left);
        return left;
    }

    @Override
    public String visitCastExpr(MOCParser.CastExprContext ctx) {
        String result = generator.newTemp();
        String value = visit(ctx.unaryExpr());
        String type = ctx.varType().getText();
        
        generator.addInstruction(new TACInstruction(
            TACInstruction.OpType.CAST,
            result,
            value,
            type
        ));
        
        return result;
    }

    @Override
    public String visitAssignable(MOCParser.AssignableContext ctx) {
        if (ctx.LEFTBRACKET() != null) {
            // Array access
            String array = ctx.IDENTIFIER().getText();
            String index = visit(ctx.expression());
            String temp = generator.newTemp();
            
            generator.addInstruction(new TACInstruction(
                TACInstruction.OpType.ARRAY_ACCESS,
                temp,
                array,
                index
            ));
            
            return temp;
        }
        return ctx.IDENTIFIER().getText();
    }

    @Override
    public String visitPrimeExpr(MOCParser.PrimeExprContext ctx) {
        if (ctx.intLiteral() != null) {
            return ctx.intLiteral().getText();
        } else if (ctx.doubleLiteral() != null) {
            return ctx.doubleLiteral().getText();
        } else if (ctx.getChild(0).getText().startsWith("\"") && ctx.getChild(0).getText().endsWith("\"")) {
            String str = ctx.getChild(0).getText();
            return str.substring(1, str.length() - 1);
        } else if (ctx.IDENTIFIER() != null) {
            if (ctx.LEFTBRACKET() != null) {
                // Array access
                String array = ctx.IDENTIFIER().getText();
                String index = visit(ctx.expression());
                String temp = generator.newTemp();
                
                generator.addInstruction(new TACInstruction(
                    TACInstruction.OpType.ARRAY_ACCESS,
                    temp,
                    array,
                    index
                ));
                
                return temp;
            }
            return ctx.IDENTIFIER().getText();
        } else if (ctx.expression() != null) {
            return visit(ctx.expression());
        }
        return null;
    }

    @Override
    public String visitWriteStatement(MOCParser.WriteStatementContext ctx) {
        if (ctx.WRITE() != null) {
            if (ctx.expression() != null) {
                String value = visit(ctx.expression());
                generator.addInstruction(new TACInstruction(
                    TACInstruction.OpType.WRITE,
                    null,
                    value,
                    null
                ));
            } else {
                System.err.println("Erro: write() sem expressão.");
            }
        } else if (ctx.WRITEC() != null) {
            if (ctx.expression() != null) {
                String value = visit(ctx.expression());
                generator.addInstruction(new TACInstruction(
                    TACInstruction.OpType.WRITE,
                    null,
                    value,
                    null
                ));
            } else {
                System.err.println("Erro: writec() sem expressão.");
            }
        } else if (ctx.WRITES() != null) {
            if (ctx.expression() != null) {
                String value = visit(ctx.expression());
                generator.addInstruction(new TACInstruction(
                    TACInstruction.OpType.WRITE,
                    null,
                    value,
                    null
                ));
            } else if (ctx.STRING_LITERAL() != null) {
                String value = ctx.STRING_LITERAL().getText();
                generator.addInstruction(new TACInstruction(
                    TACInstruction.OpType.WRITE,
                    null,
                    value,
                    null
                ));
            } else {
                System.err.println("Erro: writes() sem expressão ou string literal.");
            }
        } else if (ctx.WRITEV() != null) {
            if (ctx.expression() != null) {
                String value = visit(ctx.expression());
                generator.addInstruction(new TACInstruction(
                    TACInstruction.OpType.WRITE,
                    null,
                    value,
                    null
                ));
            } else {
                System.err.println("Erro: writev() sem expressão.");
            }
        }
        return null;
    }

    @Override
    public String visitReadStatement(MOCParser.ReadStatementContext ctx) {
        if (ctx.READ() != null) {
            String target = ctx.IDENTIFIER().getText();
            generator.addInstruction(new TACInstruction(
                TACInstruction.OpType.READ,
                target,
                null,
                null
            ));
        } else if (ctx.READC() != null) {
            String target = ctx.IDENTIFIER().getText();
            generator.addInstruction(new TACInstruction(
                TACInstruction.OpType.READ,
                target,
                null,
                null
            ));
        } else if (ctx.READS() != null) {
            String target = ctx.IDENTIFIER().getText();
            generator.addInstruction(new TACInstruction(
                TACInstruction.OpType.READ,
                target,
                null,
                null
            ));
        }
        return null;
    }

    @Override
    public String visitConditional(MOCParser.ConditionalContext ctx) {
        String condition = visit(ctx.expression());
        String falseLabel = generator.newLabel();
        String endLabel = generator.newLabel();
        
        // Jump if condition is false
        generator.addInstruction(new TACInstruction(
            TACInstruction.OpType.JUMPZ,
            falseLabel,
            condition,
            null
        ));
        
        // True branch
        visit(ctx.getChild(4));
        
        // Jump to end
        generator.addInstruction(new TACInstruction(
            TACInstruction.OpType.JUMP,
            endLabel,
            null,
            null
        ));
        
        // False label
        generator.addInstruction(new TACInstruction(
            TACInstruction.OpType.LABEL,
            falseLabel,
            null,
            null
        ));
        
        // False branch (if exists)
        if (ctx.getChildCount() > 6) {
            visit(ctx.getChild(6));
        }
        
        // End label
        generator.addInstruction(new TACInstruction(
            TACInstruction.OpType.LABEL,
            endLabel,
            null,
            null
        ));
        
        return null;
    }

    @Override
    public String visitLoop(MOCParser.LoopContext ctx) {
        String startLabel = generator.newLabel();
        String endLabel = generator.newLabel();
        
        // Start label
        generator.addInstruction(new TACInstruction(
            TACInstruction.OpType.LABEL,
            startLabel,
            null,
            null
        ));
        
        // Condition
        String condition = visit(ctx.expression().get(0));
        
        // Jump if condition is false
        generator.addInstruction(new TACInstruction(
            TACInstruction.OpType.JUMPZ,
            endLabel,
            condition,
            null
        ));
        
        // Loop body
        visit(ctx.getChild(4));
        
        // Jump back to start
        generator.addInstruction(new TACInstruction(
            TACInstruction.OpType.JUMP,
            startLabel,
            null,
            null
        ));
        
        // End label
        generator.addInstruction(new TACInstruction(
            TACInstruction.OpType.LABEL,
            endLabel,
            null,
            null
        ));
        
        return null;
    }

    @Override
    public String visitReturnStatement(MOCParser.ReturnStatementContext ctx) {
        String value = visit(ctx.expression());
        generator.addInstruction(new TACInstruction(
            TACInstruction.OpType.RETURN,
            null,
            value,
            null
        ));
        return null;
    }

    public TACGenerator getGenerator() {
        return generator;
    }
} 