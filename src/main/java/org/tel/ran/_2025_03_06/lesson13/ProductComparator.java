package org.tel.ran._2025_03_06.lesson13;

import java.util.Comparator;

public class ProductComparator implements Comparator<Product> {

    @Override
    public int compare(Product o1, Product o2) {
        return (int) ((o1.getFinalPrice() - o2.getFinalPrice()) * 100);
    }
}
