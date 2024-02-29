package com.nagarro.remotelearning.factory;

import com.nagarro.remotelearning.classloader.SimpleClassLoader;
import com.nagarro.remotelearning.pojo.MyClass;

public class Factory {
    private static final String CLASS_FILE_PATH = "MyClass.class";
    private static final String Sub_CLASS_FILE_PATH = "MySubClass.class";
    public static MyClass createMyClassInstance() {
        return new MyClass();
    }

    public static MyClass createReloadedMyClassInstance() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        SimpleClassLoader classLoader = new SimpleClassLoader(CLASS_FILE_PATH);
        Class<?> clazz = classLoader.findClass("com.nagarro.remotelearning.pojo.MyClass");
        return (MyClass) clazz.newInstance();
    }
    public static MyClass mySubClass() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        SimpleClassLoader classLoader = new SimpleClassLoader(Sub_CLASS_FILE_PATH);
        Class<?> clazz = classLoader.findClass("com.nagarro.remotelearning.pojo.MySubClass");
        return (MyClass) clazz.newInstance();
    }
}
