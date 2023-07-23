public class LinkedListEx {

    private Node head;
    private Node tail;
    private int length;

    class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    LinkedListEx(int value) {
        Node newNode = new Node(value);
        this.head = newNode;
        this.tail = newNode;
        this.length = 1;
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
            this.head = newNode;
        }
        this.length++;
    }

    public int removeLast() {
        if (length == 0)
            return head.value;
        if (length == 1) {
            this.head = null;
            this.tail = null;
            this.length--;
            return head.value;
        } else {
            Node temp = head;
            Node pre = head;
            while (temp.next != null) {
                pre = temp;
                temp = temp.next;
            }
            this.tail = pre;
            this.tail.next = null;
            this.length--;
            return temp.value;
        }
    }

    public int removeFirst() {
        if (length == 0)
            return head.value;
        if (length == 1) {
            this.head = null;
            this.tail = null;
            this.length--;
            return head.value;
        } else {
            Node temp = head;
            this.head = this.head.next;
            temp.next = null;
            this.length--;
            return temp.value;
        }
    }

    public int getLength() {
        return length;
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

    public void set(int index, int value) {
        Node temp = get(index);
        temp.value = value;
    }

    public Node remove(int value) {
        Node temp = head;
        int index = 0;
        while (temp != null && temp.value != value) {
            temp = temp.next;
            index++;
        }
        if (temp == null)
            return null;
        if (index == 0) {
            removeFirst();
            temp.next = null;
            return temp;
        }
        Node pre = get(index - 1);
        pre.next = temp.next;
        temp.next = null;
        length--;
        return temp;
    }

    public void insert(int index, int value) {
        if (index < 0 || index >= length)
            return;
        if (index == 0) {
            prepend(value);
            return;
        }
        Node newNode = new Node(value);
        Node pre = get(index - 1);
        Node after = get(index + 1);

        pre.next = newNode;
        newNode.next = after;
        length++;
    }

    public void reverse() {
        if (length < 0)
            return;
        Node before = null;
        Node temp = head;
        this.head = tail;
        this.tail = temp;

        for (int i = 0; i < length; i++) {
            if (temp == null)
                return;
            Node after = temp.next;
            temp.next = before;
            before = temp;
            temp = after;
        }
    }

    public static void main(String[] args) {
        LinkedListEx linkedList = new LinkedListEx(10);

        linkedList.append(20);
        linkedList.append(30);
        linkedList.append(40);

        System.out.println("Original Linked List:");
        linkedList.printLList();

        linkedList.reverse();

        System.out.println("\nReversed Linked List:");
        linkedList.printLList();
    }
}
