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

public class Main {
    @SuppressWarnings("unused")
    public static void main(String[] args) {
        if (args.length == 0) {
            System.err.println("Erro: Nenhum arquivo de entrada especificado");
            System.err.println("Uso: java Main <arquivo.moc>");
            return;
        }

        try {
            // Ler o arquivo de entrada
            CharStream input = CharStreams.fromFileName(args[0]);
            
            // Criar o lexer
            MOCLexer lexer = new MOCLexer(input);
            
            // Criar o parser
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            MOCParser parser = new MOCParser(tokens);
            
            // Obter a árvore sintática
            ParseTree tree = parser.program();
            
            // Visualização gráfica da AST do ANTLR
            JFrame frame = new JFrame("AST - ANTLR");
            TreeViewer viewer = new TreeViewer(Arrays.asList(parser.getRuleNames()), tree);
            viewer.setScale(1.5); // aumenta o zoom se necessário
            frame.add(viewer);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(800, 600);
            frame.setVisible(true);
            
            // Verificar erros de sintaxe
            if (parser.getNumberOfSyntaxErrors() > 0) {
                System.err.println("\n=== ERROS DE SINTAXE ===");
                System.err.println("Foram encontrados " + parser.getNumberOfSyntaxErrors() + " erros de sintaxe.");
                System.err.println("Compilação abortada.");
                return;
            }
            
            // Análise semântica
            SemanticAnalyzer semanticAnalyzer = new SemanticAnalyzer();
            semanticAnalyzer.visit(tree);
            
            // Verificar erros semânticos
            if (semanticAnalyzer.hasErrors()) {
                System.err.println("\n=== ERROS SEMÂNTICOS ===");
                System.err.println("Foram encontrados " + semanticAnalyzer.getErrors().size() + " erros semânticos:");
                for (String error : semanticAnalyzer.getErrors()) {
                    System.err.println(error);
                }
                System.err.println("\nCompilação abortada.");
                return;
            }
            
            // Gerar código intermediário
            MOCTACVisitor tacVisitor = new MOCTACVisitor();
            tacVisitor.visit(tree);
            
            // Obter o código gerado
            TACGenerator generator = tacVisitor.getGenerator();
            
            // Imprimir o código gerado
            System.out.println("\n=== CÓDIGO TAC GERADO ===");
            for (TACInstruction instruction : generator.getInstructions()) {
                System.out.println(instruction);
            }
            
        } catch (IOException e) {
            System.err.println("\n=== ERRO DE I/O ===");
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        }
    }
}
