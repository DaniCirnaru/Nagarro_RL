package com.nagarro.remotelearning.factory;

import com.nagarro.remotelearning.pojo.MyClass;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class FactoryTest extends TestCase {

    public FactoryTest(String testName) {
        super(testName);
    }

    public static Test suite() {
        return new TestSuite(FactoryTest.class);
    }

    public void testCreateMyClassInstance() {
        MyClass myClass = Factory.createMyClassInstance();
        assertEquals("MyClass", myClass.getClassName());
    }

    public void testCreateReloadedMyClassInstance() {
        MyClass myClass;
        try {
            myClass = Factory.createReloadedMyClassInstance();
            assertEquals("MySubClass", myClass.getClassName()); // Verify subclass behavior
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }

    public void testFixedCastingProblem() {
        // Test casting the reloaded class object to the old class
        MyClass myClass;
        try {
            myClass = Factory.mySubClass();
            assertEquals("MySubClass", myClass.getClassName()); // Verify subclass behavior
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }
}
