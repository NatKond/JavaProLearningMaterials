package org.tel.ran._2025_03_06.lesson13;

import java.util.Objects;

public class Product {

    private String name;
    private String sku;
    private String category;
    private double price;
    private double discountPercentage;

    public Product(String name, String sku, String category, double price, double discountPercentage) {
        this.name = name;
        this.sku = sku;
        this.category = category;
        this.price = price;
        this.discountPercentage = discountPercentage;
    }

    public String getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }

    public String getSku() {
        return sku;
    }

    public double getPrice() {
        return price;
    }

    public double getDiscountPercentage() {
        return discountPercentage;
    }

    public double getFinalPrice() {
        return price * (1 - discountPercentage / 100);
    }

    public void setDiscountPercentage(double discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    public void checkSku(){
        if (!sku.matches("[A-Z]{3}-\\d{4}")){
            throw new InvalidSkuException(name + " has invalid stock keeping unit.");
        }
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) return false;
        Product product = (Product) object;
        return Double.compare(price, product.price) == 0 && Double.compare(discountPercentage, product.discountPercentage) == 0 && Objects.equals(name, product.name) && Objects.equals(sku, product.sku) && Objects.equals(category, product.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, sku, category, price, discountPercentage);
    }

    @Override
    public String toString() {
        return name +
                ": sku='" + sku + '\'' +
                ", category='" + category + '\'' +
                ", price=" + price +
                ", discountPercentage=" + discountPercentage;
    }
}
