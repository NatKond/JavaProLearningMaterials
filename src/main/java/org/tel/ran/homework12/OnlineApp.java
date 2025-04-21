package org.tel.ran.homework12;

import java.time.LocalDate;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public final class OnlineApp {
    private static Set<User> users = new HashSet<>();

    public static Set<User> getUsers() {
        return users;
    }

    public static void addUser(User user) {
        OnlineApp.users.add(user);
    }

    public static Set<User> findMostActiveUsers() {
        int maxInteractions = users.stream()
                .map(user -> user.getInteractions().size())
                .max(Integer::compare)
                .orElseThrow();

        return users.stream()
                .filter(user -> user.getInteractions().size() == maxInteractions)
                .collect(Collectors.toSet());
    }

    public static Set<Content> findThreeMostPopularContent() {
        return users.stream()
                .flatMap(user -> user.getInteractions().stream().map(Interaction::getContent))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .sorted((e1, e2) -> Long.compare(e2.getValue(), e1.getValue()))
                .map(Map.Entry::getKey)
                .limit(3)
                .collect(Collectors.toSet());
    }

    public static Map<String, Double> findAverageOfInteractionsByCountry() {
        return users.stream()
                .collect(Collectors.groupingBy(User::getCountry,
                        Collectors.mapping(user -> user.getInteractions().size(), Collectors.averagingInt(i -> i))));
                //.entrySet().stream()
                //.collect(Collectors.toMap(Map.Entry::getKey, entry -> entry.getValue().stream()
                //.mapToInt(user -> user.getInteractions().size()).average().orElse(0.0)));
    }

    public static Set<User> findUsersInteractingWithDifferentTypesOfContent() {
        Map<User, Long> userTypeContentCountMap = users.stream()
                .collect(Collectors.toMap(Function.identity(), user -> user.getInteractions().stream()
                        .map(interaction -> interaction.getContent().getClass())
                        .distinct().count()));

        long maxTypeContentInteractions = userTypeContentCountMap.values().stream()
                .max(Long::compare)
                .orElseThrow();

        return userTypeContentCountMap.entrySet().stream()
                .filter(entry -> entry.getValue() == maxTypeContentInteractions)
                .map(Map.Entry::getKey)
                .collect(Collectors.toSet());
    }

    public static Map<Class<?>, Double> findAverageNumberOfInteractionsForEachTypeOfContent() {
        return users.stream()
                .flatMap(user -> user.getInteractions().stream())
                .map(Interaction::getContent)
                .collect(Collectors.groupingBy(Content::getClass, Collectors.groupingBy(Function.identity(), Collectors.counting())))
                .entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, (entry) -> entry.getValue().values().stream().collect(Collectors.averagingLong(l -> l))));
    }

    public static Set<User> findUsersWithLastMonthInteractions() {
        return users.stream()
                .filter(user -> user.getInteractions().stream()
                        .allMatch(interaction -> interaction.getLocalDate().isAfter(LocalDate.now().minusMonths(1))))
                .collect(Collectors.toSet());
    }

    public static Set<User> findUsersHadOnlyLiked() {
        return users.stream()
                .filter(user -> user.getInteractions().stream().allMatch(interaction -> interaction.getType().equals(InteractionType.LIKE)))
                .collect(Collectors.toSet());
    }
}
