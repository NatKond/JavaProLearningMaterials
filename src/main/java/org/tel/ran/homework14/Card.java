package org.tel.ran.homework14;

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

    public String getName(String pin) {
        return name;
    }

    public double getBalance(String pin) {
        return balance;
    }

    public double getMaxBalance() {
        return maxBalance;
    }

    public void deposit(double amount) {
        if (amount < 0)
            throw new IllegalArgumentException("The amount must be positive.");
        if (balance >= maxBalance)
            throw new IllegalArgumentException("The maximum ифдфтсу amount has been reached.");

        synchronized (this) {
            balance += amount;
        }
    }

    public void withdraw(double amount) {
        if (amount < 0)
            throw new IllegalArgumentException("The amount must be positive.");
        if (balance < amount)
            throw new IllegalArgumentException("Insufficient funds.");
        synchronized (this) {
            balance -= amount;
        }
    }

    public void setName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Invalid name!");
        }
        this.name = name;
    }

    public void setBalance(double balance) {
        if (balance < 0)
            throw new IllegalArgumentException("The initial balance should be positive.");
        this.balance = balance;
    }
}
