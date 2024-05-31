package com.nagarro.remotelearning.util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ClassFinder {
    public static List<Class<?>> find(String packageName) throws ClassNotFoundException, IOException {
        String path = packageName.replace('.', '/');
        File directory = new File(Thread.currentThread().getContextClassLoader().getResource(path).getFile());
        List<Class<?>> classes = new ArrayList<>();
        if (directory.exists()) {
            String[] files = directory.list();
            for (String file : files) {
                if (file.endsWith(".class")) {
                    String className = packageName + '.' + file.substring(0, file.length() - 6);
                    classes.add(Class.forName(className));
                }
            }
        }
        return classes;
    }
}
