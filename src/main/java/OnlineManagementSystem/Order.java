package OnlineManagementSystem;

import java.util.Date;
import java.util.UUID;

public class Order {
    private String orderId;
    private String userId;
    private Cart cart;
    private Date orderDate;

    public Order(String userId, Cart cart) {
        this.orderId = UUID.randomUUID().toString();
        this.userId = userId;
        this.cart = cart;
        this.orderDate = new Date();
    }

    public String getOrderId() {
        return orderId;
    }

    public String getUserId() {
        return userId;
    }

    public Cart getCart() {
        return cart;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    @Override
    public String toString() {
        return "Order ID: " + orderId +
                "\nUser ID: " + userId +
                "\nOrder Date: " + orderDate +
                "\n" + cart.toString();
    }
}
