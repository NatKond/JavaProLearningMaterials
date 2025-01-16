package org.tel.ran.lesson02;

public class Main {
    public static void main(String[] args) {
        Person person1 = new Person();
        Person person2 = new Person("Petr Ivanov", 28);
        person1.move();
        person1.talk();
        person2.talk();
        person2.move();
    }
}
