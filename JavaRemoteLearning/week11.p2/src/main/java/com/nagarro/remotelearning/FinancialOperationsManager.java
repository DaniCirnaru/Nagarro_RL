package com.nagarro.remotelearning;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FinancialOperationsManager {

    private Connection connection;

    public FinancialOperationsManager(Connection connection) {
        this.connection = connection;
    }

    public void recordFinancialOperation(double amount, String description, String username) throws SQLException {
        String getUserIDQuery = "SELECT id, balance FROM `user` WHERE `username` = ?";
        String updateBalanceQuery = "UPDATE `user` SET `balance` = ? WHERE `id` = ?";
        String insertOperationQuery = "INSERT INTO `operation` (`amount`, `description`, `user_id`) VALUES (?, ?, ?)";

        try (
                PreparedStatement getUserIDStatement = connection.prepareStatement(getUserIDQuery);
                PreparedStatement updateBalanceStatement = connection.prepareStatement(updateBalanceQuery);
                PreparedStatement insertOperationStatement = connection.prepareStatement(insertOperationQuery)
        ) {

            getUserIDStatement.setString(1, username);
            ResultSet resultSet = getUserIDStatement.executeQuery();

            if (resultSet.next()) {
                long userId = resultSet.getLong("id");
                double currentBalance = resultSet.getDouble("balance");

                updateUserBalance(amount, updateBalanceStatement, userId, currentBalance);


                recordOperation(amount,description, insertOperationStatement, userId);

                System.out.println("Financial operation recorded successfully.");
            } else {
                System.out.println("User not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
    }

    private static void recordOperation(double amount,String description, PreparedStatement insertOperationStatement, long userId) throws SQLException {
        insertOperationStatement.setDouble(1, amount);
        insertOperationStatement.setString(2, description);
        insertOperationStatement.setLong(3, userId);
        insertOperationStatement.executeUpdate();
    }

    private static void updateUserBalance(double amount, PreparedStatement updateBalanceStatement, long userId, double currentBalance) throws SQLException {
        double newBalance = currentBalance + amount;
        updateBalanceStatement.setDouble(1, newBalance);
        updateBalanceStatement.setLong(2, userId);
        updateBalanceStatement.executeUpdate();
    }
}


