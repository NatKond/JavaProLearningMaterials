package org.tel.ran._2025_01_21.lesson03practice.part2;

public class Dog extends Animal{

    private boolean bites;

    public Dog(String name, String food, String location, boolean bites) {
        super(name, food, location);
        this.bites = bites;
    }

    @Override
    public void makeNoise(){
        System.out.println("The dog " + this.getName() + " says woof.");
    }

    @Override
    public void sleep() {
        System.out.println("The dog " + this.getName() + " eats " + this.getFood() + ".");
    }

    @Override
    public void eat() {
        System.out.println("The dog " + this.getName() + " sleeps in " + this.getLocation() + ".");
    }

    public void begForFood(){
        System.out.println("The dog " + this.getName() +  " is begging for food");
    }

}
