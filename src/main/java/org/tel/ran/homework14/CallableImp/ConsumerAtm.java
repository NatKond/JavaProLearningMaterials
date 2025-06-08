package org.tel.ran.homework14.CallableImp;

import java.util.concurrent.Callable;

public class ConsumerAtm implements Callable<Boolean> {

    private Card card;

    private double amount;

    private int sleepTime;

    public ConsumerAtm(Card card, double amount, int sleepTime) {
        this.card = card;
        this.amount = amount;
        this.sleepTime = sleepTime;
    }

    @Override
    public Boolean call() throws Exception {
        while (true) {
            card.withdraw(amount);
            Thread.sleep(sleepTime);
        }
    }
}
