package org.tel.ran.lesson03practice.part2;

public class Cat extends Animal {

    private int lengthOfFur;

    public Cat(String name, String food, String location, int lengthOfFur) {
        super(name, food, location);
        this.lengthOfFur = lengthOfFur;
    }

    public int getLengthOfFur() {
        return lengthOfFur;
    }

    @Override
    public void makeNoise() {
        System.out.println("The cat " + this.getName() + " says meow.");
    }

    @Override
    public void eat() {
        System.out.println("The cat " + this.getName() + " eats " + this.getFood() + ".");
    }

    @Override
    public void sleep() {
        System.out.println("The cat " + this.getName() + " sleeps in " + this.getLocation() + ".");
    }

    public void purr() {
        System.out.println("The cat " + this.getName() + " purrs.");
    }
}