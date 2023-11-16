import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class LibraryCatlogManagementUsingArrays {
    static String[][] catalog = {
            {"101", "HTML and CSS", "Jon Duckett", "Available", "Null"},
            {"102", "JavaScript: The Good Parts", "Douglas C", "Available", "Null"},
            {"103", "Learning Web Design", "Jennifer N", "CP2014", "23-May-2023"},
            {"104", "Responsive Web Design", "Ben Frain", "EC3142", "17-May-2023"}
    };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            displayMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume the newline

            switch (choice) {
                case 1:
                    displayBooks();
                    break;
                case 2:
                    issueBook(scanner);
                    break;
                case 3:
                    returnBook(scanner);
                    break;
                case 4:
                    System.out.println("Thank you for visiting SmartPoint!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void displayMenu() {
        System.out.println("-----------------------------------------------------------------------------------------------------");
        System.out.println("Welcome to the Unique Library");
        System.out.println("-----------------------------------------------------------------------------------------------------");
        System.out.println("\nView the complete list of Books\n" +
                "Issue a Book\n" +
                "Return a Book\n" +
                "Exit\n");
        System.out.print("\nPlease choose an option from the above menu: ");
    }

    private static void displayBooks() {
        System.out.println("\n-----------------------------------------------------------------------------------------------------");
        System.out.println("List of all Books");
        System.out.println("-----------------------------------------------------------------------------------------------------");
        System.out.println("Book ID\tBook Title\tAuthor\tAvailability\tIssue Date");
        for (String[] book : catalog) {
            for (String attribute : book) {
                System.out.print(attribute + "\t");
            }
            System.out.println();
        }
        System.out.print("\nEnter 'Y' to return to the main menu or 'N' to Exit: ");
        Scanner scanner = new Scanner(System.in);
        String returnMenu = scanner.nextLine().toUpperCase();
        if (returnMenu.equals("N")) {
            System.out.println("Thank you for visiting SmartPoint!");
            System.exit(0);
        }
    }

    private static void issueBook(Scanner scanner) {
        System.out.println("\n-----------------------------------------------------------------------------------------------------");
        System.out.println("Issue the Book");
        System.out.println("-----------------------------------------------------------------------------------------------------");
        System.out.print("Enter the Book ID: ");
        String bookId = scanner.nextLine();

        int index = findBookIndex(bookId);
        if (index == -1) {
            System.out.println("Book not found!");
            return;
        }

        String[] book = catalog[index];

        System.out.println(book[0] + " - " + book[1] + " by " + book[2] + ": " + book[3]);

        if (!book[3].equals("Available")) {
            System.out.println("Book is already issued.");
            return;
        }

        System.out.print("Enter StudentID: ");
        String studentId = scanner.nextLine();

        System.out.print("Enter 'C' to confirm: ");
        String confirmation = scanner.nextLine().toUpperCase();

        if (confirmation.equals("C")) {
            book[3] = studentId;
            book[4] = new SimpleDateFormat("dd-MMM-yyyy").format(new Date());
            System.out.println("BookID: " + book[0] + " is Issued to " + studentId);
        }
    }

    private static void returnBook(Scanner scanner) {
        System.out.println("\n-----------------------------------------------------------------------------------------------------");
        System.out.println("Return the Book");
        System.out.println("-----------------------------------------------------------------------------------------------------");
        System.out.print("Enter the Book ID: ");
        String bookId = scanner.nextLine();

        int index = findBookIndex(bookId);
        if (index == -1) {
            System.out.println("Book not found!");
            return;
        }

        String[] book = catalog[index];

        System.out.println(book[0] + " - " + book[1] + " by " + book[2]);
        System.out.println("StudentID - " + book[3]);
        System.out.println("Issue Date - " + book[4]);

        if (book[3].equals("Available")) {
            System.out.println("Book is not issued.");
            return;
        }

        try {
            Date issueDate = new SimpleDateFormat("dd-MMM-yyyy").parse(book[4]);
            Date currentDate = new Date();
            long diffInMillies = Math.abs(currentDate.getTime() - issueDate.getTime());
            long diff = diffInMillies / (24 * 60 * 60 * 1000);

            if (diff > 7) {
                double charges = (diff - 7) * 10;
                System.out.println("Delayed by - " + (diff - 7) + " days");
                System.out.println("Delayed Charges - Rs. " + charges);
            }

            System.out.print("Enter 'R' to confirm the return: ");
            String confirmation = scanner.nextLine().toUpperCase();

            if (confirmation.equals("R")) {
                book[3] = "Available";
                book[4] = "Null";
                System.out.println("BookID: " + book[0] + " is returned back");
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private static int findBookIndex(String bookId) {
        for (int i = 0; i < catalog.length; i++) {
            if (catalog[i][0].equals(bookId)) {
                return i;
            }
        }
        return -1;
    }
}
