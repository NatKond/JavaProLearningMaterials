package org.tel.ran._2025_03_04.lesson12;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Person {

    private String name;
    private int age = 18;
    private List<Cat> cats;

    public Person(String name) {
        this.name = name;
    }

    public Person(String name, List<Cat> cats) {
        this.name = name;
        this.cats = cats;
    }

    public void grow() {
        age++;
    }

    public void addCat(Cat cat) {
        cats.add(cat);
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Cat> getCats() {
        return cats;
    }

    public void setCats(List<Cat> cats) {
        this.cats = cats;
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) return false;
        Person person = (Person) object;
        return age == person.age && Objects.equals(name, person.name) && Objects.equals(cats, person.cats);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, cats);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", cats=" + cats +
                '}';
    }
}
