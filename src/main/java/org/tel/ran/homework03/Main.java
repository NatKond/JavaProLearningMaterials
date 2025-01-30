package org.tel.ran.homework03;

public class Main {
    public static void main(String[] args) {
        //DebitCard card00 = new DebitCard("");
        CreditCard card01 = new CreditCard("John Snow", 100.00);
        DebitCard card02 = new DebitCard("Arya Stark", 250.50);
        CreditCard card03 = new CreditCard("Daenerys Targaryen", 200.75);
        DebitCard card04 = new DebitCard("Tyrion Lannister", 5000.00);
        CreditCard card05 = new CreditCard("Sansa Stark");

        Atm atm = new Atm();

        atm.setCard(card05);
        atm.setPin("5253");
        atm.deposit(1000);

        Card[] cards = new Card[]{card01,card02,card03,card04};

        System.out.println("-------- BALANCE --------");
        showBalanceForCards(atm, cards);

        atm.setCard(card05, "5253");

        atm.showBalance();

        atm.showBalanceInCurrency(1.0435, "$");

        atm.showBalanceInCurrency(0.8434, "GBP");

        atm.showBalanceInCurrency(7.6060, "CNY");

        System.out.println("-------- TAXES --------");

        payTaxes(atm, 250,cards);

        atm.setCard(card05, "5253");
        atm.withdraw(250);

        showBalanceForCards(atm, cards);
        atm.setCard(card05, "5253");
        atm.showBalance();

        /*System.out.println("-------- WITHDRAW FROM DEBIT CARD --------");
        atm.setCard(card02);
        atm.withdraw(10);*/

        System.out.println("-------- SET DEBIT CARD WITH WRONG PIN --------");
        atm.setCard(card05, "5252");
        atm.showBalance();
    }

    private static void showBalanceForCards(Atm atm, Card... cards){
        for (Card c: cards){
            atm.setCard(c);
            atm.showBalance();
        }
    }

    private static void showBalanceForCardsInCurrency(Atm atm, double exchangeRate, String currency, Card... cards){
        for (Card c: cards){
            atm.setCard(c);
            atm.showBalanceInCurrency(exchangeRate,currency);
        }
    }

    private static void payTaxes(Atm atm, double amount, Card... cards){
        for (Card c:cards){
            atm.setCard(c);
            atm.withdraw(amount);
        }
    }
}
