import java.io.*;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

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
