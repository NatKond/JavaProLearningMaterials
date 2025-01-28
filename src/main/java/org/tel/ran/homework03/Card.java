package org.tel.ran.homework03;

/** Создайте класс Карта, которая содержит имя пользователя и баланс
 *  Сделайте несколько конструкторов (перегрузка) для:
 *  - создания карты с именем пользователя и балансом
 *  - создания карты с именем пользователя
 *  Сделайте методы для пополнения/снятия/отображения баланса
 *  Добавьте дополнительный метод для отображения баланса в различных валютах, передавая курс валюты
 */
public class Card {

    private String userName;

    private double balance;

    public Card() {
    }

    public Card(String userName) {
        this.userName = userName;
    }

    public Card(String userName, double balance) {
        balanceCheck(balance);
        this.userName = userName;
        this.balance = balance;
    }

    public String getUserName() {
        return userName;
    }

    public double getBalance() {
        return balance;
    }

    public double getBalanceInCurrency(double exchangeRate){
        return balance * exchangeRate;
    }

    public void deposit(double amount){
        amountCheck(amount);
        balance += amount;
    }

    public void showBalance(){
        System.out.printf("Balance for %s: %.2f EUR%n", userName, balance);
    }

    public void showBalanceInCurrency(double exchangeRate, String currencyName){
        System.out.printf("Balance for %s: %.2f %s%n", userName, balance*exchangeRate,currencyName);
    }

    public void withdraw(double amount){
        amountCheck(amount);
        balanceCheck(balance - amount);
        balance -= amount;
    }

    private void balanceCheck(double balance){
        if (balance < 0)
            throw new IllegalArgumentException("The balance can not fall below zero.");
    }

    private void amountCheck(double amount){
        if (amount < 0)
            throw new IllegalArgumentException("Amount must be positive.");
    }
}
