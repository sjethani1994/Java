import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class streamAPIAllExamples {
    public static void main(String[] args) {
        // 1. filter(Predicate<T> predicate):
        // Syntax: Stream<T> filter(Predicate<? super T> predicate)
        // Example: Filtering even numbers from a list.

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> evenNumbers = numbers.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());
        System.out.println("evenNumbers using filter method " + evenNumbers); // Output: [2, 4, 6]

        // 2. map(Function<T, R> mapper):
        // Syntax: Stream<R> map(Function<? super T, ? extends R> mapper)
        // Example: Converting a list of strings to uppercase.

        List<String> names = Arrays.asList("John", "Jane", "Adam");
        List<String> upperCaseNames = names.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        System.out.println("upperCaseNames using map method " + upperCaseNames); // Output: [JOHN, JANE, ADAM]

        // 3. flatMap(Function<T, Stream<R>> mapper):
        // Syntax: Stream<R> flatMap(Function<? super T, ? extends Stream<? extends R>>
        // mapper)
        // Example: Flattening a list of lists into a single list.

        List<List<Integer>> numbers1 = Arrays.asList(Arrays.asList(1, 2), Arrays.asList(3, 4), Arrays.asList(5, 6));
        List<Integer> flattenedNumbers = numbers1.stream()
                .flatMap(List::stream)
                .collect(Collectors.toList());
        System.out.println("flattenedNumbers using flatMap method " + flattenedNumbers); // Output: [1, 2, 3, 4, 5, 6]

        // 4. distinct():
        // Syntax: Stream<T> distinct()
        // Example: Removing duplicate elements from a list.

        List<Integer> numbers2 = Arrays.asList(1, 2, 2, 3, 3, 4, 5, 5);
        List<Integer> distinctNumbers = numbers2.stream()
                .distinct()
                .collect(Collectors.toList());
        System.out.println("distinct method" + distinctNumbers); // Output: [1, 2, 3, 4, 5]

        // 5. sorted():
        // Syntax: Stream<T> sorted()
        // Example: Sorting a list of strings in ascending order.

        List<String> names1 = Arrays.asList("John", "Jane", "Adam");
        List<String> sortedNames = names1.stream()
                .sorted()
                .collect(Collectors.toList());
        System.out.println("Sorting Method" + sortedNames); // Output: [Adam, Jane, John]

    }
}
