class Node {
    int value;
    Node next;

    public Node(int value) {
        this.value = value;
    }
}

public class QueueUsingLinkedList {
    Node front = null; // Front of the queue
    Node rear = null; // Rear of the queue
    int size = 0;

    public void enqueue(int data) {
        Node newNode = new Node(data);
        if (getSize() == 0) {
            front = newNode;
            rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        System.out.println("Element " + data + " is enqueued into the Queue");
        size++;
    }

    public int dequeue() {
        if (getSize() == 0) {
            System.out.println("Queue is Empty");
            return -1;
        } else {
            Node temp = front;
            front = front.next;
            if (front == null) {
                rear = null; // If the last element was dequeued, reset rear to null
            }
            size--;
            return temp.value;
        }
    }

    public void printQueue() {
        Node curr = front;
        while (curr != null) {
            System.out.print(curr.value + " ");
            curr = curr.next;
        }
        System.out.println();
    }

    public int getSize() {
        return size;
    }

    public static void main(String[] args) {
        QueueUsingLinkedList queue = new QueueUsingLinkedList();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(4);
        queue.printQueue();
        System.out.println("Dequeued element: " + queue.dequeue());
        queue.printQueue();
    }
}
