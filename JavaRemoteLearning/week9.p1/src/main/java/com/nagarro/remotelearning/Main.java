package com.nagarro.remotelearning;


import com.nagarro.remotelearning.utils.LogServer;
import com.nagarro.remotelearning.utils.Node;

public class Main {
    public static void main(String[] args) {
        LogServer logServer = new LogServer();

        Node node1 = new Node(logServer);
        Node node2 = new Node(logServer);

        node1.start();
        node2.start();

        for (int i = 0; i < 40; i++) {
            String log = logServer.consumeLog();
            System.out.println("Main thread consumed log: " + log);
        }
    }
}
