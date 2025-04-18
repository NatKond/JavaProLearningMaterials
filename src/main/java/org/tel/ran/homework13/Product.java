package org.tel.ran.homework13;

import java.util.Objects;

public class Product {
    private int id;
    private ProductCategory productCategory;
    private String name;
    private String factory;
    private int quantity;
    private boolean isPacked;
    private boolean isAdv;
    private double price;
    private double margin;
    private boolean isDebt;

    public Product() {
    }

    public Product setId(int id) {
        this.id = id;
        return this;
    }

    public Product setProductCategory(ProductCategory productCategory) {
        this.productCategory = productCategory;
        return this;
    }

    public Product setName(String name) {
        this.name = name;
        return this;
    }

    public Product setFactory(String factory) {
        this.factory = factory;
        return this;
    }

    public Product setQuantity(int quantity) {
        this.quantity = quantity;
        return this;
    }

    public Product setPacked(boolean packed) {
        isPacked = packed;
        return this;
    }

    public Product setAdv(boolean adv) {
        isAdv = adv;
        return this;
    }

    public Product setPrice(double price) {
        this.price = price;
        return this;
    }

    public Product setMargin(double margin) {
        this.margin = margin;
        return this;
    }

    public Product setDebt(boolean debt) {
        isDebt = debt;
        return this;
    }

    public ProductCategory getProductCategory() {
        return productCategory;
    }

    public String getName() {
        return name;
    }

    public String getFactory() {
        return factory;
    }

    public int getQuantity() {
        return quantity;
    }

    public boolean isPacked() {
        return isPacked;
    }

    public boolean isAdv() {
        return isAdv;
    }

    public double getPrice() {
        return price;
    }

    public double getMargin() {
        return margin;
    }

    public boolean getIsDebt() {
        return isDebt;
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) return false;
        Product product = (Product) object;
        return quantity == product.quantity && isPacked == product.isPacked && isAdv == product.isAdv && Double.compare(price, product.price) == 0 && Double.compare(margin, product.margin) == 0 && isDebt == product.isDebt && productCategory == product.productCategory && Objects.equals(name, product.name) && Objects.equals(factory, product.factory);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productCategory, name, factory, quantity, isPacked, isAdv, price, margin, isDebt);
    }

    @Override
    public String toString() {
        return "Product(" + productCategory +
                ", " + name +
                ", " + factory +
                ", " + quantity +
                ", " + isPacked +
                ", " + isAdv +
                ", " + price +
                ", " + margin +
                ", " + isDebt +");";
    }
}
