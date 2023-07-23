import java.util.ListIterator;
import java.util.Stack;

public class stackExample {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        System.out.println("Full stack : " + stack);
        System.out.println("pop method : " + stack.pop());
        System.out.println("peek method : " + stack.peek());
        System.out.println("search method : " + stack.search(3));

        int x = stack.size();
        System.out.println("The stack size is: " + x);

        ListIterator<Integer> ListIterator = stack.listIterator(stack.size());
        System.out.println("Iteration over the Stack from top to bottom:");
        while (ListIterator.hasPrevious()) {
            Integer avg = ListIterator.previous();
            System.out.println(avg);
        }

         System.out.println("");
        ListIterator<Integer> ListIteratorNew = stack.listIterator();
        System.out.println("Iteration over the Stack from bottom to top:");
        while (ListIteratorNew.hasNext()) {
            Object values = ListIteratorNew.next();
            System.out.println(values);
        }
    }
}
