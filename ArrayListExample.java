import java.util.ArrayList;
import java.util.List;

public class ArrayListExample {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Sumit");
        list.add("Gopal");
        list.add("Rohit");
        list.add("Mehul");
        list.add("Amrut");
        for (String s: list) {
            System.out.println(s);
        }

        list.remove(0);
        list.remove("Gopal");
        System.out.println(list.size());
    }
}
