package org.tel.ran._2025_02_21.summary05;

import java.util.Random;

public class Storage {
    private String[] items = {"Meat", "Bread", "Milk", "Sugar","Cheese"};
    private static final Random RANDOM = new Random();

    public Storage() {
    }

    public Storage(String...items) {
        this.items = items;
    }

    public Item getRandomItem(){
        return new Item(items[RANDOM.nextInt(5)],RANDOM.nextInt(30));
    }
}
