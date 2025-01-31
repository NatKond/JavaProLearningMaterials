package org.tel.ran.homework03;

public class Atm {

    private Card card;

    private String enteredPin;

    public Atm() {
    }

    public void setCard(Card card, String pin) {
        this.card = card;
        enteredPin = pin;
    }

    public void setCard(Card card) {
        this.card = card;
        enteredPin = null;
    }

    public void enterPin(String pin){
        enteredPin = pin;
    }

    public void showBalance(){
        try {
            System.out.printf("Balance for %s: %.2f EUR%n", card.getName(enteredPin), card.getBalance(enteredPin));
        } catch (IllegalArgumentException exception){
            System.out.println(exception.getMessage());
        }

    }

    public void showBalanceInCurrency( double exchangeRate, String currencyName){
        try {
            System.out.printf("Balance for %s: %.2f %s%n", card.getName(enteredPin), card.getBalance(enteredPin)*exchangeRate,currencyName);
        } catch (IllegalArgumentException exception){
            System.out.println(exception.getMessage());
        }
    }

    public void deposit(double amount){
        try {
            card.deposit(amount,enteredPin);
        } catch (IllegalArgumentException exception){
            System.out.println(exception.getMessage());
        }
    }

    public void withdraw( double amount){
        try {
            card.withdraw(amount,enteredPin);
        }catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
    }

    public void setPin(String pin){
        card.setPin(pin);
    }

    public void changePin(String newPin){
        try {
            card.changePin(enteredPin,newPin);
        }catch (IllegalArgumentException exception){
            System.out.println(exception.getMessage());
        }
    }

}
