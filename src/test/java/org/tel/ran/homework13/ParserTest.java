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
                new Product().setId(1).setProductCategory(ProductCategory.FOOD).setName("Pasta").setFactory("Barilla").setQuantity(150).setPacked(true).setAdv(false).setPrice(1.49).setMargin(15.0).setDebt(false),
                new Product().setId(2).setProductCategory(ProductCategory.DRINKS).setName("Mineral Water").setFactory("Coca-Cola").setQuantity(300).setPacked(true).setAdv(false).setPrice(0.99).setMargin(20.0).setDebt(false),
                new Product().setId(3).setProductCategory(ProductCategory.SNACKS).setName("Potato Chips").setFactory("Lays").setQuantity(250).setPacked(false).setAdv(true).setPrice(1.49).setMargin(18.5).setDebt(false),
                new Product().setId(4).setProductCategory(ProductCategory.FOOD).setName("Chocolate Bar").setFactory("Nestle").setQuantity(250).setPacked(false).setAdv(true).setPrice(1.99).setMargin(15.0).setDebt(false),
                new Product().setId(5).setProductCategory(ProductCategory.DRINKS).setName("Iced Tea").setFactory("Lipton").setQuantity(400).setPacked(true).setAdv(false).setPrice(1.79).setMargin(18.0).setDebt(false),
                new Product().setId(5).setProductCategory(ProductCategory.SNACKS).setName("Mixed Nuts").setFactory("Planters").setQuantity(200).setPacked(true).setAdv(true).setPrice(3.49).setMargin(22.0).setDebt(false)
        );
        Assertions.assertEquals(expected, Parser.parseProductsFromFile(Path.of("files/shortReportTest.json")));
    }

}