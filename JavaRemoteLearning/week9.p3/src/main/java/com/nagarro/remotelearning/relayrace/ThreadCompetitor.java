package com.nagarro.remotelearning.relayrace;

public class ThreadCompetitor extends Thread {
    private int threadNumber;
    private String teamName;
    private ThreadRaceContext context;

    public ThreadCompetitor(int threadNumber, String teamName, ThreadRaceContext context) {
        this.threadNumber = threadNumber;
        this.teamName = teamName;
        this.context = context;
    }

    @Override
    public void run() {
        System.out.println("Thread " + threadNumber + " from " + teamName + " is running...");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Thread " + threadNumber + " from " + teamName + " finished!");
    }
}