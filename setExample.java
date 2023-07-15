import java.util.HashSet;

public class setExample {
    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(3);

        set.remove(1);

        System.out.println(set);
    }
}
