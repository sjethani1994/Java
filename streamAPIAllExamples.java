import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class streamAPIAllExamples {
        public static void main(String[] args) {

                /**
                 * 1. filter(Predicate<T> predicate):
                 * Syntax: Stream<T> filter(Predicate<? super T> predicate)
                 * Example: Filtering even numbers from a list.
                 */

                List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
                List<Integer> evenNumbers = numbers.stream()
                                .filter(n -> n % 2 == 0)
                                .collect(Collectors.toList());
                System.out.println("evenNumbers using filter method " + evenNumbers); // Output: [2, 4, 6]

                /**
                 * 2. map(Function<T, R> mapper):
                 * Syntax: Stream<R> map(Function<? super T, ? extends R> mapper)
                 * Example: Converting a list of strings to uppercase.
                 */

                List<String> names = Arrays.asList("John", "Jane", "Adam");
                List<String> upperCaseNames = names.stream()
                                .map(String::toUpperCase)
                                .collect(Collectors.toList());
                System.out.println("upperCaseNames using map method " + upperCaseNames); // Output: [JOHN, JANE, ADAM]

                /**
                 * 3. flatMap(Function<T, Stream<R>> mapper):
                 * Syntax: Stream<R> flatMap(Function<? super T, ? extends Stream<? extends
                 * R>>mapper)
                 * Example: Flattening a list of lists into a single list.
                 */

                List<List<Integer>> numbers1 = Arrays.asList(Arrays.asList(1, 2), Arrays.asList(3, 4),
                                Arrays.asList(5, 6));
                List<Integer> flattenedNumbers = numbers1.stream()
                                .flatMap(List::stream)
                                .collect(Collectors.toList());
                System.out.println("flattenedNumbers using flatMap method " + flattenedNumbers); // Output: [1, 2, 3, 4,
                                                                                                 // 5, 6]

                /**
                 * 4. distinct():
                 * Syntax: Stream<T> distinct()
                 * Example: Removing duplicate elements from a list.
                 */

                List<Integer> numbers2 = Arrays.asList(1, 2, 2, 3, 3, 4, 5, 5);
                List<Integer> distinctNumbers = numbers2.stream()
                                .distinct()
                                .collect(Collectors.toList());
                System.out.println("distinct method" + distinctNumbers); // Output: [1, 2, 3, 4, 5]

                /**
                 * 5. sorted():
                 * Syntax: Stream<T> sorted()
                 * Example: Sorting a list of strings in ascending order.
                 */
                List<String> names1 = Arrays.asList("John", "Jane", "Adam");
                List<String> sortedNames = names1.stream()
                                .sorted()
                                .collect(Collectors.toList());
                System.out.println("Sorting Method" + sortedNames); // Output: [Adam, Jane, John]

                /**
                 * 6. peek method
                 */
                List<Integer> numbers3 = Arrays.asList(1, 2, 3, 4, 5);

                numbers3.stream()
                                .peek(n -> {
                                        System.out.println("Before doubling: " + n);
                                        System.out.println("------------------");
                                })
                                .map(n -> n * 2)
                                .peek(n -> System.out.println("After doubling: " + n))
                                .collect(Collectors.toList());

                /**
                 * 7. Limit Method
                 */
                List<Integer> numbers4 = Arrays.asList(1, 2, 3, 4, 5);

                List<Integer> limitedNumbers = numbers4.stream()
                                .limit(3)
                                .collect(Collectors.toList());

                System.out.println("Limit Method " + limitedNumbers);

                /**
                 * 8. anyMatch():
                 * Syntax :- boolean anyMatchResult = stream.anyMatch(Predicate<? super T>
                 * predicate);
                 * Example :- Checks if any element in the stream is divisible by 2.
                 */
                List<Integer> numbers5 = Arrays.asList(1, 2, 3, 4, 5);

                boolean anyMatchResult = numbers5.stream().anyMatch(n -> n % 2 == 0);
                System.out.println("Any element divisible by 2 using anyMatch() method ? " + anyMatchResult);

                /**
                 * 9. allMatch():
                 * Syntax :- boolean allMatchResult = stream.allMatch(Predicate<? super
                 * T>predicate)
                 * Example :- Checks if all strings in the stream have a length greater than 3.
                 */
                List<String> words = Arrays.asList("apple", "banana", "pear", "kiwi");

                boolean allMatchResult = words.stream().allMatch(s -> s.length() > 3);
                System.out.println(
                                "All strings have length greater than 3 using allMatch() method ? " + allMatchResult);

                /**
                 * 10. noneMatch():
                 * Syntax :- boolean noneMatchResult = stream.noneMatch(Predicate<? super T>
                 * predicate);
                 * Example :- Checks if none of the elements in the stream are negative numbers.
                 */
                List<Integer> numbers6 = Arrays.asList(1, 2, 3, 4, 5);

                boolean noneMatchResult = numbers6.stream().noneMatch(n -> n < 0);
                System.out.println("No negative numbers in the stream using noneMatch() method ? " + noneMatchResult);

                /**
                 * 11. Reduce():
                 * Syntax :- Optional<T> reduce(BinaryOperator<T> accumulator)
                 * Example :- Reduction without an identity value
                 */
                List<Integer> numbers7 = Arrays.asList(1, 2, 3, 4, 5);

                Optional<Integer> sumOptional = numbers7.stream().reduce((a, b) -> a + b);
                sumOptional.ifPresent(sum -> System.out
                                .println("Calculating Sum Using reduce() method without identity value: " + sum));

                /**
                 * 12. Reduce():
                 * Syntax :- T reduce(T identity, BinaryOperator<T> accumulator)
                 * Example :- Reduction with an identity value
                 */
                List<Integer> numbers8 = Arrays.asList(1, 2, 3, 4, 5);
                int product = numbers8.stream().reduce(1, (a, b) -> a + b);
                System.out.println("Calculating Sum Using reduce() method withidentity value:  " + product);

        }
}
