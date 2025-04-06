package org.tel.ran.homework12;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

class OnlineAppTest {
    private static List<User> USERS = List.of(
            new User("Alice Johnson", 25, "USA"),
            new User("Bob Smith", 30, "Canada"),
            new User("Charlie Brown", 28, "Germany"),
            new User("Diana Miller", 22, "France"),
            new User("Ethan Clark", 35, "USA"),
            new User("Fiona Davis", 27, "Canada"),
            new User("George Wilson", 31, "Germany"),
            new User("Hannah Lewis", 24, "France"),
            new User("Ivan Martin", 29, "USA"),
            new User("Julia Thompson", 26, "Canada")
    );

    private static List<Content> CONTENT_LIST = List.of(
            new Video("Stream API Explained", "Deep dive into Java Stream API."),
            new Video("Data Structures", "Overview of common data structures in Java."),
            new Video("Design Patterns", "Learn popular software design patterns."),
            new Music("Rhythm Pulse", "Upbeat electronic dance music."),
            new Music("Acoustic Vibes", "Chill acoustic guitar melody."),
            new Music("Night Drive", "Lo-fi beats for late-night coding."),
            new Music("Epic Journey", "Cinematic orchestral score."),
            new Music("Morning Energy", "Pop-rock tune to start your day."),
            new Article("SOLID Principles", "Best practices for OOP design."),
            new Article("Garbage Collection", "How memory management works in Java."),
            new Article("Functional Interfaces", "Using lambdas and functional interfaces.")
    );

    @BeforeAll
    static void init() {
        USERS.forEach(user -> CONTENT_LIST.forEach(content -> {
            if (user.getCountry().equals("USA") && content.getClass().equals(Video.class)) {
                user.view(content);
            }
        }));
    }

    @Test
    void addUser() {
        Assertions.assertEquals(USERS, OnlineApp.getUsers());
    }

    @Test
    void addContent() {
        Assertions.assertEquals(CONTENT_LIST, OnlineApp.getContent());
    }

    @Test
    void interact() {
        List<Interaction> expected = List.of(
                Interaction.builder(USERS.get(0), CONTENT_LIST.get(0), InteractionType.VIEW).localDate(LocalDate.now()).build(),
                Interaction.builder(USERS.get(0), CONTENT_LIST.get(1), InteractionType.VIEW).localDate(LocalDate.now()).build(),
                Interaction.builder(USERS.get(0), CONTENT_LIST.get(2), InteractionType.VIEW).localDate(LocalDate.now()).build(),
                Interaction.builder(USERS.get(4), CONTENT_LIST.get(0), InteractionType.VIEW).localDate(LocalDate.now()).build(),
                Interaction.builder(USERS.get(4), CONTENT_LIST.get(1), InteractionType.VIEW).localDate(LocalDate.now()).build(),
                Interaction.builder(USERS.get(4), CONTENT_LIST.get(2), InteractionType.VIEW).localDate(LocalDate.now()).build(),
                Interaction.builder(USERS.get(8), CONTENT_LIST.get(0), InteractionType.VIEW).localDate(LocalDate.now()).build(),
                Interaction.builder(USERS.get(8), CONTENT_LIST.get(1), InteractionType.VIEW).localDate(LocalDate.now()).build(),
                Interaction.builder(USERS.get(8), CONTENT_LIST.get(2), InteractionType.VIEW).localDate(LocalDate.now()).build()
        );

        Assertions.assertEquals(expected, OnlineApp.getInteractions());
    }

    @Test
    void findMostActiveUsersTest() {
        List<User> expected = List.of(
                USERS.get(0),
                USERS.get(4),
                USERS.get(8)
        );
        Assertions.assertEquals(expected, OnlineApp.findMostActiveUsers());
    }

    @Test
    void findThreeMostPopularContentTest() {
        List<Content> expected = List.of(
                CONTENT_LIST.get(0),
                CONTENT_LIST.get(1),
                CONTENT_LIST.get(2)
        );
        Assertions.assertEquals(expected, OnlineApp.findThreeMostPopularContent());
    }

    @Test
    void findAverageOfInteractionsByCountryTest() {
        Map<String,Double> expected = Map.of(
                "USA", 3.0,
                "Canada", 0.0,
                "Germany", 0.0,
                "France",0.0);
        Assertions.assertEquals(expected, OnlineApp.findAverageOfInteractionsByCountry());
    }
}