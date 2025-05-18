/**
 * Classe que representa uma instrução em Three-Address Code (TAC)
 * Cada instrução TAC tem um operador e até três operandos (result, arg1, arg2)
 */
public class TACInstruction {
    /**
     * Enumeração que define todos os tipos de operações possíveis em TAC
     * Inclui operações aritméticas, lógicas, de controle de fluxo e I/O
     */
    public enum OpType {
        // Operações de atribuição e aritméticas
        ASSIGN,     // Atribuição simples: result = arg1
        ADD,        // Adição: result = arg1 + arg2
        SUB,        // Subtração: result = arg1 - arg2
        MUL,        // Multiplicação: result = arg1 * arg2
        DIV,        // Divisão: result = arg1 / arg2
        MOD,        // Módulo: result = arg1 % arg2
        
        // Operações lógicas
        AND,        // E lógico: result = arg1 && arg2
        OR,         // OU lógico: result = arg1 || arg2
        NOT,        // NÃO lógico: result = !arg1
        
        // Operações de comparação
        LT,         // Menor que: result = arg1 < arg2
        GT,         // Maior que: result = arg1 > arg2
        LEQ,        // Menor ou igual: result = arg1 <= arg2
        GEQ,        // Maior ou igual: result = arg1 >= arg2
        EQUAL,      // Igual: result = arg1 == arg2
        NOTEQUAL,   // Diferente: result = arg1 != arg2
        
        // Operações de controle de fluxo
        LABEL,      // Rótulo: result:
        JUMP,       // Salto incondicional: goto result
        JUMPZ,      // Salto se zero: if arg1 == 0 goto result
        JUMPNZ,     // Salto se não zero: if arg1 != 0 goto result
        
        // Operações de função
        PARAM,      // Parâmetro de função: param arg1
        CALL,       // Chamada de função: result = call arg1, arg2
        RETURN,     // Retorno de função: return arg1
        
        // Operações de entrada/saída
        READ,       // Leitura de número: read result
        READC,      // Leitura de caractere: readc result
        READS,      // Leitura de string: reads result
        WRITE,      // Escrita de número: write arg1
        WRITEC,     // Escrita de caractere: writec arg1
        WRITES,     // Escrita de string: writes arg1
        
        // Operações especiais
        CAST,       // Conversão de tipo: result = (arg2) arg1
        ARRAY_ACCESS // Acesso a array: result = arg1[arg2]
    }

    // Campos da instrução TAC
    private OpType op;      // Tipo da operação
    private String result;  // Resultado da operação (destino)
    private String arg1;    // Primeiro argumento
    private String arg2;    // Segundo argumento (opcional)

    /**
     * Construtor de uma instrução TAC
     * @param op Tipo da operação
     * @param result Variável que receberá o resultado
     * @param arg1 Primeiro argumento da operação
     * @param arg2 Segundo argumento da operação (pode ser null)
     */
    public TACInstruction(OpType op, String result, String arg1, String arg2) {
        this.op = op;
        this.result = result;
        this.arg1 = arg1;
        this.arg2 = arg2;
    }

    /**
     * Gera uma representação em string da instrução TAC
     * @return String formatada representando a instrução
     */
    @Override
    public String toString() {
        switch (op) {
            case ASSIGN:
                return result + " = " + arg1;
            case LABEL:
                return result + ":";
            case JUMP:
                return "goto " + result;
            case JUMPZ:
                return "if " + arg1 + " == 0 goto " + result;
            case JUMPNZ:
                return "if " + arg1 + " != 0 goto " + result;
            case PARAM:
                return "param " + arg1;
            case CALL:
                return result + " = call " + arg1 + ", " + arg2;
            case RETURN:
                return "return " + arg1;
            case READ:
            case READC:
            case READS:
                return "read " + result;
            case WRITE:
            case WRITEC:
            case WRITES:
                return "write " + arg1;
            case CAST:
                return result + " = (" + arg2 + ") " + arg1;
            case ARRAY_ACCESS:
                return result + " = " + arg1 + "[" + arg2 + "]";
            default:
                if (op == OpType.NOT) {
                    return result + " = !" + arg1;
                }
                return result + " = " + arg1 + " " + op.toString() + " " + arg2;
        }
    }

    // Getters para acessar os campos da instrução
    public OpType getOp() { return op; }
    public String getResult() { return result; }
    public String getArg1() { return arg1; }
    public String getArg2() { return arg2; }
} 