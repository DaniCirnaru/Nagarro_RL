package com.nagarro.remotelearning;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class FinancialReport {

    private static final String URL = "jdbc:mysql://localhost:3306/week11_1";
    private static final String USER = "root";
    private static final String PASSWORD = "dani1234";

    public void listAllClients(Connection connection) throws SQLException {
        String query = "SELECT name FROM user";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            System.out.println("List of all clients:");
            while (resultSet.next()) {
                System.out.println("Name: " + resultSet.getString("name"));
            }
        }
    }


    public void retrieveBalanceByUsername(Connection connection, String username) throws SQLException {
        String query = "SELECT balance FROM user WHERE username = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, username);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    double balance = resultSet.getDouble("balance");
                    System.out.println("Balance of client " + username + ": " + balance);
                } else {
                    System.out.println("Client with username " + username + " not found.");
                }
            }
        }
    }

    public void clientsWithHighBalance(Connection connection) throws SQLException {
        String query = "SELECT * FROM user WHERE balance > 100000";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            System.out.println("List of clients with balance over 100,000:");
            while (resultSet.next()) {
                System.out.println("ID: " + resultSet.getLong("id") +
                        ", Name: " + resultSet.getString("name") +
                        ", Username: " + resultSet.getString("username") +
                        ", Balance: " + resultSet.getDouble("balance"));
            }
        }
    }
}

