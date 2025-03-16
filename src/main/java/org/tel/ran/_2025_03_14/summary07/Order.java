package org.tel.ran._2025_03_14.summary07;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

public class Order {
    private int id;
    private User user;
    private Map<Item, Integer> items;
    private OrderStatus status;
    private static int countOrder = 0;

    public Order(User user) {
        this(++countOrder, user, new EnumMap<>(Item.class), OrderStatus.NEW);
    }

    public Order(int id, User user, Map<Item, Integer> items, OrderStatus status) {
        this.id = id;
        this.user = user;
        this.items = items;
        this.status = status;
        OrderStorage.addOrder(this);
    }

    public User getUser() {
        return user;
    }

    public void addItem(Item item) {
        items.putIfAbsent(item, 0);
        items.put(item, (items.get(item) + 1));
    }


    public void addItem(Item item, int quantity) {
        items.putIfAbsent(item, 0);
        items.put(item, (items.get(item) + quantity));
    }

    public void addAll(Item... itemsToAdd) {
        for (Item item : itemsToAdd) {
            items.putIfAbsent(item, 0);
            items.put(item, items.get(item) + 1);
        }
    }

    public void increase(Item item) {
        if (!items.containsKey(item)) return;
        addItem(item);
    }

    public void decrease(Item item) {
        if (!items.containsKey(item)) return;
        if (items.get(item) - 1 == 0) {
            items.remove(item);
            return;
        }
        items.put(item, items.get(item) - 1);
    }

    public void remove(Item item) {
        if (!items.containsKey(item)) return;
        items.remove(item);
    }

    public String changeStatus() {
        StringBuilder output = new StringBuilder("Order № ");
        output.append(id).append(" status").append(status).append("→");
        status = status.next();
        return output.append(status).toString();
    }

    public void cancel() {
        if (status.equals(OrderStatus.SHIPPED) || status.equals(OrderStatus.DELIVERED)) return;
        status = OrderStatus.CANCELED;
    }

    public double getTotalAmount() {
        double sum = 0;
        for (Map.Entry<Item, Integer> entry : items.entrySet()) {
            sum += entry.getKey().getPrice();
        }
        return sum;
    }

    @Override
    public String toString() {
        return "Order №" + id +
                ": user=" +  user + '\'' +
                ", items=" + items +
                ", status=" + status;
    }
}
