import java.util.Scanner;

class TreeNode {
    String word;
    int frequency;
    TreeNode left;
    TreeNode right;

    public TreeNode(String word) {
        this.word = word;
        this.frequency = 1;
        this.left = null;
        this.right = null;
    }
}

class WordFrequencyCounterProcessor {
    private TreeNode root;

    public WordFrequencyCounterProcessor() {
        root = null;
    }

    public void insert(String word) {
        root = insertRoot(root, word);
    }

    private TreeNode insertRoot(TreeNode root, String word) {
        if (root == null) {
            return new TreeNode(word);
        }

        int comparison = word.compareTo(root.word);
        if (comparison < 0) {
            root.left = insertRoot(root.left, word);
        } else if (comparison > 0) {
            root.right = insertRoot(root.right, word);
        } else {
            root.frequency++;
        }

        return root;
    }

    public void printWordFrequencies() {
        inOrderTraversal(root);
    }

    private static void inOrderTraversal(TreeNode root) {
        if (root != null) {
            System.out.println(root.word + ": " + root.frequency);
             inOrderTraversal(root.left);
            inOrderTraversal(root.right);
        }
    }

    public TreeNode getRoot() {
        return root;
    }
}

public class WordFrequencyCounter {
    public static void main(String[] args) {
        WordFrequencyCounterProcessor counter = new WordFrequencyCounterProcessor();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter text:");
        String input = scanner.nextLine();
        String[] words = input.split("\\s+");

        for (String word : words) {
            word = word.toLowerCase().replaceAll("[^a-zA-Z]", "");
            if (!word.isEmpty()) {
                counter.insert(word);
            }
        }

        System.out.println("Word frequencies:");
        counter.printWordFrequencies();

        scanner.close();
    }
}
