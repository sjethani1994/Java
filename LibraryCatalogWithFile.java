import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.Date;

public class LibraryCatalogWithFile {
    static String[][] catalog;

    public static void main(String[] args) {
        loadDataFromFile();
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
                    saveDataToFile();
                    System.out.println("Data saved to file. Exiting the application.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void loadDataFromFile() {
        try (BufferedReader br = new BufferedReader(new FileReader("library_catalog_using_files.csv"))) {
            catalog = br.lines().map(line -> line.split(",")).toArray(String[][]::new);
        } catch (IOException e) {
            System.out.println("Error reading data from file. Starting with an empty catalog.");
            catalog = new String[0][];
        }
    }

    private static void saveDataToFile() {
        try (PrintWriter writer = new PrintWriter(new FileWriter("library_catalog_using_files.csv"))) {
            for (String[] book : catalog) {
                writer.println(String.join(",", book));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void displayMenu() {
        System.out.println(
                "-----------------------------------------------------------------------------------------------------");
        System.out.println("Welcome to the Unique Library");
        System.out.println(
                "-----------------------------------------------------------------------------------------------------");
        System.out.println("\nView the complete list of Books\n" +
                "Issue a Book\n" +
                "Return a Book\n" +
                "Save and Exit\n");
        System.out.print("\nPlease choose an option from the above menu: ");
    }

    private static void displayBooks() {
        System.out.println(
                "\n-----------------------------------------------------------------------------------------------------");
        System.out.println("List of all Books");
        System.out.println(
                "-----------------------------------------------------------------------------------------------------");
        System.out.println("Book ID\tBook Title\tAuthor\tAvailability\tIssue Date");
        for (String[] book : catalog) {
            for (String attribute : book) {
                System.out.print(attribute + "\t");
            }
            System.out.println();
        }
    }

    private static void issueBook(Scanner scanner) {
        System.out.println(
                "\n-----------------------------------------------------------------------------------------------------");
        System.out.println("Issue the Book");
        System.out.println(
                "-----------------------------------------------------------------------------------------------------");
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
            saveDataToFile(); // Save data to file after issuing a book
        }
    }

    private static void returnBook(Scanner scanner) {
        System.out.println(
                "\n-----------------------------------------------------------------------------------------------------");
        System.out.println("Return the Book");
        System.out.println(
                "-----------------------------------------------------------------------------------------------------");
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
                saveDataToFile(); // Save data to file after returning a book
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
