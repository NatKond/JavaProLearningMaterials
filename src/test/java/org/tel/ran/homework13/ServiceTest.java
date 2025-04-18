package org.tel.ran.homework13;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.nio.file.Paths;
import java.util.Map;
import java.util.Set;

class ServiceTest {

    private Service service = new Service(Parser.parseProductsFromFile(Paths.get("files/shortReportTest.json")));

    @Test
    void getAllFactoriesTest() {
        Set<String> expected = Set.of("Lays", "Barilla", "Nestle", "Lipton", "Coca-Cola", "Planters");
        Assertions.assertEquals(expected, service.getAllFactories());
    }

    @Test
    void getMostExpensiveInCategoryTest() {
        Product expected = new Product().setId(5).setProductCategory(ProductCategory.SNACKS).setName("Mixed Nuts").setFactory("Planters").setQuantity(200).setPacked(true).setAdv(true).setPrice(3.49).setMargin(22.0).setDebt(false);
        Assertions.assertEquals(expected, service.getMostExpensiveInCategory(ProductCategory.SNACKS));
    }

    @Test
    void findMostInStockInCurrencyTest() {
        Product expected = new Product().setId(5).setProductCategory(ProductCategory.DRINKS).setName("Iced Tea").setFactory("Lipton").setQuantity(400).setPacked(true).setAdv(false).setPrice(1.79).setMargin(18.0).setDebt(false);
        Assertions.assertEquals(expected, service.findMostInStockInCurrency());
    }

    @Test
    void findMostInStockInCurrencyInCategoryTest() {
        Product expected = new Product().setId(2).setProductCategory(ProductCategory.DRINKS).setName("Mineral Water").setFactory("Coca-Cola").setQuantity(300).setPacked(true).setAdv(false).setPrice(0.99).setMargin(20.0).setDebt(false);
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
                        new Product().setId(1).setProductCategory(ProductCategory.FOOD).setName("Pasta").setFactory("Barilla").setQuantity(150).setPacked(true).setAdv(false).setPrice(1.49).setMargin(15.0).setDebt(false),
                        new Product().setId(2).setProductCategory(ProductCategory.DRINKS).setName("Mineral Water").setFactory("Coca-Cola").setQuantity(300).setPacked(true).setAdv(false).setPrice(0.99).setMargin(20.0).setDebt(false),
                        new Product().setId(5).setProductCategory(ProductCategory.DRINKS).setName("Iced Tea").setFactory("Lipton").setQuantity(400).setPacked(true).setAdv(false).setPrice(1.79).setMargin(18.0).setDebt(false),
                        new Product().setId(5).setProductCategory(ProductCategory.SNACKS).setName("Mixed Nuts").setFactory("Planters").setQuantity(200).setPacked(true).setAdv(true).setPrice(3.49).setMargin(22.0).setDebt(false)
                ),
                false, Set.of(
                        new Product().setId(3).setProductCategory(ProductCategory.SNACKS).setName("Potato Chips").setFactory("Lays").setQuantity(250).setPacked(false).setAdv(true).setPrice(1.49).setMargin(18.5).setDebt(false),
                        new Product().setId(4).setProductCategory(ProductCategory.FOOD).setName("Chocolate Bar").setFactory("Nestle").setQuantity(250).setPacked(false).setAdv(true).setPrice(1.99).setMargin(15.0).setDebt(false)
                )
        );
        Assertions.assertEquals(expected, service.groupByPacked());
    }

    @Test
    void getProductWithMostMarginInCategoryTest() {
        Product expected = new Product().setId(2).setProductCategory(ProductCategory.DRINKS).setName("Mineral Water").setFactory("Coca-Cola").setQuantity(300).setPacked(true).setAdv(false).setPrice(0.99).setMargin(20.0).setDebt(false);
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
                new Product().setId(1).setProductCategory(ProductCategory.FOOD).setName("Pasta").setFactory("Barilla").setQuantity(150).setPacked(true).setAdv(false).setPrice(1.49).setMargin(15.0).setDebt(false),
                new Product().setId(4).setProductCategory(ProductCategory.FOOD).setName("Chocolate Bar").setFactory("Nestle").setQuantity(250).setPacked(false).setAdv(true).setPrice(1.99).setMargin(15.0).setDebt(false)
        );
        Assertions.assertEquals(expected, service.getFirstWithLowestMargin(3, ProductCategory.FOOD));
    }
}