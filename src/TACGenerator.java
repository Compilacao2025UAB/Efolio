import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.HashSet;
import java.util.Set;

/**
 * Gerador de Codigo Intermediário Three-Address Code (TAC)
 * Responsável por gerar e otimizar o codigo intermediário
 * e manter a tabela de símbolos durante a geracao de codigo
 */
public class TACGenerator {
    // Lista de instrucões TAC geradas
    private List<TACInstruction> instructions;
    // Tabela de símbolos que mapeia nomes para tipos
    private Map<String, String> symbolTable;
    // Contador para gerar nomes únicos de variáveis temporárias
    private int tempCounter;
    // Contador para gerar nomes únicos de labels
    private int labelCounter;

    /**
     * Construtor do Gerador TAC
     * Inicializa as estruturas de dados necessárias
     */
    public TACGenerator() {
        this.instructions = new ArrayList<>();
        this.symbolTable = new HashMap<>();
        this.tempCounter = 0;
        this.labelCounter = 0;
    }

    /**
     * Gera um novo nome para uma variável temporária
     * @return Nome único para a variável temporária (t1, t2, ...)
     */
    public String newTemp() {
        return "t" + (++tempCounter);
    }

    /**
     * Gera um novo nome para um label
     * @return Nome único para o label (L1, L2, ...)
     */
    public String newLabel() {
        return "L" + (++labelCounter);
    }

    /**
     * Adiciona uma nova instrucao TAC à lista de instrucões
     * @param instruction Instrucao TAC a ser adicionada
     */
    public void addInstruction(TACInstruction instruction) {
        instructions.add(instruction);
    }

    /**
     * Adiciona um símbolo à tabela de símbolos
     * @param name Nome do símbolo
     * @param type Tipo do símbolo
     */
    public void addSymbol(String name, String type) {
        symbolTable.put(name, type);
    }

    /**
     * Obtém o tipo de um símbolo da tabela de símbolos
     * @param name Nome do símbolo
     * @return Tipo do símbolo ou null se nao encontrado
     */
    public String getSymbolType(String name) {
        return symbolTable.get(name);
    }

    /**
     * Obtém a lista de instrucões TAC geradas
     * @return Lista de instrucões TAC
     */
    public List<TACInstruction> getInstructions() {
        return instructions;
    }

    /**
     * Otimiza o codigo TAC gerado
     * Realiza as seguintes otimizacões:
     * 1. Eliminacao de codigo morto (atribuicões nao utilizadas)
     * 2. Simplificacao de expressões constantes
     */
    public void optimize() {
        boolean changed;
        do {
            changed = false;
            for (int i = 0; i < instructions.size(); i++) {
                TACInstruction inst = instructions.get(i);
                
                // Eliminar atribuicões nao utilizadas
                if (inst.getOp() == TACInstruction.OpType.ASSIGN) {
                    boolean used = false;
                    // Verifica se o resultado é usado em instrucões subsequentes
                    for (int j = i + 1; j < instructions.size(); j++) {
                        TACInstruction nextInst = instructions.get(j);
                        if ((nextInst.getArg1() != null && nextInst.getArg1().equals(inst.getResult())) || 
                            (nextInst.getArg2() != null && nextInst.getArg2().equals(inst.getResult()))) {
                            used = true;
                            break;
                        }
                    }
                    // Remove a instrucao se nao for usada e nao for um símbolo da tabela
                    if (!used && !symbolTable.containsKey(inst.getResult())) {
                        instructions.remove(i);
                        changed = true;
                        i--;
                    }
                }
                
                // Simplificacao de expressões constantes
                if (inst.getOp() == TACInstruction.OpType.ADD || 
                    inst.getOp() == TACInstruction.OpType.SUB ||
                    inst.getOp() == TACInstruction.OpType.MUL ||
                    inst.getOp() == TACInstruction.OpType.DIV) {
                    try {
                        // Tenta avaliar a expressao em tempo de compilacao
                        double arg1 = Double.parseDouble(inst.getArg1());
                        double arg2 = Double.parseDouble(inst.getArg2());
                        double result = 0;
                        
                        // Realiza a operacao
                        switch (inst.getOp()) {
                            case ADD: result = arg1 + arg2; break;
                            case SUB: result = arg1 - arg2; break;
                            case MUL: result = arg1 * arg2; break;
                            case DIV: result = arg1 / arg2; break;
                            default:
                                break;
                        }
                        
                        // Substitui a expressao pelo resultado
                        instructions.set(i, new TACInstruction(
                            TACInstruction.OpType.ASSIGN,
                            inst.getResult(),
                            String.valueOf(result),
                            null
                        ));
                        changed = true;
                    } catch (NumberFormatException e) {
                        // Nao é uma expressao constante, continua sem otimizacao
                    }
                }
            }
        } while (changed);
    }

    /**
     * Gera uma representacao em string da tabela de símbolos
     * @return String formatada com a tabela de símbolos
     */
    public String getSymbolTableString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n=== TABELA DE SÍMBOLOS ===\n");
        sb.append("┌────────────┬────────────┬────────────┐\n");
        sb.append("│ Nome       │ Tipo       │ Valor      │\n");
        sb.append("├────────────┼────────────┼────────────┤\n");
        
        for (Map.Entry<String, String> entry : symbolTable.entrySet()) {
            String name = entry.getKey();
            String type = entry.getValue();
            String value = "nao inicializado";
            
            // Procura o valor nas instrucões TAC
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

    /**
     * Gera uma representação em string do código TAC
     * @return String formatada com o código TAC original e otimizado (apenas ASCII)
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        
        // Guarda uma cópia profunda das instruções originais
        List<TACInstruction> originalInstructions = new ArrayList<>();
        for (TACInstruction inst : instructions) {
            originalInstructions.add(new TACInstruction(
                inst.getOp(),
                inst.getResult(),
                inst.getArg1(),
                inst.getArg2()
            ));
        }
        
        // Código TAC Original
        sb.append("\n=== CODIGO TAC ORIGINAL ===\n");
        sb.append("+----+------------+------------+------------+------------+\n");
        sb.append("| #  | Operacao   | Resultado  | Arg1       | Arg2       |\n");
        sb.append("+----+------------+------------+------------+------------+\n");
        
        int i = 1;
        for (TACInstruction inst : originalInstructions) {
            sb.append(String.format("| %-2d | %-10s | %-10s | %-10s | %-10s |\n",
                i++,
                inst.getOp(),
                inst.getResult() != null ? inst.getResult() : "",
                inst.getArg1() != null ? inst.getArg1() : "",
                inst.getArg2() != null ? inst.getArg2() : ""));
        }
        sb.append("+----+------------+------------+------------+------------+\n");

        // Código TAC Otimizado com liveness analysis
        List<TACInstruction> optimizedInstructions = new ArrayList<>();
        Set<String> live = new HashSet<>();
        // Percorrer de trás para a frente
        for (int idx = originalInstructions.size() - 1; idx >= 0; idx--) {
            TACInstruction inst = originalInstructions.get(idx);
            String result = inst.getResult();
            String arg1 = inst.getArg1();
            String arg2 = inst.getArg2();
            boolean isAssignment = inst.getOp() == TACInstruction.OpType.ASSIGN ||
                                   inst.getOp() == TACInstruction.OpType.ADD ||
                                   inst.getOp() == TACInstruction.OpType.SUB ||
                                   inst.getOp() == TACInstruction.OpType.MUL ||
                                   inst.getOp() == TACInstruction.OpType.DIV;
            // Se a variável de resultado não está viva, pode eliminar
            if (isAssignment && result != null && !live.contains(result)) {
                continue; // Elimina a instrução
            }
            // Atualiza o conjunto de variáveis vivas
            if (result != null) live.remove(result);
            if (arg1 != null && !isNumber(arg1)) live.add(arg1);
            if (arg2 != null && !isNumber(arg2)) live.add(arg2);
            // Adiciona a instrução à lista otimizada (no início)
            optimizedInstructions.add(0, inst);
        }
        // Simplificação de expressões constantes (apenas para as que restaram)
        for (int j = 0; j < optimizedInstructions.size(); j++) {
            TACInstruction inst = optimizedInstructions.get(j);
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
                        default: break;
                    }
                    optimizedInstructions.set(j, new TACInstruction(
                        TACInstruction.OpType.ASSIGN,
                        inst.getResult(),
                        String.valueOf(result),
                        null
                    ));
                } catch (NumberFormatException e) {
                    // Não é uma expressão constante
                }
            }
        }
        sb.append("\n=== CODIGO TAC OTIMIZADO ===\n");
        sb.append("+----+------------+------------+------------+------------+\n");
        sb.append("| #  | Operacao   | Resultado  | Arg1       | Arg2       |\n");
        sb.append("+----+------------+------------+------------+------------+\n");
        i = 1;
        for (TACInstruction inst : optimizedInstructions) {
            sb.append(String.format("| %-2d | %-10s | %-10s | %-10s | %-10s |\n",
                i++,
                inst.getOp(),
                inst.getResult() != null ? inst.getResult() : "",
                inst.getArg1() != null ? inst.getArg1() : "",
                inst.getArg2() != null ? inst.getArg2() : ""));
        }
        sb.append("+----+------------+------------+------------+------------+\n");
        return sb.toString();
    }

    /**
     * Mostra apenas o TAC simples (original, sem otimização)
     */
    public String toStringSimples() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n=== CODIGO TAC SIMPLES ===\n");
        sb.append("+----+------------+------------+------------+------------+\n");
        sb.append("| #  | Operacao   | Resultado  | Arg1       | Arg2       |\n");
        sb.append("+----+------------+------------+------------+------------+\n");
        int i = 1;
        for (TACInstruction inst : instructions) {
            sb.append(String.format("| %-2d | %-10s | %-10s | %-10s | %-10s |\n",
                i++,
                inst.getOp(),
                inst.getResult() != null ? inst.getResult() : "",
                inst.getArg1() != null ? inst.getArg1() : "",
                inst.getArg2() != null ? inst.getArg2() : ""));
        }
        sb.append("+----+------------+------------+------------+------------+\n");
        return sb.toString();
    }

    /**
     * Mostra apenas o TAC otimizado (com liveness analysis)
     */
    public String toStringOtimizado() {
        StringBuilder sb = new StringBuilder();
        // Código TAC Otimizado com liveness analysis
        List<TACInstruction> originalInstructions = new ArrayList<>();
        for (TACInstruction inst : instructions) {
            originalInstructions.add(new TACInstruction(
                inst.getOp(),
                inst.getResult(),
                inst.getArg1(),
                inst.getArg2()
            ));
        }
        List<TACInstruction> optimizedInstructions = new ArrayList<>();
        Set<String> live = new HashSet<>();
        for (int idx = originalInstructions.size() - 1; idx >= 0; idx--) {
            TACInstruction inst = originalInstructions.get(idx);
            String result = inst.getResult();
            String arg1 = inst.getArg1();
            String arg2 = inst.getArg2();
            boolean isAssignment = inst.getOp() == TACInstruction.OpType.ASSIGN ||
                                   inst.getOp() == TACInstruction.OpType.ADD ||
                                   inst.getOp() == TACInstruction.OpType.SUB ||
                                   inst.getOp() == TACInstruction.OpType.MUL ||
                                   inst.getOp() == TACInstruction.OpType.DIV;
            if (isAssignment && result != null && !live.contains(result)) {
                continue;
            }
            if (result != null) live.remove(result);
            if (arg1 != null && !isNumber(arg1)) live.add(arg1);
            if (arg2 != null && !isNumber(arg2)) live.add(arg2);
            optimizedInstructions.add(0, inst);
        }
        for (int j = 0; j < optimizedInstructions.size(); j++) {
            TACInstruction inst = optimizedInstructions.get(j);
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
                        default: break;
                    }
                    optimizedInstructions.set(j, new TACInstruction(
                        TACInstruction.OpType.ASSIGN,
                        inst.getResult(),
                        String.valueOf(result),
                        null
                    ));
                } catch (NumberFormatException e) {
                    // Não é uma expressão constante
                }
            }
        }
        sb.append("\n=== CODIGO TAC OTIMIZADO ===\n");
        sb.append("+----+------------+------------+------------+------------+\n");
        sb.append("| #  | Operacao   | Resultado  | Arg1       | Arg2       |\n");
        sb.append("+----+------------+------------+------------+------------+\n");
        int i = 1;
        for (TACInstruction inst : optimizedInstructions) {
            sb.append(String.format("| %-2d | %-10s | %-10s | %-10s | %-10s |\n",
                i++,
                inst.getOp(),
                inst.getResult() != null ? inst.getResult() : "",
                inst.getArg1() != null ? inst.getArg1() : "",
                inst.getArg2() != null ? inst.getArg2() : ""));
        }
        sb.append("+----+------------+------------+------------+------------+\n");
        return sb.toString();
    }

    /**
     * Mostra o TAC simples (linha a linha, sem tabela)
     */
    public String toStringLinhaPorLinha() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n=== CODIGO TAC SIMPLES (LINHA A LINHA) ===\n");
        for (TACInstruction inst : instructions) {
            sb.append(inst.toString()).append("\n");
        }
        return sb.toString();
    }

    /**
     * Mostra o TAC otimizado (linha a linha, sem tabela)
     */
    public String toStringLinhaPorLinhaOtimizado() {
        // Código TAC Otimizado com liveness analysis
        List<TACInstruction> originalInstructions = new ArrayList<>();
        for (TACInstruction inst : instructions) {
            originalInstructions.add(new TACInstruction(
                inst.getOp(),
                inst.getResult(),
                inst.getArg1(),
                inst.getArg2()
            ));
        }
        List<TACInstruction> optimizedInstructions = new ArrayList<>();
        Set<String> live = new HashSet<>();
        for (int idx = originalInstructions.size() - 1; idx >= 0; idx--) {
            TACInstruction inst = originalInstructions.get(idx);
            String result = inst.getResult();
            String arg1 = inst.getArg1();
            String arg2 = inst.getArg2();
            boolean isAssignment = inst.getOp() == TACInstruction.OpType.ASSIGN ||
                                   inst.getOp() == TACInstruction.OpType.ADD ||
                                   inst.getOp() == TACInstruction.OpType.SUB ||
                                   inst.getOp() == TACInstruction.OpType.MUL ||
                                   inst.getOp() == TACInstruction.OpType.DIV;
            if (isAssignment && result != null && !live.contains(result)) {
                continue;
            }
            if (result != null) live.remove(result);
            if (arg1 != null && !isNumber(arg1)) live.add(arg1);
            if (arg2 != null && !isNumber(arg2)) live.add(arg2);
            optimizedInstructions.add(0, inst);
        }
        for (int j = 0; j < optimizedInstructions.size(); j++) {
            TACInstruction inst = optimizedInstructions.get(j);
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
                        default: break;
                    }
                    optimizedInstructions.set(j, new TACInstruction(
                        TACInstruction.OpType.ASSIGN,
                        inst.getResult(),
                        String.valueOf(result),
                        null
                    ));
                } catch (NumberFormatException e) {
                    // Não é uma expressão constante
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("\n=== CODIGO TAC OTIMIZADO (LINHA A LINHA) ===\n");
        for (TACInstruction inst : optimizedInstructions) {
            sb.append(inst.toString()).append("\n");
        }
        return sb.toString();
    }

    // Função auxiliar para verificar se uma string é um número
    private boolean isNumber(String s) {
        if (s == null) return false;
        try {
            Double.parseDouble(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
} 