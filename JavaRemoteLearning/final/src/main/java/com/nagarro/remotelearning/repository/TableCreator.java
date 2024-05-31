package com.nagarro.remotelearning.repository;

import com.nagarro.remotelearning.annotation.Column;
import com.nagarro.remotelearning.annotation.ForeignKey;
import com.nagarro.remotelearning.annotation.JoinColumn;
import com.nagarro.remotelearning.annotation.Table;
import com.nagarro.remotelearning.model.Address;
import com.nagarro.remotelearning.util.ClassFinder;
import com.nagarro.remotelearning.util.TypeConverter;

import java.io.IOException;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class TableCreator {
    private final Connection connection;

    public TableCreator(Connection connection) {
        this.connection = connection;
    }

    public void createTables(String packageName) {
        try {
            List<Class<?>> classes = ClassFinder.find(packageName);
            for (Class<?> clazz : classes) {
                if (clazz.isAnnotationPresent(Table.class)) {
                    createTable(clazz);
                } else {
                    System.out.println("Class " + clazz.getName() + " does not have @Table annotation.");
                }
            }
            for (Class<?> clazz : classes) {
                if (clazz.isAnnotationPresent(Table.class)) {
                    addForeignKeys(clazz);
                }
            }
        } catch (ClassNotFoundException | IOException e) {
            System.err.println("An error occurred while finding classes: " + e.getMessage());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void createTable(Class<?> clazz) throws SQLException {
        Table tableAnnotation = clazz.getAnnotation(Table.class);
        String tableName = tableAnnotation.name();
        StringBuilder sb = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
        sb.append(tableName).append(" (");

        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(Column.class)) {
                addColumnDefinition(sb, field);
            }
        }
        sb.setLength(sb.length() - 2);
        sb.append(");");
        executeUpdate(sb.toString());
        System.out.println("Table " + tableName + " created successfully.");
    }

    private void addColumnDefinition(StringBuilder sb, Field field) {
        Column columnAnnotation = field.getAnnotation(Column.class);
        if (columnAnnotation != null) {
            String columnName = columnAnnotation.name();
            String columnType = TypeConverter.javaTypeToSqlType(field.getType());
            boolean isPrimaryKey = columnAnnotation.primaryKey();
            boolean isAutoIncrement = columnAnnotation.autoIncrement();

            sb.append(columnName).append(" ").append(columnType);

            if (isPrimaryKey) {
                sb.append(" PRIMARY KEY");
            }
            if (isAutoIncrement) {
                sb.append(" AUTO_INCREMENT");
            }
            sb.append(", ");
        } else {
            throw new IllegalArgumentException("Column annotation not found for field: " + field.getName());
        }
    }

    private void addForeignKeys(Class<?> clazz) throws SQLException {
        Table tableAnnotation = clazz.getAnnotation(Table.class);
        String tableName = tableAnnotation.name();

        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(ForeignKey.class) && field.isAnnotationPresent(JoinColumn.class)) {
                addForeignKey(tableName, field);
            }
        }
    }

    private void addForeignKey(String tableName, Field field) throws SQLException {
        ForeignKey foreignKey = field.getAnnotation(ForeignKey.class);
        String columnName = field.getAnnotation(JoinColumn.class).name();
        String referencedTable = foreignKey.referencedTable();
        String referencedColumnName = foreignKey.referencedColumnName();

        String constraintName = "fk_" + columnName;

        StringBuilder sb = new StringBuilder("ALTER TABLE ");
        sb.append(tableName).append(" ADD CONSTRAINT ").append(constraintName)
                .append(" FOREIGN KEY (").append(columnName).append(") REFERENCES ")
                .append(referencedTable).append("(").append(referencedColumnName).append(");");

        if (!checkForeignKeyConstraintExists(tableName, constraintName)) {
            executeUpdate(sb.toString());
            System.out.println("Foreign key added to " + tableName + " referencing " + referencedTable);
        } else {
            System.out.println("Foreign key constraint " + constraintName + " already exists in table " + tableName);
        }
    }

    private boolean checkForeignKeyConstraintExists(String tableName, String constraintName) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            String query = "SELECT COUNT(*) AS count FROM information_schema.TABLE_CONSTRAINTS " +
                    "WHERE TABLE_NAME = '" + tableName + "' " +
                    "AND CONSTRAINT_NAME = '" + constraintName + "' " +
                    "AND CONSTRAINT_TYPE = 'FOREIGN KEY';";

            ResultSet resultSet = statement.executeQuery(query);
            if (resultSet.next()) {
                int count = resultSet.getInt("count");
                return count > 0;
            }
        }
        return false;
    }

    private void executeUpdate(String sql) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate(sql);
        }
    }
}
