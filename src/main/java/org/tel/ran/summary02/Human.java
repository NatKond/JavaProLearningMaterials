package org.tel.ran.summary02;

public class Human extends Animated implements AnimalWalker{

    public Human(String name, int age) {
        super(name, age);
    }

    @Override
    public void sayHello() {
        System.out.println("Hello! I am human. My name is " + getName());
    }

    public void feed(Animal... animals){
        for (Animal a:animals){
            a.eat();
        }
    }

    @Override
    public void walkAnimal(Animal animal) {
        System.out.printf("%s walking with %s.%n",getName(),animal.getName());
        animal.setHungry(true);
    }
}
