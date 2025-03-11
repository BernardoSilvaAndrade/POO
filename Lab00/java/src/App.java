import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.lang.Boolean;

public class App {
    public static void main(String[] args) {
        try (FileReader arquivo = new FileReader("src/entrada.txt");
                BufferedReader arquivoF = new BufferedReader(arquivo)) {

            String linha;
            StringBuilder builder = new StringBuilder();
            boolean italico = false;
            boolean negrito = false;
            while ((linha = arquivoF.readLine()) != null) {
                for (int i = 0; i < linha.length(); i++) {
                    char ch = linha.charAt(i);
                    if (ch == '*') {
                        if (italico) {
                            builder.append("</b>");
                        } else {
                            builder.append("<b>");
                        }
                        italico = !italico;
                    } else if (ch == '_') {
                        if (negrito) {
                            builder.append("</i>");
                        } else {
                            builder.append("<i>");
                        }
                        negrito = !negrito;
                    } else {
                        builder.append(ch);
                    }
                }
            }
            System.out.println(builder);
        } catch (IOException e) {
            System.out.println("Erro ao abrir o arquivo: " + e.getMessage());
        }

    }
}