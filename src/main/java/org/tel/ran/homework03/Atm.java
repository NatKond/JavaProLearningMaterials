package org.tel.ran.homework03;

public class Atm {

    Card card;

    public Atm() {
    }

    public void setCard(Card card, String pin) {
        if (card.checkPin(pin)){
            this.card = card;
        } else throw new IllegalArgumentException("Incorrect PIN.");
    }

    public void setCard(Card card) {
        if (card.hasPin()){
            throw new IllegalArgumentException("Please enter your PIN.");
        }
        this.card = card;
    }

    public void showBalance(){
        System.out.printf("Balance for %s: %.2f EUR%n", card.getName(), card.getBalance());
    }

    public void showBalanceInCurrency( double exchangeRate, String currencyName){
        System.out.printf("Balance for %s: %.2f %s%n", card.getName(), card.getBalance()*exchangeRate,currencyName);
    }

    public void deposit( double amount){
        card.deposit(amount);
    }

    public void withdraw( double amount){
        card.withdraw(amount);
    }

    public void setPin(String pin){
        card.setPin(pin);
    }

    public void changePin(String oldPin, String newPin){
        card.changePin(oldPin,newPin);
    }

}
