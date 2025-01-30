package org.tel.ran.homework03;

public class Atm {

    public void showBalance(Card card){
        System.out.printf("Balance for %s: %.2f EUR%n", card.getName(), card.getBalance());
    }

    public void showBalanceInCurrency(Card card, double exchangeRate, String currencyName){
        System.out.printf("Balance for %s: %.2f %s%n", card.getName(), card.getBalance()*exchangeRate,currencyName);
    }

    public void deposit(Card card, double amount){
        card.deposit(amount);
    }

    public void withdraw(Card card, double amount){
        card.withdraw(amount);
    }

}
