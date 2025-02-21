package org.tel.ran._2025_02_21.summary05;

import java.util.Random;

public class Storage {
    private static final String[] ITEMS = {"Meat", "Bread", "Milk", "Sugar","Cheese"};
    private static final Random RANDOM = new Random();

    public static Item getRandomItem(){
        return new Item(ITEMS[RANDOM.nextInt(5)],RANDOM.nextInt(30));
    }
}
