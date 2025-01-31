package org.tel.ran.homework03;

public class CreditCard extends Card{

    public CreditCard(String userName) {
        super(userName);
    }

    public CreditCard(String userName, double balance) {
        super(userName, balance);
    }

    @Override
    public void withdraw(double amount, String pin) {
        if (amount < 0) {
            throw new IllegalArgumentException("The amount must be positive.");
        }
        super.setBalance(getBalance(pin) - amount);
    }
}
