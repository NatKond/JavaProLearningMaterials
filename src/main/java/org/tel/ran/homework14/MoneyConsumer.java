package org.tel.ran.homework14;


import java.util.concurrent.atomic.AtomicBoolean;

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
                if ("Insufficient funds.".equals(e.getMessage())) {
                    hasException.set(true);
                    return;
                }
            } catch (InterruptedException e) {
                return;
            }
        }
    }
}
