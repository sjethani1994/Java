import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class mapOperatorInStream {
    public static void main(String[] args) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("1", "YaYa");
        hashMap.put("2", "NoNo");
        hashMap.put("3", "OkOk");

        List<String> listOfString = hashMap.entrySet().stream().filter(i -> i.getKey().startsWith("2"))
                .map(Map.Entry::getValue).collect(Collectors.toList());
        System.out.println("listOfString " + listOfString);

        List<String> newList = Arrays.asList("aaa", "abc", "aaa", "pqr", "xyz", "bbb", "aaa");
        List<String> distinctList = newList.stream().distinct().collect(Collectors.toList());
        Long countOfDistinctElementsInList = newList.stream().distinct().count();
        System.out.println("distinct List " + distinctList);
        System.out.println("distinct List Count " + countOfDistinctElementsInList);

    }
}
