package org.tel.ran._2025_02_21.summary05;

import java.util.PriorityQueue;

public class PriorityQueueExample {
    public static void main(String[] args) {
        PriorityQueue<Item> store= new PriorityQueue<>();
        for (int i = 0; i < 10; i++) {
            store.add(Storage.getRandomItem());
        }
        System.out.println("store = " + store);
        while (!store.isEmpty()){
            System.out.println("I take " + store.poll());
        }
    }

    /**
     * С помощью PriorityQueue реализовать модель: в магазин завозятся продукты с двух разных складов.
     * У каждого продукта есть название и срок годности (пусть для простоты исчисляется в количестве оставшихся дней).
     * В магазин приходят покупатели и выбирают продукт с наибольшим оставшемся сроком годности
     */
}
