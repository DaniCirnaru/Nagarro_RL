package com.nagarro.remotelearning.race;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.synchronizedList;

public class ThreadRaceContext {
    private int numCompetitors;
    private List<Integer> finishOrder;

    public ThreadRaceContext(int numCompetitors) {
        this.numCompetitors = numCompetitors;
        finishOrder =  synchronizedList(new ArrayList<>());
    }

    public synchronized void notifyFinish(int raceNumber) {
        finishOrder.add(raceNumber);
        if (finishOrder.size() == numCompetitors) {
            displayResults();
        }
    }

    private void displayResults() {
        System.out.println("Final Rankings:");
        for (int i = 0; i < finishOrder.size(); i++) {
            System.out.println((i + 1) + ". Competitor " + finishOrder.get(i));
        }
    }
}
