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
        copyOfProducts.sort(new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return (int) (o2.getPrice() - o1.getPrice()) * 100;
            }
        });
        // copyOfProducts.sort((o1, o2) -> (int) (o2.getPrice() * 10 - o1.getPrice() * 10));
        if (copyOfProducts.size() <= 3) {
            return copyOfProducts;
        }
        return copyOfProducts.subList(0, 3);
    }

    public List<Product> getSortedByFinalPrice(List<Product> products) {
        List<Product> copyOfProducts = new ArrayList<>(products);
        copyOfProducts.sort(new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return (int) (o1.getFinalPrice() - o2.getFinalPrice()) * 100;
            }
        });
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
}
