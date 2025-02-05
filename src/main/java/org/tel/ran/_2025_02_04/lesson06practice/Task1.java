package org.tel.ran._2025_02_04.lesson06practice;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class Task1 {
    public static void main(String[] args) {

        ArrayList arrayList = new ArrayList();

        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            arrayList.add(random.nextInt(50));
        }

        for (int i = 0; i < arrayList.size(); i++) {
            System.out.print(arrayList.get(i) + " ");
        }
        System.out.println();

        for (int i = 0; i < arrayList.size(); i++) {
            System.out.print(arrayList.get(arrayList.size() - 1 - i) + " ");
        }
        System.out.println();

        for (int i = arrayList.size() - 1; i >= 0; i--) {
            System.out.print(arrayList.get(i) + " ");
        }

        //ArrayList <Integer> integers = new ArrayList<>();

        ArrayList arrayList1 = new ArrayList();

        for (Object i:arrayList) {
            if ((int)i < 20){
                arrayList1.add((int) i);
            }
        }
        System.out.println();
        System.out.println(arrayList1);

        int sum = 0;
        for (Object i:arrayList) {
            sum += (int) i;
        }

        System.out.println("Sum: " + sum);

        for (int i = 0; i < arrayList1.size(); i += 3) {
            System.out.print("integers.get(" + i + ") = " + arrayList1.get(i) + "; ");
        }
        System.out.println();
        System.out.println("arrayList1.size() = " + arrayList1.size());

        for (int i = 0; i < arrayList1.size()/2; i++) {
            System.out.print("arrayList1.get(" + i + ") = " + arrayList1.get(i) + "; ");
            System.out.println("arrayList1.get(" + (arrayList1.size() - 1 - i) + ") = " + arrayList1.get(arrayList1.size() - 1 - i));
        }

        for (int i = 0, j = arrayList1.size() - 1; i < arrayList1.size()/2.0 || j > arrayList1.size()/2.0; i++, j--) {
            System.out.print("arrayList1.get(" + i + ") = " + arrayList1.get(i) + "; ");
            System.out.println("arrayList1.get(" + j + ") = " + arrayList1.get(j));
        }

        int left = 0;
        int right = arrayList1.size() - 1;
        while (left < right){
            System.out.print("arrayList1.get(" + left + ") = " + arrayList1.get(left++));
            System.out.println("arrayList1.get(" + right + ") = " + arrayList1.get(right--));
        }

    }
}
