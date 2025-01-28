package org.tel.ran.homework03;

public class Main {
    public static void main(String[] args) {
        Card card01 = new Card("John Snow", 100.00);
        Card card02 = new Card("Arya Stark", 250.50);
        Card card03 = new Card("Daenerys Targaryen", 500.75);
        Card card04 = new Card("Tyrion Lannister", 5000.00);
        Card card05 = new Card("Sansa Stark");

        card05.deposit(1000);

        Card[] cards = new Card[]{card01,card02,card03,card04,card05};

        showBalanceForAllCards(cards);

        showBalanceForAllCards( 1.0435, "$", card05);

        showBalanceForAllCards(0.8434, "GBP", card05);

        showBalanceForAllCards( 7.6060, "CNY", card05);

        payTaxes(100,cards);

        showBalanceForAllCards(cards);

        card01.withdraw(10);
    }

    public static void showBalanceForAllCards(Card... cards){
        for (Card c: cards){
            c.showBalance();
        }
    }
    public static void showBalanceForAllCards(double exchangeRate, String currency, Card... cards){
        for (Card c: cards){
            c.showBalanceInCurrency(exchangeRate,currency);
        }
    }

    public static void payTaxes(double amount, Card... cards){
        for (Card c:cards){
            c.withdraw(amount);
        }
    }

    
}
