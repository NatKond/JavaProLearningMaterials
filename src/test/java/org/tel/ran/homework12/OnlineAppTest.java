package org.tel.ran.homework12;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Map;
import java.util.Set;

class OnlineAppTest {
    private static User user1 = new User("Alice Johnson", 25, "USA");
    private static User user2 = new User("Diana Miller", 22, "France");
    private static User user3 = new User("Ethan Clark", 35, "USA");
    private static User user4 = new User("Fiona Davis", 27, "Canada");
    private static User user5 = new User("Hannah Lewis", 24, "France");
    private static User user6 = new User("Ivan Martin", 29, "USA");
    private static User user7 = new User("George Wilson", 31, "Germany");

    private static Set<User> USERS = Set.of(user1, user2, user3, user4, user5, user6, user7);

    private static Content video1 = new Video("Stream API Explained", "Deep dive into Java Stream API.");
    private static Content video2 = new Video("Data Structures", "Overview of common data structures in Java.");
    private static Content video3 = new Video("Design Patterns", "Learn popular software design patterns.");
    private static Content music1 = new Music("Rhythm Pulse", "Upbeat electronic dance music.");
    private static Content music2 = new Music("Acoustic Vibes", "Chill acoustic guitar melody.");
    private static Content music3 = new Music("Night Drive", "Lo-fi beats for late-night coding.");
    private static Content music4 = new Music("Epic Journey", "Cinematic orchestral score.");
    private static Content music5 = new Music("Morning Energy", "Pop-rock tune to start your day.");
    private static Content article1 = new Article("SOLID Principles", "Best practices for OOP design.");
    private static Content article2 = new Article("Garbage Collection", "How memory management works in Java.");
    private static Content article3 = new Article("Functional Interfaces", "Using lambdas and functional interfaces.");


    private static Set<Content> CONTENT_SET = Set.of(video1, video2, video3, music1, music2, music3, music4, music5, article1, article2, article3);

    @BeforeAll
    static void init() {
        USERS.forEach(user -> CONTENT_SET.forEach(content -> {
            if (user.getCountry().equals("USA") && content.getClass().equals(Video.class)) {
                user.view(content, LocalDate.now());
            } else if (user.getName().equals("Hannah Lewis") && content.getClass().equals(Article.class)) {
                user.comment(content, LocalDate.of(2025, 3, 15), "Interesting.");
            } else if ((user.getName().equals("Diana Miller") || user.getName().equals("Fiona Davis")) && content.getClass().equals(Music.class)) {
                user.like(content, LocalDate.of(2025, 2, 15));
            } else if (user.getName().equals("George Wilson") && (content.getName().equals("Morning Energy")
                            || content.getName().equals("Design Patterns")
                            || content.getName().equals("SOLID Principles"))){
                user.like(content,LocalDate.now());
            }
        }));
    }

    @Test
    void addUser() {
        Assertions.assertEquals(USERS, OnlineApp.getUsers());
    }

    @Test
    void interactPositiveTestCase1() {
        Set<Interaction> expected = Set.of(
                Interaction.builder(user1, video1, InteractionType.VIEW).localDate(LocalDate.now()).build(),
                Interaction.builder(user1, video2, InteractionType.VIEW).localDate(LocalDate.now()).build(),
                Interaction.builder(user1, video3, InteractionType.VIEW).localDate(LocalDate.now()).build()
        );
        Assertions.assertEquals(expected, user1.getInteractions());
    }

    @Test
    void interactPositiveTestCase2(){
        Set<Interaction> expected = Set.of(
                Interaction.builder(user3, video1, InteractionType.VIEW).localDate(LocalDate.now()).build(),
                Interaction.builder(user3, video2, InteractionType.VIEW).localDate(LocalDate.now()).build(),
                Interaction.builder(user3, video3, InteractionType.VIEW).localDate(LocalDate.now()).build()
        );
        Assertions.assertEquals(expected, user3.getInteractions());
    }

    @Test
    void interactPositiveTestCase3(){
        Set<Interaction> expected = Set.of(
                Interaction.builder(user6, video1, InteractionType.VIEW).localDate(LocalDate.now()).build(),
                Interaction.builder(user6, video2, InteractionType.VIEW).localDate(LocalDate.now()).build(),
                Interaction.builder(user6, video3, InteractionType.VIEW).localDate(LocalDate.now()).build()
        );
        Assertions.assertEquals(expected, user6.getInteractions());
    }

    @Test
    void interactPositiveTestCase4(){
        Set<Interaction> expected = Set.of(
                Interaction.builder(user5, article1, InteractionType.COMMENT).comment("Interesting.").localDate(LocalDate.of(2025, 3, 15)).build(),
                Interaction.builder(user5, article2, InteractionType.COMMENT).comment("Interesting.").localDate(LocalDate.of(2025, 3, 15)).build(),
                Interaction.builder(user5, article3, InteractionType.COMMENT).comment("Interesting.").localDate(LocalDate.of(2025, 3, 15)).build()
        );
        Assertions.assertEquals(expected, user5.getInteractions());
    }

    @Test
    void interactPositiveTestCase5(){
        Set<Interaction> expected = Set.of(
                Interaction.builder(user2, music1, InteractionType.LIKE).localDate(LocalDate.of(2025, 2, 15)).build(),
                Interaction.builder(user2, music2, InteractionType.LIKE).localDate(LocalDate.of(2025, 2, 15)).build(),
                Interaction.builder(user2, music3, InteractionType.LIKE).localDate(LocalDate.of(2025, 2, 15)).build(),
                Interaction.builder(user2, music4, InteractionType.LIKE).localDate(LocalDate.of(2025, 2, 15)).build(),
                Interaction.builder(user2, music5, InteractionType.LIKE).localDate(LocalDate.of(2025, 2, 15)).build()
        );
        Assertions.assertEquals(expected, user2.getInteractions());
    }

    @Test
    void interactPositiveTestCase6(){
    Set<Interaction> expected = Set.of(
            Interaction.builder(user4, music1, InteractionType.LIKE).localDate(LocalDate.of(2025, 2, 15)).build(),
            Interaction.builder(user4, music2, InteractionType.LIKE).localDate(LocalDate.of(2025, 2, 15)).build(),
            Interaction.builder(user4, music3, InteractionType.LIKE).localDate(LocalDate.of(2025, 2, 15)).build(),
            Interaction.builder(user4, music4, InteractionType.LIKE).localDate(LocalDate.of(2025, 2, 15)).build(),
            Interaction.builder(user4, music5, InteractionType.LIKE).localDate(LocalDate.of(2025, 2, 15)).build()
    );
        Assertions.assertEquals(expected, user4.getInteractions());
    }

    @Test
    void interactPositiveTestCase7(){
        Set<Interaction> expected = Set.of(
                Interaction.builder(user7, video3, InteractionType.LIKE).localDate(LocalDate.now()).build(),
                Interaction.builder(user7, music5, InteractionType.LIKE).localDate(LocalDate.now()).build(),
                Interaction.builder(user7, article1, InteractionType.LIKE).localDate(LocalDate.now()).build()
        );
        Assertions.assertEquals(expected, user7.getInteractions());
    }

    @Test
    void findMostActiveUsersTest() {
        Set<User> expected = Set.of(
                user2,
                user4
        );
        Assertions.assertEquals(expected, OnlineApp.findMostActiveUsers());
    }

    @Test
    void findThreeMostPopularContentTest() {
        Set<Content> expected = Set.of(
                video1,
                video2,
                video3
        );
        Assertions.assertEquals(expected, OnlineApp.findThreeMostPopularContent());
    }

    @Test
    void findAverageOfInteractionsByCountryTest() {
        Map<String, Double> expected = Map.of(
                "USA", 3.0,
                "Canada", 5.0,
                "Germany", 3.0,
                "France", 4.0);
        Assertions.assertEquals(expected, OnlineApp.findAverageOfInteractionsByCountry());
    }

    @Test
    void findUsersInteractingWithDifferentTypesOfContentTest(){
        Set<User> expected = Set.of(new User("George Wilson", 31, "Germany"));
        Assertions.assertEquals(expected,OnlineApp.findUsersInteractingWithDifferentTypesOfContent());
    }

    @Test
    void findAvgNumberOfInteractionsForEachTypeOfContentTest(){
        Map<Class<?>, Long> expected = Map.of(
                Video.class, 10L,
                Article.class, 4L,
                Music.class, 11L
        );
        Assertions.assertEquals(expected, OnlineApp.countNumberOfInteractionsForEachTypeOfContent());
    }

}