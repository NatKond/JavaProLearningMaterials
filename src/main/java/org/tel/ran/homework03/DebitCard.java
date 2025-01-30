package org.tel.ran.homework03;

public class DebitCard extends Card{
    public DebitCard(String userName) {
        super(userName);
    }

    public DebitCard(String userName, double balance) {
        super(userName);
    }

    @Override
    public void withdraw(double amount) {
        withdrawCheck(amount);
        super.withdraw(amount);
    }

    private void withdrawCheck(double amount){
        if (super.getBalance() < amount)
            throw new IllegalArgumentException("Insufficient funds.");
    }
}
