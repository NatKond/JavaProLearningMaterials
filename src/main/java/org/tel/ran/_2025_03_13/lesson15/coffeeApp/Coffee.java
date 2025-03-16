package org.tel.ran._2025_03_13.lesson15.coffeeApp;

public enum Coffee {
    ESPRESSO(2.50, 30,false),
    AMERICANO(3.00, 150,false),
    LATTE(4.50, 250, true),
    CAPPUCCINO(4.00, 200,true),
    MOCHA(5.00, 300,true),
    MACCHIATO(3.50, 50,true),
    FLAT_WHITE(4.80, 200,true);

    private double price;
    private int volume;
    private boolean containsMilk;

    Coffee(double price, int volume, boolean containsMilk) {
        this.price = price;
        this.volume = volume;
        this.containsMilk = containsMilk;
    }

    public double getPrice() {
        return price;
    }

    public int getVolume() {
        return volume;
    }

    public boolean isContainingMilk() {
        return containsMilk;
    }

    @Override
    public String toString() {
        return name() +
                "(price=" + price +
                ", volume=" + volume + ")";
    }
}

