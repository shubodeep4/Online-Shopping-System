package OnlineManagementSystem;

public class User {
    private String userId;
    private String name;
    private Cart cart;

    public User(String userId, String name) {
        this.userId = userId;
        this.name = name;
        this.cart = new Cart();
    }

    public String getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public Cart getCart() {
        return cart;
    }

    public void addToCart(Product product, int quantity) {
        cart.addProduct(product, quantity);
    }

    public void removeFromCart(Product product) {
        cart.removeProduct(product);
    }

    public void placeOrder() {
        if (cart.getTotalAmount() > 0) {
            Order order = new Order(userId, cart);
            System.out.println("Order placed successfully! Your order details:");
            System.out.println(order);
            cart.clearCart();
        } else {
            System.out.println("Cart is empty. Cannot place an order.");
        }
    }
}
