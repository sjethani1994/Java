import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class streamApiEx {
    public static void main(String[] args) {
        List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> list2 = Arrays.asList(6, 7, 8, 9, 10);
        List<Integer> list3 = Arrays.asList(11, 12, 13, 14, 15);

        // 1. flatMap Method
        List<Integer> combinedList = Stream.of(list1, list2, list3)
                .flatMap(List::stream)
                .collect(Collectors.toList());

        System.out.println("combined List using flatMap API " + combinedList);

        // 2. peek method
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        numbers.stream()
                .peek(n -> {
                    System.out.println("Before doubling: " + n);
                    System.out.println("------------------");
                })
                .map(n -> n * 2)
                .peek(n -> System.out.println("After doubling: " + n))
                .collect(Collectors.toList());

    }
}
