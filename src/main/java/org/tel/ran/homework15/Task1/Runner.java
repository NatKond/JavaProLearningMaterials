package org.tel.ran.homework15.Task1;

import lombok.Getter;

import java.util.concurrent.Semaphore;

import static org.tel.ran.homework15.Task1.Competition.RANDOM;

public class Runner implements Runnable {

    @Getter
    private String name;

    private int numberOfLaps;

    private Semaphore bridge;

    @Getter
    private long totalTime;

    public Runner(String name, int numberOfLaps, Semaphore bridge) {
        this.name = name;
        this.numberOfLaps = numberOfLaps;
        this.bridge = bridge;
    }

    @Override
    public void run() {
        long start = System.currentTimeMillis();
        for (int i = 1; i <= numberOfLaps; i++) {
            System.out.println("- "+ name + " is running " + i + " lap");
            try {
                Thread.sleep(RANDOM.nextInt(15, 20));
                bridge.acquire();
                System.out.println(name + " is running across the bridge");
                bridge.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        long end = System.currentTimeMillis();
        totalTime = end - start;
        System.out.println("! " + name + " has finished the race" + name + " has total time: " + totalTime);
    }
}
