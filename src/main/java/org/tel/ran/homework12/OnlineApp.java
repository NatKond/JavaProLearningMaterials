package org.tel.ran.homework12;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public final class OnlineApp {
    private static List<User> users = new ArrayList<>();
    private static List<Content> content = new ArrayList<>();
    private static List<Interaction> interactions = new ArrayList<>();

    public static List<User> getUsers() {
        return users;
    }

    public static List<Content> getContent() {
        return content;
    }

    public static List<Interaction> getInteractions() {
        return interactions;
    }

    public static void addUser(User user) {
        OnlineApp.users.add(user);
    }

    public static void addContent(Content content) {
        OnlineApp.content.add(content);
    }

    public static void interact(User user, Content content, InteractionType interactionType) {
        interactions.add(Interaction.builder(user, content, interactionType).localDate(LocalDate.now()).build());
    }

    public static void interact(User user, Content content, InteractionType interactionType, String comment) {
        interactions.add(Interaction.builder(user, content, interactionType).localDate(LocalDate.now()).comment(comment).build());
    }

    public static List<User> findMostActiveUsers() {
        Map<User, Long> userCountInteractionsMap = interactions.stream()
                .map(Interaction::getUser)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        long maxInteractions = userCountInteractionsMap.values().stream()
                .max(Long::compare)
                .orElseThrow();

        return userCountInteractionsMap.entrySet().stream()
                .filter(entry -> entry.getValue() == maxInteractions)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static List<Content> findThreeMostPopularContent() {
        return interactions.stream()
                .map(Interaction::getContent)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .sorted((e1, e2) -> Math.toIntExact(e1.getValue() - e2.getValue()))
                .map(Map.Entry::getKey)
                .limit(3)
                .toList();
    }

    public static Map<String, Double> findAverageOfInteractionsByCountry() {
        return users.stream()
                .collect(Collectors.groupingBy(User::getCountry))
                .entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, entry -> entry.getValue().stream()
                        .map(user -> interactions.stream()
                                .filter(interaction -> interaction.getUser().equals(user))
                                .count())
                        .mapToDouble(d -> d).average().orElse(0.0)));
    }
}
