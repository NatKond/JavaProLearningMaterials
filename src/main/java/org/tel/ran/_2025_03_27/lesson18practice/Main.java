package org.tel.ran._2025_03_27.lesson18practice;

import java.util.Comparator;
import java.util.List;

/**
 * Создать список из 10 студентов
 * Студент должен содержать id, name, age
 * <p>
 * С помощью stream api :
 * 1) Взять список студентов и вернуть список их id
 * 2) Взять список студентов и вернуть список студентов,
 * возраст которых больше 25
 * 3) Взять список студентов и вернуть список id студентов
 * отсортированным по убыванию и только для тех чье имя
 * начинается с "M"
 */

public class Main {
    public static void main(String[] args) {
        List<Student> students = List.of(
                        new Student(1, "Alice Johnson", 20),
                        new Student(2, "Bob Smith", 22),
                        new Student(3, "Charlie Brown", 21),
                        new Student(4, "David Williams", 23),
                        new Student(3, "Matthew Miller", 21),
                        new Student(6, "Frank Miller", 24),
                        new Student(7, "Grace Wilson", 20),
                        new Student(8, "Henry Moore", 22),
                        new Student(7, "Megan Moore", 22),
                        new Student(10, "Jack Anderson", 23));

        System.out.println("getIds(students) = " + getStudentIds(students));
        System.out.println("getStudentOlderThan25(students, 20) = " + getStudentsOlderThan(students, 21));
        System.out.println("getStudentsWithSurname(students, 'M') = " + getStudentsWithSurname(students, 'M'));
        System.out.println("getStudentIdsWithSurname(students, 'M') = " + getStudentIdsWithSurname(students, 'M'));

    }

    public static List<Integer> getStudentIds(List<Student> students){
        // return students.stream().map(Student::getId).collect(Collectors.toList());
        return students.stream().map(Student::getId).toList();
    }

    public static List<Student> getStudentsOlderThan(List<Student> students, int age){
        return students.stream().filter(s -> s.getAge() > age).toList();
    }

    public static List<Student> getStudentsWithSurname(List<Student> students, Character letter){
        return students.stream().filter(s -> s.getName().split(" ")[1].charAt(0) == letter).sorted(Comparator.comparing(Student::getId).reversed()).toList();
    }

    public static List<Integer> getStudentIdsWithSurname(List<Student> students, Character letter){
        return students.stream().filter(s -> s.getName().split(" ")[1].charAt(0) == letter).map(Student::getId).sorted((a, b) -> Integer.compare(b, a)).toList();
    }
}
