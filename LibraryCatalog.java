import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class LibraryCatalog {
    private static final int MAX_BOOKS = 100;
    private static final int BOOK_FIELDS = 5;
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd-MMM-yyyy");

    private static String[][] catalog = new String[MAX_BOOKS][BOOK_FIELDS];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        initializeCatalog(); // Initialize the catalog with sample data

        System.out.println("Welcome to the Unique Library\n");

        while (!exit) {
            printMenu();
            System.out.print("\nPlease choose an option from the above menu: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character after reading the integer

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
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }

        System.out.println("Thank you for using the library catalog application!");
    }

    private static void initializeCatalog() {
        catalog[0] = new String[] { "101", "HTML and CSS", "Jon Duckett", "Available", "Null" };
        catalog[1] = new String[] { "102", "JavaScript: The Good Parts", "Douglas Crockford", "Available", "Null" };
        catalog[2] = new String[] { "103", "Learning Web Design", "Jennifer Niederst Robbins", "CP2014",
                "23-May-2023" };
        catalog[3] = new String[] { "104", "Responsive Web Design", "Ben Frain", "EC3142", "17-May-2023" };
    }

    private static void printMenu() {
        System.out.println("--------------------------------------------------");
        System.out.println("Welcome to the Unique Library");
        System.out.println("--------------------------------------------------");
        System.out.println("1. View the complete list of Books");
        System.out.println("2. Issue a Book");
        System.out.println("3. Return a Book");
        System.out.println("4. Exit");
    }

    private static void displayBooks() {
        System.out.println("\nList of all Books");
        System.out.println("--------------------------------------------------");
        System.out.println("Book ID\tBook Title\t\tAuthor\t\tAvailability\tIssue Date");
        for (String[] book : catalog) {
            if (book[0] == null) {
                break; // Stop iterating when encountering a null book ID
            }
            System.out.println(book[0] + "\t\t" + book[1] + "\t\t" + book[2] + "\t\t" + book[3] + "\t\t" + book[4]);
        }
        System.out.println();
    }

    private static void issueBook(Scanner scanner) {
        System.out.print("\nEnter the Book ID to issue: ");
        String bookId = scanner.nextLine();

        int bookIndex = findBookIndex(bookId);
        if (bookIndex != -1) {
            if (catalog[bookIndex][3].equals("Available")) {
                System.out.print("Enter the Student ID: ");
                String studentId = scanner.nextLine();
                catalog[bookIndex][3] = studentId;
                catalog[bookIndex][4] = LocalDate.now().format(DATE_FORMATTER);
                System.out.println("Book issued successfully!");
                catalog[bookIndex][3] = "Unavailable";
            } else {
                System.out.println("The book is not available for issuance.");
            }
        } else {
            System.out.println("Book not found!");
        }
    }

    private static void returnBook(Scanner scanner) {
        System.out.print("\nEnter the Book ID to return: ");
        String bookId = scanner.nextLine();

        int bookIndex = findBookIndex(bookId);
        if (bookIndex != -1) {
            if (!catalog[bookIndex][3].equals("Available")) {
                LocalDate issueDate = LocalDate.parse(catalog[bookIndex][4], DATE_FORMATTER);
                LocalDate currentDate = LocalDate.now();
                int daysDiff = (int) (currentDate.toEpochDay() - issueDate.toEpochDay());
                int lateDays = Math.max(daysDiff - 7, 0);

                double charges = lateDays * 10;
                System.out.println("Late return charges: Rs. " + charges);

                catalog[bookIndex][3] = "Available";
                catalog[bookIndex][4] = "Null";
                System.out.println("Book returned successfully!");
            } else {
                System.out.println("The book is already available in the library.");
            }
        } else {
            System.out.println("Book not found!");
        }
    }

    private static int findBookIndex(String bookId) {
        for (int i = 0; i < catalog.length; i++) {
            if (catalog[i][0].equals(bookId)) {
                return i;
            }
        }
        return -1; // Book not found
    }
}