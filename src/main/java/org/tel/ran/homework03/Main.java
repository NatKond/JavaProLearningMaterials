package org.tel.ran.homework03;

public class Main {
    public static void main(String[] args) {
        //DebitCard card00 = new DebitCard("");
        CreditCard card01 = new CreditCard("John Snow", 100.00);
        DebitCard card02 = new DebitCard("Arya Stark", 250.50);
        CreditCard card03 = new CreditCard("Daenerys Targaryen", -200.75);
        DebitCard card04 = new DebitCard("Tyrion Lannister", 5000.00);
        CreditCard card05 = new CreditCard("Sansa Stark");
        Atm atm = new Atm();

        atm.deposit(card05, 1000);

        Card[] cards = new Card[]{card01,card02,card03,card04,card05};

        System.out.println("-------- BALANCE --------");
        showBalanceForCards(atm, cards);

        atm.showBalanceInCurrency(card05, 1.0435, "$");

        atm.showBalanceInCurrency(card05, 0.8434, "GBP");

        atm.showBalanceInCurrency(card05, 7.6060, "CNY");

        System.out.println("-------- TAXES --------");

        payTaxes(atm, 250,cards);

        showBalanceForCards(atm, cards);

        System.out.println("-------- WITHDRAW FROM DEBIT CARD --------");
        atm.withdraw( card02, 10);
    }

    private static void showBalanceForCards(Atm atm, Card... cards){
        for (Card c: cards){
            atm.showBalance(c);
        }
    }

    private static void showBalanceForCardsInCurrency(Atm atm, double exchangeRate, String currency, Card... cards){
        for (Card c: cards){
            atm.showBalanceInCurrency(c,exchangeRate,currency);
        }
    }

    private static void payTaxes(Atm atm, double amount, Card... cards){
        for (Card c:cards){
            atm.withdraw(c, amount);
        }
    }
}
