package org.tel.ran.homework07;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.tel.ran.textFormatting.*;

class WordCounterTest {

    private final String TEXT = "Apple, apple, apple! I love apples.";

    @Test
    void getWordsCountMap() {
        // given
        Map<String, Integer> expected = Map.of("apple", 3, "i", 1, "love", 1, "apples", 1);
        // when
        Map<String, Integer> actual = WordCounter.getWordsCountMap(TEXT);
        // then
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void printMap() {
        // given
        String expected = YELLOW + "A: " + RESET + "apple 3\n" + "   apples 1\n" +
                YELLOW + "I: " + RESET + "i 1\n" +
                YELLOW + "L: " + RESET + "love 1\n";
        // when
        String actual = WordCounter.printMap(WordCounter.getWordsCountMap(TEXT));
        // then
        Assertions.assertEquals(expected, actual);
    }
}