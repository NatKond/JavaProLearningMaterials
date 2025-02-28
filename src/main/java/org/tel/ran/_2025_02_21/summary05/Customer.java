package org.tel.ran._2025_02_21.summary05;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String name;
    private List<Item> shoppingCart;

    public Customer(String name) {
        this.name = name;
        shoppingCart = new ArrayList<>();
    }

    public void addItem(Store store) {
        Item item = store.takeItem();
        shoppingCart.add(item);
        System.out.println(name + " takes " + item);
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        output.append(name).append(": \n");
        for (Item item : shoppingCart) {
            output.append(item).append("\n");
        }
        return output.toString();
    }
}
