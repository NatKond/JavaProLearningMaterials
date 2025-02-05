package org.tel.ran._2025_02_04.lesson06;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListExample {
    public static void main(String[] args) {
        //ArrayList list1 = new ArrayList();
        List list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add("7");
        list.add("8");
        list.add("9");
        list.add("10");
        System.out.println("list = " + list);

        list.remove(1);

        list.remove(Integer.valueOf(3));

        list.remove("7");
        System.out.println("list = " + list);

        list.add(4,15);
        list.set(0,10);
        System.out.println("list = " + list);
        System.out.println("list.get(3) = " + list.get(3));

        for (int i = 0; i < list.size(); i++) {
            System.out.println("list.get(" + i + ") = " + list.get(i));
        }

        System.out.println("list = " + list);

        Iterator iterator = list.iterator();
        System.out.println("iterator.next() = " + iterator.next());
        System.out.println("iterator.next() = " + iterator.next());
        System.out.println("iterator.next() = " + iterator.next());
        System.out.println("iterator.next() = " + iterator.next());
        /* while (iterator.hasNext()){
            System.out.println("iterator.next() = " + iterator.next());
        }*/

    }
}
