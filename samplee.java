import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class samplee {
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private static String fileName = "order_data.csv";

    // Method to write order data to CSV file
    public static void writeOrderData(String[] orderData) {
        String header = "Waiter Name, Customer Name, Item Name, Sales Amount, Order Mode, Tip Amount";
        String orderLine = String.join(",", orderData);

        try (BufferedWriter writer = Files.newBufferedWriter(Path.of(fileName), StandardOpenOption.CREATE,
                StandardOpenOption.APPEND)) {
            if (Files.size(Path.of(fileName)) == 0) {
                writer.write(header);
                writer.newLine();
            }

            writer.write(orderLine);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method to read order data from CSV file
    public static List<String[]> readOrderData() {
        List<String[]> orderDataList = new ArrayList<>();
        // TODO: Read order data from the CSV file and populate the orderDataList
        return orderDataList;
    }

    // Method to calculate total sales
    public static double calculateTotalSales(List<String[]> orderDataList) {
        double amount = 0;
        try (BufferedReader re = new BufferedReader(new FileReader(fileName))) {
            String line;
            line = re.readLine();
            while ((line = re.readLine()) != null) {
                String[] data = line.split(",");
                amount += Double.parseDouble(data[4]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return amount;
    }

    // Method to search for orders by customer name
    public static void searchOrdersByCustomerName(List<String[]> orderDataList) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter customer name: ");
        String customerName = scanner.nextLine();

        try (BufferedReader brr = new BufferedReader(new FileReader(fileName))) {
            String line = brr.readLine();

            while ((line = brr.readLine()) != null) {

                String[] data = line.split(",");
                String name = data[1].trim();
                if (name.equalsIgnoreCase(customerName))
                    System.out.println("Name of the employee: " + name);

            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    // Method to find online orders on a particular date
    public static void findOnlineOrdersByDate(List<String[]> orderDataList) {
    }

    // Method to find the waiter who handled the maximum number of customers

    public static String findMaxCustomerWaiter(List<String[]> orderDataList) {
        return null;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("----------- Restaurant System Menu -----------");
            System.out.println("1. Place an Order");
            System.out.println("2. Calculate Total Sales for the Day");
            System.out.println("3. Search Orders by Customer Name");
            System.out.println("4. Find Online Orders on a Date");
            System.out.println("5. Find Waiter Handling Maximum Customers");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            List<String[]> orderDataList = readOrderData();

            switch (choice) {
                case 1:
                    System.out.print("Enter waiter name: ");
                    String waiterName = scanner.nextLine();

                    System.out.print("Enter customer name: ");
                    String customerName = scanner.nextLine();

                    System.out.print("Enter item name: ");
                    String itemName = scanner.nextLine();

                    System.out.print("Enter sales amount: ");
                    double salesAmount = scanner.nextDouble();

                    System.out.print("Enter order mode (online/offline): ");
                    String orderMode = scanner.next();
                    scanner.nextLine(); // Consume the newline character

                    System.out.print("Enter tip amount: ");
                    double tipAmount = scanner.nextDouble();
                    scanner.nextLine(); // Consume the newline character

                    String[] orderData = {
                            waiterName,
                            customerName,
                            itemName,
                            orderMode,
                            String.valueOf(salesAmount),
                            LocalDate.now().format(DATE_FORMATTER),
                            String.valueOf(tipAmount)
                    };
                    if (orderData != null) {
                        writeOrderData(orderData);
                    }
                    break;

                case 2:
                    double totalSales = calculateTotalSales(orderDataList);
                    System.out.println("Total sales for the day: $" + totalSales);
                    break;

                case 3:
                    searchOrdersByCustomerName(orderDataList);
                    break;

                case 4:
                    findOnlineOrdersByDate(orderDataList);
                    break;

                case 5:
                    String maxCustomerWaiter = findMaxCustomerWaiter(orderDataList);
                    System.out.println("Waiter who handled the maximum number of customers: " + maxCustomerWaiter);
                    break;

                case 6:
                    System.out.println("Exiting the program. Goodbye!");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }

            System.out.println();
        }
    }

}