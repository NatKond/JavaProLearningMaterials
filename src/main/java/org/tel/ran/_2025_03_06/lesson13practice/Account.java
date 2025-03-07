package org.tel.ran._2025_03_06.lesson13practice;

import java.util.Objects;

public class Account {

    private String name;
    private double balance;

    public Account(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        checkAmount(amount);
        balance += amount;
    }

    public void withdraw(double amount) {
        checkAmount(amount);
        checkBalance(amount);
        balance -= amount;
    }

    private void checkAmount(double amount) {
        if (amount <= 0) {
            throw new InvalidAmountException("The amount " + amount + " is invalid.");
        }
    }

    private void checkBalance(double amount) {
        if (amount > balance){
            throw new InsufficientFundException("Insufficient funds. Available " + balance);
        }
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) return false;
        Account account = (Account) object;
        return Double.compare(balance, account.balance) == 0 && Objects.equals(name, account.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, balance);
    }

    @Override
    public String toString() {
        return "Account{" +
                "name='" + name + '\'' +
                ", balance=" + balance +
                '}';
    }
}
