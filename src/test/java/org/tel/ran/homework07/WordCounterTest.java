package org.tel.ran.homework07;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.*;
import static org.tel.ran.textFormatting.*;

class WordCounterTest {

    private final String TEXT = "Apple, apple, apple! I love apples.";
    private final String TEXT_RUSSIAN = "Я люблю яблоки, яблоки, яблоки! Они такие вкусные, такие сладкие, такие сочные!";
    private final String TEXT_GERMAN = "Ich mag Bananen, Bananen, Bananen! Sie sind süß, süß und lecker. ";
    private final String TEXT_SPANISH = "Las fresas, las fresas, las fresas son mis frutas favoritas. Son dulces, son rojas, son deliciosas. ";

    @Test
    void countWordsTest() {
        // given
        String expected = YELLOW + "A: " + RESET + "apple 3\n" + "   apples 1\n" +
                YELLOW + "I: " + RESET + "i 1\n" +
                YELLOW + "L: " + RESET + "love 1\n";
        // when
        String actual = WordCounter.countWords(TEXT);
        // then
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void countWordsRussianTest() {
        // given
        String expected = YELLOW + "В: " + RESET + "вкусные 1\n" +
                YELLOW + "Л: " + RESET + "люблю 1\n" +
                YELLOW + "О: " + RESET + "они 1\n" +
                YELLOW + "С: " + RESET + "сладкие 1\n" + "   сочные 1\n" +
                YELLOW + "Т: " + RESET + "такие 3\n" +
                YELLOW + "Я: " + RESET + "я 1\n" + "   яблоки 3\n";
        // when
        String actual = WordCounter.countWords(TEXT_RUSSIAN);
        // then
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void countWordsGermanTest() {
        // given
        String expected = YELLOW + "B: " + RESET + "bananen 3\n" +
                YELLOW + "I: " + RESET + "ich 1\n" +
                YELLOW + "L: " + RESET + "lecker 1\n" +
                YELLOW + "M: " + RESET + "mag 1\n" +
                YELLOW + "S: " + RESET + "sie 1\n" + "   sind 1\n" + "   süß 2\n" +
                YELLOW + "U: " + RESET + "und 1\n";
        // when
        String actual = WordCounter.countWords(TEXT_GERMAN);
        // then
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void countWordsSpanishTest() {
        // given
        String expected = YELLOW + "D: " + RESET + "deliciosas 1\n" + "   dulces 1\n" +
                YELLOW + "F: " + RESET + "favoritas 1\n" + "   fresas 3\n" + "   frutas 1\n" +
                YELLOW + "L: " + RESET + "las 3\n" +
                YELLOW + "M: " + RESET + "mis 1\n" +
                YELLOW + "R: " + RESET + "rojas 1\n" +
                YELLOW + "S: " + RESET + "son 4\n";
        // when
        String actual = WordCounter.countWords(TEXT_SPANISH);
        // then
        Assertions.assertEquals(expected, actual);
    }
}