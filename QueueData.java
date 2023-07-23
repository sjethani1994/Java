public class QueueData {
    private Node first;
    private Node last;
    private int length;

    class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    QueueData(int value) {
        Node newNode = new Node(value);
        this.first = newNode;
        this.last = newNode;
        this.length = 1;
    }

    public void printQueueQ() {
        Node temp = first;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public int getLength() {
        return length;
    }

    public void enqueueQ(int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            this.first = newNode;
            this.last = newNode;
        } else {
            newNode.next = first;
            this.first = newNode;
        }
        this.length++;
    }

    public Node dequeueQ() {
        Node prev = first;
        Node temp = first;
        while (temp.next != null){
            prev = temp;
            temp = temp.next;
        }
        prev.next = null;
        this.last = prev;
        this.length--;
        return temp;
    }
}
