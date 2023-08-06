import java.util.HashMap;

public class targetSumAssignement {

    public static int[] findIndicesOfTwoNumbers(int weightsOfPackages[], int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < weightsOfPackages.length; i++) {
            int diff = target - weightsOfPackages[i];
            if (map.containsKey(diff)) {
                return new int[] { map.get(diff), i };
            }
            map.put(weightsOfPackages[i], i);
        }
        return new int[] {};
    }

    public static void main(String[] args) {
        int targetWeight = 10;
        int[] weightsOfPackages = { 4, 6, 2, 9, 7, 3 };
        int[] indices = findIndicesOfTwoNumbers(weightsOfPackages, targetWeight);

        if (indices.length == 2) {
            int index1 = indices[0];
            int index2 = indices[1];
            System.out.println(index1 + " " + index2);
        } else {
            System.out.println("No pair found.");
        }
    }
}
