package org.tel.ran.homework15.Task2;

import java.util.concurrent.Exchanger;

public class Waiter implements Runnable{

    private String name;

    private Exchanger<Coffee> exchanger;

    private Coffee coffeeOrdered;

    public Waiter(String name, Exchanger<Coffee> exchanger) {
        this.name = name;
        this.exchanger = exchanger;
    }

    @Override
    public void run() {
        System.out.println(name + " is waiting for a customer");

        System.out.println(name + " is taking the order");
        try {
            coffeeOrdered = exchanger.exchange(null);
            System.out.println(name + " is making the coffee " + coffeeOrdered);
            System.out.println(name + " is taking the coffee " + coffeeOrdered + " to the customer");
            exchanger.exchange(coffeeOrdered);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
