import java.util.Scanner;

import MyObject.MyObject;

public class InventoryManagementSystemUsingInterface {
    public static void main(String[] args) {
        MyObject[] productList = new MyObject[20];
        productList[0] = new MyObject(101, "Mobile", 20,
                "RAM: 4GB | Processor: Qualcomm Snapdragon 660 | OS: Android 11", 10000);
        productList[1] = new MyObject(102, "Laptop", 30, "RAM: 8GB | Processor: Intel Core i5-1135G7 | OS: Windows 10",
                70000);
        productList[2] = new MyObject(103, "Tablet", 25, "RAM: 6GB | Processor: Apple A14 Bionic | OS: iPadOS", 30000);
        productList[3] = new MyObject(104, "Portable HDD", 10,
                "Storage: 1TB | Connectivity: USB 3.0 | Compatibility: Windows, macOS", 7000);
        productList[4] = new MyObject(105, "Bluetooth Headphone", 15,
                "Battery Life: 20 hours | Connectivity: Bluetooth 5.0 | Compatibility: iOS, Android", 3500);
        productList[5] = new MyObject(106, "Smart-watch", 40,
                "RAM: 1GB | Processor: Samsung Exynos 9110 | OS: Tizen OS", 25000);
        productList[6] = new MyObject(107, "Digital Camera", 35,
                "Megapixels: 24.2 | Sensor Size: APS-C | Lens: 18-55mm f/3.5-5.6", 45000);
        productList[7] = new MyObject(108, "Portable Power bank", 25,
                "Capacity: 10,000mAh | Input/Output: USB-C | Charging Speed: 18W", 4500);
        productList[8] = new MyObject(109, "Printer", 50,
                "Inkjet | Print Speed: 10 pages per minute | Connectivity: USB, Wi-Fi", 15000);
        productList[9] = new MyObject(110, "Wireless Router", 60,
                "Wi-Fi Standards: 802.11ax | Speed: Up to 1200Mbps | Frequency Bands: Dual-band (2.4 GHz and 5 GHz)",
                8000);

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the SmartPoint Electronics Store\n");

        while (true) {
            System.out.println("1: View the complete list of our products");
            System.out.println("2: Check the available count for a specific product");
            System.out.println("3: View the specifications and details of a specific product");
            System.out.println("4: Add a new product");
            System.out.println("5: Modify the details of a specific product");
            System.out.println("6: Exit");
            System.out.print("Please choose an option from the above menu: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    displayProductList(productList);
                    break;
                case 2:
                    System.out.print("Enter the Product ID: ");
                    int productId = scanner.nextInt();
                    getProductCount(productId, productList);
                    break;
                case 3:
                    System.out.print("Enter the Product ID: ");
                    productId = scanner.nextInt();
                    viewProductDetails(productId, productList);
                    break;
                case 4:
                    addProductDetails(productList);
                    break;
                case 5:
                    System.out.print("Enter the Product ID: ");
                    productId = scanner.nextInt();
                    editProduct(productId, productList);
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
        }

        System.out.println();
    }

    public static void displayProductList(MyObject[] productList) {
        for (MyObject product : productList) {
            if (product != null) {
                System.out.printf("%d %s\n", product.productId, product.productName);
                System.out.println("-------------------------");
            }
        }
    }

    public static void getProductCount(int productId, MyObject[] productList) {
        if (isValidProductId(productId, productList)) {
            for (MyObject product : productList) {
                if (product != null) {
                    if (productId == product.productId) {
                        System.out.println("\n" + productId + " " + product.productName);
                        System.out.println("Total available count: " + product.productCount + "\n");
                    }
                }
            }
        }
    }

    public static void viewProductDetails(int productId, MyObject[] productList) {
        for (MyObject product : productList) {
            if (product != null) {
                if (productId == product.productId) {
                    System.out.printf("%d %s %s\n", product.productId, product.productName,
                            product.productSpecifications);
                    System.out.println("-------------------------");
                }
            }
        }
    }

    public static boolean isValidProductId(int productId, MyObject[] productList) {
        for (MyObject product : productList) {
            if (product != null) {
                if (productId == product.productId) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void addProductDetails(MyObject[] productList) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Product Name : ");
        String productName = sc.nextLine();

        System.out.println("Enter Product count : ");
        int productCount = sc.nextInt();

        sc.nextLine();

        System.out.println("Enter Product Specifications : ");
        String productSpecifications = sc.nextLine();

        System.out.println("Enter Product price : ");
        int productPrice = sc.nextInt();

        int productId;
        int lastIndex = -1;
        for (int i = productList.length - 1; i >= 0; i--) {
            if (productList[i] != null) {
                lastIndex = i;
                break;
            }
        }

        if (lastIndex != -1) {
            productId = productList[lastIndex].productId + 1;
        } else {
            productId = 1; // or any other default value
        }

        MyObject newProduct = new MyObject(productId, productName, productCount, productSpecifications, productPrice);

        int index = -1;
        for (int i = 0; i < productList.length; i++) {
            if (productList[i] == null) {
                index = i;
                break;
            }
        }

        // If an empty slot is found, add the new product to the productList array
        if (index != -1) {
            productList[index] = newProduct;
            System.out.println("Product added successfully.");
        } else {
            System.out.println("Product list is full. Unable to add the product.");
        }
    }

    public static void editProduct(int productId, MyObject[] productList) {
        MyObject newProduct = null;
        int index = -1;
        for (int i = 0; i < productList.length; i++) {
            if (productList[i] != null) {
                if (productId == productList[i].productId) {
                    index = i;
                    newProduct = new MyObject(productList[i].productId, productList[i].productName,
                            productList[i].productCount, productList[i].productSpecifications,
                            productList[i].productPrice);
                }
            }
            // Use 'product' and 'i' as needed
        }

        if (newProduct != null) {

            System.out.printf("%s %d %s\n", newProduct.productName, newProduct.productCount,
                    newProduct.productSpecifications);
            System.out.println("-------------------------");

            Scanner sc = new Scanner(System.in);

            System.out.println("Enter Product count : ");
            int productCount = sc.nextInt();

            sc.nextLine();

            System.out.println("Enter Product Specifications : ");
            String productSpecifications = sc.nextLine();

            System.out.println("Enter Product price : ");
            int productPrice = sc.nextInt();

            MyObject editProduct = new MyObject(newProduct.productId, newProduct.productName, productCount,
                    productSpecifications, productPrice);

            productList[index] = productList[index] = new MyObject(editProduct.productId, editProduct.productName,
                    editProduct.productCount, editProduct.productSpecifications, editProduct.productPrice);
            System.out.println("Product details updated successfully.\n");
        }
    }
}
