package org.tel.ran.homework03;

public class Atm {

    public void showBalance(Card card){
        System.out.printf("Balance for %s: %.2f EUR%n", card.getName(), card.getBalance());
    }

    public void showBalanceInCurrency(Card card, double exchangeRate, String currencyName){
        System.out.printf("Balance for %s: %.2f %s%n", card.getName(), card.getBalance()*exchangeRate,currencyName);
    }

    public void deposit(Card card, double amount){
        amountCheck(amount);
        card.setBalance(card.getBalance() + amount);
    }

    public void withdraw(Card card, double amount){
        amountCheck(amount);
        if (card instanceof DebitCard) {
            withdrawCheck(card, amount);
        }
        card.setBalance(card.getBalance() - amount);
    }

    private void withdrawCheck(Card card, double amount){
        if (card.getBalance() < amount)
            throw new IllegalArgumentException("Insufficient funds.");
    }

    private void amountCheck(double amount){
        if (amount < 0)
            throw new IllegalArgumentException("The amount must be positive.");
    }
}
