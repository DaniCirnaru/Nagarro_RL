package com.nagarro.remotelearning;


public class App 
{
    public static void main(String[] args) {
        // Test the ConnectionManager class in main
        Connection conn1 = ConnectionManager.getConnection();
        Connection conn2 = ConnectionManager.getConnection();
        Connection conn3 = ConnectionManager.getConnection();
        Connection conn4 = ConnectionManager.getConnection();
        Connection conn5 = ConnectionManager.getConnection();
        Connection conn6 = ConnectionManager.getConnection(); // Will return null


        System.out.println("Connection 1: " + conn1);
        System.out.println("Connection 2: " + conn2);
        System.out.println("Connection 3: " + conn3);
        System.out.println("Connection 4: " + conn4);
        System.out.println("Connection 5: " + conn5);
        System.out.println("Connection 6: " + conn6);
    }
}
