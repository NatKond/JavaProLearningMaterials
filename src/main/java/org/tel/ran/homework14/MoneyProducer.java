package org.tel.ran.homework14;

import java.util.concurrent.atomic.AtomicBoolean;

public class MoneyProducer implements Runnable {

    private Card card;

    private double amount;

    private final AtomicBoolean hasException;

    public MoneyProducer(Card card, double amount, AtomicBoolean hasException) {
        this.hasException = hasException;
        this.amount = amount;
        this.card = card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public void run() {
        if (hasException.get()) {
            return;
        }
        while (true) {
            try {
                card.deposit(amount);
                Thread.sleep(10);
            } catch (IllegalArgumentException e) {
                if ("The maximum balance amount has been reached.".equals(e.getMessage())) {

                    hasException.set(true);
                    return;
                }
            } catch (InterruptedException e) {
                return;
            }
            if (Thread.interrupted()) {
                return;
            }
        }
    }
}
