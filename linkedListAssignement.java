class Node<E> {
    public E item;
    public Node<E> next;

    public Node(E item) {
        this.item = item;
        this.next = null;
    }
}

public class linkedListAssignement<E> {
    private Node<E> head;
    private int size;

    public linkedListAssignement() {
        this.head = null;
        this.size = 0;
    }

    public void insertAtBeginning(E value) {
        Node<E> newNode = new Node<>(value);
        newNode.next = head;
        head = newNode;
        size++;
    }

    public void insertAtParticularPosition(E value, int position) {
        if (position < 0 || position > size) {
            System.out.println("Invalid position. Position should be between 0 and " + size);
            return;
        }

        if (position == 0) {
            insertAtBeginning(value);
            return;
        }

        Node<E> newNode = new Node<>(value);
        Node<E> current = head;
        for (int i = 1; i < position; i++) {
            current = current.next;
        }
        newNode.next = current.next;
        current.next = newNode;
        size++;
    }

    public void insertionAtEnd(E value) {
        Node<E> newNode = new Node<>(value);
        if (head == null) {
            head = newNode;
        } else {
            Node<E> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }

    public void deleteAtBeginning() {
        if (head != null) {
            head = head.next;
            size--;
        } else {
            System.out.println("List is empty. Nothing to delete.");
        }
    }

    public void deleteAtNth(int position) {
        if (this.head != null && position <= this.size) {
            Node<E> prev = null;
            Node<E> current = head;
            for (int i = 0; i < position; i++) {
                prev = current;
                current = current.next;

            }
            prev.next = current.next;
            this.size--;
        } else {
            System.out.println("Invalid position");
        }
    }

    public void deleteAtEnd() {
        if (head == null) {
            System.out.println("List is empty. Nothing to delete.");
            return;
        }

        if (head.next == null) {
            head = null;
            size = 0;
            return;
        }

        Node<E> prev = null;
        Node<E> current = head;

        while (current.next != null) {
            prev = current;
            current = current.next;
        }

        prev.next = null;
        size--;
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

    public static void main(String[] args) {
        linkedListAssignement<String> list = new linkedListAssignement<>();
        list.insertAtBeginning("Sumit");
        list.insertAtBeginning("Gopal");
        list.insertAtBeginning("Ravi");
        list.insertionAtEnd("Sushil");
        list.insertAtParticularPosition("Vilas", 1);
        list.printNodes();
        list.deleteAtBeginning();
        list.printNodes();
        list.deleteAtEnd();
        list.printNodes();
        list.deleteAtNth(1);
        list.printNodes();
    }
}
