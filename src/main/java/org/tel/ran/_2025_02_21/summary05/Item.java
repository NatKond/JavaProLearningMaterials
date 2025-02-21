package org.tel.ran._2025_02_21.summary05;

public class Item implements Comparable<Item>{
    private String name;
    private int expirationDate;

    public Item(String name, int expirationDate) {
        this.name = name;
        this.expirationDate = expirationDate;
    }

    @Override
    public int compareTo(Item o) {
        return o.expirationDate - this.expirationDate;
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", expirationDate=" + expirationDate +
                '}';
    }
}
