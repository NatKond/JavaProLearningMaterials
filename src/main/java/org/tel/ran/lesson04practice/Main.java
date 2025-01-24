package org.tel.ran.lesson04practice;

public class Main {
    public static void main(String[] args) {

        Item[][] items = new Item[5][5];

        Category[] categorys = new Category[5];
        CatalogBuilder.populateCatalog(categorys,items);

        for (Category category : categorys) {
            category.printAllItems();
        }
        System.out.println();
        Basket basket = new Basket();
        basket.addItem(categorys[0].getItems()[0]);
        basket.addItem(categorys[2].getItems()[4]);
        basket.addItem(categorys[4].getItems()[3]);
        basket.printItemsInBasket();

        User user = new User("Ivan","12345", basket);

        System.out.println("user.getBasket().getTotalPrice() = " + user.getBasket().getTotalPrice());

    }
}
