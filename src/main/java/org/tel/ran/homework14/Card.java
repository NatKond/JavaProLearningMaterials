package org.tel.ran.homework14;

import static org.tel.ran.textFormatting.RED;

public class Card {

    private String name;

    private double balance;

    private double maxBalance;

    public Card(String userName) {
        setName(userName);
    }

    public Card(String userName, double balance) {
        setName(userName);
        setBalance(balance);
    }

    public Card(String name, double balance, double maxBalance) {
        this.name = name;
        this.balance = balance;
        this.maxBalance = maxBalance;
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public double getMaxBalance() {
        return maxBalance;
    }

    public void deposit(double amount) {
        if (amount < 0)
            throw new IllegalArgumentException("The amount must be positive.");

        synchronized (this) {
            if (balance + amount >= maxBalance) {
                balance = maxBalance;
                System.out.println(RED + Thread.currentThread().getName() + " reached the maximum balance, balance = " + balance);
                throw new IllegalArgumentException("The maximum balance amount has been reached.");
            }
            if (balance == 0) {
                System.out.println(RED + Thread.currentThread().getName() + " reached the minimum balance, balance = " + balance);
                return;
            }

            balance += amount;
            System.out.println(Thread.currentThread().getName() + " deposits " + amount + ", balance = " + balance);
        }
    }

    public void withdraw(double amount) {
        if (amount < 0)
            throw new IllegalArgumentException("The amount must be positive.");

        synchronized (this) {
            if (balance <= amount) {
                balance = 0;
                System.out.println(RED + Thread.currentThread().getName() + " reached the minimum balance, balance = " + balance);
                throw new IllegalArgumentException("Insufficient funds.");
            }
            if (balance == maxBalance) {
                System.out.println(RED + Thread.currentThread().getName() + " reached the maximum balance, balance = " + balance);
                return;
            }

            balance -= amount;
            System.out.println(Thread.currentThread().getName() + " withdraws " + amount + ", balance = " + balance);
        }
    }

    public void setName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Invalid name!");
        }
        synchronized (this) {
            this.name = name;
        }
    }

    public void setBalance(double balance) {
        if (balance < 0)
            throw new IllegalArgumentException("The initial balance should be positive.");
        synchronized (this) {
            this.balance = balance;
        }
    }
}
