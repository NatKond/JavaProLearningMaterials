package org.tel.ran._2025_03_06.lesson13;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class ProductServiceTest {

    private static final ProductService PRODUCT_SERVICE = new ProductService();

    private static final List<Product> PRODUCTS = new ArrayList<>(List.of(
            new Product("Laptop", "ABC-1234", "Electronics", 1200.99, 10),
            new Product("Phone", "XYZ-5678", "Electronics", 799.49, 5),
            new Product("Tablet", "TAB-9999", "Electronics", 499.99, 0),
            new Product("Shoes", "SHO-1111", "Fashion", 59.99, 20),
            new Product("Jacket", "JCK-2222", "Fashion", 119.99, 15),
            new Product("Bread", "BRD-3333", "Food", 1.99, 0),
            new Product("Milk", "MLK-4444", "Food", 2.49, 0),
            new Product("Cheese", "CHS-5555", "Food", 5.99, 10),
            new Product("Toy Car", "TOY-6666", "Toys", 19.99, 25)
    ));

    private static final List<Product> LIST_WITH_TWO_PRODUCTS = new ArrayList<>(List.of(
            new Product("Shoes", "SHO-1111", "Fashion", 59.99, 20),
            new Product("Tablet", "TAB-9999", "Electronics", 499.99, 0)
    ));


    @Test
    void groupByCategoryTest() {
        // given
        Map<String, List<Product>> expected = Map.of(
                "Electronics", List.of(new Product("Laptop", "ABC-1234", "Electronics", 1200.99, 10),
                        new Product("Phone", "XYZ-5678", "Electronics", 799.49, 5),
                        new Product("Tablet", "TAB-9999", "Electronics", 499.99, 0)),

                "Fashion", List.of(new Product("Shoes", "SHO-1111", "Fashion", 59.99, 20),
                        new Product("Jacket", "JCK-2222", "Fashion", 119.99, 15)),

                "Food", List.of(new Product("Bread", "BRD-3333", "Food", 1.99, 0),
                        new Product("Milk", "MLK-4444", "Food", 2.49, 0),
                        new Product("Cheese", "CHS-5555", "Food", 5.99, 10)),

                "Toys", List.of(new Product("Toy Car", "TOY-6666", "Toys", 19.99, 25)));

        // when
        Map<String, List<Product>> actual = PRODUCT_SERVICE.groupByCategory(PRODUCTS);

        // then
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void getThreeMostExpensiveTest() {
        // given
        List<Product> expected = List.of(
                new Product("Laptop", "ABC-1234", "Electronics", 1200.99, 10),
                new Product("Phone", "XYZ-5678", "Electronics", 799.49, 5),
                new Product("Tablet", "TAB-9999", "Electronics", 499.99, 0));
        // when
        List<Product> actual = PRODUCT_SERVICE.getThreeMostExpensive(PRODUCTS);

        // then
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void getThreeMostExpensiveShortTest() {
        // given
        List<Product> expected = List.of(
                new Product("Tablet", "TAB-9999", "Electronics", 499.99, 0),
                new Product("Shoes", "SHO-1111", "Fashion", 59.99, 20)
        );
        // when
        List<Product> actual = PRODUCT_SERVICE.getThreeMostExpensive(LIST_WITH_TWO_PRODUCTS);

        // then
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void getSortedByPriceTest() {
        // given
        List<Product> expected = List.of(
                new Product("Bread", "BRD-3333", "Food", 1.99, 0),
                new Product("Milk", "MLK-4444", "Food", 2.49, 0),
                new Product("Cheese", "CHS-5555", "Food", 5.99, 10),
                new Product("Toy Car", "TOY-6666", "Toys", 19.99, 25),
                new Product("Shoes", "SHO-1111", "Fashion", 59.99, 20),
                new Product("Jacket", "JCK-2222", "Fashion", 119.99, 15),
                new Product("Tablet", "TAB-9999", "Electronics", 499.99, 0),
                new Product("Phone", "XYZ-5678", "Electronics", 799.49, 5),
                new Product("Laptop", "ABC-1234", "Electronics", 1200.99, 10));
        // when
        List<Product> actual = PRODUCT_SERVICE.getSortedByFinalPrice(PRODUCTS);

        // then
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void checkAllSkuTest() {
        PRODUCT_SERVICE.checkAllSku(PRODUCTS);
        List<Product> productsWithInvalidSku = new ArrayList<>(LIST_WITH_TWO_PRODUCTS);

        productsWithInvalidSku.add(new Product("Shoes", "SHO-111", "Fashion", 59.99, 20));
        RuntimeException runtimeException = Assertions.assertThrows(InvalidSkuException.class, ()-> PRODUCT_SERVICE.checkAllSku(productsWithInvalidSku));
        Assertions.assertEquals("Shoes has invalid stock keeping unit.", runtimeException.getMessage());
        productsWithInvalidSku.removeLast();

        productsWithInvalidSku.add(new Product("Tablet", "AB-1234", "Electronics", 1200.99, 10));
        runtimeException = Assertions.assertThrows(InvalidSkuException.class, ()-> PRODUCT_SERVICE.checkAllSku(productsWithInvalidSku));
        Assertions.assertEquals("Tablet has invalid stock keeping unit.", runtimeException.getMessage());
        productsWithInvalidSku.removeLast();

        productsWithInvalidSku.add(new Product("Cheese", "CHS5555", "Food", 5.99, 10));
        runtimeException = Assertions.assertThrows(InvalidSkuException.class, ()-> PRODUCT_SERVICE.checkAllSku(productsWithInvalidSku));
        Assertions.assertEquals("Cheese has invalid stock keeping unit.", runtimeException.getMessage());
        Assertions.assertThrows(InvalidSkuException.class, () -> PRODUCT_SERVICE.checkAllSku(productsWithInvalidSku));
    }

    @Test
    void productsWithPricesTest() {
        // given
        List<Product> expected = List.of(
                new Product("Bread", "BRD-3333", "Food", 1.99, 0),
                new Product("Milk", "MLK-4444", "Food", 2.49, 0),
                new Product("Cheese", "CHS-5555", "Food", 5.99, 10),
                new Product("Toy Car", "TOY-6666", "Toys", 19.99, 25));

        //when
        List<Product> actual = PRODUCT_SERVICE.productsWithPrices(PRODUCTS, 1, 20);

        // then
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void applyDiscountToCategoryTest() {
        // given
        List<Product> expected = List.of(
                new Product("Laptop", "ABC-1234", "Electronics", 1200.99, 20),
                new Product("Phone", "XYZ-5678", "Electronics", 799.49, 20),
                new Product("Tablet", "TAB-9999", "Electronics", 499.99, 20),
                new Product("Shoes", "SHO-1111", "Fashion", 59.99, 20),
                new Product("Jacket", "JCK-2222", "Fashion", 119.99, 15),
                new Product("Bread", "BRD-3333", "Food", 1.99, 0),
                new Product("Milk", "MLK-4444", "Food", 2.49, 0),
                new Product("Cheese", "CHS-5555", "Food", 5.99, 10),
                new Product("Toy Car", "TOY-6666", "Toys", 19.99, 25)
        );

        //when
        List<Product> actual = PRODUCT_SERVICE.applyDiscountToCategory(PRODUCTS,"Electronics", 20);

        // then
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void findMostPopularCategoryPositiveCaseTest(){
        // given
        String expected = "Electronics";

        // when
        String actual = PRODUCT_SERVICE.findMostPopularCategory(PRODUCTS);

        // then
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void findMostPopularCategoryNegativeCaseTest(){
        Assertions.assertThrows(NullPointerException.class, () -> PRODUCT_SERVICE.findMostPopularCategory(null));
    }

    @Test
    void findCheapestCategoryTest (){
        // given
        String expected = "Food";

        // when
        String actual = PRODUCT_SERVICE.findCheapestCategory(PRODUCTS);

        // then
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void findProductsByKeywordNameTest(){
        // given
        List<Product> expected = List.of(new Product("Tablet", "TAB-9999", "Electronics", 499.99, 0));

        // when
        List<Product>  actual = PRODUCT_SERVICE.findProductsByKeyword(PRODUCTS, "Tab");

        // then
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void findProductsByKeywordCategoryTest(){
        // given
        List<Product> expected = List.of(new Product("Bread", "BRD-3333", "Food", 1.99, 0),
                new Product("Milk", "MLK-4444", "Food", 2.49, 0),
                new Product("Cheese", "CHS-5555", "Food", 5.99, 10));

        // when
        List<Product>  actual = PRODUCT_SERVICE.findProductsByKeyword(PRODUCTS, "Food");

        // then
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void findProductsByKeywordPriceTest(){
        // given
        List<Product> expected = List.of(new Product("Jacket", "JCK-2222", "Fashion", 119.99, 15),
                new Product("Toy Car", "TOY-6666", "Toys", 19.99, 25));

        // when
        List<Product>  actual = PRODUCT_SERVICE.findProductsByKeyword(PRODUCTS, "19.99");

        // then
        Assertions.assertEquals(expected, actual);
    }
}
