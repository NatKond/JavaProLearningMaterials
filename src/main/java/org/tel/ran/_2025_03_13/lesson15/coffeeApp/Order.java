package org.tel.ran._2025_03_13.lesson15.coffeeApp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Order {

    private List<Coffee> coffeeList = new ArrayList<>();

    public void addCoffee(Coffee coffee) {
        coffeeList.add(coffee);
    }

    public int getTotalVolume() {
        int sum = 0;
        for (Coffee coffee : coffeeList) {
            sum += coffee.getVolume();
        }
        return sum;
    }

    public double getTotalPrice() {
        double sum = 0;
        for (Coffee coffee : coffeeList) {
            sum += coffee.getPrice();
        }
        return sum;
    }

    public Map<String, List<Coffee>> groupByMilk() {
        Map<String, List<Coffee>> groupedCoffeeByMilk = new HashMap<>();
        String withMilk = "With milk";
        String withoutMilk = "Without milk";
        for (Coffee coffee : coffeeList) {
            if (coffee.isContainingMilk()) {
                groupedCoffeeByMilk.putIfAbsent(withMilk, new ArrayList<>());
                groupedCoffeeByMilk.get(withMilk).add(coffee);
            } else {
                groupedCoffeeByMilk.putIfAbsent(withoutMilk, new ArrayList<>());
                groupedCoffeeByMilk.get(withoutMilk).add(coffee);
            }
        }
        return groupedCoffeeByMilk;
    }

    @Override
    public String toString() {
        return "Order{" +
                "coffeeList=" + coffeeList +
                '}';
    }
}
