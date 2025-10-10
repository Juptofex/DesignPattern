import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class WordList {
    private String file;

    public WordList(String file) {
        this.file = file;
    }

    public void printIf(Strategy s) throws IOException {
        BufferedReader input = new BufferedReader(
                new FileReader(this.file));
        String buffer;
        while ((buffer = input.readLine()) != null) {
            StringTokenizer mots = new StringTokenizer(buffer,
                    " \t.;(){}\"'*=:!/\\");
            while (mots.hasMoreTokens()) {
                String mot = mots.nextToken();
                if (s.isValid(mot))
                    System.out.println(mot);
            }
        }
    }
}
