import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import org.antlr.v4.gui.Trees;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
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

                // Mostra a Arvore
                System.out.println("\nParsed Tree:");
                System.out.println(tree.toStringTree(parser));

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
            }
        }

        scanner.close();
    }
}
