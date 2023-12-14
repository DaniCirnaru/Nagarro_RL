package com.nagarro.remotelearning.week1p4;

public class ConnectionManager {
    private static final int MAX_CONNECTIONS = 5;
    private static int connectionCounter = 0;
    private static Connection[] connections = new Connection[MAX_CONNECTIONS];

    public static Connection createConnection() {
        if (connectionCounter < MAX_CONNECTIONS) {
            connections[connectionCounter] = Connection.createNewConnection();
            return connections[connectionCounter++];
        } else {
            System.out.println("ConnectionManager has reached the maximum number of connections.");
            return null;
        }
    }
}