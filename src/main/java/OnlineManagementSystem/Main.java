package OnlineManagementSystem;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        ShoppingSystem system = new ShoppingSystem();
        User user = new User("U001", "John Doe");

        // Adding products to the catalog
        Product product1 = new Product("P001", "Laptop", 1200.00, 10);
        Product product2 = new Product("P002", "Smartphone", 800.00, 15);
        system.addProductToCatalog(product1);
        system.addProductToCatalog(product2);

        // Showing the product catalog
        system.showCatalog();

        // User interaction
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nEnter the Product ID to add to the cart:");
        String productId = scanner.nextLine();
        Product product = system.findProductById(productId);

        if (product != null) {
            System.out.println("Enter the quantity:");
            int quantity = scanner.nextInt();
            user.addToCart(product, quantity);
        } else {
            System.out.println("Product not found.");
        }

        // Showing the cart
        System.out.println("\n" + user.getCart());

        // Placing the order
        user.placeOrder();

        // Showing the catalog after the order is placed
        System.out.println("\nCatalog after the order:");
        system.showCatalog();
    }
}