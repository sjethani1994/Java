public class functionalInterfaceExamples {
    public static void main(String[] args) {
        functionInterface ref = (i, j) -> i + j;

        int result = ref.getSum(4, 4);

        System.out.println(result);
    }
}
