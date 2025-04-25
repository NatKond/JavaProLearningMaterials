package org.tel.ran._2025_01_23.lesson04practice;

public class Main {
    public static void main(String[] args) {

        Item[][] items = new Item[5][5];

        Category[] categories = new Category[5];
        CatalogBuilder.populateCatalog(categories,items);

        for (Category category : categories) {
            category.printAllItems();
        }
        System.out.println();
        Basket basket = new Basket();
        basket.addItem(categories[0].getItems()[0]);
        basket.addItem(categories[2].getItems()[4]);
        basket.addItem(categories[4].getItems()[3]);
        basket.printItemsInBasket();

        User user = new User("Ivan","12345", basket);

        System.out.println("user.getBasket().getTotalPrice() = " + user.getBasket().getTotalPrice());

    }
}
