package com.nagarro.remotelearning.week2p3;

public class Rectangle extends Quadrilateral {
    //Static block
    static {
        System.out.println("Rectangular Static block is initialized");
    }

    //Fields
    private int field2 = getField2();

    //Constructor
    public Rectangle() {
        System.out.println("Rectangular Constructor is called");
    }

    // Method with local variable
    public void rectangularMethod() {
        int localVar1 = 10;
        System.out.println("Rectangular Local variable initialized");
    }

    //Getter for field1
    public int getField2() {
        System.out.println("Rectangular Field1 is initialized");
        return 2;
    }
}
