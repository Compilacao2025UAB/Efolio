import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Classe responsável pelo pré-processamento do código fonte.
 * Realiza conversões de caracteres e strings para seus valores ASCII
 * antes da análise léxica e semântica.
 */
public class Preprocessor {
    /**
     * Método principal que processa todo o código fonte.
     * Divide o input em linhas e processa cada uma individualmente.
     * @param input O código fonte a ser processado
     * @return O código fonte processado com as conversões aplicadas
     */
    public static String preprocess(String input) {
        StringBuilder sb = new StringBuilder();
        String[] lines = input.split("\\r?\\n");
        for (String line : lines) {
            sb.append(processLine(line)).append("\n");
        }
        return sb.toString();
    }

    /**
     * Converte caracteres especiais para seus equivalentes ASCII.
     * Exemplo: 'á' -> 'a', 'ç' -> 'c'
     * @param c O carácter a ser convertido
     * @return O carácter convertido para ASCII
     */
    private static String convertToASCII(char c) {
        // Mapeamento de caracteres especiais para ASCII
        switch (c) {
            case 'á': case 'à': case 'ã': case 'â': case 'ä': return "a";
            case 'Á': case 'À': case 'Ã': case 'Â': case 'Ä': return "A";
            case 'é': case 'è': case 'ê': case 'ë': return "e";
            case 'É': case 'È': case 'Ê': case 'Ë': return "E";
            case 'í': case 'ì': case 'î': case 'ï': return "i";
            case 'Í': case 'Ì': case 'Î': case 'Ï': return "I";
            case 'ó': case 'ò': case 'õ': case 'ô': case 'ö': return "o";
            case 'Ó': case 'Ò': case 'Õ': case 'Ô': case 'Ö': return "O";
            case 'ú': case 'ù': case 'û': case 'ü': return "u";
            case 'Ú': case 'Ù': case 'Û': case 'Ü': return "U";
            case 'ç': return "c";
            case 'Ç': return "C";
            case 'ñ': return "n";
            case 'Ñ': return "N";
            default: return String.valueOf(c);
        }
    }
    
    /**
     * Lê um arquivo e aplica o pré-processamento em cada linha.
     * @param filePath Caminho do arquivo a ser lido
     * @return Conteúdo do arquivo processado
     * @throws IOException Se houver erro na leitura do arquivo
     */
    public static String readFile(String filePath) throws IOException {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(
                new FileInputStream(filePath), StandardCharsets.UTF_8))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(preprocess(line)).append("\n");
            }
        }
        return content.toString();
    }

    /**
     * Verifica se uma linha contém uma atribuição ou declaração
     * que precisa de conversão de caracteres/strings.
     * Exemplo: x = 'A' ou x = "ABC"
     * @param line A linha a ser verificada
     * @return true se a linha precisa de conversão, false caso contrário
     */
    private static boolean isAssignmentOrDeclaration(String line) {
        return line.matches(".*= *('.*'|\".*\").*") && !line.trim().startsWith("write");
    }

    /**
     * Processa uma única linha do código fonte.
     * Aplica as conversões necessárias se a linha for uma atribuição ou declaração.
     * @param line A linha a ser processada
     * @return A linha processada com as conversões aplicadas
     */
    private static String processLine(String line) {
        if (isAssignmentOrDeclaration(line)) {
            line = convertCharLiterals(line);
            line = convertStringLiterals(line);
        }
        return line;
    }

    /**
     * Converte literais de carácter para seus valores ASCII.
     * Exemplo: 'A' -> 65
     * @param line A linha contendo literais de carácter
     * @return A linha com os literais convertidos para valores ASCII
     */
    private static String convertCharLiterals(String line) {
        // Regex para encontrar literais de carácter: 'X'
        Pattern charPattern = Pattern.compile("'([^'\\])'");
        Matcher matcher = charPattern.matcher(line);
        StringBuffer sb = new StringBuffer();
        while (matcher.find()) {
            char c = matcher.group(1).charAt(0);
            matcher.appendReplacement(sb, String.valueOf((int) c));
        }
        matcher.appendTail(sb);
        return sb.toString();
    }

    /**
     * Converte literais de string para arrays de valores ASCII.
     * Exemplo: "ABC" -> {65, 66, 67}
     * @param line A linha contendo literais de string
     * @return A linha com os literais convertidos para arrays de valores ASCII
     */
    private static String convertStringLiterals(String line) {
        // Regex para encontrar literais de string: "..."
        Pattern stringPattern = Pattern.compile("\"([^\"]*)\"");
        Matcher matcher = stringPattern.matcher(line);
        StringBuffer sb = new StringBuffer();
        while (matcher.find()) {
            String str = matcher.group(1);
            StringBuilder array = new StringBuilder("{");
            for (int i = 0; i < str.length(); i++) {
                array.append((int) str.charAt(i));
                if (i < str.length() - 1) array.append(", ");
            }
            array.append("}");
            matcher.appendReplacement(sb, array.toString());
        }
        matcher.appendTail(sb);
        return sb.toString();
    }
} 