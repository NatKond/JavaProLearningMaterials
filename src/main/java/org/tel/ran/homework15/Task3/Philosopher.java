package org.tel.ran.homework15.Task3;

import java.util.Random;

import static org.tel.ran.textFormatting.RESET;
import static org.tel.ran.textFormatting.YELLOW;

public class Philosopher {
    private final String name;
    private final Fork fork1;
    private final Fork fork2;
    private static final Random random = new Random();

    public Philosopher(String name, Fork fork1, Fork fork2) {
        this.name = name;
        this.fork1 = fork1;
        this.fork2 = fork2;
    }

    @Override
    public String toString() {
        return "Philosopher{" + "name='" + name + '}';
    }

    public void atTheTable() {
        while (true) {
            snack();
            think();
        }
    }

    public void snack() {
        synchronized (fork1) {
            synchronized (fork2) {
                eatSpaghetti(fork1, fork2);
            }
        }
    }

    public void think() {
        try {
            System.out.println(YELLOW + this + " thinks about important things... " + RESET);
            Thread.sleep(random.nextInt(50));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void eatSpaghetti(Fork fork1, Fork fork2) {
        try {
            System.out.println(this + " eats spaghetti with " + fork1 + " and " + fork2);
            Thread.sleep(random.nextInt(50));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
