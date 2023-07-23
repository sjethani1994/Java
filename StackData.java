public class StackData {

    private Node top;
    private int length;

    class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    StackData(int value) {
        Node newNode = new Node(value);
        this.top = newNode;
        this.length = 1;
    }

    public void printStack() {
        Node temp = top;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public int getLength() {
        return length;
    }

    public void push(int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            this.top = newNode;
        } else {
            newNode.next = top;
            this.top = newNode;
        }
        this.length++;
    }

    public Node pop() {
        if (length == 0)
            return null;

        Node temp = top;
        this.top = top.next;
        temp.next = null;
        this.length--;
        return temp;
    }

    public static void main(String[] args) {
        StackData stack = new StackData(10);

        stack.push(20);
        stack.push(30);
        stack.push(40);

        System.out.println("Current Stack:");
        stack.printStack();

        Node poppedNode = stack.pop();
        if (poppedNode != null) {
            System.out.println("\nPopped Element: " + poppedNode.value);
        }

        System.out.println("\nUpdated Stack:");
        stack.printStack();
    }
}
