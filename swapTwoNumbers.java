public class swapTwoNumbers {
    public static void main(String[] args) {
        int numA = 63;
        int numB = 15;
        int temp;

        temp = numA;
        numA = numB;
        numB = temp;
        
        System.out.println(numA);
        System.out.println(numB);
    }
}
