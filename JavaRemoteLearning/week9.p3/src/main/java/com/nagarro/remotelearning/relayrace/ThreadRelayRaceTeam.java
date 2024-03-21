package com.nagarro.remotelearning.relayrace;

public class ThreadRelayRaceTeam extends Thread {
    private String teamName;
    private static final int NUM_COMPETITORS = 4;
    private ThreadRaceContext context;

    public ThreadRelayRaceTeam(String teamName, ThreadRaceContext context) {
        this.teamName = teamName;
        this.context = context;
    }

    @Override
    public void run() {
        for (int i = 0; i < NUM_COMPETITORS; i++) {
            ThreadCompetitor competitor = new ThreadCompetitor(i + 1, teamName, context);
            competitor.start();
            try {
                competitor.join(); // Wait for the competitor to finish
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        context.finishTeam(this);
    }

    public String getTeamName() {
        return teamName;
    }
}
