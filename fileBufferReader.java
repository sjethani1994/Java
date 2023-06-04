import java.io.BufferedReader;
import java.io.FileReader;

public class fileBufferReader {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("first.txt"));
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            br.close();
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("File Not Found.");
        }
    }
}
