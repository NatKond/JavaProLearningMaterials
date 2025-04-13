package org.tel.ran.homework13;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.nio.file.Paths;
import java.util.Map;
import java.util.Set;

class ServiceTest {

    private Service service = new Service(Parser.parseProducts(Parser.readFile(Paths.get("files/shortReportTest.json"))));

    @Test
    void getAllFactoriesTest() {
        Set<String> expected = Set.of("Lays", "Barilla", "Nestle", "Lipton", "Coca-Cola", "Planters");
        Assertions.assertEquals(expected, service.getAllFactories());
    }

    @Test
    void getMostExpensiveInCategoryTest() {
        Product expected = new Product(ProductCategory.SNACKS, "Mixed Nuts", "Planters", 200, true, true, 3.49, 22.0, false);
        Assertions.assertEquals(expected, service.getMostExpensiveInCategory(ProductCategory.SNACKS));
    }

    @Test
    void findMostInStockInCurrencyTest() {
        Product expected = new Product(ProductCategory.DRINKS, "Iced Tea", "Lipton", 400, true, false, 1.79, 18.0, false);
        Assertions.assertEquals(expected, service.findMostInStockInCurrency());
    }

    @Test
    void findMostInStockInCurrencyInCategoryTest() {
        Product expected = new Product(ProductCategory.DRINKS, "Mineral Water", "Coca-Cola", 300, true, false, 0.99, 20.0, false);
        Assertions.assertEquals(expected, service.findMostInStockInCurrencyInCategory(ProductCategory.DRINKS));
    }

    @Test
    void countAdvertisedProductInCategoryTest() {
        Assertions.assertEquals(1, service.countAdvertisedProductInCategory(ProductCategory.FOOD));
    }

    @Test
    void groupByPackedTest() {
        Map<Boolean, Set<Product>> expected = Map.of(
                true, Set.of(
                        new Product(ProductCategory.FOOD, "Pasta", "Barilla", 150, true, false, 1.49, 15.0, false),
                        new Product(ProductCategory.DRINKS, "Mineral Water", "Coca-Cola", 300, true, false, 0.99, 20.0, false),
                        new Product(ProductCategory.DRINKS, "Iced Tea", "Lipton", 400, true, false, 1.79, 18.0, false),
                        new Product(ProductCategory.SNACKS, "Mixed Nuts", "Planters", 200, true, true, 3.49, 22.0, false)
                ),
                false, Set.of(
                        new Product(ProductCategory.FOOD, "Chocolate Bar", "Nestle", 250, false, true, 1.99, 15.0, false),
                        new Product(ProductCategory.SNACKS, "Potato Chips", "Lays", 250, false, true, 1.49, 18.5, false)
                )
        );
        Assertions.assertEquals(expected, service.groupByPacked());
    }

    @Test
    void getProductWithMostMarginInCategoryTest() {
        Product expected = new Product(ProductCategory.DRINKS, "Mineral Water", "Coca-Cola", 300, true, false, 0.99, 20.0, false);
        Assertions.assertEquals(expected, service.getProductWithMostMarginInCategory(ProductCategory.DRINKS));
    }

    @Test
    void findAvgMarginInEveryCategoryTest() {
        Map<ProductCategory, Double> expected = Map.of(
                ProductCategory.DRINKS, 19.0,
                ProductCategory.SNACKS, 20.25,
                ProductCategory.FOOD, 15.0
        );
        Assertions.assertEquals(expected, service.findAvgMarginInEveryCategory());
    }

    @Test
    void getFirstWithLowestMarginTest() {
        Set<Product> expected = Set.of(
                new Product(ProductCategory.FOOD, "Pasta", "Barilla", 150, true, false, 1.49, 15.0, false),
                new Product(ProductCategory.FOOD, "Chocolate Bar", "Nestle", 250, false, true, 1.99, 15.0, false)
        );
        Assertions.assertEquals(expected, service.getFirstWithLowestMargin(3, ProductCategory.FOOD));
    }
}