package org.tel.ran.homework08;

public class Main {
    public static void main(String[] args) {
        Object o = 10;
        ValidationSystem.validate(o);
        ValidationSystem.validate("Hello");
        ValidationSystem.validate('2');
        ValidationSystem.validate(10);

    }
}
