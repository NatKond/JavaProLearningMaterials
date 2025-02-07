package org.tel.ran._2025_02_07.summary03;

import java.util.*;

/**
 * Имеется заданный список имен студентов: List names = new ArrayList<>(List.of("Mary", "Jane", "Tom", "Tim", "Mark", "Ann", null, ""))
 * С помощью итератора:
 * a). Вывести имена, состоящие из 4 букв
 * b). Удалить из списка null и пустые строки.
 * С помощью listIterator:
 * c). вывести все элементы листа в обратном порядке.
 * d). Удалить из списка все имена, начинающиеся на "T"
 * e). Заменить в списке "Ann" на "student Ann
 */


public class TaskIterator {
    public static final String YELLOW = "\u001B[33m";
    public static final String RESET = "\u001B[0m";

    public static void main(String[] args) {
        List<String> names = new ArrayList<>(List.of("Mary", "Jane", "Tom", "Tim", "Mark", "Ann"));
        names.add(null);
        names.add("");
        names.add(null);
        System.out.println(names);

        printNamesOfLength(names,4);

        deleteNullElements(names);
        System.out.println(names);

        System.out.println(reverseList(names));

        printInReverseOrder(names);
        deleteNamesStartingWith(names,"T");
        System.out.println(names);
        addWordStudentToName(names, "Ann");
        System.out.println(names);

        System.out.println(YELLOW + "Найти все дубликаты в List<String> и вернуть их в виде нового списка" + RESET);
        names.addAll(List.of("Mary","Mark","Mark","Tom","Tim","Tom","Tom","Tom"));
        System.out.println(names);
        System.out.println(getAllDublicates(names));
    }

    public static void printNamesOfLength(List<String> names, int length) {
        System.out.println(YELLOW + "a). Вывести имена, состоящие из 4 букв." + RESET);
        Iterator<String> namesIterator = names.iterator();
        while (namesIterator.hasNext()){
            String name = namesIterator.next();
            if (name != null && name.length() == length) System.out.print(name + " ");
        }
        System.out.println();
    }

    public static void deleteNullElements(List<String> names){
        System.out.println(YELLOW + "b). Удалить из списка null и пустые строки." + RESET);
        Iterator<String> namesIterator = names.iterator();
        while (namesIterator.hasNext()){
            String name = namesIterator.next();
            if (name == null) namesIterator.remove();
            else if (name.isEmpty()) namesIterator.remove();
        }
    }

    public static List<String> reverseList(List<String> stringList){
        System.out.println(YELLOW + "c). Вывести все элементы листа в обратном порядке. Версия 1." + RESET);
        ListIterator<String> listIterator = stringList.listIterator(stringList.size());
        List<String> result = new ArrayList<>();
        while (listIterator.hasPrevious()){
            result.add(listIterator.previous());
        }
        return result;
    }

    public static void printInReverseOrder(List<String> names){
        System.out.println(YELLOW + "c). Вывести все элементы листа в обратном порядке. Версия 2." + RESET);
        ListIterator<String> namesListIterator = names.listIterator();
        while (namesListIterator.hasNext()){
            namesListIterator.next();
        }

        while (namesListIterator.hasPrevious())
            System.out.print(namesListIterator.previous() + " ");
        System.out.println();
    }

    public static void deleteNamesStartingWith(List<String> names, String start){
        System.out.println(YELLOW + "d). Удалить из списка все имена, начинающиеся на T." + RESET);
        ListIterator<String> namesListIterator = names.listIterator();
        while (namesListIterator.hasNext()){
            if (namesListIterator.next().startsWith(start)){
                namesListIterator.remove();
            }
        }
    }

    public static void addWordStudentToName(List<String> names, String name){
        System.out.println(YELLOW + "e). Заменить в списке Ann на student Ann" + RESET);
        ListIterator<String> namesListIterator = names.listIterator();
        while (namesListIterator.hasNext()){
            String nameFromList = namesListIterator.next();
            if (nameFromList.equals(name)){
                namesListIterator.set("student " + nameFromList);
            }
        }
    }

    /**
     * Найти все дубликаты в List<String> и вернуть их в виде нового списка
     */
    public static List<String> getAllDublicates(List<String> strings){
        Set<String> stringsDublicates = new HashSet<>();
        for (int i = 0; i < strings.size(); i++) {
            for (int j = i + 1; j < strings.size(); j++) {
                if (strings.get(i).equals(strings.get(j))){
                    stringsDublicates.add(strings.get(i));
                }
            }
        }

        return new ArrayList<>(stringsDublicates);
    }
}