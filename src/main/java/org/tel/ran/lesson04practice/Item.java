package org.tel.ran.lesson04practice;

/**
 * а) Создать класс Товар, имеющий переменные имя, цена, рейтинг.
 * б) Создать класс Категория, имеющий переменные имя и массив товаров.
 * в) Создать класс Basket, содержащий массив купленных товаров.
 * г) Создать класс User, содержащий логин, пароль и объект класса Basket.
 * Создать несколько объектов класса Категория.
 * Создать объект класса User и инициализировать все его поля, и посчитайте суммарную цену товаров, и средний рейтинг покупок.
 */

public class Item {

    private String name;

    private double price;

    private int rating;

    public Item(String name, double price, int rating) {
        this.name = name;
        this.price = price;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getRating() {
        return rating;
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", rating=" + rating +
                '}';
    }
}
