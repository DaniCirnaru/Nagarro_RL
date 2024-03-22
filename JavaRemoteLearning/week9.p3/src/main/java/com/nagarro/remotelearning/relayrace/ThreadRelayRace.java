package com.nagarro.remotelearning.relayrace;

import java.util.ArrayList;
import java.util.List;

public class ThreadRelayRace {
    public static void main(String[] args) {

        startRace();
    }

    private static void startRace() {
        ThreadRaceContext context = new ThreadRaceContext();
        List<ThreadRelayRaceTeam> teams = createTeams(context);
        context.setTotalTeams(teams.size());
        startTeams(teams);
        context.waitForAllTeamsToFinish();
        context.displayResults();
    }

    private static List<ThreadRelayRaceTeam> createTeams(ThreadRaceContext context) {
        List<ThreadRelayRaceTeam> teams = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            teams.add(new ThreadRelayRaceTeam("Team " + (i + 1), context));
        }
        return teams;
    }

    private static void startTeams(List<ThreadRelayRaceTeam> teams) {
        for (ThreadRelayRaceTeam team : teams) {
            team.start();
        }
    }
}
