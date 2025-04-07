package org.tel.ran.homework12;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
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
                .collect(Collectors.groupingBy(User::getCountry))
                .entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, entry -> entry.getValue().stream()
                        .map(user -> user.getInteractions().size())
                        .mapToInt(d -> d).average().orElse(0.0)));
    }

    public static Set<User> findUsersInteractingWithDifferentTypesOfContent(){
        Map<User, Integer> userTypeContentMap = users.stream()
                .collect(Collectors.toMap(Function.identity(), user -> user.getInteractions().stream()
                        .map(interaction -> interaction.getContent().getClass())
                        .collect(Collectors.toSet()).size()));

        int maxTypeContentInteractions = userTypeContentMap.values().stream()
                .max(Integer::compare)
                .orElseThrow();

        return userTypeContentMap.entrySet().stream()
                .filter(entry -> entry.getValue() == maxTypeContentInteractions)
                .map(Map.Entry::getKey)
                .collect(Collectors.toSet());
    }

    public static Map<Class<?>, Long> countNumberOfInteractionsForEachTypeOfContent(){
        return users.stream()
                .flatMap(user -> user.getInteractions().stream())
                .map(Interaction::getContent)
                .collect(Collectors.groupingBy(Content::getClass,Collectors.counting()));
    }
}
