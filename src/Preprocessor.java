import java.io.*;
import java.util.regex.*;

public class Preprocessor {
    public static void main(String[] args) throws IOException {
        if (args.length < 2) {
            System.out.println("Uso: java Preprocessor <input.moc> <output.moc>");
            return;
        }
        String inputFile = args[0];
        String outputFile = args[1];

        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
        BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));

        String line;
        Pattern charAssign = Pattern.compile("int\\s+(\\w+)\\s*=\\s*'(.)';");
        Pattern strArrAssign = Pattern.compile("int\\[\\]\\s+(\\w+)\\s*=\\s*\"([^\"]*)\";");

        while ((line = reader.readLine()) != null) {
            Matcher mChar = charAssign.matcher(line);
            Matcher mStrArr = strArrAssign.matcher(line);
            if (mChar.find()) {
                String var = mChar.group(1);
                char c = mChar.group(2).charAt(0);
                int ascii = (int) c;
                line = line.replaceFirst("'(.)'", String.valueOf(ascii));
            } else if (mStrArr.find()) {
                String var = mStrArr.group(1);
                String str = mStrArr.group(2);
                StringBuilder arr = new StringBuilder("[");
                for (int i = 0; i < str.length(); i++) {
                    if (i > 0) arr.append(",");
                    arr.append((int)str.charAt(i));
                }
                arr.append("]");
                line = line.replaceFirst("\"([^\"]*)\"", arr.toString());
            }
            writer.write(line);
            writer.newLine();
        }
        reader.close();
        writer.close();
        System.out.println("Pré-processamento concluído: " + outputFile);
    }
} 