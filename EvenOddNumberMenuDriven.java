import java.util.Scanner;

public class EvenOddNumberMenuDriven {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char choice = ' ';
        do {
            System.out.print("Enter Number :- ");
            int number = sc.nextInt();
            sc.nextLine(); // Consume the newline character

            if (number % 2 == 0) {
                System.out.println(number + " is Prime.");
            } else {
                System.out.println(number + " is Odd.");
            }

            System.out.print("Enter \"Y\" to continue or \"N\" to Exit: ");
            String input = sc.nextLine();
            choice = input.charAt(0);
        }while (choice == 'y' || choice == 'Y');

        sc.close();
    }
}
