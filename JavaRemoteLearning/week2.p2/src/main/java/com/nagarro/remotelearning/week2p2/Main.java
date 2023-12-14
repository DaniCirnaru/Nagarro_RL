package com.nagarro.remotelearning.week2p2;

public class Main {
    public static void main(String[] args) {
        Tank tank = new Tank(100); // Creating a tank with a capacity of 100 units
        tank.fill(80);
        // Testing finalize method - Uncomment to test
        //System.gc(); // This might trigger the garbage collection and finalize method
        tank.finalize();
        tank.fill(80); // Trying to fill more than the tank's capacity
        tank.empty(40); // Trying to empty more than the current volume

    }
}
