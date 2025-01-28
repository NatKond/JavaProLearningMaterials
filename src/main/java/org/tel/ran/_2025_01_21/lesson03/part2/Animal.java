package org.tel.ran._2025_01_21.lesson03.part2;

public abstract class Animal {

    String name;

    public Animal() {
    }

    public Animal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract void voice();

    public boolean isInCage(int numberOfCage){
        return numberOfCage <= 5;
    }
}
