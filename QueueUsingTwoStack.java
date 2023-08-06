import java.util.Stack;

public class QueueUsingTwoStack {
    private Stack<Integer> enqueueStack; // For enqueue
    private Stack<Integer> dequeueStack; // For dequeue

    public QueueUsingTwoStack() {
        enqueueStack = new Stack<>();
        dequeueStack = new Stack<>();
    }

    public void enqueue(int data) {
        enqueueStack.push(data);
        System.out.println("Element " + data + " is enqueued into the Queue.");
    }

    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is Empty.");
            return -1;
        }

        if (dequeueStack.isEmpty()) {
            while (!enqueueStack.isEmpty()) {
                dequeueStack.push(enqueueStack.pop());
            }
        }

        return dequeueStack.pop();
    }

    public boolean isEmpty() {
        return enqueueStack.isEmpty() && dequeueStack.isEmpty();
    }

    public static void main(String[] args) {
        QueueUsingTwoStack queue = new QueueUsingTwoStack();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(4);
        System.out.println("Dequeued element: " + queue.dequeue());
        queue.enqueue(8);
        System.out.println("Dequeued element: " + queue.dequeue());
    }
}
