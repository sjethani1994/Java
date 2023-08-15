import java.util.Scanner;
import java.util.Stack;

class CartItem {
    private String itemName;
    private int quantity;

    public CartItem(String itemName, int quantity) {
        this.itemName = itemName;
        this.quantity = quantity;
    }

    public String getItemName() {
        return itemName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return itemName + " (Quantity: " + quantity + ")";
    }
}

class ShoppingCart {
    private Stack<CartItem> items;

    public ShoppingCart() {
        items = new Stack<>();
    }

    public void addItem(String itemName, int quantity) {
        CartItem newItem = new CartItem(itemName, quantity);
        items.push(newItem);
        System.out.println(quantity + " " + itemName + "(s) added to the cart.");
    }

    public void updateItemQuantity(String itemName, int newQuantity) {
        for (CartItem item : items) {
            if (item.getItemName().equals(itemName)) {
                item.setQuantity(newQuantity);
                System.out.println("Quantity of " + itemName + " updated to " + newQuantity);
                return;
            }
        }
        System.out.println(itemName + " not found in the cart.");
    }

    public void removeItem(String itemName) {
        for (CartItem item : items) {
            if (item.getItemName().equals(itemName)) {
                items.remove(item);
                System.out.println(itemName + " removed from the cart.");
                return;
            }
        }
        System.out.println(itemName + " not found in the cart.");
    }

    public void displayCart() {
        if (items.isEmpty()) {
            System.out.println("Cart is empty.");
        } else {
            System.out.println("Items in the cart:");
            for (CartItem item : items) {
                System.out.println("- " + item);
            }
        }
    }
}

public class cart {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Add Item");
            System.out.println("2. Update Quantity");
            System.out.println("3. Remove Item");
            System.out.println("4. Display Cart");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            int newQuantity;
            switch (choice) {
                case 1:
                    System.out.print("Enter item name: ");
                    String itemName = scanner.nextLine();
                    System.out.print("Enter quantity: ");
                    int quantity = scanner.nextInt();
                    cart.addItem(itemName, quantity);
                    break;
                case 2:
                    System.out.print("Enter item name: ");
                    itemName = scanner.nextLine();
                    System.out.print("Enter new quantity: ");
                    newQuantity = scanner.nextInt();
                    cart.updateItemQuantity(itemName, newQuantity);
                    break;
                case 3:
                    System.out.print("Enter item name: ");
                    itemName = scanner.nextLine();
                    cart.removeItem(itemName);
                    break;
                case 4:
                    cart.displayCart();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please choose a valid option.");
            }
        }
    }
}
