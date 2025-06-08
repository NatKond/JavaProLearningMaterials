package org.tel.ran.homework15.Task2;

import java.util.concurrent.Exchanger;

public class Customer implements Runnable{

    private String name;

    private Exchanger<Coffee> exchanger;

    private Coffee coffeeOrdered;

    private Coffee coffeeReceived;

    public Customer(String name, Exchanger<Coffee> exchanger, Coffee coffeeOrdered) {
        this.name = name;
        this.exchanger = exchanger;
        this.coffeeOrdered = coffeeOrdered;
    }

    @Override
    public void run() {
        System.out.println(name + " is entering a cafe");
        System.out.println(name + " is ordering a coffee");
        try {
            coffeeReceived = exchanger.exchange(coffeeOrdered);
            System.out.println(name + " is waiting for the coffee " + coffeeOrdered);
            coffeeReceived = exchanger.exchange(coffeeOrdered);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(name + " is drinking a coffee " + coffeeReceived);
    }
}
