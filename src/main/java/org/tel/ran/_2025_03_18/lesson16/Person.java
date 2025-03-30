package org.tel.ran._2025_03_18.lesson16;

import java.util.Objects;

public class Person {
    private final String name;
    private int age;
    private final boolean isActive;

    public Person(String name, int age, boolean isActive) {
        this.name = name;
        this.age = age;
        this.isActive = isActive;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isActive() {
        return isActive;
    }

    public void sayIt(String s){
        System.out.println(s);
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) return false;
        Person person = (Person) object;
        return age == person.age && isActive == person.isActive && Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, isActive);
    }

    @Override
    public String toString() {
        return name +
                " is " + age +
                " years old.";
    }
}
