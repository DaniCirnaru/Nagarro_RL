package com.nagarro.remotelearning;

public class ConnectionManager {
    private static final int MAX_INDEX = 5; //fixed index
    private static Connection[] connections = new Connection[MAX_INDEX];
    private static int currentIndex = 0;

    private ConnectionManager() {
        // Prevent explicit instantiation outside this class by using a private constructor
    }

    public static Connection getConnection() {
        //If the ConnectionManager runs out of objects,
        if (currentIndex < MAX_INDEX) {
            Connection newConnection = new Connection();
            connections[currentIndex] = newConnection;
            currentIndex++;
            return newConnection;
        } else {
            return null;//Returning null reference
        }
    }
}