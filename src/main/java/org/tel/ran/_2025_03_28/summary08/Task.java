package org.tel.ran._2025_03_28.summary08;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Имеется два списка элементов.List list1 = Arrays.asList(1, 2, 3, 5, 5);
 * List list2 = Arrays.asList(4, 5, 6, 1);
 * С помощью flatmap:
 * a). Получить все возможные значения произведения чисел из обоих списков
 * b). Получить все возможные повторяющиеся пары чисел из обоих списков [1, 1] [5, 5]
 * с). Найти все пары чисел, которые делятся друг на друга [2, 4] [3, 6] [5, 1]
 */

public class Task {
    public static void main(String[] args) {
        List<Integer> list1 = Arrays.asList(1, 2, 3, 5, 5);
        List<Integer> list2 = Arrays.asList(4, 5, 6, 1);

        System.out.println("allMultiplications(list1,list2) = " + allMultiplications(list1, list2));
        System.out.println("allCombinations(list1,list2) = " + allCombinations(list1, list2));
        System.out.println("findDivisiblePairs(list1,list2) = " + findDivisiblePairs(list1, list2));
    }

    public static List<Integer> allMultiplications(List<Integer> list1, List<Integer> list2) {
        return list1.stream().flatMap(x -> list2.stream().map(y -> x * y)).toList();
    }

    public static Set<List<Integer>> allCombinations(List<Integer> list1, List<Integer> list2) {
        return list1.stream()
                .flatMap(x -> list2.stream()
                        .filter(y -> Objects.equals(y, x))
                        .map(y -> Arrays.asList(x, y)))
                .collect(Collectors.toSet());
    }

    public static Set<List<Integer>> findDivisiblePairs(List<Integer> list1, List<Integer> list2) {
        return list1.stream()
                .filter(x -> x != 1)
                .flatMap(x -> list2.stream()
                        .filter(y -> y != 1)
                        .filter(y -> !x.equals(y))
                        .filter(y -> x % y == 0 || y % x == 0)
                        .map(y -> List.of(x, y)))
                .collect(Collectors.toSet());
    }
}
