import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LibraryCatalogApp {
    private static final String CSV_FILE_PATH = "library_catalog.csv";
    private static final double DAILY_CHARGE = 10.0;

    private static List<Book> catalog = new ArrayList<>();

    public static void main(String[] args) {
        loadCatalog();

        displayMenu();
    }

    private static void displayMenu() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("----------------------------------------------------");
        System.out.println("Welcome to the Unique Library");
        System.out.println("----------------------------------------------------");
        System.out.println();
        System.out.println("1. View the complete list of Books");
        System.out.println("2. Issue a Book");
        System.out.println("3. Return a Book");
        System.out.println("4. Exit");
        System.out.println();

        while (true) {
            System.out.print("Please choose an option from the above menu: ");
            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    displayAllBooks();
                    break;
                case 2:
                    issueBook(scanner);
                    break;
                case 3:
                    returnBook(scanner);
                    break;
                case 4:
                    saveCatalog();
                    System.out.println("Thank you for visiting SmartPoint!");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }

            System.out.println();
            System.out.print("Enter 'Y' to return to the main menu or 'N' to Exit: ");
            String choice = scanner.nextLine().toUpperCase();
            if (!choice.equals("Y")) {
                saveCatalog();
                System.out.println("Thank you for visiting SmartPoint!");
                return;
            }

            System.out.println("----------------------------------------------------");
            System.out.println("Welcome to the Unique Library");
            System.out.println("----------------------------------------------------");
            System.out.println();
            System.out.println("1. View the complete list of Books");
            System.out.println("2. Issue a Book");
            System.out.println("3. Return a Book");
            System.out.println("4. Exit");
            System.out.println();
        }
    }

    private static void displayAllBooks() {
        System.out.println("----------------------------------------------------");
        System.out.println("List of all Books");
        System.out.println("----------------------------------------------------");
        System.out.println();
        System.out.printf("%-8s%-20s%-20s%-12s%-12s%n", "Book ID", "Book Title", "Author", "Availability", "Issue Date");
        System.out.println();

        for (Book book : catalog) {
            System.out.printf("%-8s%-20s%-20s%-12s%-12s%n", book.getBookID(), book.getTitle(), book.getAuthor(), book.getAvailability(), book.getIssueDate());
        }
    }

    private static void issueBook(Scanner scanner) {
        System.out.println("----------------------------------------------------");
        System.out.println("Issue the Book");
        System.out.println("----------------------------------------------------");
        System.out.println();

        System.out.print("Enter the Book ID: ");
        String bookId = scanner.nextLine();

        Book book = findBook(bookId);
        if (book != null) {
            if (book.getAvailability().equals("available")) {
                System.out.println(bookId + " - " + book.getTitle() + " by " + book.getAuthor() + ": Available");
                System.out.print("Enter Student ID: ");
                String studentId = scanner.nextLine();

                System.out.print("Enter 'C' to confirm: ");
                String confirm = scanner.nextLine().toUpperCase();

                if (confirm.equals("C")) {
                    book.setAvailability(studentId);
                    book.setIssueDate("Null");
                    System.out.println("BookID: " + bookId + " is issued to " + studentId);
                }
            } else {
                System.out.println("Book " + bookId + " is not available for issuance.");
            }
        } else {
            System.out.println("Book " + bookId + " not found in the catalog.");
        }
    }

    private static void returnBook(Scanner scanner) {
        System.out.println("----------------------------------------------------");
        System.out.println("Return the Book");
        System.out.println("----------------------------------------------------");
        System.out.println();

        System.out.print("Enter the Book ID: ");
        String bookId = scanner.nextLine();

        Book book = findBook(bookId);
        if (book != null) {
            if (!book.getAvailability().equals("available")) {
                System.out.println(bookId + " - " + book.getTitle() + " by " + book.getAuthor());
                System.out.println("StudentID - " + book.getAvailability());
                System.out.println("Issue Date - " + book.getIssueDate());

                String issueDate = book.getIssueDate();
                String currentDate = java.time.LocalDate.now().toString();
                long daysDelayed = calculateDaysDelayed(issueDate, currentDate);

                if (daysDelayed > 0) {
                    double charges = daysDelayed * DAILY_CHARGE;
                    System.out.println("Delayed by - " + daysDelayed + " days");
                    System.out.printf("Delayed Charges - Rs. %.2f%n", charges);

                    System.out.print("Enter 'R' to confirm the return: ");
                    String confirm = scanner.nextLine().toUpperCase();

                    if (confirm.equals("R")) {
                        book.setAvailability("available");
                        book.setIssueDate("Null");
                        System.out.println("BookID: " + bookId + " is returned back");
                    }
                } else {
                    System.out.println("Book " + bookId + " is returned.");
                    book.setAvailability("available");
                    book.setIssueDate("Null");
                }
            } else {
                System.out.println("Book " + bookId + " is already available.");
            }
        } else {
            System.out.println("Book " + bookId + " not found in the catalog.");
        }
    }

    private static Book findBook(String bookId) {
        for (Book book : catalog) {
            if (book.getBookID().equals(bookId)) {
                return book;
            }
        }
        return null;
    }

    private static long calculateDaysDelayed(String issueDate, String currentDate) {
        java.time.LocalDate issue = java.time.LocalDate.parse(issueDate);
        java.time.LocalDate current = java.time.LocalDate.parse(currentDate);
        return java.time.temporal.ChronoUnit.DAYS.between(issue, current);
    }

   private static void loadCatalog() {
    try (BufferedReader reader = new BufferedReader(new FileReader(CSV_FILE_PATH))) {
        String line;
        while ((line = reader.readLine()) != null) {
            String[] bookData = line.split(",");
            if (bookData.length == 5) {
                String bookID = bookData[0];
                String title = bookData[1];
                String author = bookData[2];
                String availability = bookData[3];
                String issueDate = bookData[4].isEmpty() ? "Null" : bookData[4];
                Book book = new Book(bookID, title, author, availability, issueDate);
                catalog.add(book);
            }
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
}

    private static void saveCatalog() {
        try (FileWriter writer = new FileWriter(CSV_FILE_PATH)) {
            for (Book book : catalog) {
                writer.write(book.getBookID() + "," + book.getTitle() + "," + book.getAuthor() + "," + book.getAvailability() + "," + book.getIssueDate() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class Book {
        private String bookID;
        private String title;
        private String author;
        private String availability;
        private String issueDate;

        public Book(String bookID, String title, String author, String availability, String issueDate) {
            this.bookID = bookID;
            this.title = title;
            this.author = author;
            this.availability = availability;
            this.issueDate = issueDate;
        }

        public String getBookID() {
            return bookID;
        }

        public String getTitle() {
            return title;
        }

        public String getAuthor() {
            return author;
        }

        public String getAvailability() {
            return availability;
        }

        public String getIssueDate() {
            return issueDate;
        }

        public void setAvailability(String availability) {
            this.availability = availability;
        }

        public void setIssueDate(String issueDate) {
            this.issueDate = issueDate;
        }
    }
}
