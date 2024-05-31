package com.nagarro.remotelearning.repository;

import com.nagarro.remotelearning.annotation.Column;
import com.nagarro.remotelearning.annotation.Table;
import com.nagarro.remotelearning.util.DatabaseUtil;
import com.nagarro.remotelearning.util.TypeConverter;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GenericRepository<T> {
    private final Connection connection;
    private final Class<T> type;

    public GenericRepository(Class<T> type) throws SQLException {
        this.connection = DatabaseUtil.getConnection();
        this.type = type;
    }

    public void save(T entity) {
        Savepoint savepoint = null;
        try {
            connection.setAutoCommit(false);
            savepoint = connection.setSavepoint("BeforeSave");

            Table tableAnnotation = type.getAnnotation(Table.class);
            String tableName = tableAnnotation.name();
            StringBuilder columns = new StringBuilder();
            StringBuilder values = new StringBuilder();
            Field[] fields = type.getDeclaredFields();
            for (Field field : fields) {
                if (field.isAnnotationPresent(Column.class)) {
                    Column column = field.getAnnotation(Column.class);
                    columns.append(column.name()).append(", ");
                    values.append("?, ");
                }
            }
            columns.setLength(columns.length() - 2);
            values.setLength(values.length() - 2);

            String sql = String.format("INSERT INTO %s (%s) VALUES (%s)", tableName, columns, values);
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                setPreparedStatementValues(statement, fields, entity);
                statement.executeUpdate();
            }

            connection.commit();
        } catch (SQLException | IllegalAccessException e) {
            if (savepoint != null) {
                try {
                    connection.rollback(savepoint);
                    connection.commit();
                    System.out.println("Transaction rolled back to savepoint.");
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            e.printStackTrace();
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public int saveAndReturnGeneratedId(T entity) {
        Savepoint savepoint = null;
        try {
            connection.setAutoCommit(false);
            savepoint = connection.setSavepoint("BeforeSave");

            Table tableAnnotation = type.getAnnotation(Table.class);
            String tableName = tableAnnotation.name();
            StringBuilder columns = new StringBuilder();
            StringBuilder values = new StringBuilder();
            Field[] fields = type.getDeclaredFields();
            for (Field field : fields) {
                if (field.isAnnotationPresent(Column.class)) {
                    Column column = field.getAnnotation(Column.class);
                    columns.append(column.name()).append(", ");
                    values.append("?, ");
                }
            }
            columns.setLength(columns.length() - 2);
            values.setLength(values.length() - 2);

            String sql = String.format("INSERT INTO %s (%s) VALUES (%s)", tableName, columns, values);
            try (PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                setPreparedStatementValues(statement, fields, entity);
                statement.executeUpdate();

                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    int generatedId = generatedKeys.getInt(1);
                    connection.commit();
                    return generatedId;
                }
            }
        } catch (SQLException | IllegalAccessException e) {
            if (savepoint != null) {
                try {
                    connection.rollback(savepoint);
                    connection.commit();
                    System.out.println("Transaction rolled back to savepoint.");
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            e.printStackTrace();
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return -1;
    }

    public T findById(int id) {
        try {
            Table tableAnnotation = type.getAnnotation(Table.class);
            String tableName = tableAnnotation.name();
            String idColumn = getIdColumn(type);
            String sql = String.format("SELECT * FROM %s WHERE %s = ?", tableName, idColumn);
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, id);
                ResultSet resultSet = statement.executeQuery();
                if (resultSet.next()) {
                    return mapRowToEntity(resultSet);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void update(T entity) {
        try {
            Table tableAnnotation = type.getAnnotation(Table.class);
            String tableName = tableAnnotation.name();
            StringBuilder setClause = new StringBuilder();
            String idColumn = getIdColumn(type);
            Field[] fields = type.getDeclaredFields();
            for (Field field : fields) {
                if (field.isAnnotationPresent(Column.class)) {
                    Column column = field.getAnnotation(Column.class);
                    if (!column.primaryKey()) {
                        setClause.append(column.name()).append(" = ?, ");
                    }
                }
            }
            setClause.setLength(setClause.length() - 2);

            String sql = String.format("UPDATE %s SET %s WHERE %s = ?", tableName, setClause, idColumn);
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                setPreparedStatementValues(statement, fields, entity);
                Field idField = getIdField(type);
                idField.setAccessible(true);
                statement.setObject(fields.length, idField.get(entity));
                statement.executeUpdate();
            }
        } catch (SQLException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        try {
            Table tableAnnotation = type.getAnnotation(Table.class);
            String tableName = tableAnnotation.name();
            String idColumn = getIdColumn(type);
            String sql = String.format("DELETE FROM %s WHERE %s = ?", tableName, idColumn);
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, id);
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void saveAll(List<T> entities) {
        if (entities == null || entities.isEmpty()) return;
        try {
            Table tableAnnotation = type.getAnnotation(Table.class);
            String tableName = tableAnnotation.name();
            StringBuilder columns = new StringBuilder();
            StringBuilder values = new StringBuilder();
            Field[] fields = type.getDeclaredFields();
            for (Field field : fields) {
                if (field.isAnnotationPresent(Column.class)) {
                    Column column = field.getAnnotation(Column.class);
                    columns.append(column.name()).append(", ");
                    values.append("?, ");
                }
            }
            columns.setLength(columns.length() - 2);
            values.setLength(values.length() - 2);

            String sql = String.format("INSERT INTO %s (%s) VALUES (%s)", tableName, columns, values);
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                for (T entity : entities) {
                    setPreparedStatementValues(statement, fields, entity);
                    statement.addBatch();
                }
                statement.executeBatch();
            }
        } catch (SQLException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public List<T> filterByField(String fieldName, Object value) {
        List<T> entities = new ArrayList<>();
        try {
            Table tableAnnotation = type.getAnnotation(Table.class);
            String tableName = tableAnnotation.name();
            String sql = String.format("SELECT * FROM %s WHERE %s = ?", tableName, fieldName);
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setObject(1, value);
                ResultSet resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    entities.add(mapRowToEntity(resultSet));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return entities;
    }

    public List<T> findPaginated(int pageNumber, int pageSize) {
        List<T> entities = new ArrayList<>();
        try {
            Table tableAnnotation = type.getAnnotation(Table.class);
            String tableName = tableAnnotation.name();
            int offset = (pageNumber - 1) * pageSize;
            String sql = String.format("SELECT * FROM %s LIMIT ? OFFSET ?", tableName);
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, pageSize);
                statement.setInt(2, offset);
                ResultSet resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    entities.add(mapRowToEntity(resultSet));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return entities;
    }

    private void setPreparedStatementValues(PreparedStatement statement, Field[] fields, T entity) throws SQLException, IllegalAccessException {
        int index = 1;
        for (Field field : fields) {
            if (field.isAnnotationPresent(Column.class)) {
                field.setAccessible(true);
                Object value = field.get(entity);
                if (value instanceof Enum) {
                    value = value.toString();
                }
                statement.setObject(index, value);
                index++;
            }
        }
    }

    private T mapRowToEntity(ResultSet resultSet) {
        try {
            T entity = type.getDeclaredConstructor().newInstance();
            Field[] fields = type.getDeclaredFields();
            for (Field field : fields) {
                if (field.isAnnotationPresent(Column.class)) {
                    Column column = field.getAnnotation(Column.class);
                    String columnName = column.name();
                    Object value = resultSet.getObject(columnName);
                    field.setAccessible(true);
                    field.set(entity, value);
                }
            }
            return entity;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private String getIdColumn(Class<T> type) {
        for (Field field : type.getDeclaredFields()) {
            if (field.isAnnotationPresent(Column.class)) {
                Column column = field.getAnnotation(Column.class);
                if (column.primaryKey()) {
                    return column.name();
                }
            }
        }
        throw new IllegalArgumentException("No primary key field found in class " + type.getName());
    }

    private Field getIdField(Class<T> type) {
        for (Field field : type.getDeclaredFields()) {
            if (field.isAnnotationPresent(Column.class)) {
                Column column = field.getAnnotation(Column.class);
                if (column.primaryKey()) {
                    return field;
                }
            }
        }
        throw new IllegalArgumentException("No primary key field found in class " + type.getName());
    }
}
