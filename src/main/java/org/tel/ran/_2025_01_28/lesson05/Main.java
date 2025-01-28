package org.tel.ran._2025_01_28.lesson05;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        int bigInt = 1000;
        int smallInt = 80;

        byte byte1 = (byte) smallInt;
        smallInt = byte1;

        Object object1 = new Cat("Boston");
        Object object2 = new Person(LocalDate.now());

        //upcasting
        Animal animal1 = new Cat("Boston");
        Animal animal2 = new Dog("Rich");
        //animal1.meow;

        //downcasting
        Cat cat = (Cat) animal1;
        cat.meow();

        int primitiveInt = 0;

        Integer objectInt1 = 123;
        Integer objectInt2 = 321;
        //unboxing;
        primitiveInt = objectInt1;

        System.out.println(objectInt1.intValue() + objectInt2.intValue());

        char primitiveC = 'c';
        Character objectC = 'c';

        BigDecimal bigDecimal1 = BigDecimal.ONE;
        BigDecimal bigDecimal2 = BigDecimal.ONE;

        System.out.println(bigDecimal1.add(bigDecimal2));
    }
}
