package org.tel.ran.homework15.Task1;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class Competition {

    public static final Random RANDOM = new Random();

    public static void main(String[] args) {

        Semaphore bridge = new Semaphore(1);

        int numberOfLaps = 3;

        Runner runner1 = new Runner("Usain Bolt", numberOfLaps, bridge);
        Runner runner2 = new Runner("Haile Gebrselassie", numberOfLaps, bridge);
        Runner runner3 = new Runner("Carl Lewis", numberOfLaps, bridge);

        Thread thread1 = new Thread(runner1);
        Thread thread2 = new Thread(runner2);
        Thread thread3 = new Thread(runner3);

        thread1.start();
        thread2.start();
        thread3.start();

        try {
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long totalTime1 = runner1.getTotalTime();
        long totalTime2 = runner2.getTotalTime();
        long totalTime3 = runner3.getTotalTime();

        Runner winner = totalTime1 < totalTime2 ?
                (totalTime1 < totalTime3 ? runner1: runner3):
                (totalTime2 < totalTime3 ? runner2 : runner3);

        System.out.println("Result : " + winner.getName() + "wins, with total time = " + winner.getTotalTime());

    }
}
