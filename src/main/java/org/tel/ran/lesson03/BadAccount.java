package org.tel.ran.lesson03;

public class BadAccount {

    int balance;

    int hold;

    public BadAccount(int balance, int hold) {
        this.balance = balance;
        this.hold = hold;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void setHold(int hold) {
        this.hold = hold;
    }

    public int getHold() {
        return hold;
    }

    @Override
    public String toString() {
        return "BadAccount{" +
                "balance=" + balance +
                ", hold=" + hold +
                '}';
    }
}
