package org.tel.ran.homework15.Task2;

import java.util.List;
import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Cafe {
    public static void main(String[] args) {
        Exchanger<Coffee> exchanger1 = new Exchanger<>();
        Exchanger<Coffee> exchanger2 = new Exchanger<>();

        List<Customer> customers = List.of(
                new Customer("Steeve", exchanger1, Coffee.ESPRESSO),
                new Customer("Alex", exchanger2, Coffee.LATTE)
        );

        List<Waiter> waiters = List.of(
                new Waiter("Waiter1", exchanger1),
                new Waiter("Waiter2", exchanger2)
        );

        try (ExecutorService service = Executors.newCachedThreadPool()) {
            customers.forEach(service::execute);
            waiters.forEach(service::execute);
        }
    }
}
