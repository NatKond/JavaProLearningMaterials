package org.tel.ran.lesson03.part2;

public class Dog extends Animal {

    public Dog(String name) {
        super(name);
    }

    @Override
    public void voice(){
        System.out.println("Dog " + super.name + " says woof.");
    }
}
