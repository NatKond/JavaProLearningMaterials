package org.tel.ran.homework03;

public class CreditCard extends Card{

    public CreditCard(String userName) {
        super(userName);
    }

    public CreditCard(String userName, double balance) {
        super(userName, balance);
    }

    public CreditCard(String userName, double balance, String pin) {
        super(userName, balance, pin);
    }

    @Override
    public void withdraw(double amount, String pin) {
        if (amount < 0) {
            throw new IllegalArgumentException("The amount must be positive.");
        }
        super.balance -= amount;
    }
}
