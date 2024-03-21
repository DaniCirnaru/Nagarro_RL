package com.nagarro.remotelearning.race;

public class ThreadRaceCompetitor extends Thread {
    private int raceNumber;
    private ThreadRaceContext raceContext;

    public ThreadRaceCompetitor(int raceNumber, ThreadRaceContext raceContext) {
        this.raceNumber = raceNumber;
        this.raceContext = raceContext;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(+ 1000);
            raceContext.notifyFinish(raceNumber);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}



