package org.tel.ran.homework03;

public class Main {
    public static void main(String[] args) {
        Card card01 = new Card("John Snow", 100.00);
        Card card02 = new Card("Arya Stark", 250.50);
        Card card03 = new Card("Daenerys Targaryen", 500.75);
        Card card04 = new Card("Tyrion Lannister", 1000.00);
        Card card05 = new Card("Sansa Stark");

        System.out.println("Balance for " + card01.getUserName() + ": " + card01.getBalance() + " EUR");
        System.out.println("Balance for " + card01.getUserName() + ": " + card01.getBalanceInCurrency(7.6060) + " CNY");
        System.out.println("Balance for " + card01.getUserName() + ": " + card01.getBalanceInCurrency(1.0435) + " $");

        System.out.println("Balance for " + card03.getUserName() + ": " + card03.getBalance() + " EUR");
        System.out.println("Balance for " + card03.getUserName() + ": " + card03.getBalanceInCurrency(7.6060) + " CNY");
        System.out.println("Balance for " + card03.getUserName() + ": " + card03.getBalanceInCurrency(1.0435) + " $");


        System.out.println("Balance for " + card05.getUserName() + ": " + card05.getBalanceInCurrency(0.8434) + " GBP");
    }
}
