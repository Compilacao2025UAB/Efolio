import java.io.*;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

public class Main {
    public static void main(String[] args) {
<<<<<<< HEAD
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
=======
        Scanner scanner = new Scanner(System.in);
        boolean success = false;

        while (!success) {
            System.out.print("Introduzir o nome do ficheiro (com o caminho se não estiver na pasta testes): ");
            String fileName = scanner.nextLine().trim();
            String filePath = "testes/" + fileName;

            try {
                // Carregar Input
                CharStream input = CharStreams.fromFileName(filePath);
                MOCLexer lexer = new MOCLexer(input);
                CommonTokenStream tokens = new CommonTokenStream(lexer);
                MOCParser parser = new MOCParser(tokens);

                // Fazer Parse
                ParseTree tree = parser.program();

                // Visitor Semantico
                SemanticVisitor checker = new SemanticVisitor();

                // Mostra a Arvore
                System.out.println("\nParsed Tree:");
                System.out.println(tree.toStringTree(parser));

                // Visitor call
                checker.visit(tree);

                // Abre o GUI
                Trees.inspect(tree, parser);

                // Se estiver correto fechar programa
                success = true;

            // Erros
            } catch (IOException e) {
                System.err.println("File not found: " + filePath);
            } catch (Exception e) {
                System.err.println( "An error occurred during parsing.");
                e.printStackTrace();
            }

            if (!success) {
                System.out.println("\nPlease try again.\n");
>>>>>>> 9cbbb2f41009591f36438d9e945b95d648621823
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
