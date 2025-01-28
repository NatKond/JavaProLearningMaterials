package org.tel.ran._2025_01_21.lesson03.part2;

public class Dog extends Animal {

    public Dog(String name) {
        super(name);
    }

    @Override
    public void voice(){
        System.out.println("Dog " + super.name + " says woof.");
    }
}
