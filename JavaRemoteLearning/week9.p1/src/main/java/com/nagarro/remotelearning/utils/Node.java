package com.nagarro.remotelearning.utils;

public class Node extends Thread {
    private final LogServer server;

    public Node(LogServer server) {
        this.server = server;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            String logMessage = "Log message from Node " + Thread.currentThread().getName() + ", Message " + i;
            server.addLog(logMessage);
            System.out.println("Node " + Thread.currentThread().getName() + " generated log: " + logMessage);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
