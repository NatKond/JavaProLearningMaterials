package org.tel.ran.homework14.CallableImp;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

public class MoneyCallableApp {

    public static final Random RANDOM = new Random();

    public static void main(String[] args) {
        Card card = new Card("Jane Doh", 500, 1000);
        int numberOfAtm = RANDOM.nextInt(3, 7);
        List<Callable<Boolean>> callableList = new ArrayList<>();

        for (int i = 0; i < numberOfAtm; i++) {
            callableList.add(new ConsumerAtm(card, RANDOM.nextInt(25, 51), RANDOM.nextInt(500, 1501)));
            callableList.add(new ProducerAtm(card, RANDOM.nextInt(25, 51), RANDOM.nextInt(500, 1501)));
        }

        ExecutorService executorService = Executors.newFixedThreadPool(numberOfAtm * 2);

        List<Future<Boolean>> futures = new ArrayList<>();

        callableList.forEach((callable) -> futures.add(executorService.submit(callable)));

        System.out.println(callableList.size());

        Boolean hasException = false;

        for (Future<Boolean> future : futures) {
            try {
                future.get();
            } catch (ExecutionException e) {
                executorService.shutdown();
                System.out.println("Task threw exception: " + e.getMessage());
            } catch (InterruptedException e) {
                System.err.println("Thread was interrupted while waiting for result.");
            }
        }
        executorService.shutdown();
    }
}
