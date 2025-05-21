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
        Card card = new Card("John Dow", 500, 1000);
        int numberOfATM = RANDOM.nextInt(3, 7);
        List<Runnable> runnableList = new ArrayList<>();

        for (int i = 0; i < numberOfATM; i++) {
            runnableList.add(new MoneyConsumer(card, RANDOM.nextInt(25, 51), RANDOM.nextInt(500,1501), THROWN_EXCEPTION));
            runnableList.add(new MoneyProducer(card, RANDOM.nextInt(25, 51),RANDOM.nextInt(500,1501), THROWN_EXCEPTION));
        }

        ExecutorService executorService = Executors.newFixedThreadPool(numberOfATM * 2);

        for (Runnable runnable : runnableList) {
            executorService.submit(runnable);
        }

        executorService.shutdown();
    }

}
