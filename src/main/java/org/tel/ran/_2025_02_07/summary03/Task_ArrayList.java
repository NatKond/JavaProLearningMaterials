package org.tel.ran._2025_02_07.summary03;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Task_ArrayList {
    public static void main(String[] args) {

        List<String> strings = new ArrayList<>(List.of("Hello", "Bye", "Goodbye", "Ay"));
        System.out.println( countChars(strings));
        System.out.println(getStringLongerThanThree(strings));
        System.out.println(findMaxLength(strings));

        List<Integer> integers = new ArrayList<>(List.of(3,5,6,4,2,1));
        System.out.println(findSum(integers));
        System.out.println(findMax(integers));
        System.out.println(findAllMultiple(integers, 3));
        System.out.println(isSorted(integers));
        integers.sort(Comparator.naturalOrder());
        System.out.println(isSorted(integers));
    }
    /**
     * У вас есть список значений String, вы должны вернуть список количества символов этих String
     * @param strings
     * @return
     */
    public static List<Integer> countChars(List<String> strings){
        List<Integer> countLengths = new ArrayList<>();
        for (String string : strings) {
            countLengths.add(string.length());
        }
        return countLengths;
    }

    /**
     * У вас есть список значений String, вы должны вернуть список со всеми значениями String более трех символо
     * @param strings
     * @return
     */

    public static List<String> getStringLongerThanThree(List<String> strings){
        ArrayList<String> stringsLongerThanThree = new ArrayList<>();
        for (String s: strings){
            if (s.length() > 3){
                stringsLongerThanThree.add(s);
            }
        }
        return stringsLongerThanThree;
    }

    /**
     * У вас есть список значений Integer, вы должны вернуть их сумму
     * @param integers
     * @return
     */

    public static int findSum(List<Integer> integers){
        int sum = 0;
        for (Integer num: integers){
            sum += num;
        }
        return sum;
    }

    /**
     * у вас есть список значений Integer, вы должны вернуть их максимум
     * @param integers
     * @return
     */

    public static int findMax(List<Integer> integers){
        int max = integers.getFirst();
        for (Integer num: integers){
            if (num > max) max = num;
        }
        return max;
    }

    /**
     * у вас есть список String, вы должны вернуть максимальную длину String
     */
    public static int findMaxLength (List<String> strings){
        int maxLength = 0;
        for (String str:strings){
            if(str.length() > maxLength){
                maxLength = str.length();
            }
        }
        return maxLength;
    }

    /**
     * Написать метод, который проверяет, является ли список Integer отсортированным.
     */
    public static boolean isSorted(List<Integer> integers){
        int previousNumber = integers.getFirst();
        for (Integer num:integers){
           if (num < previousNumber) return false;
           previousNumber = num;
        }
        return true;
    }

    /**
     * Написать метод, который выдает из исходного списка список всех значений, делящихся на заданное число q
     */
    public static List<Integer> findAllMultiple(List<Integer> integers,int q){
        ArrayList<Integer> multiples = new ArrayList<>();
        for (Integer num:integers){
            if (num%q == 0){
                multiples.add(num);
            }
        }
        return multiples;
    }
}
