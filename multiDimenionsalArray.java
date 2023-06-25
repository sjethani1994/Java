public class multiDimenionsalArray {
    public static void main(String[] args) {
        // 1.Create a 2D array to store the sales data. The array should have dimensions
        // of 7 rows (representing the days of the week)
        // 2Initialize the array with the sales data for each day and product/category.
        // 3.Create an array to store the total sales for each day of the week.
        // 4. Iterate through each row (day) of the 2D array and calculate the sum of
        // sales for that day.
        // 5. Store the calculated sum in the corresponding position in the total sales
        // array.
        // 6. Display the total sales for each day.

        int[][] salesArray = {
                { 12, 35, 71, 62, 92 },
                { 48, 20, 76, 54, 30 },
                { 5, 89, 16, 42, 78 },
                { 99, 10, 57, 4, 18 },
                { 83, 95, 87, 33, 62 },
                { 22, 58, 15, 60, 89 },
                { 27, 46, 51, 32, 9 }
        };

        int[] tSales = new int[salesArray.length];
        int dayTotal = 0;
        int weekTotal = 0;
        for (int i = 0; i < salesArray.length; i++) {
            for (int j = 0; j < salesArray[i].length; j++) {
                dayTotal += salesArray[i][j];
            }
            tSales[i] = dayTotal;
        }

        for (int i = 0; i < tSales.length; i++) {
            System.out.println("day :" + (i + 1) + " Sale:" + tSales[i]);
            weekTotal += tSales[i];
        }

        System.out.println("Total Sale Of Week : " + weekTotal);
    }
}
