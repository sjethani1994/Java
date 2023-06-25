public class arraySort {
    public static void main(String[] args) {
        // 1.Initialize two variables, smallest and secondSmallest,
        // 2.Iterate through each element in the array.
        // 3.Compare the current element with the smallest variable.
        // 4.If the current element is smaller than smallest, update both smallest and
        // secondSmallest accordingly.
        // 5.If the current element is greater than or equal to smallest but smaller
        // than secondSmallest, update secondSmallest only.
        // After iterating through all the elements, secondSmallest will hold the second
        // smallest element in the array.
        // 6. Return the value of secondSmallest.
        int[] abc = { 4, 6, 2, 7, 9, 3, 68, 19 };
        int smallest = abc[0];
        int secondSmallest = abc[1];
        for (int i : abc) {
            if (i < smallest) {
                secondSmallest = smallest;
                smallest = i;
            } else if (i < secondSmallest && i != smallest) {
                secondSmallest = i;
            }
        }
        System.out.println(secondSmallest);
    }
}
