package org.tel.ran._2025_03_14.summary07;

import java.util.ArrayList;
import java.util.List;

public class OrderStorage {

    private static final List<Order> ORDERS = new ArrayList<>();

    public static void addOrder(Order order) {
        ORDERS.add(order);
    }

    public static List<Order> getAllOrders(User user) {
        if (user.getRole() == UserRole.ADMIN) {
            return ORDERS;
        }

        List<Order> userOrders = new ArrayList<>();
        for (Order order : ORDERS) {
            if (order.getUser().equals(user)){
                userOrders.add(order);
            }
        }
        return userOrders;
    }
}
