package org.tel.ran._2025_03_04.lesson12practice;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayFinderTest {

    private final int[] ARRAY = {-4, 4, 2, 56, 42, 78, 33, 15, -1, -8, 15};
    private final int[] ARRAY_OF_NEGATIVES = {-4, -5, -2, -10, -30, -15, -33, -45, -1, -8, -25};
    private final int[] ARRAY_OF_POSITIVES = {5, 4, 2, 56, 42, 68, 33, 15, 1, 8, 15};

    private final ArrayFinder arrayFinder = new ArrayFinder();

    @Test
    void getMinTest() {
        // given
        int expectedMin = -8;
        // then
        Assertions.assertEquals(expectedMin,arrayFinder.getMin(ARRAY));
    }

    @Test
    void getMinInArrayWithPositivesTest() {
        // given
        int expectedMin = -45;
        // then
        Assertions.assertEquals(expectedMin,arrayFinder.getMin(ARRAY_OF_NEGATIVES));
    }

    @Test
    void getMinInArrayWithNegativesTest() {
        // given
        int expectedMin = 1;
        // then
        Assertions.assertEquals(expectedMin,arrayFinder.getMin(ARRAY_OF_POSITIVES));
    }

    @Test
    void getMaxTest() {
        // given
        int expectedMax = 78;
        // then
        Assertions.assertEquals(expectedMax,arrayFinder.getMax(ARRAY));
    }

    @Test
    void getMaxInArrayWithPositivesTest() {
        // given
        int expectedMax = -1;
        // then
        Assertions.assertEquals(expectedMax,arrayFinder.getMax(ARRAY_OF_NEGATIVES));
    }

    @Test
    void getMaxInArrayWithNegativesTest() {
        // given
        int expectedMax = 68;
        // then
        Assertions.assertEquals(expectedMax,arrayFinder.getMax(ARRAY_OF_POSITIVES));
    }

    @Test
    void getMaxWhenArrayIsEmpty() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> arrayFinder.getMin(new int[]{}));
    }

    @Test
    void getMaxWhenArrayIsNull() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> arrayFinder.getMin(null));
    }
}