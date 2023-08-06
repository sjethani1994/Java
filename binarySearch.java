class BSTNode {
    int value;
    BSTNode left;
    BSTNode right;

    public BSTNode(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }

    public static BSTNode insert(BSTNode current, int value) {
        if (current == null) {
            return new BSTNode(value);
        } else {
            if (value < current.value) {
                current.left = insert(current.left, value);
            } else {
                current.right = insert(current.right, value);
            }
        }
        return current;
    }

    public static void printPreOrder(BSTNode current) {
        if (current == null) {
            return;
        }
        System.out.print(current.value + " ");
        printPreOrder(current.left);
        printPreOrder(current.right);
    }

    public static boolean containsValue(BSTNode current, int searchValue) {
        if (current == null) {
            return false;
        }

        if (searchValue == current.value) {
            return true;
        } else if (searchValue < current.value) {
            return containsValue(current.left, searchValue);
        } else {
            return containsValue(current.right, searchValue);
        }
    }

    public static BSTNode[] findMinMaxInBinarySearchTree(BSTNode current) {
        if (current == null) {
            throw new IllegalArgumentException("The tree is empty.");
        }

        BSTNode min = current;
        BSTNode max = current;

        // Find the leftmost node to get the minimum value
        while (min.left != null) {
            min = min.left;
        }

        // Find the rightmost node to get the maximum value
        while (max.right != null) {
            max = max.right;
        }

        return new BSTNode[] { min, max };
    }

    public static BSTNode deleteNode(BSTNode current, int key) {
        // Base case: If the current node is null (empty subtree), return null
        if (current == null) {
            return null;
        }

        // If the key is smaller than the current node's value, go to the left subtree
        if (key < current.value) {
            current.left = deleteNode(current.left, key);
        }
        // If the key is greater than the current node's value, go to the right subtree
        else if (key > current.value) {
            current.right = deleteNode(current.right, key);
        }
        // If the key matches the current node's value, delete the node
        else {
            // Case 1: Node to be deleted has no children (a leaf node)
            if (current.left == null && current.right == null) {
                return null;
            }
            // Case 2: Node to be deleted has one child (either left or right)
            else if (current.left == null) {
                return current.right;
            } else if (current.right == null) {
                return current.left;
            }
            // Case 3: Node to be deleted has two children
            else {
                // Find the in-order successor (smallest node in the right subtree)
                BSTNode successor = inOrderSuccessor(current.right);
                // Copy the value of the in-order successor to the current node
                current.value = successor.value;
                // Delete the in-order successor from the right subtree
                current.right = deleteNode(current.right, successor.value);
            }
        }

        // Return the updated current node after deletion
        return current;
    }

    // Helper method to find the in-order successor in the given subtree
    private static BSTNode inOrderSuccessor(BSTNode current) {
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }
}

public class binarySearch {
    public static void main(String[] args) {
        BSTNode root = null;
        root = BSTNode.insert(root, 10);
        root = BSTNode.insert(root, 5);
        root = BSTNode.insert(root, 15);
        root = BSTNode.insert(root, 1);
        root = BSTNode.insert(root, 7);
        root = BSTNode.insert(root, 12);
        root = BSTNode.insert(root, 20);

        System.out.print("Pre-order traversal: ");
        BSTNode.printPreOrder(root);
        System.out.println();

        int searchValue = 10;
        boolean isFound = BSTNode.containsValue(root, searchValue);
        System.out.println("Value: " + searchValue + " found: " + isFound);

        try {
            BSTNode[] minMaxNodes = BSTNode.findMinMaxInBinarySearchTree(root);
            BSTNode minNode = minMaxNodes[0];
            BSTNode maxNode = minMaxNodes[1];
            System.out.println("Minimum value: " + minNode.value);
            System.out.println("Maximum value: " + maxNode.value);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        root = BSTNode.deleteNode(root, 10);
        System.out.print("Pre-order traversal after deleting 10: ");
        BSTNode.printPreOrder(root);
        System.out.println();
    }
}
