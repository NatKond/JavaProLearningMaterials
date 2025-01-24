package org.tel.ran.lesson04practice;

import java.util.Arrays;

public class Basket {

    private Item[] chosenItems = new Item[0];

    public Basket() {
    }

    public Basket(Item[] items) {
        this.chosenItems = items;
    }

    public void addItem(Item item){
        int currentSize = chosenItems.length;
        Item[] newChosenItems = new Item[currentSize + 1];
        for (int i = 0; i < currentSize; i++) {
            newChosenItems[i] = chosenItems[i];
        }
        //Item[] newChosenItems = Arrays.copyOf(chosenItems, currentSize + 1);
        newChosenItems[newChosenItems.length - 1] = item;
        chosenItems = newChosenItems;
    }

    public Item[] getChosenItems() {
        return chosenItems;
    }

    public double getTotalPrice(){
        double result = 0;
        for (Item item:chosenItems){
            result += item.getPrice();
        }
        return result;
    }

    public double getAverageRating(){
        double sum = 0;
        for (Item item:chosenItems){
            sum += item.getRating();
        }
        return sum / chosenItems.length;
    }

    public void printItemsInBasket(){
        System.out.println("Items int the basket:");
        for (int i = 0; i < chosenItems.length; i++) {
            System.out.println(i+ ". " + chosenItems[i].getName() + " " + chosenItems[i].getPrice() + " (" + chosenItems[i].getRating() + ").");
        }
    }

    @Override
    public String toString() {
        return "Basket{" +
                "chosenItems=" + Arrays.toString(chosenItems) +
                '}';
    }
}
