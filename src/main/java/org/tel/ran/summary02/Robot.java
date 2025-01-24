package org.tel.ran.summary02;

public class Robot extends Creature implements AnimalWalker, MouseCatcher{

    public Robot(String name) {
        super(name);
    }

    @Override
    public void sayHello() {
        System.out.println("Hello! I am a robot. My name is " + getName());
    }

    @Override
    public void walkAnimal(Animal animal) {
        System.out.printf("%s walking with %s.%n",getName(),animal.getName());
        animal.setHungry(true);
    }

    @Override
    public void catchMouse(Mouse mouse) {
        System.out.printf("%s catches a mouse %s.%n",getName(),mouse.getName());
    }
}
