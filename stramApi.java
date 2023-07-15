import java.util.List;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.Arrays;

public class stramApi {
    public static void main(String[] args) {

        // Integer List Example with stream
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

        List<Integer> list1 = numbers.stream().filter(i -> i % 2 == 0).collect(Collectors.toList());

        // getting sum of values in list using mapToInt and sum method
        int sum = numbers.stream().filter(i -> i % 2 == 0).mapToInt(Integer::intValue).sum();

        System.out.println("sum " + sum);

        // getting sum of values in list using mapToInt and sum method
        List<Integer> list4 = numbers.stream().filter(i -> i % 2 == 0).map(k -> k + 1).collect(Collectors.toList());

        System.out.println("list4 " + list4);

        System.out.println("list1 " + list1);

        numbers.stream().filter(i -> i % 2 == 0).forEach(j -> System.out.println(j));

        // String List Example with stream
        List<String> list2 = Arrays.asList("Sumit", "Gopal", "Vilas", "Gulab", "Krishna", "Rakesh");

        List<String> strList = list2.stream().sorted().collect(Collectors.toList());

        System.out.println("strList " + strList);

        // Object List
        List<EmployeeData> empDataList = new ArrayList<>();

        empDataList.add(new EmployeeData(1, "John", 3000));
        empDataList.add(new EmployeeData(2, "Jane", 3500));
        empDataList.add(new EmployeeData(3, "Tom", 2800));

        List<EmployeeData> filteredEmployees = empDataList.stream().filter(i -> i.salary <= 3400)
                .collect(Collectors.toList());
        System.out.println("Employee List" + filteredEmployees);

    }
}
