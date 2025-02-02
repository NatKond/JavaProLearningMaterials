package org.tel.ran.homework03;

/** Создайте класс Карта, которая содержит имя пользователя и баланс
 *  Сделайте несколько конструкторов (перегрузка) для:
 *  - создания карты с именем пользователя и балансом
 *  - создания карты с именем пользователя
 */
public abstract class Card {

    private String name;

    protected double balance;

    private String pin;

    private int countPinAttempts;

    private boolean isBlocked;


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

    public String getName(String pin) {
        if (!isCorrect(pin)){
            throw new IllegalArgumentException("Incorrect PIN.");
        }
        return name;
    }

    public double getBalance(String pin) {
        if (!isCorrect(pin)){
            throw new IllegalArgumentException("Incorrect PIN.");
        }
        return balance;
    }

    public void deposit(double amount, String pin){
        if (!isCorrect(pin)){
            throw new IllegalArgumentException("Incorrect PIN.");
        }
        if (amount < 0)
            throw new IllegalArgumentException("The amount must be positive.");
        balance += amount;
    }

    public abstract void withdraw(double amount, String pin);

    public void setPin(String pin) {
        if (this.pin == null && isPinValid(pin)){
            this.pin = pin;
        } else throw new IllegalArgumentException("This card already has a pin.");
    }

    public void changePin(String oldPin, String newPin) {
        if (!isCorrect(oldPin)){
            throw new IllegalArgumentException("Incorrect PIN.");
        }
        if (isPinValid(newPin)){
            this.pin = newPin;
        }
    }

    private void setName(String name) {
        name = name.replaceAll("\\s+", "");
        if (name.isEmpty()){
            throw new IllegalArgumentException("Invalid name!");
        }
        this.name = name;
    }

    private void setBalance(double balance) {
        if (balance < 0)
            throw new IllegalArgumentException("The initial balance should be positive.");
        this.balance = balance;
    }

    private boolean isCorrect(String pin){
        if (isBlocked)
            throw new IllegalArgumentException("To many incorrect pin attempts. The card is blocked.");

        if (this.pin == null && pin == null) return true;
        if (this.pin != null && pin != null) {
            if (this.pin.equals(pin)) return true;
            countPinAttempts++;
            if (countPinAttempts == 3) isBlocked = true;
        }
        return false;
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
