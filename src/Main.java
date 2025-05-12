import java.io.*;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import org.antlr.v4.gui.TreeViewer;
import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        try {
            // Ler o arquivo de entrada
            String inputFile = args.length > 0 ? args[0] : "testes/exemplo1.moc";
            CharStream input = CharStreams.fromFileName(inputFile);
            
            // Criar o lexer
            MOCLexer lexer = new MOCLexer(input);
            
            // Criar o parser
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            MOCParser parser = new MOCParser(tokens);
            
            // Obter a árvore sintática
            ParseTree tree = parser.program();
            
            // Mostrar a árvore sintática na GUI
            JFrame frame = new JFrame("Árvore Sintática");
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            
            // Criar um painel com barra de rolagem
            JScrollPane scrollPane = new JScrollPane();
            scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
            scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
            
            // Criar o visualizador da árvore
            TreeViewer viewer = new TreeViewer(Arrays.asList(parser.getRuleNames()), tree);
            viewer.setScale(1.5); // Aumentar o zoom para melhor visualização
            
            // Adicionar controles de zoom
            JPanel controlPanel = new JPanel();
            JButton zoomIn = new JButton("+");
            JButton zoomOut = new JButton("-");
            JButton resetZoom = new JButton("Reset");
            
            zoomIn.addActionListener(e -> {
                viewer.setScale(viewer.getScale() * 1.2);
                viewer.repaint();
            });
            
            zoomOut.addActionListener(e -> {
                viewer.setScale(viewer.getScale() / 1.2);
                viewer.repaint();
            });
            
            resetZoom.addActionListener(e -> {
                viewer.setScale(1.5);
                viewer.repaint();
            });
            
            controlPanel.add(zoomIn);
            controlPanel.add(zoomOut);
            controlPanel.add(resetZoom);
            
            // Configurar o layout
            frame.setLayout(new BorderLayout());
            frame.add(controlPanel, BorderLayout.NORTH);
            scrollPane.setViewportView(viewer);
            frame.add(scrollPane, BorderLayout.CENTER);
            
            // Ajustar o tamanho da janela
            frame.setSize(1024, 768);
            frame.setLocationRelativeTo(null); // Centralizar na tela
            frame.setVisible(true);
            
            // Realizar análise semântica
            SemanticAnalyzer semanticAnalyzer = new SemanticAnalyzer();
            semanticAnalyzer.visit(tree);
            
            // Verificar erros semânticos
            if (semanticAnalyzer.hasErrors()) {
                System.err.println("Erros semânticos encontrados:");
                for (String error : semanticAnalyzer.getErrors()) {
                    System.err.println(error);
                }
                return;
            }
            
            // Criar o visitor para gerar o código intermediário
            MOCTACVisitor visitor = new MOCTACVisitor();
            visitor.visit(tree);
            
            // Obter o gerador de código
            TACGenerator generator = visitor.getGenerator();
            
            // Otimizar o código
            generator.optimize();
            
            // Imprimir o código intermediário
            System.out.println("Código Intermediário (TAC):");
            System.out.println(generator.toString());
            
        } catch (Exception e) {
            System.err.println("Erro: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
