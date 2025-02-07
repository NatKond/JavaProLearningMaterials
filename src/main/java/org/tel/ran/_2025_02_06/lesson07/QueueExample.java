package org.tel.ran._2025_02_06.lesson07;

import java.time.LocalDateTime;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class QueueExample {
    public static void main(String[] args) {
        Patient patient1 = new Patient(LocalDateTime.of(2025,2,6,10,15));
        Patient patient2 = new Patient(LocalDateTime.of(2025,2,6,11,15));
        Patient patient3 = new Patient(LocalDateTime.of(2025,2,6,10,45));
        Patient patient4 = new Patient(LocalDateTime.of(2025,2,6,9,15));
        Patient patient5 = new Patient(LocalDateTime.of(2025,2,6,12,15));
        Patient patient6 = new Patient(LocalDateTime.of(2025,2,5,23,15));
        Patient patient7 = new Patient(LocalDateTime.of(2025,2,6,10,25));
        Patient patient8 = new Patient(LocalDateTime.of(2025,2,6,7,45));
        Patient patient9 = new Patient(LocalDateTime.of(2025,2,6,8,30));
        Patient patient10 = new Patient(LocalDateTime.of(2025,2,6,5,30));

        Queue queue = new PriorityQueue(List.of(patient1,patient2,patient3,patient4,patient5,patient6,patient7,patient8,patient9,patient10));

        for(Object p: queue){
            System.out.println(p);
        }
        //System.out.println("queue = " + queue);

        System.out.println("queue.poll() = " + queue.poll());
        System.out.println("queue.poll() = " + queue.poll());
        System.out.println("queue.poll() = " + queue.poll());
        System.out.println("queue.poll() = " + queue.poll());
        System.out.println("queue.poll() = " + queue.poll());
        System.out.println("queue.poll() = " + queue.poll());

        for(Object p: queue){
            System.out.println(p);
        }

    }
}
