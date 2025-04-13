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
                user.view(content, LocalDate.now().minusDays(5));
            } else if (user.getName().equals("Hannah Lewis") && content.getClass().equals(Article.class)) {
                user.comment(content, LocalDate.now().minusMonths(2), "Interesting.");
            } else if ((user.getName().equals("Diana Miller") || user.getName().equals("Fiona Davis")) && content.getClass().equals(Music.class)) {
                user.like(content, LocalDate.now().minusMonths(6));
            } else if (user.getName().equals("George Wilson") && (content.getName().equals("Morning Energy")
                    || content.getName().equals("Design Patterns")
                    || content.getName().equals("SOLID Principles"))) {
                user.like(content, LocalDate.now());
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
                Interaction.builder(video1, InteractionType.VIEW).localDate(LocalDate.now().minusDays(5)).build(),
                Interaction.builder(video2, InteractionType.VIEW).localDate(LocalDate.now().minusDays(5)).build(),
                Interaction.builder(video3, InteractionType.VIEW).localDate(LocalDate.now().minusDays(5)).build()
        );
        Assertions.assertEquals(expected, user1.getInteractions());
    }

    @Test
    void interactPositiveTestCase2() {
        Set<Interaction> expected = Set.of(
                Interaction.builder(video1, InteractionType.VIEW).localDate(LocalDate.now().minusDays(5)).build(),
                Interaction.builder(video2, InteractionType.VIEW).localDate(LocalDate.now().minusDays(5)).build(),
                Interaction.builder(video3, InteractionType.VIEW).localDate(LocalDate.now().minusDays(5)).build()
        );
        Assertions.assertEquals(expected, user3.getInteractions());
    }

    @Test
    void interactPositiveTestCase3() {
        Set<Interaction> expected = Set.of(
                Interaction.builder(video1, InteractionType.VIEW).localDate(LocalDate.now().minusDays(5)).build(),
                Interaction.builder(video2, InteractionType.VIEW).localDate(LocalDate.now().minusDays(5)).build(),
                Interaction.builder(video3, InteractionType.VIEW).localDate(LocalDate.now().minusDays(5)).build()
        );
        Assertions.assertEquals(expected, user6.getInteractions());
    }

    @Test
    void interactPositiveTestCase4() {
        Set<Interaction> expected = Set.of(
                Interaction.builder(article1, InteractionType.COMMENT).comment("Interesting.").localDate(LocalDate.now().minusMonths(2)).build(),
                Interaction.builder(article2, InteractionType.COMMENT).comment("Interesting.").localDate(LocalDate.now().minusMonths(2)).build(),
                Interaction.builder(article3, InteractionType.COMMENT).comment("Interesting.").localDate(LocalDate.now().minusMonths(2)).build()
        );
        Assertions.assertEquals(expected, user5.getInteractions());
    }

    @Test
    void interactPositiveTestCase5() {
        Set<Interaction> expected = Set.of(
                Interaction.builder(music1, InteractionType.LIKE).localDate(LocalDate.now().minusMonths(6)).build(),
                Interaction.builder(music2, InteractionType.LIKE).localDate(LocalDate.now().minusMonths(6)).build(),
                Interaction.builder(music3, InteractionType.LIKE).localDate(LocalDate.now().minusMonths(6)).build(),
                Interaction.builder(music4, InteractionType.LIKE).localDate(LocalDate.now().minusMonths(6)).build(),
                Interaction.builder(music5, InteractionType.LIKE).localDate(LocalDate.now().minusMonths(6)).build()
        );
        Assertions.assertEquals(expected, user2.getInteractions());
    }

    @Test
    void interactPositiveTestCase6() {
        Set<Interaction> expected = Set.of(
                Interaction.builder(music1, InteractionType.LIKE).localDate(LocalDate.now().minusMonths(6)).build(),
                Interaction.builder(music2, InteractionType.LIKE).localDate(LocalDate.now().minusMonths(6)).build(),
                Interaction.builder(music3, InteractionType.LIKE).localDate(LocalDate.now().minusMonths(6)).build(),
                Interaction.builder(music4, InteractionType.LIKE).localDate(LocalDate.now().minusMonths(6)).build(),
                Interaction.builder(music5, InteractionType.LIKE).localDate(LocalDate.now().minusMonths(6)).build()
        );
        Assertions.assertEquals(expected, user4.getInteractions());
    }

    @Test
    void interactPositiveTestCase7() {
        Set<Interaction> expected = Set.of(
                Interaction.builder(video3, InteractionType.LIKE).localDate(LocalDate.now()).build(),
                Interaction.builder(music5, InteractionType.LIKE).localDate(LocalDate.now()).build(),
                Interaction.builder(article1, InteractionType.LIKE).localDate(LocalDate.now()).build()
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
    void findUsersInteractingWithDifferentTypesOfContentTest() {
        Set<User> expected = Set.of(new User("George Wilson", 31, "Germany"));
        Assertions.assertEquals(expected, OnlineApp.findUsersInteractingWithDifferentTypesOfContent());
    }

    @Test
    void findAverageNumberOfInteractionsForEachTypeOfContentTest() {
        System.out.println(OnlineApp.findAverageNumberOfInteractionsForEachTypeOfContent());
        Map<Class<?>, Double> expected = Map.of(
                Video.class, 10.0 / 3,
                Article.class, 4.0 / 3,
                Music.class, 11.0 / 5
        );
        Assertions.assertEquals(expected, OnlineApp.findAverageNumberOfInteractionsForEachTypeOfContent());
    }

    @Test
    void findUsersWithLastMonthInteractionsTest() {
        Set<User> expected = Set.of(user1, user3, user6, user7);
        Assertions.assertEquals(expected, OnlineApp.findUsersWithLastMonthInteractions());
    }

    @Test
    void findUsersHadOnlyLikedTest() {
        Set<User> expected = Set.of(user2, user4, user7);
        Assertions.assertEquals(expected, OnlineApp.findUsersHadOnlyLiked());
    }
}