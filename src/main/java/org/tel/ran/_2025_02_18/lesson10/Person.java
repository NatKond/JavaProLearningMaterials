package org.tel.ran._2025_02_18.lesson10;

import java.util.Objects;

public class Person implements Comparable{

    private String firstName;
    private String lastName;
    private int age;

    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Person person = (Person) obj;
        return age == person.age && Objects.equals(firstName, person.getFirstName()) && Objects.equals(lastName,person.getLastName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, age);
    }

    @Override
    public int compareTo(Object obj){
        Person that = (Person) obj;
        return this.lastName.compareTo(that.getLastName());
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + " is " + age + " years old.";
    }
}
