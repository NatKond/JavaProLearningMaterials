package org.tel.ran._2025_03_04.lesson12;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CalculatorTest {

    private static final int TEN = 10;
    private static final int FIVE = 5;

    private static Calculator calculator;

    @BeforeEach
    void init() {
        calculator = new Calculator();
    }

    @Test
    void sumPositiveCaseTest() {
        // given
        int expected = 15;

        // when
        int actual = calculator.sum(TEN, FIVE);

        // then
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void subPositiveCaseTest() {
        // given
        int expected = 5;

        // when
        int actual = calculator.sub(TEN, FIVE);

        // then
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void mulPositiveCaseTest() {
        // given
        int expected = 50;

        // when
        int actual = calculator.mul(TEN, FIVE);

        // then
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void divPositiveCaseTest() {
        // given
        int expected = 2;

        // when
        int actual = calculator.div(TEN, FIVE);

        // then
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void divNegativeCaseTest() {
        // given
        int zero = 0;

        // then
        Assertions.assertThrows(ArithmeticException.class, () -> calculator.div(TEN, zero));
    }
}