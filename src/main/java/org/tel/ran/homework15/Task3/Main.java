package org.tel.ran.homework15.Task3;

public class Main {
    public static void main(String[] args) {
        Fork fork1 = new Fork(1);
        Fork fork2 = new Fork(2);
        Fork fork3 = new Fork(3);

        Philosopher philosopher1 = new Philosopher("Plato", fork1, fork2);
        Philosopher philosopher2 = new Philosopher("Socrates", fork2, fork3);
        Philosopher philosopher3 = new Philosopher("Aristotle", fork3, fork1);

        new Thread(philosopher1::atTheTable).start();
        new Thread(philosopher2::atTheTable).start();
        new Thread(philosopher3::atTheTable).start();
    }
}

