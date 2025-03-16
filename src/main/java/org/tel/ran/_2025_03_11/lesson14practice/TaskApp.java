package org.tel.ran._2025_03_11.lesson14practice;

import java.util.ArrayList;
import java.util.List;

import static org.tel.ran._2025_03_11.lesson14practice.Status.*;
import static org.tel.ran._2025_03_11.lesson14practice.TaskPriority.*;
import static org.tel.ran.textFormatting.*;

public class TaskApp {

    public static void main(String[] args) {
        Task task1 = new Task("Fix login bug", TODO, HIGH);
        Task task2 = new Task("Optimize video", TODO, MEDIUM);
        Task task3 = new Task("Resolve UI glitches", COMPLETED, LOW);
        Task task4 = new Task("Improve accessibility", TODO, HIGH);
        Task task5 = new Task("Test certificate generation", TODO, MEDIUM);

        List<Task> tasks = new ArrayList<>(List.of(task1, task2, task3, task4, task5));
        tasks.add(new Task("Resolve issue with notifications", TODO, HIGH));

        setStatusInProgressForHighPriority(tasks);

        System.out.println(printTasks(tasks));

        System.out.println(tasks.getLast());
    }

    public static void setStatusInProgressForHighPriority(List<Task> tasks) {
        for (Task task : tasks) {
            if (task.getPriority() == HIGH) {
                task.setStatus(IN_PROGRESS);
            }
        }
    }

    public static String printTasks(List<Task> tasks) {
        StringBuilder output = new StringBuilder();
        for (Task task : tasks) {
            output.append(task).append("\n");
        }
        return output.toString();
    }
}
