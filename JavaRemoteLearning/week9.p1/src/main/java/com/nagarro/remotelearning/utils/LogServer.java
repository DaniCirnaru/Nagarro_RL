package com.nagarro.remotelearning.utils;

import java.util.LinkedList;
import java.util.Queue;

public class LogServer {
    private final Queue<String> logQueue = new LinkedList<>();
    private final int MAX_QUEUE_SIZE = 10;

    public synchronized void addLog(String log) {
        while (logQueue.size() >= MAX_QUEUE_SIZE) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        logQueue.add(log);
        notifyAll();
    }

    public synchronized String consumeLog() {
        while (logQueue.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        String log = logQueue.poll();
        notifyAll();
        return log;
    }
}
