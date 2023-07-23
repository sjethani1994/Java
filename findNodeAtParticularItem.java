class Node<E> {
    E item;
    Node<E> next;

    public Node(E item) {
        this.item = item;
        this.next = null;
    }
}

class LinkedList<E> {
    private Node<E> head;
    private int size;

    public LinkedList() {
        this.head = null;
        this.size = 0;
    }

    public void addToFront(E item) {
        Node<E> newNode = new Node<>(item);
        newNode.next = head;
        head = newNode;
        size++;
    }

    public E getItemAtPosition(int position) {
        if (position < 0 || position >= size) {
            throw new IndexOutOfBoundsException("Invalid position. Position should be between 0 and " + (size - 1));
        }

        Node<E> current = this.head;
        for (int i = 0; i < position; i++) {
            current = current.next;
        }
        return current.item;
    }

    public int getPositionOfItem(E item) {
        Node<E> current = this.head;
        int position = 0;
        while (current != null) {
            if (current.item.equals(item)) {
                return position;
            }
            current = current.next;
            position++;
        }
        return -1; // Item not found
    }

    public void reverse() {
        Node<E> previous = null;
        Node<E> current = head;
        Node<E> next = null;

        while (current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        head = previous; // The new head is the last node after reversing
    }

    public int getSize() {
        return size;
    }

    public void printNodes() {
        if (size == 0) {
            System.out.println("List is empty.");
            return;
        }

        Node<E> current = head;
        int index = 0;
        while (current != null) {
            System.out.println("Node " + current.item + " is at location " + index);
            current = current.next;
            index++;
        }
    }
}

public class findNodeAtParticularItem {
    public static void main(String[] args) {
        LinkedList<String> linkedList = new LinkedList<>();

        linkedList.addToFront("Apple");
        linkedList.addToFront("Banana");
        linkedList.addToFront("Orange");
        linkedList.addToFront("Grapes");

        linkedList.printNodes();
        System.out.println();

        int position1 = 1;
        int position2 = 3;

        String item1 = linkedList.getItemAtPosition(position1);
        String item2 = linkedList.getItemAtPosition(position2);

        System.out.println("Item at position " + position1 + ": " + item1);
        System.out.println("Item at position " + position2 + ": " + item2);
        System.out.println();

        String item3 = "Orange";
        String item4 = "Apple";

        int position3 = linkedList.getPositionOfItem(item3);
        int position4 = linkedList.getPositionOfItem(item4);

        System.out.println("Item " + item3 + " at position : " + position3);
        System.out.println("Item " + item4 + " at position : " + position4);
        System.out.println();

        linkedList.reverse();
        linkedList.printNodes();
    }
}
