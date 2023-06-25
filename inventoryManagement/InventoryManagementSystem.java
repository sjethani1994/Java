package inventoryManagement;
import java.util.ArrayList;
import java.util.Scanner;

public class InventoryManagementSystem {
    private static ArrayList<Product> products = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nInventory Management System Menu:");
            System.out.println("1. Add Product");
            System.out.println("2. Product List");
            System.out.println("3. Product Count");
            System.out.println("4. View Product Details");
            System.out.println("5. Edit Product");
            System.out.println("6. Update Inventory");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addProduct(scanner);
                    break;
                case 2:
                    viewProductList();
                    break;
                case 3:
                    getProductCount(scanner);
                    break;
                case 4:
                    viewProductDetails(scanner);
                    break;
                case 5:
                    editProduct(scanner);
                    break;
                case 6:
                    updateInventory(scanner);
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 0);
    }

    private static void addProduct(Scanner scanner) {
        System.out.print("Enter product name: ");
        String name = scanner.next();
        System.out.print("Enter product specification: ");
        String specification = scanner.next();
        System.out.print("Enter product cost: $");
        double cost = scanner.nextDouble();
        System.out.print("Enter product quantity: ");
        int quantity = scanner.nextInt();

        Product product = new Product(name, specification, cost, quantity);
        products.add(product);

        System.out.println("Product added successfully!");
    }

    private static void viewProductList() {
        System.out.println("Product List:");
        for (Product product : products) {
            System.out.println(product.getName());
        }
    }

    private static void getProductCount(Scanner scanner) {
        System.out.print("Enter product name: ");
        String name = scanner.next();

        int count = 0;
        for (Product product : products) {
            if (product.getName().equalsIgnoreCase(name)) {
                count = product.getQuantity();
                break;
            }
        }

        System.out.println("Product count for " + name + ": " + count);
    }

    private static void viewProductDetails(Scanner scanner) {
        System.out.print("Enter product name: ");
        String name = scanner.next();

        for (Product product : products) {
            if (product.getName().equalsIgnoreCase(name)) {
                System.out.println(product);
                break;
            }
        }
    }

    private static void editProduct(Scanner scanner) {
        System.out.print("Enter product name: ");
        String name = scanner.next();

        for (Product product : products) {
            if (product.getName().equalsIgnoreCase(name)) {
                System.out.print("Enter new specification: ");
                String specification = scanner.nextLine();
                scanner.next();
                System.out.print("Enter new cost: $");
                double cost = scanner.nextDouble();

                product.setSpecification(specification);
                product.setCost(cost);

                System.out.println("Product details updated!");
                break;
            }
        }
    }

    private static void updateInventory(Scanner scanner) {
        System.out.print("Enter product name: ");
        String name = scanner.next();

        for (Product product : products) {
            if (product.getName().equalsIgnoreCase(name)) {
                System.out.print("Enter quantity to add (positive value) or delete (negative value): ");
                int quantity = scanner.nextInt();

                int newQuantity = product.getQuantity() + quantity;
                if (newQuantity >= 0) {
                    product.setQuantity(newQuantity);
                    System.out.println("Inventory updated!");
                } else {
                    System.out.println("Invalid quantity! Inventory cannot be negative.");
                }
                break;
            }
        }
    }
}

