package org.tel.ran.homework08;

public class Main {
    public static void main(String[] args) {
        Object o = 10;
        ValidationSystem validationSystem = new ValidationSystem();
        validationSystem.validate(o);
        validationSystem.validate("Hello");
        validationSystem.validate('5');
        validationSystem.validate(10);
    }
}
