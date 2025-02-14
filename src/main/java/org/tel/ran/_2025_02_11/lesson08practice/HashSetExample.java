package org.tel.ran._2025_02_11.lesson08practice;
import java.util.HashSet;
import java.util.Set;

public class HashSetExample {
    public static void main(String[] args) {
        //Внутри сета - мапа - массив
        //В идеальном случае - в одной ячейке один элемент
        //в каждой ячейке массива хранится связный список


        System.out.println("Hello3".hashCode());
        System.out.println("A".hashCode());
        System.out.println(Integer.valueOf(10).hashCode());
        System.out.println(new CustomList(null).hashCode());

        Set<Integer> integerSet = new HashSet<>();
        integerSet.add(10);
        //hashCode 10 -> hash(hashCode, length) -> index
        integerSet.add(5);
        //hashCode 5 -> hash(hashCode, length) -> index1
        //add O(1)

        boolean contains = integerSet.contains(10); // contains O(1)
        //hashCode 10 -> hash(hashCode, length) -> index

        integerSet.add(10); // contains


    }
}
