package org.tel.ran.homework14;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;

public class MoneyApp {

    public static final Random RANDOM = new Random();

    public static final AtomicBoolean THROWN_EXCEPTION = new AtomicBoolean(false);

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        Card card = new Card("John Dow", 500, 1000);

        List<Runnable> runnables = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            runnables.add(new MoneyConsumer(card, RANDOM.nextInt(25, 51), THROWN_EXCEPTION));
            runnables.add(new MoneyProducer(card, RANDOM.nextInt(25, 51), THROWN_EXCEPTION));
        }

        for (Runnable runnable : runnables) {
            executorService.submit(runnable);
        }


        while (true) {
            if (THROWN_EXCEPTION.get()) {
                executorService.shutdownNow();
                return;
            }
        }
    }

}
