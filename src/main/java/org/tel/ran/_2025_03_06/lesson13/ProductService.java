package org.tel.ran._2025_03_06.lesson13;

import java.util.*;

public class ProductService {

    public Map<String, List<Product>> groupByCategory(List<Product> products) {
        checkProductList(products);
        Map<String, List<Product>> productsGroupedByCategory = new HashMap<>();
        for (Product product : products) {
            productsGroupedByCategory.putIfAbsent(product.getCategory(), new ArrayList<>());
            productsGroupedByCategory.get(product.getCategory()).add(product);
        }
        return productsGroupedByCategory;
    }

    public List<Product> getThreeMostExpensive(List<Product> products) {
        checkProductList(products);
        List<Product> copyOfProducts = new ArrayList<>(products);
        copyOfProducts.sort(new ProductComparator().reversed());
        // copyOfProducts.sort((o1, o2) -> (int) (o2.getPrice() * 100 - o1.getPrice() * 100));
        if (copyOfProducts.size() <= 3) {
            return copyOfProducts;
        }
        return copyOfProducts.subList(0, 3);
    }

    public List<Product> getSortedByFinalPrice(List<Product> products) {
        checkProductList(products);
        List<Product> copyOfProducts = new ArrayList<>(products);
        copyOfProducts.sort(new ProductComparator());
        // copyOfProducts.sort((o1, o2) -> (int) (o1.getFinalPrice() * 100 - o2.getFinalPrice() * 100));
        return copyOfProducts;
    }

    public void checkAllSku(List<Product> products) {
        checkProductList(products);
        for (Product product : products) {
            product.checkSku();
        }
    }

    public List<Product> getProductsWithPrices(List<Product> products, double min, double max) {
        checkProductList(products);
        List<Product> output = new ArrayList<>();
        for (Product product : products) {
            if (product.getPrice() >= min && product.getPrice() <= max) {
                output.add(product);
            }
        }
        return output;
    }

    public List<Product> applyDiscountToCategory(List<Product> products, String category, double discount) {
        checkProductList(products);
        for (Product product : products) {
            if (product.getCategory().equals(category)) {
                product.setDiscountPercentage(discount);
            }
        }
        return products;
    }

    public String findMostPopularCategory(List<Product> products) {
        checkProductList(products);
        Map<String, List<Product>> groupedByCategory = groupByCategory(products);
        int count = 0;
        String category = null;
        for (Map.Entry<String, List<Product>> entry : groupedByCategory.entrySet()) {
            if (entry.getValue().size() > count) {
                category = entry.getKey();
                count = entry.getValue().size();
            }
        }
        return category;
    }

    public String findCheapestCategory(List<Product> products) {
        checkProductList(products);
        Map<String, List<Product>> groupedByCategory = groupByCategory(products);
        String category = null;
        double minAveragePrice = Double.MAX_VALUE;
        for (Map.Entry<String, List<Product>> entry : groupedByCategory.entrySet()) {
            double sum = 0;
            for (Product product : entry.getValue()) {
                sum += product.getFinalPrice();
            }
            double averagePrice = sum / entry.getValue().size();
            if (averagePrice < minAveragePrice) {
                category = entry.getKey();
                minAveragePrice = averagePrice;
            }
        }
        return category;
    }

    public List<Product> findProductsByKeyword(List<Product> products, String target) {
        checkProductList(products);
        target = target.toLowerCase();
        List<Product> output = new ArrayList<>();
        for (Product product : products) {
            String category = product.getCategory().toLowerCase();
            String name = product.getName().toLowerCase();
            String price = String.valueOf(product.getPrice());
            if (category.contains(target) || name.contains(target) || price.contains(target)) {
                output.add(product);
            }
        }
        return output;
    }

    private void checkProductList(List<Product> products) {
        if (products == null) {
            throw new InvalidProductListException("Product list is null or empty.");
        }
    }
}
