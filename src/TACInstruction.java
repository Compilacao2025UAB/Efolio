public class TACInstruction
    {
        public enum OpType
            {
                ASSIGN, ADD, SUB, MUL, DIV, MOD,
                AND, OR, NOT,
                LT, GT, LEQ, GEQ, EQUAL, NOTEQUAL,
                LABEL, JUMP, JUMPZ, JUMPNZ,
                PARAM, CALL, RETURN,
                READ, READC, READS,
                WRITE, WRITEC, WRITES,
                CAST, ARRAY_ACCESS
            }

        private OpType op;
        private String result;
        private String arg1;
        private String arg2;

        public TACInstruction(OpType op, String result, String arg1, String arg2)
            {
                this.op = op;
                this.result = result;
                this.arg1 = arg1;
                this.arg2 = arg2;
            }

        @Override
        public String toString()
            {
                switch (op)
                    {
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
                            if (op == OpType.NOT)
                                {
                                    return result + " = !" + arg1;
                                }
                            return result + " = " + arg1 + " " + op.toString() + " " + arg2;
                    }
            }

        public OpType getOp()
            {
                return op;
            }

        public String getResult()
            {
                return result;
            }

        public String getArg1()
            {
                return arg1;
            }

        public String getArg2()
            {
                return arg2;
            }
    }