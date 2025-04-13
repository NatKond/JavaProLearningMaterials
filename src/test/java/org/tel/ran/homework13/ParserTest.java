package org.tel.ran.homework13;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.util.Set;

class ParserTest {

    @Test
    void readFileTest() {
        String expected = "[" +
                "  {\"CATEGORY\": \"FOOD#1\",\"NAME\": \"Pasta#1\",\"FACTORY\": \"Barilla#1\",\"QUANTITY\": 150,\"ISPACKED\": true,\"ISADV\": false,\"PRICE\": 1.49,\"MARGIN\": 15.0,\"ISDEBT\": false}," +
                "  {\"CATEGORY\": \"DRINKS#2\",\"NAME\": \"Mineral Water#2\",\"FACTORY\": \"Coca-Cola#2\",\"QUANTITY\": 300,\"ISPACKED\": true,\"ISADV\": false,\"PRICE\": 0.99,\"MARGIN\": 20.0,\"ISDEBT\": false}," +
                "  {\"CATEGORY\": \"SNACKS#3\",\"NAME\": \"Potato Chips#3\",\"FACTORY\": \"Lays#3\",\"QUANTITY\": 250,\"ISPACKED\": false,\"ISADV\": true,\"PRICE\": 1.49,\"MARGIN\": 18.5,\"ISDEBT\": false}," +
                "  {\"CATEGORY\": \"FOOD#4\",\"NAME\": \"Chocolate Bar#4\",\"FACTORY\": \"Nestle#4\",\"QUANTITY\": 250,\"ISPACKED\": false,\"ISADV\": true,\"PRICE\": 1.99,\"MARGIN\": 15.0,\"ISDEBT\": false}," +
                "  {\"CATEGORY\": \"DRINKS#5\",\"NAME\": \"Iced Tea#5\",\"FACTORY\": \"Lipton#5\",\"QUANTITY\": 400,\"ISPACKED\": true,\"ISADV\": false,\"PRICE\": 1.79,\"MARGIN\": 18.0,\"ISDEBT\": false}," +
                "  {\"CATEGORY\": \"SNACKS#6\",\"NAME\": \"Mixed Nuts#6\",\"FACTORY\": \"Planters#6\",\"QUANTITY\": 200,\"ISPACKED\": true,\"ISADV\": true,\"PRICE\": 3.49,\"MARGIN\": 22.0,\"ISDEBT\": false}" +
                "]";
        Assertions.assertEquals(expected, Parser.readFile(Path.of("files/shortReportTest.json")));
    }

    @Test
    void parseProductsTest() {
        Set<Product> expected = Set.of(
                new Product(ProductCategory.FOOD, "Pasta", "Barilla", 150, true, false, 1.49, 15.0, false),
                new Product(ProductCategory.DRINKS, "Mineral Water", "Coca-Cola", 300, true, false, 0.99, 20.0, false),
                new Product(ProductCategory.SNACKS, "Potato Chips", "Lays", 250, false, true, 1.49, 18.5, false),
                new Product(ProductCategory.FOOD, "Chocolate Bar", "Nestle", 250, false, true, 1.99, 15.0, false),
                new Product(ProductCategory.DRINKS, "Iced Tea", "Lipton", 400, true, false, 1.79, 18.0, false),
                new Product(ProductCategory.SNACKS, "Mixed Nuts", "Planters", 200, true, true, 3.49, 22.0, false)
        );
        Assertions.assertEquals(expected, Parser.parseProducts(Parser.readFile(Path.of("files/shortReportTest.json"))));
    }

}