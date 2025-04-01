package org.tel.ran._2025_03_28.summary08;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.IntStream;

/**
 * Найти все ключи в Map<String, Integer>, соответствующие заданному значению, и вернуть их в виде списка.
 * Дан список чисел. Необходимо найти сумму всех четных чисел.
 * Дан список чисел. Необходимо найти среднее значение всех чисел. //average()
 * Дан список слов. Необходимо найти самое длинное слово.
 * Дан список чисел. Необходимо пропустить первые два элемента и вывести остальные
 * Дан список слов. Необходимо проверить, содержит ли он хотя бы одно слово, начинающееся с буквы "A".
 * Дан список строк. Необходимо объединить их в одну строку, разделенную запятой. //Collectors.joining()
 * Дан список объектов Person. Необходимо сгруппировать их по возрасту и вывести результат.
 * Дан список чисел. Необходимо проверить, являются ли все числа положительными.
 * Дан список чисел. Необходимо найти первое четное число.
 * Дан список чисел. Необходимо умножить все числа на заданное значение.
 * Дан список строк. Необходимо найти сумму длин всех строк.
 */

public class CollectionsWithStreams {
    public static void main(String[] args) {
        Map<String, Integer> stringIntegerMap = Map.of(
                "Apple", 3,
                "Banana", 5,
                "Orange", 1,
                "Grapes", 3,
                "Pineapple", 3);
        System.out.println("findAllKeys(stringIntegerMap,3) = " + findAllKeys(stringIntegerMap, 3));
        Random random = new Random();
        System.out.println("RandomStringUtils.random(6) = " + RandomStringUtils.randomAlphabetic(12));

        // List<String> strings = Stream.generate(() -> RandomStringUtils.randomAlphabetic(random.nextInt(5) + 2)).limit(10).toList();
        List<String> strings = List.of("Apple", "Apricot", "Avocado", "Orange", "Grapes", "Pineapple");
        System.out.println("strings = " + strings);
        System.out.println("transformStrings(strings) = " + transformStrings(strings));
        System.out.println("avrLength(strings) = " + avrLength(strings, 'A'));

        List<Integer> numbers = IntStream.generate(() -> random.nextInt(-100, 100)).limit(20).boxed().toList();
        System.out.println("numbers = " + numbers);



    }

    public static List<String> findAllKeys(Map <String,Integer> stringIntegerMap, int value){
        return stringIntegerMap.entrySet().stream()
                .filter(entry -> entry.getValue().equals(value))
                .map(Map.Entry::getKey)
                .toList();
    }

    /**
     * Дан список строк. Необходимо отфильтровать строки, длина которых больше 3 символов,
     * преобразовать их в верхний регистр, удалить повторяющиеся и вывести результат в отсортированном порядке.
     */

    public static List<String> transformStrings(List<String> strings){
        return strings.stream()
                .filter(s -> s.length() > 3)
                .map(String::toUpperCase)
                .distinct()
                .sorted()
                .toList();
    }

    /**
     * Дан список слов. Необходимо найти среднюю длину слов, начинающихся с буквы "A"
     */

    public static double avrLength (List<String> strings, char c){
        return strings.stream()
                .filter(s -> s.charAt(0) == c)
                .map(String::length)
                .mapToDouble(i -> i)
                .average()
                .orElse(0.0);
    }

}
