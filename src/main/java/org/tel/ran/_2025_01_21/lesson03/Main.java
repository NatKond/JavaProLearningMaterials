package org.tel.ran._2025_01_21.lesson03;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        Person person1 = new Person(LocalDate.of(1990,1,15));
        Person person2 = new Person(LocalDate.of(1990,1,15));

        System.out.println("person1.equals(person2) = " + person1.equals(person2));

        BadAccount badAccount = new BadAccount(100,0);
        makePay(77,badAccount);

        System.out.println("badAccount = " + badAccount);

        Account account = new Account(100,0);
        account.makePay(77);

        System.out.println("account = " + account);

    }

    public static void makePay(int amount, BadAccount badAccount){
        if (amount < 0){
            throw new IllegalArgumentException("Amount can not be negative.");
        }
        if (amount > badAccount.getBalance()){
            throw new IllegalArgumentException("You don't have enough money.");
        }
        badAccount.setBalance(badAccount.getBalance() - amount);
        badAccount.setHold(badAccount.getHold() + amount);
    }
}
