package org.tel.ran.homework12;

import java.time.LocalDate;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public final class OnlineApp {
    private static Set<User> users = new HashSet<>();
    private static Set<Content> content = new HashSet<>();
    private static Set<Interaction> interactions = new HashSet<>();

    public static Set<User> getUsers() {
        return users;
    }

    public static Set<Content> getContent() {
        return content;
    }

    public static Set<Interaction> getInteractions() {
        return interactions;
    }

    public static void addUser(User user) {
        OnlineApp.users.add(user);
    }

    public static void addContent(Content content) {
        OnlineApp.content.add(content);
    }

    public static void addInteraction(Interaction interaction) {
        interactions.add(interaction);
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
                .sorted((e1, e2) -> Math.toIntExact(e2.getValue() - e1.getValue()))
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
