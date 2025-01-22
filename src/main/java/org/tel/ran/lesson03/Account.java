package org.tel.ran.lesson03;

public class Account {

    int balance;

    int hold;

    public Account(int balance, int hold) {
        this.balance = balance;
        this.hold = hold;
    }

    public int getHold() {
        return hold;
    }

    public int getBalance() {
        return balance;
    }

    public void makePay(int amount){
        if (amount < 0){
            throw new IllegalArgumentException("Amount can not be negative.");
        }
        if (amount > this.getBalance()){
            throw new IllegalArgumentException("You don't have enough money.");
        }
        balance -= amount;
        hold += amount;
    }

    @Override
    public String toString() {
        return "Account{" +
                "balance=" + balance +
                ", hold=" + hold +
                '}';
    }
}
