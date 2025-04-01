package org.tel.ran._2025_03_25.lesson17;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.UnaryOperator;

public class Main {
    private static final Map<ItemType,UnaryOperator<Double>> UNARY_OPERATOR_MAP = new EnumMap<>(ItemType.class);
    static {
        UNARY_OPERATOR_MAP.put(ItemType.ELECTRONICS, price -> price * 0.9);
        UNARY_OPERATOR_MAP.put(ItemType.CLOTHING, price -> (price * 0.2 < 500) ? price * 0.8 : price - 500);
        UNARY_OPERATOR_MAP.put(ItemType.GROCERIES, price -> price - 50);
        UNARY_OPERATOR_MAP.put(ItemType.BOOKS, price -> (price > 1000) ? price * 0.95 : price);
    }
    public static void main(String[] args) {
        System.out.println(calculatePrice(ItemType.ELECTRONICS, 1000)); // 900.0
        System.out.println(calculatePrice(ItemType.CLOTHING, 3000));   // 2500.0
        System.out.println(calculatePrice(ItemType.GROCERIES, 200));   // 150.0
        System.out.println(calculatePrice(ItemType.BOOKS, 1200));      // 1140.0
    }

    public static double calculatePrice(ItemType type, double price){
        UnaryOperator<Double> discountFunction = UNARY_OPERATOR_MAP.get(type);
       // UnaryOperator<Double> discountFunction = type.applyDiscount();
        return discountFunction.apply(price);
    }
}
