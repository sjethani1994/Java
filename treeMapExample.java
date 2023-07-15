import java.util.TreeMap;

public class treeMapExample {
    public static void main(String[] args) {
        TreeMap<Integer, String> map = new TreeMap();

        map.put(1, "AA");
        map.put(2, "BB");
        map.put(3, "CC");

        map.remove(1);

        System.out.println(map);
    }
}
