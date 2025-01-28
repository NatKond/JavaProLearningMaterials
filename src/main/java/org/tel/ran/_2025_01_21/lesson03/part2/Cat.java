package org.tel.ran._2025_01_21.lesson03.part2;

public class Cat extends Animal {

    public Cat(String name) {
        super(name);
    }

    @Override
    public void voice(){
        System.out.println("Cat " + super.name + " says meowww.");
    }
}
