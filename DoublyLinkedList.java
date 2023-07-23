public class DoublyLinkedList {
    private Node head;
    private Node tail;
    private int length;

    class Node {
        Node prev;
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    DoublyLinkedList(int value) {
        Node newNode = new Node(value);
        this.head = newNode;
        this.tail = newNode;
        length = 1;
    }

    public int getLength() {
        return length;
    }

    public void printLList() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public void append(int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            this.tail.next = newNode;
            newNode.prev = tail;
            this.tail = newNode;
        }
        this.length++;
    }

    public void prepend(int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            newNode.next = head;
            this.head.prev = newNode;
            this.head = newNode;
        }
        this.length++;
    }

    public Node removeFirst() {
        if (length == 0)
            return null;
        if (length == 1) {
            this.head = null;
            this.tail = null;
            this.length--;
            return null;
        }
        Node temp = head;
        this.head = head.next;
        this.head.prev = null;
        temp.next = null;
        this.length--;
        return temp;
    }

    public Node removeLast() {
        if (length == 0)
            return null;
        if (length == 1) {
            this.head = null;
            this.tail = null;
            length--;
            return null;
        }
        Node temp = tail;
        this.tail = temp.prev;
        this.tail.next = null;
        temp.prev = null;
        this.length--;
        return temp;
    }

    public Node get(int index) {
        if (index < 0 || index >= length)
            return null;
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    public void insert(int index, int value) {
        Node newNode = new Node(value);
        Node temp = get(index);

        newNode.next = temp;
        Node prev = temp.prev;
        temp.prev = newNode;
        prev.next = newNode;
        newNode.prev = prev;
        length++;
    }

    public void set(int index, int value) {
        Node temp = get(index);
        temp.value = value;
    }

    public void remove(int value) {
        Node temp = head;
        int index = 0;

        while (temp != null && temp.value != value) {
            temp = temp.next;
            index++;
        }
        if (temp == null)
            return;

        if (index == 0) {
            removeFirst();
            return;
        }
        if (index == length - 1) {
            removeLast();
            return;
        }
        Node prev = temp.prev;
        prev.next = temp.next;
        Node after = prev.next;
        after.prev = prev;
        temp.next = null;
        temp.prev = null;
        length--;
    }

    public void reverse() {
        if (length < 0)
            return;
        Node before = null;
        Node temp = head;
        this.head = tail;
        this.tail = temp;

        for (int i = 0; i < length; i++) {
            Node after = temp.next;
            temp.next = before;
            temp.prev = after;
            before = temp;
            temp = after;
        }
    }

    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList(10);

        dll.append(20);
        dll.append(30);
        dll.append(40);
        dll.append(50);

        System.out.println("Original Doubly Linked List:");
        dll.printLList();

        dll.reverse();

        System.out.println("\nReversed Doubly Linked List:");
        dll.printLList();
    }
}
