package org.tel.ran.homework5;

import java.util.*;

import static org.tel.ran.textFormatting.*;

/**
 * Создать TreeSet. Из него: Найти заданное число 10, самое большое, самое маленькое Вывести все четные числа
 * Получить список всех чисел в обратном порядке Получить список всех чисел меньше 7
 */
public class Task_TreeSet {

    public static void main(String[] args) {
        Set<Integer> numbers = Set.of(8, 5, 11, 2, 9, 4, 3, 1, 7, 10);
        System.out.println("findNumber(numbers,10) = " + findNumber(numbers, 10));
        System.out.println("findMin(numbers) = " + findMin(numbers));
        System.out.println("findMax(numbers) = " + findMax(numbers));
        System.out.println("createReversedList(numbers) = " + createReversedList(numbers));
        System.out.println("createListWithNumbersLessThanTarget(numbers, 7) = " + createListWithNumbersLessThanTarget(numbers, 7));
    }

    public static boolean findNumber(Set<Integer> numbers, int target) {
        System.out.println(YELLOW + "Найти заданное число 10" + RESET);
        /*for (Integer number:numbers){
            if (number.equals(target)){
                return true;
            }
        }
        return false;*/
        return numbers.contains(target);
    }

    public static Integer findMin(Set<Integer> numbers) {
        System.out.println(YELLOW + "Найти самое маленькое число" + RESET);
        Iterator<Integer> setIterator = numbers.iterator();
        return setIterator.next();
    }

    public static Integer findMax(Set<Integer> numbers) {
        System.out.println(YELLOW + "Найти самое большое число" + RESET);
        List<Integer> numbersList = new ArrayList<>(numbers);
        return numbersList.getLast();
    }

    public static List<Integer> createReversedList(Set<Integer> numbers) {
        System.out.println(YELLOW + "Получить список всех чисел в обратном порядке" + RESET);
        List<Integer> reversedList = new ArrayList<>(numbers);
        return reversedList.reversed();
    }

    public static List<Integer> createListWithNumbersLessThanTarget(Set<Integer> numbers, int target) {
        System.out.println(YELLOW + "Получить список всех чисел меньше target" + RESET);
        List<Integer> listWithNumbersLessThanTarget = new ArrayList<>();
        for (Integer number : numbers) {
            if (number < target) {
                listWithNumbersLessThanTarget.add(number);
            }
        }
        return listWithNumbersLessThanTarget;
    }
}
