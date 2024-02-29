package com.nagarro.remotelearning.classloader;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class SimpleClassLoader extends ClassLoader {

    private final String classFilePath;

    public SimpleClassLoader(String classFilePath) {
        this.classFilePath = classFilePath;
    }

    @Override
    public Class<?> findClass(String className) throws ClassNotFoundException {
        byte[] classBytes = loadClassFromFile(classFilePath);
        return defineClass(className, classBytes, 0, classBytes.length);
    }

    private byte[] loadClassFromFile(String filePath) throws ClassNotFoundException {

        ByteArrayOutputStream bos;
        try {
            InputStream resourceAsStream = SimpleClassLoader.getSystemClassLoader().getResourceAsStream(filePath);

            bos = new ByteArrayOutputStream();
            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = resourceAsStream.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }
            return bos.toByteArray();
        } catch (IOException e) {
            throw new ClassNotFoundException("Error loading class from file", e);
        }

    }
}