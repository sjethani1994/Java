import java.util.Arrays;

public class arrayExample {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 9 };
        String[] strArr = { "A", "B", "C", "D", "E" };
        System.out.println(Arrays.toString(arr)); // printing the array
        System.out.println();
        System.out.println(Arrays.toString(strArr)); // printing the array
        System.out.println();
        System.out.println(arr[1]);

        for (int i : arr) {
            System.out.println(i);
        }

        System.out.println();

        for (String string : strArr) {
            System.out.println(string);
        }

        System.out.println();

        int i = 0;
        while (i < arr.length) {
            System.out.println(arr[i]);
            i++;
        }

        // int[] arr2 = new int[40]; // declaring array with size 40

        // arr2[0] = 1;
        // arr2[1] = 2;
        // arr2[2] = 3;
        // arr2[3] = 4;
        // arr2[4] = 5;
        // System.out.println(arr2[0]);

        // Converting String into an array
        // char[] name =  ;
        // System.out.println();
        }
}
