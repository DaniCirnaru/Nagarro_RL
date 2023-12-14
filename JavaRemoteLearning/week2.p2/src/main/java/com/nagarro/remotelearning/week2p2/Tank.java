package com.nagarro.remotelearning.week2p2;

public class Tank {
    private final int capacity;
    private int volume;

    public Tank(int capacity) {
        this.capacity = capacity;
        this.volume = 0;
    }

    public void fill(int amount) {
        if (volume + amount <= capacity) {
            volume += amount;
            System.out.println("Tank filled with " + amount + " units");
        } else {
            System.out.println("Tank cannot hold this much!");
        }
    }

    public void empty(int amount) {
        if (volume >= amount) {
            volume -= amount;
            System.out.println("Tank emptied by " + amount + " units");
        } else {
            System.out.println("Not enough liquid in the tank!");
        }
    }

    @Override
    protected void finalize() {
        if (volume == 0) {
            System.out.println("Tank is empty. Clean up successful.");
            try {
                super.finalize();
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }// Normally, you’ll also do this:
            // super.finalize(); // Call the base-class version
        } else {
            System.out.println("Error: Tank not empty during cleanup!");
        }
    }
}

