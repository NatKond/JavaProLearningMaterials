package org.tel.ran.homework02;

public class Factorial {

    public Factorial() {
    }

    public int getFactorialFor(int inputNumber){
        checkForNegative(inputNumber);
        if (checkForZero(inputNumber)) return 1;

        int result = 1;
        for (int i = 2; i <= inputNumber; i++) {
            result *= i;
        }
        return result;
    }

    public int getFactorialWhile(int inputNumber){
        checkForNegative(inputNumber);
        if (checkForZero(inputNumber)) return 1;

        int result = 1;
        int i = 2;
        while (i <= inputNumber){
            result *= i++;
        }
        return result;
    }

    public int getFactorialDoWhile(int inputNumber){
        checkForNegative(inputNumber);
        if (checkForZero(inputNumber)) return 1;

        int result = 1;
        if (inputNumber == 1) return result;
        int i = 2;
        do {
            result *= i++;
        }while (i <= inputNumber);

        return result;
    }

    private boolean checkForZero(int inputNumber){
        return (inputNumber == 0);
    }

    private void checkForNegative(int inputNumber){
        if (inputNumber < 0){
            throw new IllegalArgumentException("Factorial is not defined for negative numbers.");
        }
    }
}
