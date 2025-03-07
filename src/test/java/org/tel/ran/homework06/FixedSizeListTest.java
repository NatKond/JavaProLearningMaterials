package org.tel.ran.homework06;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.tel.ran._2025_03_04.lesson12.Calculator;
import org.tel.ran.homework06.exceptions.MaxSizeExceededException;
import org.tel.ran.homework06.exceptions.OutOfRangeException;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FixedSizeListTest {

    private final List<String> FIXED_SIZE_LIST_1 = new FixedSizeList<>(10);

    @BeforeEach
    void init() {
        FIXED_SIZE_LIST_1.add("Hello");
        FIXED_SIZE_LIST_1.add("Hi");
        FIXED_SIZE_LIST_1.add("Good morning");
        FIXED_SIZE_LIST_1.add("Good afternoon");
        FIXED_SIZE_LIST_1.add("Good evening");
        FIXED_SIZE_LIST_1.add("Bye");
        FIXED_SIZE_LIST_1.add("See you");
        FIXED_SIZE_LIST_1.add("Take care");
    }

    @Test
    void sizeTest() {
        // given
        int expected = 5;
        List<String> fixedSizeList = new FixedSizeList<>(expected);
        // when
        for (int i = 0; i < expected; i++) {
            fixedSizeList.add("Hi");
        }
        // then
        Assertions.assertEquals(expected, fixedSizeList.size());
    }

    @Test
    void isEmptyTest() {
        Assertions.assertFalse(FIXED_SIZE_LIST_1.isEmpty());
        List<String> emptyFixedSizeList = new FixedSizeList<>(5);
        Assertions.assertTrue(emptyFixedSizeList.isEmpty());
    }

    @Test
    void containsTest() {
        Assertions.assertTrue(FIXED_SIZE_LIST_1.contains("Hello"));
        Assertions.assertFalse(FIXED_SIZE_LIST_1.contains("Farewell"));
        FIXED_SIZE_LIST_1.add(null);
        Assertions.assertTrue(FIXED_SIZE_LIST_1.contains(null));
    }

    @Test
    void iterator() {
        // given
        Iterator<String> fixedSizeListIterator = FIXED_SIZE_LIST_1.iterator();
        List<String> expected = List.of("Hi", "Good morning", "Good afternoon", "Good evening", "Bye", "See you", "Take care");
        // then
        Assertions.assertTrue(fixedSizeListIterator.hasNext());
        Assertions.assertEquals("Hello", fixedSizeListIterator.next());
        fixedSizeListIterator.remove();
        Assertions.assertEquals(expected, FIXED_SIZE_LIST_1);

        // when
        for (int i = 0; i < FIXED_SIZE_LIST_1.size(); i++) {
            fixedSizeListIterator.next();
        }
        //then
        Assertions.assertThrows(OutOfRangeException.class, () -> fixedSizeListIterator.next());

    }

    @Test
    void addPositiveTest() {
        // given
        List<String> expected = List.of("Hello", "Hi", "Good morning", "Good afternoon", "Good evening", "Bye", "See you", "Take care", "Catch you later");
        // when
        Assertions.assertTrue(FIXED_SIZE_LIST_1.add("Catch you later"));
        // then
        Assertions.assertEquals(expected, FIXED_SIZE_LIST_1);

        // when
        FIXED_SIZE_LIST_1.add(2, "Hey");
        expected = List.of("Hello", "Hi", "Hey", "Good morning", "Good afternoon", "Good evening", "Bye", "See you", "Take care", "Catch you later");
        // then
        Assertions.assertEquals(expected, FIXED_SIZE_LIST_1);
    }

    @Test
    void addNegativeTest() {
        // given
        FIXED_SIZE_LIST_1.add(2, "Hey");
        FIXED_SIZE_LIST_1.add("Catch you later");
        // then
        Assertions.assertThrows(MaxSizeExceededException.class, () -> FIXED_SIZE_LIST_1.add("Farewell"));

        Assertions.assertThrows(OutOfRangeException.class, () -> FIXED_SIZE_LIST_1.add(FIXED_SIZE_LIST_1.size(), "Farewell"));
    }

    @Test
    void removeTest() {
        // given
        List<String> expected = List.of("Hello", "Hi", "Good morning", "Good afternoon", "Good evening", "Bye", "Take care");
        // when
        Assertions.assertTrue(FIXED_SIZE_LIST_1.remove("See you"));
        //then
        Assertions.assertEquals(expected, FIXED_SIZE_LIST_1);

        // when
        FIXED_SIZE_LIST_1.add(null);
        FIXED_SIZE_LIST_1.remove(null);
        //then
        Assertions.assertEquals(expected, FIXED_SIZE_LIST_1);

        //then
        Assertions.assertEquals("Hi", FIXED_SIZE_LIST_1.remove(1));

        Assertions.assertFalse(FIXED_SIZE_LIST_1.remove("Farewell"));

        Assertions.assertThrows(OutOfRangeException.class, () -> FIXED_SIZE_LIST_1.remove(FIXED_SIZE_LIST_1.size()));
    }

    @Test
    void clear() {
        // given
        List<String> expected = List.of();
        // when
        FIXED_SIZE_LIST_1.clear();
        // then
        Assertions.assertEquals(expected, FIXED_SIZE_LIST_1);
    }

    @Test
    void get() {
        Assertions.assertEquals("Hello", FIXED_SIZE_LIST_1.get(0));
        Assertions.assertEquals("Take care", FIXED_SIZE_LIST_1.get(FIXED_SIZE_LIST_1.size() - 1));
        Assertions.assertThrows(OutOfRangeException.class, () -> FIXED_SIZE_LIST_1.get(FIXED_SIZE_LIST_1.size()));
    }

    @Test
    void set() {
        // given
        List<String> expected = List.of("Hello", "Hey", "Good morning", "Good afternoon", "Good evening", "Bye", "See you", "Take care");

        Assertions.assertEquals("Hi", FIXED_SIZE_LIST_1.set(1, "Hey"));
        Assertions.assertEquals(expected, FIXED_SIZE_LIST_1);

    }

    @Test
    void indexOf() {
        // given
        FIXED_SIZE_LIST_1.add(4, null);
        // then
        Assertions.assertEquals(4, FIXED_SIZE_LIST_1.indexOf(null));
        Assertions.assertEquals(1, FIXED_SIZE_LIST_1.indexOf("Hi"));
        Assertions.assertEquals(FIXED_SIZE_LIST_1.size() - 1, FIXED_SIZE_LIST_1.indexOf("Take care"));
    }

    @Test
    void lastIndexOf() {
        // then
        Assertions.assertEquals(0, FIXED_SIZE_LIST_1.lastIndexOf("Hello"));

        // given
        FIXED_SIZE_LIST_1.add(7, "Hello");
        // then

        Assertions.assertEquals(7, FIXED_SIZE_LIST_1.lastIndexOf("Hello"));

    }
}