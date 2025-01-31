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

    private int pinAttempts;

    private int isBlocked;


    public Card(String userName) {
        setName(userName);
    }

    public Card(String userName, double balance) {
        setName(userName);
        initialiseBalance(balance);
    }

    public Card(String userName, double balance, String pin) {
        setName(userName);
        initialiseBalance(balance);
        setPin(pin);
    }

    public String getName(String pin) {
        if (!checkPin(pin)){
            throw new IllegalArgumentException("Incorrect PIN.");
        };
        return name;
    }

    public double getBalance(String pin) {
        if (!checkPin(pin)){
            throw new IllegalArgumentException("Incorrect PIN.");
        };
        return balance;
    }

    public void deposit(double amount, String pin){
        if (!checkPin(pin)){
            throw new IllegalArgumentException("Incorrect PIN.");
        };
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
        if (!checkPin(oldPin)){
            throw new IllegalArgumentException("Incorrect PIN.");
        }
        if (isPinValid(newPin)){
            this.pin = newPin;
        }
    }

    protected void setBalance(double balance){
        this.balance = balance;
    }

    private boolean checkPin(String pin){
        if (this.pin == null && pin == null) return true;
        if (this.pin != null && pin != null) return this.pin.equals(pin);
        return false;
    }

    private void setName(String name) {
        name = name.replaceAll("\\s+", "");
        if (name.isEmpty()){
            throw new IllegalArgumentException("Invalid name!");
        }
        this.name = name;
    }

    private void initialiseBalance(double balance) {
        if (balance < 0)
            throw new IllegalArgumentException("The initial balance should be positive.");
        this.balance = balance;
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
