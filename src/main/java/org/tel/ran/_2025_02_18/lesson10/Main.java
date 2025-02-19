package org.tel.ran._2025_02_18.lesson10;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Person person1 = new Person("John", "Doh", 31);
        Cat cat1 = new Cat("Boston", 7, "ginger");

        Map<Person, Cat> personCatMap = new HashMap<>();
        personCatMap.put(person1, cat1);
        System.out.println(personCatMap.get(person1).getName());
        System.out.println("person1.hashCode() = " + person1.hashCode());
        System.out.println("(person1.hashCode() % 16) = " + (person1.hashCode() % 16));

        person1.setAge(34);
        System.out.println("person1.hashCode() = " + person1.hashCode());
        System.out.println("(person1.hashCode() % 16) = " + (person1.hashCode() % 16));
        System.out.println("personCatMap.containsKey(person1) = " + personCatMap.containsKey(person1));
    }
}
