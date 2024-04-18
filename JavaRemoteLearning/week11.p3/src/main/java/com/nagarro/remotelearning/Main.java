package com.nagarro.remotelearning;

public class Main {

    public static void main(String[] args) {
        DatabaseInfoPrinter printer = new DatabaseInfoPrinter();

        System.out.println("Database Name:");
        printer.printDatabaseName();

        System.out.println("\nTables and Columns:");
        printer.printTablesAndColumns();
    }
}