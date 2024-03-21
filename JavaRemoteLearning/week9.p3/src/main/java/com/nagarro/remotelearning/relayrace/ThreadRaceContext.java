package com.nagarro.remotelearning.relayrace;

import java.util.ArrayList;
import java.util.List;

public class ThreadRaceContext {
    private int totalTeams;
    private int finishedTeams;
    private List<ThreadRelayRaceTeam> teams;

    public ThreadRaceContext() {
        this.totalTeams = 0;
        this.finishedTeams = 0;
        this.teams = new ArrayList<>();
    }

    public synchronized void finishTeam(ThreadRelayRaceTeam team) {
        finishedTeams++;
        teams.add(team);
        if (finishedTeams == totalTeams) {
            notifyAll();
        }
    }

    public synchronized void setTotalTeams(int totalTeams) {
        this.totalTeams = totalTeams;
    }

    public synchronized void waitForAllTeamsToFinish() {
        while (finishedTeams < totalTeams) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void displayResults() {
        System.out.println("Race Results:");
        for (int i = 0; i < teams.size(); i++) {
            ThreadRelayRaceTeam team = teams.get(i);
            System.out.println("Position " + (i + 1) + ": " + team.getTeamName());
        }
    }
}

