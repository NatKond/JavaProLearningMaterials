package org.tel.ran.homework13;

import java.util.*;
import java.util.stream.Collectors;

public class Service {

    private Set<Product> products;

    private Service() {
        products = new HashSet<>();
    }

    public Service(Set<Product> products) {
        this.products = products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public Set<String> getAllFactories() {
        return products.stream()
                .map(Product::getFactory)
                .collect(Collectors.toSet());
    }

    public Product getMostExpensiveInCategory(ProductCategory productCategory) {
        return products.stream()
                .filter(product -> product.getProductCategory().equals(productCategory))
                .max(Comparator.comparingDouble(Product::getPrice))
                .orElseThrow();
    }

    public Product findMostInStockInCurrency() {
        return products.stream()
                .max(Comparator.comparingDouble(p -> p.getQuantity() * p.getPrice()))
                .orElseThrow();
    }

    public Product findMostInStockInCurrencyInCategory(ProductCategory productCategory) {
        return products.stream()
                .filter(product -> product.getProductCategory().equals(productCategory))
                .min(Comparator.comparingDouble(Product::getPrice))
                .orElseThrow();
    }

    public long countAdvertisedProductInCategory(ProductCategory productCategory) {
        return products.stream()
                .filter(product -> product.getProductCategory().equals(productCategory))
                .filter(Product::isAdv)
                .count();
    }

    public Map<Boolean, Set<Product>> groupByPacked() {
        return products.stream()
                .collect(Collectors.groupingBy(Product::isPacked, Collectors.toSet()));
    }

    public Product getProductWithMostMarginInCategory(ProductCategory productCategory) {
        return products.stream()
                .filter(product -> product.getProductCategory().equals(productCategory))
                .max(Comparator.comparingDouble(Product::getMargin))
                .orElseThrow();
    }

    public Map<ProductCategory, Double> findAvgMarginInEveryCategory() {
        return products.stream()
                .collect(Collectors.groupingBy(Product::getProductCategory, Collectors.mapping(Product::getMargin, Collectors.toList())))
                .entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, entry -> entry.getValue().stream().mapToDouble(d -> d).average().orElseThrow()));
    }

    public Set<Product> getFirstWithLowestMargin(int quantity, ProductCategory productCategory) {
        return products.stream()
                .filter(product -> product.getProductCategory().equals(productCategory))
                .sorted(Comparator.comparingDouble(Product::getMargin))
                .limit(quantity)
                .collect(Collectors.toSet());
    }
}
