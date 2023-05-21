import java.util.Scanner;

public class patternPrinting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Select a pattern to print:");
        System.out.println("1. Pyramid");
        System.out.println("2. Diamond");
        System.out.println("3. Number Pattern");
        System.out.println("4. Floyd's triangle");

        System.out.print("Enter your choice (1-4): ");
        int choice = scanner.nextInt();
        int rows;

        switch (choice) {
            case 1:
                System.out.println("Enter the number of rows for the pyramid:");
                rows = scanner.nextInt();
                printPyramid(rows);
                break;
            case 2:
                System.out.println("Enter the number of rows for the diamond:");
                rows = scanner.nextInt();
                printDiamondPattern(rows);
                break;
            case 3:
                System.out.println("Enter the number of rows for the number pattern:");
                rows = scanner.nextInt();
                printNumberPattern(rows);
                break;
            case 4:
                System.out.println("Enter the number of rows for Floyd's triangle:");
                rows = scanner.nextInt();
                printFloydTriangle(rows);
                break;
            default:
                System.out.println("Invalid choice!");
        }

        scanner.close();
    }

    public static void printPyramid(int rows) {
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= rows - i; j++) {
                System.out.print(" ");
            }
            for (int k = 1; k <= 2 * i - 1; k++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void printDiamondPattern(int rows) {
        // Upper half of the diamond
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= rows - i; j++) {
                System.out.print(" ");
            }

            for (int k = 1; k <= 2 * i - 1; k++) {
                System.out.print("*");
            }

            System.out.println();
        }

        // Lower half of the diamond
        for (int i = rows - 1; i >= 1; i--) {
            for (int j = 1; j <= rows - i; j++) {
                System.out.print(" ");
            }

            for (int k = 1; k <= 2 * i - 1; k++) {
                System.out.print("*");
            }

            System.out.println();
        }
    }

    public static void printNumberPattern(int rows) {
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    public static void printFloydTriangle(int rows) {
        int floyd = 1;
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(floyd++ + " ");
            }
            System.out.println(" ");
        }
    }
}
