package org.tel.ran._2025_01_24.summary02;

public class Mouse extends Animal {

    public Mouse(String name, int age) {
        super(name, age);
    }

    @Override
    public void sayHello() {
        System.out.println("Pee-pee! I'm a mouse. My name is " + getName());
    }
}
