package org.tel.ran._2025_02_21.summary05;

import java.util.PriorityQueue;

public class PriorityQueueExample {
    public static void main(String[] args) {
        PriorityQueue<Item> items= new PriorityQueue<>();
        Storage groceryStore = new Storage();
        Storage fruitStore = new Storage("apples", "bananas", "oranges", "grapes", "kiwi");

        for (int i = 0; i < 10; i++) {
            items.add(groceryStore.getRandomItem());
            items.add(fruitStore.getRandomItem());
        }
        Store store1 = new Store(items);
        System.out.println(store1);

        Customer customer1 = new Customer("John Doh");
        Customer customer2 = new Customer("Jane Doh");

        while (!store1.isEmpty()){
            customer1.addItem(store1);
            customer2.addItem(store1);
        }

        System.out.println(customer1);
        System.out.println(customer2);
    }

    /**
     * С помощью PriorityQueue реализовать модель: в магазин завозятся продукты с двух разных складов.
     * У каждого продукта есть название и срок годности (пусть для простоты исчисляется в количестве оставшихся дней).
     * В магазин приходят покупатели и выбирают продукт с наибольшим оставшемся сроком годности
     */
}
