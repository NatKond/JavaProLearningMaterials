package org.tel.ran._2025_03_14.summary07;

public class Main {
    public static void main(String[] args) {
        User user1 = new User("Alice", UserRole.ADMIN);
        Order order1 = new Order(user1);
        order1.addAll(Item.LAPTOP, Item.HEADPHONES, Item.SMARTPHONE);
        order1.addItem(Item.LAPTOP);

        User user2 = new User("Bob", UserRole.CUSTOMER);
        Order order2 = new Order(user2);
        order2.addAll(Item.TABLET, Item.SMARTWATCH, Item.SMARTWATCH, Item.HEADPHONES);

        User user3 = new User("Charlie", UserRole.CUSTOMER);
        Order order3 = new Order(user3);
        order3.addAll(Item.MONITOR, Item.KEYBOARD, Item.MOUSE);

        order1.changeStatus();
        System.out.println("order1 = " + order1);

        order2.addItem(Item.HEADPHONES, 5);
        order2.decrease(Item.SMARTWATCH);
        order2.remove(Item.TABLET);
        System.out.println("order2 = " + order2);

        order3.increase(Item.MONITOR);
        order3.cancel();
        System.out.println("order3 = " + order3);
        System.out.println("order3.getTotalAmount() = " + order3.getTotalAmount());

        System.out.println("OrderStorage.getAllOrders(user1) = " + OrderStorage.getAllOrders(user1));
        System.out.println("OrderStorage.getAllOrders(user2) = " + OrderStorage.getAllOrders(user2));
        System.out.println("OrderStorage.getAllOrders(user3) = " + OrderStorage.getAllOrders(user3));
    }
}
