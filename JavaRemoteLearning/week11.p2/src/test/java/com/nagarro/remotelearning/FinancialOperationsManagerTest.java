package com.nagarro.remotelearning;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class FinancialOperationsManagerTest {

    private Connection connection;

    @Before
    public void setUp() throws Exception {
        String url = "jdbc:mysql://localhost:3306/week11_1";
        String user = "root";
        String password = "dani1234";
        connection = DriverManager.getConnection(url, user, password);
    }

    @After
    public void tearDown() throws Exception {
        if (connection != null) {
            connection.close();
        }
    }

    @Test
    public void testRecordFinancialOperation_PositiveAmount() throws SQLException {
        FinancialOperationsManager manager = new FinancialOperationsManager(connection);
        double initialBalance = getCurrentBalance("ipopescu");

        manager.recordFinancialOperation(1000, "Test operation", "ipopescu");

        double finalBalance = getCurrentBalance("ipopescu");
        assertEquals(initialBalance + 1000, finalBalance, 0.001);
    }

    @Test
    public void testRecordFinancialOperation_NegativeAmount() throws SQLException {
        FinancialOperationsManager manager = new FinancialOperationsManager(connection);
        double initialBalance = getCurrentBalance("ipopescu");

        manager.recordFinancialOperation(-500, "Test operation", "ipopescu");

        double finalBalance = getCurrentBalance("ipopescu");
        assertEquals(initialBalance - 500, finalBalance, 0.001);
    }

    // Helper method to retrieve current balance of a user
    private double getCurrentBalance(String username) throws SQLException {
        String query = "SELECT balance FROM `user` WHERE `username` = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, username);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getDouble("balance");
            } else {
                throw new SQLException("User not found");
            }
        }
    }


}
