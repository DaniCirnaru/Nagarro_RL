package com.nagarro.remotelearning;


import com.nagarro.remotelearning.race.ThreadRaceCompetitor;
import com.nagarro.remotelearning.race.ThreadRaceContext;

public class ThreadRace {
    public static void main(String[] args) {
        final int numCompetitors = 10;
        ThreadRaceContext raceContext = new ThreadRaceContext(numCompetitors);
        ThreadRaceCompetitor[] competitors = new ThreadRaceCompetitor[numCompetitors];

        for (int i = 0; i < numCompetitors; i++) {
            competitors[i] = new ThreadRaceCompetitor(i + 1, raceContext);
            competitors[i].start();
        }
    }
}
