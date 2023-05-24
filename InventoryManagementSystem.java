import java.util.Scanner;

public class InventoryManagementSystem {
    private static final int MAX_PRODUCTS = 10;

    private String[] productNames;
    private String[] specifications;
    private double[] costs;
    private int[] quantities;

    public static void main(String[] args) {
        InventoryManagementSystem ims = new InventoryManagementSystem();
        ims.initializeInventory();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the SmartPoint Electronics Store\n");

        while (true) {
            System.out.println("1: View the complete list of our products");
            System.out.println("2: Check the available count for a specific product");
            System.out.println("3: View the specifications and details of a specific product");
            System.out.println("4: Modify the details of a specific product");
            System.out.println("5: Update the inventory for a specific product");
            System.out.println("6: Exit");
            System.out.print("Please choose an option from the above menu: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    ims.displayProductList();
                    break;
                case 2:
                    System.out.print("Enter the Product ID: ");
                    int productId = scanner.nextInt();
                    int count = ims.getProductCount(productId);
                    System.out.println("\n" + productId + " " + ims.productNames[productId - 101]);
                    System.out.println("Total available count: " + count + "\n");
                    break;
                case 3:
                    System.out.print("Enter the Product ID: ");
                    productId = scanner.nextInt();
                    ims.viewProductDetails(productId);
                    break;
                case 4:
                    System.out.print("Enter the Product ID: ");
                    productId = scanner.nextInt();
                    ims.editProduct(productId);
                    break;
                case 5:
                    System.out.print("Enter the Product ID: ");
                    productId = scanner.nextInt();
                    System.out.println("\n1:Add inventory");
                    System.out.println("2: Subtract inventory");
                    System.out.print("Please choose an option from the above menu: ");
                    int inventoryOption = scanner.nextInt();
                    System.out.printf("%nCurrent available inventory for %s: %d%n%n", ims.productNames[productId - 101],
                            ims.quantities[productId - 101]);
                    System.out.print("Please enter the count to be ");
                    if (inventoryOption == 1) {
                        System.out.print("added: ");
                    } else if (inventoryOption == 2) {
                        System.out.print("subtracted: ");
                    }
                    int countToUpdate = scanner.nextInt();
                    ims.updateInventory(productId, countToUpdate);
                    break;
                case 6:
                    System.out.println("\nThank you for visiting SmartPoint!");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice!");
                    break;
            }

            System.out.print("Enter \"Y\" to return to the main menu or \"N\" to Exit: ");
            String continueOption = scanner.next();
            if (!continueOption.equalsIgnoreCase("Y")) {
                System.out.println("\nThank you for visiting SmartPoint!");
                scanner.close();
                break;
            }

            System.out.println();
        }
    }

    public InventoryManagementSystem() {
        productNames = new String[MAX_PRODUCTS];
        specifications = new String[MAX_PRODUCTS];
        costs = new double[MAX_PRODUCTS];
        quantities = new int[MAX_PRODUCTS];
    }

    public void initializeInventory() {
        productNames[0] = "Mobile";
        specifications[0] = "5.5 inch display, 4GB RAM, 64GB storage";
        costs[0] = 500.0;
        quantities[0] = 20;

        productNames[1] = "Laptop";
        specifications[1] = "15.6 inch display, 8GB RAM, 256GB SSD";
        costs[1] = 800.0;
        quantities[1] = 15;
    }

    public void displayProductList() {
        System.out.println("List of all Products\n");
        System.out.println("Product ID\tProduct Name");
        for (int i = 0; i < MAX_PRODUCTS; i++) {
            if (productNames[i] != null) {
                System.out.printf("%8d\t%s\n", i + 101, productNames[i]);
            }
        }
        System.out.println();
    }

    public int getProductCount(int productId) {
        if (isValidProductId(productId)) {
            return quantities[productId - 101];
        }
        return 0;
    }

    public void viewProductDetails(int productId) {
        if (isValidProductId(productId)) {
            System.out.printf("%d %s\n", productId, productNames[productId - 101]);
            System.out.println("Total available count: " + quantities[productId - 101]);
            System.out.println("Specifications: " + specifications[productId - 101]);
            System.out.println();
        } else {
            System.out.println("Invalid Product ID!");
        }
    }

    public void editProduct(int productId) {
        if (isValidProductId(productId)) {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Enter new specifications:");
            String newSpecs = scanner.nextLine();

            System.out.println("Enter new cost:");
            double newCost = scanner.nextDouble();

            System.out.println("Enter new quantity:");
            int newQuantity = scanner.nextInt();

            specifications[productId - 101] = newSpecs;
            costs[productId - 101] = newCost;
            quantities[productId - 101] = newQuantity;

            System.out.println("Product details updated successfully.\n");

            scanner.close();
        } else {
            System.out.println("Invalid Product ID!");
        }
    }

    public void updateInventory(int productId, int countToUpdate) {
        if (isValidProductId(productId)) {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Add inventory or subtract inventory? (A/S)");
            String option = scanner.nextLine();

            if (option.equalsIgnoreCase("A")) {
                quantities[productId - 101] += countToUpdate;
            } else if (option.equalsIgnoreCase("S")) {
                quantities[productId - 101] -= countToUpdate;
            } else {
                System.out.println("Invalid option!");
            }

            System.out.printf("%d%s\n", productId, productNames[productId - 101]);
            System.out.println("Total available count: " + quantities[productId - 101]);
            System.out.println();

            scanner.close();
        } else {
            System.out.println("Invalid Product ID!");
        }
    }

    private boolean isValidProductId(int productId) {
        return productId >= 101 && productId <= 110 && productNames[productId - 101] != null;
    }
}
