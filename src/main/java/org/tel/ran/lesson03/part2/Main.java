package org.tel.ran.lesson03.part2;

public class Main {
    public static void main(String[] args) {
        Animal animal1 = new Cat("Fluffy");
        Animal animal2 = new Dog("Max");
        Animal animal3 = new Cat("One");

        animal1.voice();
        animal2.voice();
        animal3.voice();

        System.out.println("animal1.isInCage(5) = " + animal1.isInCage(5));

    }
}
