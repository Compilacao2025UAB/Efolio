import org.antlr.v4.gui.TreeViewer;
import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import parser.MOCLexer;
import parser.MOCParser;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import parser.*;
import java.io.*;
import java.util.Map;

public class Main
    {
        @SuppressWarnings("unused")
        public static void main(String[] args)
            {
                // Configurar codificacao UTF-8 para o output
                System.setProperty("file.encoding", "UTF-8");
                if (args.length == 0)
                    {
                        System.err.println("Erro: Nenhum arquivo de entrada especificado");
                        System.err.println("Uso: java Main <arquivo.moc>");
                        return;
                    }

                // Verificar se o ficheiro existe
                if (!Files.exists(Paths.get(args[0])))
                    {
                        System.err.println("Erro: Ficheiro de entrada nao existe.");
                        return;
                    }

                // Verificar se o ficheiro está vazio
                try
                    {
                        if (Files.size(Paths.get(args[0])) == 0)
                            {
                                System.err.println("Erro: Ficheiro de entrada esta vazio.");
                                return;
                            }
                    }
                catch (IOException e)
                    {
                        System.err.println("Erro ao verificar o tamanho do ficheiro: " + e.getMessage());
                        return;
                    }

                try
                    {
                        // Ler o arquivo de entrada
                        CharStream input = CharStreams.fromFileName(args[0]);

                        // Criar o lexer
                        MOCLexer lexer = new MOCLexer(input);

                        // Criar o parser
                        CommonTokenStream tokens = new CommonTokenStream(lexer);
                        MOCParser parser = new MOCParser(tokens);

                        // Obter a árvore sintática
                        ParseTree tree = parser.program();

                        // Verificar erros de sintaxe
                        if (parser.getNumberOfSyntaxErrors() > 0)
                            {
                                System.err.println("\n=== ERROS DE SINTAXE ===");
                                System.err.println("Foram encontrados " + parser.getNumberOfSyntaxErrors() + " erros de sintaxe.");
                                System.err.println("Compilacao abortada.");
                                return;
                            }

                        // Verificar se a árvore é nula
                        if (tree == null)
                            {
                                System.err.println("Erro: Nao foi possível gerar a árvore sintatica (ParseTree). Verifique a gramatica e o ficheiro de entrada.");
                                return;
                            }

                        // Visualizacao gráfica da AST do ANTLR
                        JFrame frame = new JFrame("AST - ANTLR");
                        TreeViewer viewer = new TreeViewer(Arrays.asList(parser.getRuleNames()), tree);
                        viewer.setScale(1.5); // aumenta o zoom se necessário

                        // Adicionar barras de rolagem
                        JScrollPane scrollPane = new JScrollPane(viewer);
                        frame.add(scrollPane);
                        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        frame.setSize(800, 600);
                        frame.setVisible(true);

                        // Análise semântica
                        SemanticAnalyzer semanticAnalyzer = new SemanticAnalyzer();
                        semanticAnalyzer.visit(tree);

                        // Verificar erros semânticos
                        if (semanticAnalyzer.hasErrors())
                            {
                                System.err.println("\n=== ERROS SEMANTICOS ===");
                                System.err.println("Foram encontrados " + semanticAnalyzer.getErrors().size() + " erros semanticos:");
                                for (String error : semanticAnalyzer.getErrors())
                                    {
                                        System.err.println(error);
                                    }
                                System.err.println("\nCompilacao abortada.");
                                return;
                            }

                        // Obter a tabela de símbolos do analisador semântico
                        Map<String, SemanticAnalyzer.Symbol> symbolTable = semanticAnalyzer.getSymbolTable();
                        System.out.println("\n=== TABELA DE SIMBOLOS DO ANALISADOR SEMANTICO ===");
                        System.out.println("+------------+------------+--------------------+------------+");
                        System.out.println("| Nome       | Tipo       | Valor              | Funcao     |");
                        System.out.println("+------------+------------+--------------------+------------+");
                        for (Map.Entry<String, SemanticAnalyzer.Symbol> entry : symbolTable.entrySet())
                            {
                                SemanticAnalyzer.Symbol symbol = entry.getValue();
                                String type = symbol.type + (symbol.isArray ? "[]" : "");
                                String value = symbol.value != null ? symbol.value : "nao inicializado";
                                String isFunction = symbol.isFunction ? "Sim" : "Nao";
                                System.out.printf("| %-10s | %-10s | %-18s | %-10s |\n",
                                truncateString(entry.getKey(), 10),
                                truncateString(type, 10),
                                truncateString(value, 18),
                                truncateString(isFunction, 10));
                            }
                        System.out.println("+------------+------------+--------------------+------------+");

                        // Gerar codigo intermediário
                        MOCTACVisitor tacVisitor = new MOCTACVisitor();
                        tacVisitor.setSymbolTable(symbolTable);
                        tacVisitor.visit(tree);

                        // Obter o codigo gerado
                        TACGenerator generator = tacVisitor.getGenerator();

                        // Imprimir o codigo gerado em todos os formatos
                        System.out.println(generator.toStringSimples()); // Tabela TAC simples
                        System.out.println(generator.toStringOtimizado()); // Tabela TAC otimizado
                        System.out.println(generator.toStringLinhaPorLinha()); // TAC simples linha a linha
                        System.out.println(generator.toStringLinhaPorLinhaOtimizado()); // TAC otimizado linha a linha
                    }
                catch (IOException e)
                    {
                        System.err.println("\n=== ERRO DE I/O ===");
                        System.err.println("Erro ao ler o arquivo: " + e.getMessage());
                    }
            }
        // Método auxiliar para truncar strings mantendo caracteres especiais
        private static String truncateString(String str, int maxLength)
            {
                if (str == null) return "";
                if (str.length() <= maxLength) return str;
                return str.substring(0, maxLength - 3) + "...";
            }
    }