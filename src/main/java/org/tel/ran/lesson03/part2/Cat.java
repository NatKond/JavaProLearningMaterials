package org.tel.ran.lesson03.part2;

public class Cat extends Animal {

    public Cat(String name) {
        super(name);
    }

    @Override
    public void voice(){
        System.out.println("Cat " + super.name + " says meowww.");
    }
}
