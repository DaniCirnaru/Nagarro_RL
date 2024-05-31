package com.nagarro.remotelearning.util;

import com.nagarro.remotelearning.model.Address;
import com.nagarro.remotelearning.model.Sex;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class TypeConverter {
    private static final Map<Class<?>, String> javaToSqlTypeMap = new HashMap<>();

    static {
        javaToSqlTypeMap.put(int.class, "INT");
        javaToSqlTypeMap.put(Integer.class, "INT");
        javaToSqlTypeMap.put(String.class, "VARCHAR(255)");
        javaToSqlTypeMap.put(LocalDate.class, "DATE");
        javaToSqlTypeMap.put(Sex.class, "VARCHAR(255)");
        javaToSqlTypeMap.put(Address.class, "INT"); // Assuming Address has ID as primary key
    }

    public static String javaTypeToSqlType(Class<?> javaType) {
        String sqlType = javaToSqlTypeMap.get(javaType);
        if (sqlType == null) {
            throw new IllegalArgumentException("Unsupported Java type: " + javaType.getName());
        }
        return sqlType;
    }
}

