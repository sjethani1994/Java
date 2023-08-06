import java.util.LinkedList;
import java.util.Queue;

public class StackUsingTwoQueue {
    private Queue<Integer> mainQueue;
    private Queue<Integer> tempQueue;

    public StackUsingTwoQueue() {
        mainQueue = new LinkedList<>();
        tempQueue = new LinkedList<>();
    }

    public void push(int data) {
        // Move all elements from mainQueue to tempQueue
        while (!mainQueue.isEmpty()) {
            tempQueue.add(mainQueue.remove());
        }

        // Add the new element to mainQueue
        mainQueue.add(data);

        // Move all elements back from tempQueue to mainQueue
        while (!tempQueue.isEmpty()) {
            mainQueue.add(tempQueue.remove());
        }

        System.out.println("Element " + data + " is pushed into the Stack.");
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack is Empty.");
            return -1;
        }

        return mainQueue.remove();
    }

    public boolean isEmpty() {
        return mainQueue.isEmpty();
    }

    public static void main(String[] args) {
        StackUsingTwoQueue stack = new StackUsingTwoQueue();
        stack.push(1);
        stack.push(2);
        stack.push(4);
        System.out.println("Popped element: " + stack.pop());
        stack.push(8);
        System.out.println("Popped element: " + stack.pop());
    }
}
