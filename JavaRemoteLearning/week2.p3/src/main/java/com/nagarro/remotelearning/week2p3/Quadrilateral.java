package com.nagarro.remotelearning.week2p3;

public class Quadrilateral {
    //Static block
    static {
        System.out.println("Quad Static block is initialized");
    }

    //Fields
    private int sides = getSides();

    //Constructor
    public Quadrilateral() {
        System.out.println("Quad Constructor is called");
    }

    // Method with local variable
    public void quadMethod() {
        int localVar1 = 10;
        System.out.println("Quad Local variable initialized");
    }

    //Getter for field1
    public int getSides() {
        System.out.println("Quad Field1 is initialized");
        return 4;
    }

}
