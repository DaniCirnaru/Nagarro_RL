package com.nagarro.remotelearning.week1p4;

public class Main {
    public static void main(String[] args) {
        // Test the ConnectionManager class in main
        Connection conn1 = ConnectionManager.createConnection();
        Connection conn2 = ConnectionManager.createConnection();
        Connection conn3 = ConnectionManager.createConnection();
        Connection conn4 = ConnectionManager.createConnection();
        Connection conn5 = ConnectionManager.createConnection();
        Connection conn6 = ConnectionManager.createConnection(); // Will return null

        System.out.println("Connection 1: " + conn1);
        System.out.println("Connection 2: " + conn2);
        System.out.println("Connection 3: " + conn3);
        System.out.println("Connection 4: " + conn4);
        System.out.println("Connection 5: " + conn5);
        System.out.println("Connection 6: " + conn6);
    }
}
