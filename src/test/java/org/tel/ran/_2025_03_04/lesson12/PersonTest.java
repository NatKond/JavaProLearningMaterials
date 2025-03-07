package org.tel.ran._2025_03_04.lesson12;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class PersonTest {

    private static Person person;

    @BeforeEach
    void init() {
        person = new Person("John Doh");
    }

    @Test
    void grow() {
        // given
        int expectedAge = 19;

        // when
        person.grow();

        // then
        Assertions.assertEquals(expectedAge, person.getAge());
    }

    @Test
    void addCat() {
        // given
        List<Cat> expectedCats = new ArrayList<>(List.of(new Cat("Boston"), new Cat("Murka"),
                new Cat("Ginger"), new Cat("Viski"), new Cat("Old")));
        person.setCats(new ArrayList<>(List.of(new Cat("Boston"), new Cat("Murka"),
                new Cat("Ginger"), new Cat("Viski"))));
        // when
        person.addCat(new Cat("Old"));

        // then
        Assertions.assertEquals(expectedCats, person.getCats());
    }

    @Test
    void test() {
        // given
        Person expected = new Person("John Doh");

        // then
        Assertions.assertEquals(expected, person);
    }
}