package org.tel.ran._2025_02_07.summary03;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import static org.tel.ran.textFormatting.RESET;
import static org.tel.ran.textFormatting.YELLOW;

public class Task_ArrayList {
    public static void main(String[] args) {

        List<String> strings = new ArrayList<>(List.of("Hello", "Bye", "Goodbye", "Ay"));
        System.out.println("strings  = " + strings);
        System.out.println(countChars(strings));
        System.out.println(getStringLongerThanThree(strings));
        System.out.println(findMaxLength(strings));

        List<Integer> integers = new ArrayList<>(List.of(3, 5, 6, 4, 2, 1));
        System.out.println("integers = " + integers);
        System.out.println(findSum(integers));
        System.out.println(findMax(integers));
        System.out.println(findAllMultiple(integers, 3));
        System.out.println(YELLOW + "Написать метод, который проверяет, является ли список Integer отсортированным." + RESET);
        System.out.println("isSorted(new ArrayList<>(List.of(3, 5, 6, 4, 2, 1))) = " + isSorted(new ArrayList<>(List.of(3, 5, 6, 4, 2, 1))));
        System.out.println("isSorted(new ArrayList<>(List.of(3, 2, 1, 1, 1, 1))) = " + isSorted(new ArrayList<>(List.of(3, 2, 1, 1, 1, 1))));
        System.out.println("isSorted(new ArrayList<>(List.of(3, 3, 3, 4, 5, 6))) = " + isSorted(new ArrayList<>(List.of(3, 3, 3, 4, 5, 6))));
        System.out.println("isSorted(new ArrayList<>(List.of(1, 1, 2, 3, 4, 5))) = " + isSorted(new ArrayList<>(List.of(1, 1, 2, 3, 4, 5))));
        System.out.println("isSorted(new ArrayList<>(List.of(1, 1, 1, 1, 1, 1))) = " + isSorted(new ArrayList<>(List.of(1, 1, 1, 1, 1, 1))));
        System.out.println(YELLOW + "Написать метод, который проверяет, является ли список Integer отсортированным." + RESET);
        System.out.println("isSortedWithCopies(new ArrayList<>(List.of(3, 5, 6, 4, 2, 1))) = " + isSortedWithCopies(new ArrayList<>(List.of(3, 5, 6, 4, 2, 1))));
        System.out.println("isSortedWithCopies(new ArrayList<>(List.of(3, 2, 1, 1, 1, 1))) = " + isSortedWithCopies(new ArrayList<>(List.of(3, 2, 1, 1, 1, 1))));
        System.out.println("isSortedWithCopies(new ArrayList<>(List.of(3, 3, 3, 4, 5, 6))) = " + isSortedWithCopies(new ArrayList<>(List.of(3, 3, 3, 4, 5, 6))));
        System.out.println("isSortedWithCopies(new ArrayList<>(List.of(1, 1, 2, 3, 4, 5))) = " + isSortedWithCopies(new ArrayList<>(List.of(1, 1, 2, 3, 4, 5))));
        System.out.println("isSortedWithCopies(new ArrayList<>(List.of(1, 1, 1, 1, 1, 1))) = " + isSortedWithCopies(new ArrayList<>(List.of(1, 1, 1, 1, 1, 1))));
    }

    /**
     * У вас есть список значений String, вы должны вернуть список количества символов этих String
     *
     * @param strings
     * @return
     */
    public static List<Integer> countChars(List<String> strings) {
        System.out.println(YELLOW + "У вас есть список значений String, вы должны вернуть список количества символов этих String" + RESET);
        List<Integer> countLengths = new ArrayList<>();
        for (String string : strings) {
            countLengths.add(string.length());
        }
        return countLengths;
    }

    /**
     * У вас есть список значений String, вы должны вернуть список со всеми значениями String более трех символо
     *
     * @param strings
     * @return
     */

    public static List<String> getStringLongerThanThree(List<String> strings) {
        System.out.println(YELLOW + "У вас есть список значений String, вы должны вернуть список со всеми значениями String более трех символо" + RESET);
        ArrayList<String> stringsLongerThanThree = new ArrayList<>();
        for (String s : strings) {
            if (s.length() > 3) {
                stringsLongerThanThree.add(s);
            }
        }
        return stringsLongerThanThree;
    }

    /**
     * У вас есть список значений Integer, вы должны вернуть их сумму
     *
     * @param integers
     * @return
     */

    public static int findSum(List<Integer> integers) {
        System.out.println(YELLOW + "У вас есть список значений Integer, вы должны вернуть их сумму" + RESET);
        int sum = 0;
        for (Integer num : integers) {
            sum += num;
        }
        return sum;
    }

    /**
     * у вас есть список значений Integer, вы должны вернуть их максимум
     *
     * @param integers
     * @return
     */

    public static int findMax(List<Integer> integers) {
        System.out.println(YELLOW + "У вас есть список значений Integer, вы должны вернуть их максимум" + RESET);
        List<Integer> copy = new ArrayList<>(integers);
        copy.sort(Comparator.naturalOrder());
        return copy.getLast();
    }

    /**
     * у вас есть список String, вы должны вернуть максимальную длину String
     */
    public static int findMaxLength(List<String> strings) {
        System.out.println(YELLOW + "У вас есть список String, вы должны вернуть максимальную длину String" + RESET);
        int maxLength = 0;
        for (String str : strings) {
            if (str.length() > maxLength) {
                maxLength = str.length();
            }
        }
        return maxLength;
    }

    /**
     * Написать метод, который проверяет, является ли список Integer отсортированным.
     */
    public static boolean isSorted(List<Integer> integers) {
        Iterator<Integer> integetsIterator = integers.iterator();
        int previousNumber = integetsIterator.next();
        int currentNumber = integetsIterator.next();
        if (previousNumber == currentNumber) {
            while (integetsIterator.hasNext()) {
                currentNumber = integetsIterator.next();
                if (previousNumber != currentNumber) {
                    previousNumber = currentNumber;
                    break;
                }
            }
        }
        if (integetsIterator.hasNext() && integetsIterator.next() > previousNumber) {
            while (integetsIterator.hasNext()) {
                currentNumber = integetsIterator.next();
                if (currentNumber < previousNumber) return false;
                previousNumber = currentNumber;
            }
        } else if (integetsIterator.hasNext()) {
            while (integetsIterator.hasNext()) {
                currentNumber = integetsIterator.next();
                if (currentNumber > previousNumber) return false;
                previousNumber = currentNumber;
            }
        }
        return true;
    }

    public static boolean isSortedWithCopies(List<Integer> integers){
        List<Integer> copy1 = new ArrayList<>(integers);
        List<Integer> copy2 = new ArrayList<>(integers);
        copy1.sort(Comparator.naturalOrder());
        copy2.sort(Comparator.reverseOrder());
        return integers.equals(copy1) || integers.equals(copy2);
    }

    /**
     * Написать метод, который выдает из исходного списка список всех значений, делящихся на заданное число q
     */
    public static List<Integer> findAllMultiple(List<Integer> integers, int q) {
        System.out.println(YELLOW + "Написать метод, который выдает из исходного списка список всех значений, делящихся на заданное число q." + RESET);
        ArrayList<Integer> multiples = new ArrayList<>();
        for (Integer num : integers) {
            if (num % q == 0) {
                multiples.add(num);
            }
        }
        return multiples;
    }
}
