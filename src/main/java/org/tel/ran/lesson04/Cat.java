package org.tel.ran.lesson04;

public class Cat extends Animal {

    public Cat(String name) {
        super(name);
    }

    @Override
    public void voice(){
        System.out.println("Cat " + super.name + " says meowww.");
    }
}
