package OnlineManagementSystem;

import java.util.HashMap;
import java.util.Map;


public class Cart {

    private Map<Product, Integer> products;

    public Cart() {
        this.products = new HashMap<>();
    }

    public void addProduct(Product product, int quantity) {
        if (product.getQuantity() >= quantity) {
            products.put(product, products.getOrDefault(product, 0) + quantity);
            product.setQuantity(product.getQuantity() - quantity);
            System.out.println("Product added to cart: " + product.getName());
        } else {
            System.out.println("Insufficient stock for product: " + product.getName());
        }
    }

    public void removeProduct(Product product) {
        if (products.containsKey(product)) {
            int quantity = products.get(product);
            product.setQuantity(product.getQuantity() + quantity);
            products.remove(product);
            System.out.println("Product removed from cart: " + product.getName());
        } else {
            System.out.println("Product not found in cart: " + product.getName());
        }
    }

    public double getTotalAmount() {
        double total = 0;
        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            total += entry.getKey().getPrice() * entry.getValue();
        }
        return total;
    }

    public void clearCart() {
        products.clear();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Cart:\n");
        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            sb.append(entry.getKey().getName())
                    .append(" (x")
                    .append(entry.getValue())
                    .append(") - $")
                    .append(entry.getKey().getPrice() * entry.getValue())
                    .append("\n");
        }
        sb.append("Total: $").append(getTotalAmount());
        return sb.toString();
    }
    
    


}
