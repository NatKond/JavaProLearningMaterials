package org.tel.ran._2025_01_21.lesson03practice.part2;

public class Horse extends Animal{

    int maxSpeedInKmPerHour;

    public Horse(String name, String food, String location, int maxSpeedInKmPerHour) {
        super(name, food, location);
        this.maxSpeedInKmPerHour = maxSpeedInKmPerHour;
    }

    @Override
    public void makeNoise() {
        System.out.println("The horse " + this.getName() + " goes neigh.");
    }

    @Override
    public void eat() {
        System.out.println("The horse " + this.getName() + " eats " + this.getFood() + ".");
    }

    @Override
    public void sleep() {
        System.out.println("The horse " + this.getName() + " sleeps in " + this.getLocation() + ".");
    }

    public void prance(){
        System.out.println("The horse " + this.getName() + " is prancing.");
    }

}
