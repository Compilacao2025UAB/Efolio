import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TACGenerator {
    private List<TACInstruction> instructions;
    private Map<String, String> symbolTable;
    private int tempCounter;
    private int labelCounter;

    public TACGenerator() {
        this.instructions = new ArrayList<>();
        this.symbolTable = new HashMap<>();
        this.tempCounter = 0;
        this.labelCounter = 0;
    }

    public String newTemp() {
        return "t" + (++tempCounter);
    }

    public String newLabel() {
        return "L" + (++labelCounter);
    }

    public void addInstruction(TACInstruction instruction) {
        instructions.add(instruction);
    }

    public void addSymbol(String name, String type) {
        symbolTable.put(name, type);
    }

    public String getSymbolType(String name) {
        return symbolTable.get(name);
    }

    public List<TACInstruction> getInstructions() {
        return instructions;
    }

    public void optimize() {
        // Eliminação de codigo morto
        boolean changed;
        do {
            changed = false;
            for (int i = 0; i < instructions.size(); i++) {
                TACInstruction inst = instructions.get(i);
                
                // Eliminar atribuições não utilizadas
                if (inst.getOp() == TACInstruction.OpType.ASSIGN) {
                    boolean used = false;
                    for (int j = i + 1; j < instructions.size(); j++) {
                        TACInstruction nextInst = instructions.get(j);
                        if ((nextInst.getArg1() != null && nextInst.getArg1().equals(inst.getResult())) || 
                            (nextInst.getArg2() != null && nextInst.getArg2().equals(inst.getResult()))) {
                            used = true;
                            break;
                        }
                    }
                    if (!used && !symbolTable.containsKey(inst.getResult())) {
                        instructions.remove(i);
                        changed = true;
                        i--;
                    }
                }
                
                // Simplificação de expressões constantes
                if (inst.getOp() == TACInstruction.OpType.ADD || 
                    inst.getOp() == TACInstruction.OpType.SUB ||
                    inst.getOp() == TACInstruction.OpType.MUL ||
                    inst.getOp() == TACInstruction.OpType.DIV) {
                    try {
                        double arg1 = Double.parseDouble(inst.getArg1());
                        double arg2 = Double.parseDouble(inst.getArg2());
                        double result = 0;
                        
                        switch (inst.getOp()) {
                            case ADD: result = arg1 + arg2; break;
                            case SUB: result = arg1 - arg2; break;
                            case MUL: result = arg1 * arg2; break;
                            case DIV: result = arg1 / arg2; break;
                            default:
                                break;
                        }
                        
                        instructions.set(i, new TACInstruction(
                            TACInstruction.OpType.ASSIGN,
                            inst.getResult(),
                            String.valueOf(result),
                            null
                        ));
                        changed = true;
                    } catch (NumberFormatException e) {
                        // Não é uma expressão constante
                    }
                }
            }
        } while (changed);
    }

    public String getSymbolTableString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n=== TABELA DE SÍMBOLOS ===\n");
        sb.append("┌────────────┬────────────┬────────────┐\n");
        sb.append("│ Nome       │ Tipo       │ Valor      │\n");
        sb.append("├────────────┼────────────┼────────────┤\n");
        
        for (Map.Entry<String, String> entry : symbolTable.entrySet()) {
            String name = entry.getKey();
            String type = entry.getValue();
            String value = "não inicializado";
            
            // Procura o valor nas instruções TAC
            for (TACInstruction inst : instructions) {
                if (inst.getOp() == TACInstruction.OpType.ASSIGN && 
                    inst.getResult().equals(name)) {
                    value = inst.getArg1();
                    break;
                }
            }
            
            // Formata cada linha da tabela
            sb.append(String.format("│ %-10s │ %-10s │ %-10s │\n", 
                name, type, value));
        }
        
        sb.append("└────────────┴────────────┴────────────┘\n");
        return sb.toString();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n=== CoDIGO TAC ===\n");
        sb.append("┌────┬────────────┬────────────┬────────────┬────────────┐\n");
        sb.append("│ #  │ Operação   │ Resultado  │ Arg1       │ Arg2       │\n");
        sb.append("├────┼────────────┼────────────┼────────────┼────────────┤\n");
        
        int i = 1;
        for (TACInstruction inst : instructions) {
            sb.append(String.format("│ %-2d │ %-10s │ %-10s │ %-10s │ %-10s │\n",
                i++,
                inst.getOp(),
                inst.getResult() != null ? inst.getResult() : "",
                inst.getArg1() != null ? inst.getArg1() : "",
                inst.getArg2() != null ? inst.getArg2() : ""));
        }
        
        sb.append("└────┴────────────┴────────────┴────────────┴────────────┘\n");
        return sb.toString();
    }
} 