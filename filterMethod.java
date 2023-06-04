import java.util.Arrays;

public class filterMethod {
    public static void main(String[] args) {
        // int[] numbers = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

        // Filter Method
        // int[] evenNumbers = Arrays.stream(numbers).filter(n -> n % 2 == 0).toArray();

        // System.out.println(Arrays.toString(evenNumbers)); // Output: [2, 4, 6, 8, 10]

        // Map Method
        // int[] evenNumbers = Arrays.stream(numbers).map(n -> n * n).toArray();

        // System.out.println(Arrays.toString(evenNumbers)); // Output: [2, 4, 6, 8, 10]

        String[] names = { "John", "Alice", "Bob", "Sarah", "Mark" };

        String[] filteredNames = Arrays.stream(names)
                .filter(n -> n.length() > 3)
                .map(String::toUpperCase)
                .toArray(String[]::new);

        System.out.println(Arrays.toString(filteredNames));
    }
}
