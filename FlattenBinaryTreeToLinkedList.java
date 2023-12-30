class TreeNode {
    int val;
    TreeNode left, right;

    public TreeNode(int val) {
        this.val = val;
        this.left = this.right = null;
    }
}

public class FlattenBinaryTreeToLinkedList {
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        flatten(root.left);
        flatten(root.right);

        // Save the right subtree
        TreeNode rightSubtree = root.right;

        // Make the left subtree the new right subtree
        root.right = root.left;
        root.left = null;

        // Move to the end of the modified right subtree
        TreeNode current = root;
        while (current.right != null) {
            current = current.right;
        }

        // Attach the saved right subtree to the end
        current.right = rightSubtree;
    }

    public static void main(String[] args) {
        // Example usage
        FlattenBinaryTreeToLinkedList solution = new FlattenBinaryTreeToLinkedList();

        // Create a sample binary tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(6);

        // Flatten the binary tree
        solution.flatten(root);

        // Display the flattened linked list
        while (root != null) {
            System.out.print(root.val + " ");
            root = root.right;
        }
    }
}
