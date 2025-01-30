package org.tel.ran.homework03;

/** Создайте класс Карта, которая содержит имя пользователя и баланс
 *  Сделайте несколько конструкторов (перегрузка) для:
 *  - создания карты с именем пользователя и балансом
 *  - создания карты с именем пользователя
 */
public abstract class Card {

    private String name;

    private double balance;

    private String pin;


    public Card(String userName) {
        setName(userName);
    }

    public Card(String userName, double balance) {
        setName(userName);
        setBalance(balance);
    }

    public Card(String userName, double balance, String pin) {
        setName(userName);
        setBalance(balance);
        setPin(pin);
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount){
        amountCheck(amount);
        balance += amount;
    }

    public void withdraw(double amount){
        amountCheck(amount);
        balance -= amount;
    }

    public boolean hasPin(){
        return (pin != null);
    }

    public boolean checkPin(String pin){
        return this.pin.equals(pin);
    }

    public void setPin(String pin) {
        if (isPinValid(pin)){
            this.pin = pin;
        }
    }

    public void changePin(String oldPin, String newPin) {
        if (isPinValid(oldPin)){
            this.pin = newPin;
        }
    }

    private void setName(String name) {
        nameCheck(name);
        this.name = name;
    }

    private void setBalance(double balance) {
        balanceCheck(balance);
        this.balance = balance;
    }

    private void balanceCheck(double balance){
        if (balance < 0)
            throw new IllegalArgumentException("The initial balance should be positive.");
    }

    private void amountCheck(double amount){
        if (amount < 0)
            throw new IllegalArgumentException("The amount must be positive.");
    }

    private void nameCheck(String name){
        name = name.replaceAll("\\s+", "");
        if (name.isEmpty()){
            throw new IllegalArgumentException("Invalid name!");
        }
    }

    private boolean isPinValid(String pin){
        try{
            Integer.parseInt(pin);
            return pin.length() == 4;
        } catch (NumberFormatException e){
            return false;
        }
    }
}
