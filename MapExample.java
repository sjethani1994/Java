import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapExample {
    public static void main(String[] args) {
        Map<String, Integer> ageMap = new HashMap<>();
        ageMap.put("John", 25);
        ageMap.put("Alice", 30);
        ageMap.put("Bob", 35);
        int johnsAge = ageMap.get("John");
        System.out.println(johnsAge);

        boolean containsJohn = ageMap.containsKey("John");
        System.out.println(containsJohn); // true

        Set<String> keys = ageMap.keySet();
        System.out.println(keys); // [John, Alice, Bob]

        Collection<Integer> values = ageMap.values();
        System.out.println(values); // [25, 30, 35]
    }
}
