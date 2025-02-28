package org.tel.ran._2025_02_21.summary05;

import java.util.PriorityQueue;

public class Store {
    private PriorityQueue<Item> items;

    public Store(PriorityQueue<Item> items) {
        this.items = items;
    }

    public boolean addItem (Item item){
        items.add(item);
        return true;
    }

    public Item takeItem (){
        return items.poll();
    }

    public boolean isEmpty(){
        return items.isEmpty();
    }

    @Override
    public String toString() {
        return "Store{" +
                "items=" + items +
                '}';
    }
}
