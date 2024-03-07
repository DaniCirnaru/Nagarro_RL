package com.nagarro.remotelearning;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Map<Train, List<Integer>> trainSchedule = new HashMap<>();

        Random random = new Random();

        for (int i = 0; i < 10000; i++) {
            int trainNumber = random.nextInt(1000);
            String trainType = random.nextBoolean() ? "Passenger" : "Cargo";
            int numberOfWagons = random.nextInt(20) + 1;

            Train train = new Train(trainNumber, trainType, numberOfWagons);

            List<Integer> runningDays = generateRunningDays(random);
            trainSchedule.put(train, runningDays);
        }
        testPerformance(trainSchedule, random);

    }

    private static List<Integer> generateRunningDays(Random random) {
        List<Integer> runningDays = new ArrayList<>();
        int numRunningDays = random.nextInt(365) + 1;
        for (int i = 0; i < numRunningDays; i++) {
            runningDays.add(random.nextInt(365) + 1);
        }
        return runningDays;
    }
    private static void testPerformance(Map<Train, List<Integer>> trainSchedule, Random random) {
        int numTests = 1000;
        long totalTime = 0;

        for (int i = 0; i < numTests; i++) {
            Train randomTrain = getRandomTrain(trainSchedule, random);

            long startTime = System.nanoTime();
            trainSchedule.get(randomTrain);
            long endTime = System.nanoTime();

            long duration = endTime - startTime;
            totalTime += duration;
        }

        long averageTime = totalTime / numTests;
        System.out.println("Average time taken for retrieval: " + averageTime + " nanoseconds");
    }


    private static Train getRandomTrain(Map<Train, List<Integer>> trainSchedule, Random random) {
        int randomIndex = random.nextInt(trainSchedule.size());
        return trainSchedule.keySet().toArray(new Train[0])[randomIndex];
    }
}
