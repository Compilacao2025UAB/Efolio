import org.antlr.v4.runtime.tree.ParseTree;
import parser.MOCBaseVisitor;
import parser.MOCParser;
import java.util.HashMap;
import java.util.Map;

public class MOCSemanticVisitor extends MOCBaseVisitor<String> {
    private Map<String, String> symbolTable;
    private boolean hasErrors;

    public MOCSemanticVisitor() {
        this.symbolTable = new HashMap<>();
        this.hasErrors = false;
    }

    @Override
    public String visitProgram(MOCParser.ProgramContext ctx) {
        for (ParseTree child : ctx.children) {
            visit(child);
        }
        return null;
    }

    @Override
    public String visitAssignment(MOCParser.AssignmentContext ctx) {
        String target = ctx.assignable().getText();
        @SuppressWarnings("unused")
        String value = visit(ctx.expression());
        
        // Verificar se a variável existe
        if (!symbolTable.containsKey(target)) {
            System.err.println("Erro: Variável '" + target + "' nao declarada");
            hasErrors = true;
        }
        
        return null;
    }

    @Override
    public String visitAssignable(MOCParser.AssignableContext ctx) {
        if (ctx.LEFTBRACKET() != null) {
            // Verificar se o índice é inteiro
            String index = visit(ctx.expression());
            if (!isInteger(index)) {
                System.err.println("Erro: Índice de array deve ser inteiro");
                hasErrors = true;
            }
        }
        return ctx.IDENTIFIER().getText();
    }

    @Override
    public String visitPrimeExpr(MOCParser.PrimeExprContext ctx) {
        if (ctx.IDENTIFIER() != null && ctx.LEFTBRACKET() != null) {
            // Verificar se o índice é inteiro
            String index = visit(ctx.expression());
            if (!isInteger(index)) {
                System.err.println("Erro: Índice de array deve ser inteiro");
                hasErrors = true;
            }
        }
        return visitChildren(ctx);
    }

    private boolean isInteger(String value) {
        try {
            Integer.parseInt(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public boolean hasErrors() {
        return hasErrors;
    }
} 