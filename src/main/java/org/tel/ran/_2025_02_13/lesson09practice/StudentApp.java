package org.tel.ran._2025_02_13.lesson09practice;

import java.util.HashSet;
import java.util.Set;

public class StudentApp {
    public static void main(String[] args) {
        Student alex = new Student("alex@gmail.com", "Alex");
        int i = alex.hashCode();
        System.out.println("Alex hashcode " + i);

        Set<Student> students = new HashSet<>();
        students.add(alex);
        //students.add(1);
        System.out.println("Student size "+ students.size());

        students.add(alex);
        System.out.println("Student size "+ students.size());

        alex.setEmail("alex2@gmail.com");

        System.out.println("Alex in set = " + students.contains(alex));
        students.add(alex);
        System.out.println("Student size "+ students.size());
    }
}
