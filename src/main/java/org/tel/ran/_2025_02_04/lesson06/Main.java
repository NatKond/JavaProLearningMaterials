package org.tel.ran._2025_02_04.lesson06;

public class Main {
    public static void main(String[] args) {
        Person person1 = new Person("Ivan", "Ivanov", 33);
        Person person2 = new Person("Petr", "Petrov", 40);
        Person person3 = new Person("Sidr", "Sidorov", 45);
        Person person4 = new Person("Ivan", "Ivanov", 33);
        Person person5 = new Person("Petr", "Petrov", 40);

        System.out.println(person1.equals(person4));
        System.out.println(person1.hashCode());
        System.out.println(person4.hashCode());

        System.out.println(person2.equals(person5));
        System.out.println(person2.hashCode());
        System.out.println(person5.hashCode());
    }
}
