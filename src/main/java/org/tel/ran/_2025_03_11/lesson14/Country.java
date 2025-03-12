package org.tel.ran._2025_03_11.lesson14;

public enum Country {
    CANADA("CAD","$"){
        @Override
        public void sayHello(){
            System.out.println("Hello");
        }
    },
    POLAND("PLN", "zł") {
        @Override
        public void sayHello() {
            System.out.println("Witam");
        }
    },
    GERMANY("EUR", "€"){
        @Override
        public void sayHello(){
            System.out.println("Hallo");
        }
    };

    private String currency;

    private String currencySymbol;

    Country(String currency) {
        this.currency = currency;
    }

    Country(String currency, String currencySymbol) {
        this.currency = currency;
        this.currencySymbol = currencySymbol;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        if (this.currency == null) {
            this.currency = currency;
        }
    }

    public boolean hasCurrency(){
        return currency != null;
    }

    public boolean hasCurrency(Integer i, String s){
        return currency != null;
    }

    public boolean hasCurrency(int i, String s){
        return currency != null;
    }

    @Override
    public String toString() {
        return this.name() + " " + currency + " " + currencySymbol;
    }

    public abstract void sayHello();
}
