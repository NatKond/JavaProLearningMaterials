package org.tel.ran.lesson04practice;

import java.util.Arrays;

public class Category {

    private String name;

    private Item[] items;

    public Category() {
    }

    public Category(String name, Item[] items) {
        this.name = name;
        this.items = items;
    }

    public String getName() {
        return name;
    }

    public Item[] getItems() {
        return items;
    }

    public void printAllItems(){
        System.out.println( "--------" + name + "--------");
        for (int i = 0; i < items.length; i++) {
            System.out.println(i+ ". " + items[i].getName() + " " + items[i].getPrice() + " (" + items[i].getRating() + ").");
        }
    }

    @Override
    public String toString() {
        return "Category{" +
                "name='" + name + '\'' +
                ", items=" + Arrays.toString(items) +
                '}';
    }
}
