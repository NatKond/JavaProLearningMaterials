package org.tel.ran.lesson04practice;

public class CatalogBuilder {

    // Категории
    private static final String[] CATEGORY_NAMES = new String[]{"Electronics", "Clothing", "Groceries", "Furniture", "Toys"};

    // Товары
    private static final String[] PRODUCT_NAMES = new String[]{
            "Smartphone", "Laptop", "TV", "Headphones", "Smartwatch",   // Electronics
            "T-shirt", "Jeans", "Sneakers", "Jacket", "Hat",             // Clothing
            "Bread", "Milk", "Apples", "Chicken breast", "Chocolate",   // Groceries
            "Sofa", "Coffee Table", "Bookshelf", "Chair", "Lamp",       // Furniture
            "Action Figure", "Doll", "Lego Set", "Board Game", "Puzzle" // Toys
    };

    // Цены товаров
    private static final double[] PRICES = new double[]{
            699.99, 1200.00, 500.00, 150.00, 250.00,   // Electronics
            19.99, 49.99, 89.99, 120.00, 15.00,       // Clothing
            1.50, 0.99, 3.99, 5.49, 2.99,             // Groceries
            799.99, 150.00, 180.00, 75.00, 40.00,     // Furniture
            25.99, 15.00, 50.00, 29.99, 19.99         // Toys
    };

    // Рейтинги товаров
    private static final int[] RATINGS = new int[]{
            5, 4, 4, 5, 4,       // Electronics
            4, 3, 5, 4, 3,       // Clothing
            5, 4, 4, 5, 4,       // Groceries
            5, 4, 4, 3, 5,       // Furniture
            5, 4, 5, 4, 3        // Toys
    };

    public static void populateCatalog(Category[] categorys, Item[][] items) {
        for (int i = 0; i < CATEGORY_NAMES.length; i++) {
            for (int j = 0; j < items.length; j++) {
                items[i][j] = new Item(PRODUCT_NAMES[i*5 + j], PRICES[i*5 + j], RATINGS[i*5 + j]);
            }
            categorys[i] = new Category(CATEGORY_NAMES[i],items[i]);
        }
    }
}
