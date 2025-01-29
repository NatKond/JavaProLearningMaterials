package org.tel.ran.homework03;

/** Создайте класс Карта, которая содержит имя пользователя и баланс
 *  Сделайте несколько конструкторов (перегрузка) для:
 *  - создания карты с именем пользователя и балансом
 *  - создания карты с именем пользователя
 */
public class Card {

    private String name;

    private double balance;

    public Card(String userName) {
        setName(userName);
    }

    public Card(String userName, double balance) {
        setName(userName);
        setBalance(balance);
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public void setName(String name) {
        nameCheck(name);
        this.name = name;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    private void nameCheck(String name){
        name = name.replaceAll("\\s+", "");
        if (name.isEmpty()){
            throw new IllegalArgumentException("Invalid name!");
        }
    }
}
