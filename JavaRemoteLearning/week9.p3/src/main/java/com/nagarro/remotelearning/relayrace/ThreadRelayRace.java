package com.nagarro.remotelearning.relayrace;

import java.util.ArrayList;
import java.util.List;

public class ThreadRelayRace {
    public static void main(String[] args) {
        // Create and start the teams
        ThreadRaceContext context = new ThreadRaceContext();
        List<ThreadRelayRaceTeam> teams = createTeams(context);
        context.setTotalTeams(teams.size()); // Set the total number of teams
        startTeams(teams);
        context.waitForAllTeamsToFinish(); // Wait for all teams to finish before displaying results
        context.displayResults(); // Display the results
    }

    private static List<ThreadRelayRaceTeam> createTeams(ThreadRaceContext context) {
        List<ThreadRelayRaceTeam> teams = new ArrayList<>();
        // Create and add teams to the list
        // For simplicity, let's create 10 teams with 4 competitors each
        for (int i = 0; i < 10; i++) {
            teams.add(new ThreadRelayRaceTeam("Team " + (i + 1), context));
        }
        return teams;
    }

    private static void startTeams(List<ThreadRelayRaceTeam> teams) {
        // Start each team
        for (ThreadRelayRaceTeam team : teams) {
            team.start();
        }
    }
}