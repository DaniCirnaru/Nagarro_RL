package com.nagarro.remotelearning;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseInfoPrinter {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/week11_1";
    private static final String USER = "root";
    private static final String PASS = "dani1234";

    public void printDatabaseName() {
        String url = "jdbc:mysql://localhost:3306/week11_1";
        String user = "root";
        String password = "dani1234";

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String databaseName = connection.getCatalog(); // Use getCatalog() to get the current database name
            System.out.println("Database Name: " + databaseName);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void printTablesAndColumns() {
        String url = "jdbc:mysql://localhost:3306/week11_1";
        String user = "root";
        String password = "dani1234";

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String databaseName = connection.getCatalog(); // Get the current database name
            DatabaseMetaData metaData = connection.getMetaData();
            try (ResultSet tables = metaData.getTables(databaseName, null, null, new String[]{"TABLE"})) {
                while (tables.next()) {
                    String tableName = tables.getString("TABLE_NAME");
                    System.out.println("\nTable: " + tableName);
                    System.out.println("Columns:");
                    try (ResultSet columns = metaData.getColumns(databaseName, null, tableName, null)) {
                        while (columns.next()) {
                            String columnName = columns.getString("COLUMN_NAME");
                            String columnType = columns.getString("TYPE_NAME");
                            System.out.println(columnName + " (" + columnType + ")");
                        }
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
