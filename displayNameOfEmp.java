import java.util.ArrayList;
import java.util.Scanner;

public class displayNameOfEmp {
    public static void main(String[] args) {
        ArrayList<String> arrList = new ArrayList<>();

        Scanner sc = new Scanner(System.in);
        char choice = ' ';
        do {
            System.out.println("Enter Employee Name :- ");
            String empName = sc.nextLine();

            arrList.add(empName);
            System.out.println(arrList);
            System.out.print("Enter \"Y\" to continue or \"N\" to Exit: ");
            String input = sc.nextLine();
            choice = input.charAt(0);
        } while (choice == 'y' || choice == 'Y');

        sc.close();
    }
}
