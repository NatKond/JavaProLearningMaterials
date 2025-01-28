package org.tel.ran._2025_01_24.summary02;

abstract class Animated extends Creature {

    private int age;

    public Animated(String name, int age) {
        super(name);
        this.age = age;
    }

    public void grow(){

        System.out.println(super.getName() + " was " + age + ". Today he terned " + ++age);
    };


}
