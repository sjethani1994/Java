import java.io.File;

public class fileHandling {
    public static void main(String[] args) {
        try {
            String fn = "first.txt";
            File f1 = new File(fn);
            if (f1.exists()) {
                System.out.println("File already exists.");
            } else {
                f1.createNewFile();
                System.out.println("File " + f1.getName() + " created.");
            }
        } catch (Exception e) {
            System.out.println("File Already Created");
        }
    }
}
