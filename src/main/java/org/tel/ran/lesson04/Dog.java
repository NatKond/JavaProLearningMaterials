package org.tel.ran.lesson04;

public class Dog extends Animal implements MyInterface2 {

    public Dog(String name) {
        super(name);
    }

    @Override
    public void voice(){
        System.out.println("Dog " + super.name + " says woof.");
    }

    @Override
    public void myMethod1() {

    }

    @Override
    public void myMethod2() {

    }

    @Override
    public void myMethod3() {

    }

    @Override
    public void myMethod4() {

    }
}
