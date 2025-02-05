package org.tel.ran._2025_02_04.lesson06;

import java.util.*;

public class SetExample {
    public static void main(String[] args) {
        Set set1 = new HashSet();

        set1.add(4);
        set1.add(2);
        set1.add(1);
        set1.add(2);
        set1.add(3);
        set1.add("One");
        set1.add("Two");
        set1.add("Three");

        System.out.println("set = " + set1);

        for (Object o: set1) {
            System.out.println("o = " + o);
        }


        Set set2 = new LinkedHashSet();

        set2.add(4);
        set2.add(2);
        set2.add(1);
        set2.add(2);
        set2.add(3);
        set2.add("One");
        set2.add("Two");
        set2.add("Three");


        System.out.println("set = " + set2);

        for (Object o: set2) {
            System.out.println("o = " + o);
        }

        Set set3 = new TreeSet();
        set3.add("4");
        set3.add("2");
        set3.add("1");
        set3.add("2");
        set3.add("3");
        set3.add("10");

        System.out.println("set3 = " + set3);

        Comparator personComparator = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                Person person1 = (Person) o1;
                Person person2 = (Person) o2;

                return person1.getAge() - person2.getAge();
            }
        };

        Set set4 = new TreeSet(personComparator);
        //Set set4 = new TreeSet();

        Person person1 = new Person("Ivan", "Ivanov", 45);
        Person person2 = new Person("Petr", "Petrov", 40);
        Person person3 = new Person("Sidr", "Sidorov", 35);
        Person person4 = new Person("Ivan", "Ivanov", 33);
        Person person5 = new Person("Petr", "Petrov", 40);
        set4.add(person1);
        set4.add(person2);
        set4.add(person3);
        set4.add(person4);
        set4.add(person5);

        System.out.println("set3 = " + set4);
    }
}
