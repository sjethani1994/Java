public class BinarySearchTree {

    private Node root;

    class Node {
        int value;
        Node left;
        Node right;

        @Override
        public String toString() {
            return "Node {" +
                    "value=" + value +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }

        Node(int value) {
            this.value = value;
        }
    }

    BinarySearchTree() {

    }

    public void addData(int value) {
        Node newNode = new Node(value);
        if (root == null)
            root = newNode;
        Node temp = root;
        if (temp.value == newNode.value)
            return;
        while (true) {
            if (temp.value > newNode.value) {
                if (temp.left == null) {
                    temp.left = newNode;
                    return;
                }
                temp = temp.left;
            } else {
                if (temp.right == null) {
                    temp.right = newNode;
                    return;
                }
                temp = temp.right;
            }
        }
    }

    public boolean contains(int value) {
        Node temp = root;
        while (temp != null) {
            if (temp.value == value)
                return true;
            if (value < temp.value) {
                temp = temp.left;
            } else {
                temp = temp.right;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "BinarySearchTree {" +
                "root=" + root +
                '}';
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();

        // Adding data to the binary search tree
        bst.addData(50);
        bst.addData(30);
        bst.addData(70);
        bst.addData(20);
        bst.addData(40);
        bst.addData(60);
        bst.addData(80);

        // Display the binary search tree
        System.out.println("Binary Search Tree:");
        System.out.println(bst);

        // Searching for values in the binary search tree
        int searchValue1 = 40;
        int searchValue2 = 90;

        System.out.println("\nSearching for value " + searchValue1 + ": " + bst.contains(searchValue1));
        System.out.println("Searching for value " + searchValue2 + ": " + bst.contains(searchValue2));
    }
}
