package OnlineManagementSystem;

import java.util.ArrayList;
import java.util.List;

public class ShoppingSystem {

    private List<Product> catalog;

    public ShoppingSystem() {
        this.catalog = new ArrayList<>();
    }

    public void addProductToCatalog(Product product) {
        catalog.add(product);
        System.out.println("Product added to catalog: " + product.getName());
    }

    public void removeProductFromCatalog(Product product) {
        catalog.remove(product);
        System.out.println("Product removed from catalog: " + product.getName());
    }

    public Product findProductById(String productId) {
        for (Product product : catalog) {
            if (product.getProductId().equalsIgnoreCase(productId)) {
                return product;
            }
        }
        return null;
    }

    public void showCatalog() {
        System.out.println("Product Catalog:");
        for (Product product : catalog) {
            System.out.println(product);
        }
    }
}
