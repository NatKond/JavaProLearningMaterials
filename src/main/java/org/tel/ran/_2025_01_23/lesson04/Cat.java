package org.tel.ran._2025_01_23.lesson04;

public class Cat extends Animal {

    public Cat(String name) {
        super(name);
    }

    @Override
    public void voice(){
        System.out.println("Cat " + super.name + " says meowww.");
    }
}
