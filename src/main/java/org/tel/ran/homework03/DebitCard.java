package org.tel.ran.homework03;

public class DebitCard extends Card{
    public DebitCard(String userName) {
        super(userName);
    }

    public DebitCard(String userName, double balance) {
        super(userName);
        setBalance(balance);
    }

    @Override
    public void setBalance(double balance) {
        balanceCheck(balance);
        super.setBalance(balance);
    }

    private void balanceCheck(double balance){
        if (balance < 0)
            throw new IllegalArgumentException("The starting balance must be positive.");
    }
}
