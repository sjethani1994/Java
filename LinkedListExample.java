import java.util.LinkedList;

public class LinkedListExample {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add(0, "abc");
        list.addFirst("pqr");
        list.addLast("xyz");
        list.addFirst("jkl");
        System.out.println(list);

        String removedValue = list.remove(1); // Removes the element at index 1
        System.out.println(removedValue);

        boolean removed = list.removeIf(res -> res.startsWith("a"));
        System.out.println("Elements were removed: " + removed);  // true

        int size = list.size();
        System.out.println(size);
    }
}
