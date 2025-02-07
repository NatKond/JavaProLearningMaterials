package org.tel.ran._2025_02_07.summary03;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Collection {
    public static void main(String[] args) {

        List<String> strings = new ArrayList<>(List.of("Hello", "Bye", "Goodbye", "Ay"));
        System.out.println(countChars(strings));
        System.out.println(getStringLongerThanThree(strings));

        List<Integer> integers = new ArrayList<>(List.of(1,2,3,4,5,6));
        System.out.println(findSum(integers));
        System.out.println(findMaxLength(strings));
        System.out.println(findAllMultiple(integers, 3));
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
