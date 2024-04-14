package com.scytalys;

import Actions.*;

import java.util.concurrent.*;

public class Breakfast {

    public static void makeBreakfastSequential() {

        long startingTime = System.currentTimeMillis();

        ExecutorService executor = Executors.newFixedThreadPool(4);
        try {
            executor.submit(new BoilWater()).get();
            executor.submit(new MakeToast()).get();
            executor.submit(new BoilEgg()).get();
            executor.submit(new BrewCoffee()).get();
            executor.submit(new BlendSmoothie()).get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            executor.shutdown();
        }

        long endingTime = System.currentTimeMillis();

        System.out.println("Breakfast is ready!");

        System.out.println("Time elapsed = " + (endingTime - startingTime));
    }

    public static void makeBreakfastParallel() {

        long startingTime = System.currentTimeMillis();

        ExecutorService executor = Executors.newFixedThreadPool(4);
        try {
            executor.submit(new BoilWater());
            executor.submit(new MakeToast());
            executor.submit(new BoilEgg());
            executor.submit(new BrewCoffee());
            executor.submit(new BlendSmoothie());
        } finally {
            executor.shutdown();
        }

        long endingTime = System.currentTimeMillis();

        ScheduledExecutorService scheduler1 = Executors.newScheduledThreadPool(1);
        scheduler1.schedule(() -> System.out.println("Breakfast is ready!"), 3, TimeUnit.SECONDS);
        scheduler1.shutdown();

        ScheduledExecutorService scheduler2 = Executors.newScheduledThreadPool(2);
        scheduler2.schedule(() -> System.out.println("Time elapsed = " + (endingTime - startingTime) + " milliseconds"), 4, TimeUnit.SECONDS);
        scheduler2.shutdown();
    }

    public static void main(String[] args) {

        // makeBreakfastSequential();

        makeBreakfastParallel();

    }
}
