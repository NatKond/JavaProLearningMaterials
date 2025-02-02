package org.tel.ran.homework03;

public class DebitCard extends Card{
    public DebitCard(String userName) {
        super(userName);
    }

    public DebitCard(String userName, double balance) {
        super(userName, balance);
    }

    public DebitCard(String userName, double balance, String pin) {
        super(userName, balance, pin);
    }

    @Override
    public void withdraw(double amount, String pin) {
        withdrawCheck(amount, pin);
        if (amount < 0) {
            throw new IllegalArgumentException("The amount must be positive.");
        }
        super.balance -= amount;
    }

    private void withdrawCheck(double amount, String pin){
        if (super.getBalance(pin) < amount)
            throw new IllegalArgumentException("Insufficient funds.");
    }
}
