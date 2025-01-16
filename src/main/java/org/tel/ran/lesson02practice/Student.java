package org.tel.ran.lesson02practice;

public class Student {

    private String name;

    private int age;

    private int rate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age >= 18 && age <= 55) {
            this.age = age;
        }else {
            throw new IllegalArgumentException("Age is incorrect.");
        }
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", rate=" + rate +
                '}';
    }
}
