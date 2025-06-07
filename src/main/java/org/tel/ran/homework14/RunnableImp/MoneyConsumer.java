package org.tel.ran.homework14.RunnableImp;


import java.util.concurrent.atomic.AtomicBoolean;

import static org.tel.ran.textFormatting.YELLOW;

public class MoneyConsumer implements Runnable {

    private Card card;

    private double amount;

    private int sleepTime;

    private final AtomicBoolean hasException;

    public MoneyConsumer(Card card, double amount, int sleepTime, AtomicBoolean hasException) {
        this.card = card;
        this.amount = amount;
        this.sleepTime = sleepTime;
        this.hasException = hasException;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }


    @Override
    public void run() {
        while (!hasException.get()) {
            try {
                card.withdraw(amount);
                Thread.sleep(sleepTime);
            } catch (IllegalArgumentException e) {
                hasException.set(true);
                System.out.println(YELLOW + e.getMessage());
                System.out.println(YELLOW + Thread.currentThread().getName() + " finished the work.");
                return;
            } catch (InterruptedException e) {
                System.out.println(YELLOW + Thread.currentThread().getName() + " was interrupted.");
                return;
            }
        }
    }
}
