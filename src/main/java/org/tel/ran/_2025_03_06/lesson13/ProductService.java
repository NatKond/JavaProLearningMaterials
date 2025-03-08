package org.tel.ran._2025_03_06.lesson13;

import java.util.*;

public class ProductService {

    public Map<String, List<Product>> groupByCategory(List<Product> products) {
        Map<String, List<Product>> productsGroupedByCategory = new HashMap<>();
        for (Product product : products) {
            productsGroupedByCategory.putIfAbsent(product.getCategory(), new ArrayList<>());
            productsGroupedByCategory.get(product.getCategory()).add(product);
        }
        return productsGroupedByCategory;
    }

    public List<Product> getThreeMostExpensive(List<Product> products) {
        List<Product> copyOfProducts = new ArrayList<>(products);
        copyOfProducts.sort(new ProductComparator());
        // copyOfProducts.sort((o1, o2) -> (int) (o2.getPrice() * 10 - o1.getPrice() * 10));
        if (copyOfProducts.size() <= 3) {
            return copyOfProducts;
        }
        return copyOfProducts.subList(0, 3);
    }

    public List<Product> getSortedByFinalPrice(List<Product> products) {
        List<Product> copyOfProducts = new ArrayList<>(products);
        copyOfProducts.sort(new ProductComparator().reversed());
        // copyOfProducts.sort((o1, o2) -> (int) (o1.getFinalPrice() * 100 - o2.getFinalPrice() * 100));
        return copyOfProducts;
    }

    public void checkAllSku(List<Product> products) {
        for (Product product : products) {
            product.checkSku();
        }
    }

    public List<Product> productsWithPrices(List<Product> products, double min, double max) {
        List<Product> output = new ArrayList<>();
        for (Product product : products) {
            if (product.getPrice() > min && product.getPrice() < max) {
                output.add(product);
            }
        }
        return output;
    }

    public List<Product> applyDiscountToCategory(List<Product> products, String category, double discount) {
        List<Product> copyOfProducts = new ArrayList<>(products);
        for (Product product : copyOfProducts) {
            if (product.getCategory().equals(category)) {
                product.setDiscountPercentage(discount);
            }
        }
        return copyOfProducts;
    }

    public String findMostPopularCategory(List<Product> products) {
        Map<String, List<Product>> groupedByCategory = groupByCategory(products);
        int count = 0;
        String category = "";
        for (Map.Entry<String, List<Product>> entry : groupedByCategory.entrySet()) {
            if (entry.getValue().size() > count) {
                category = entry.getKey();
                count = entry.getValue().size();
            }
        }
        return category;
    }

    public String findCheapestCategory(List<Product> products) {
        Map<String, List<Product>> groupedByCategory = groupByCategory(products);
        String category = "";
        double minAveragePrice = Double.MAX_VALUE;
        double averagePrice = 0;
        for (Map.Entry<String, List<Product>> entry : groupedByCategory.entrySet()) {
            for (Product product : entry.getValue()) {
                averagePrice += product.getFinalPrice();
            }
            averagePrice /= entry.getValue().size();

            if (averagePrice < minAveragePrice) {
                category = entry.getKey();
                minAveragePrice = averagePrice;
            }
            averagePrice = 0;
        }
        return category;
    }

    public List<Product> findProductsByKeyword(List<Product> products, String target) {
        List<Product> output = new ArrayList<>();
        for (Product product : products) {
            if (product.getCategory().contains(target) || product.getName().contains(target) || String.valueOf(product.getPrice()).contains(target)){
                output.add(product);
            }
        }
        return output;
    }
}
