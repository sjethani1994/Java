import java.util.LinkedList;
import java.util.Queue;

public class QueueBuiltInMethods {
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();
        queue.add("ABC");
        queue.offer("DEF");
        queue.offer("GHI");
        queue.offer("JKL");
        System.out.println(queue);
        System.out.println(queue.peek());
        queue.remove();
        queue.poll();
        System.out.println(queue);

    }

}