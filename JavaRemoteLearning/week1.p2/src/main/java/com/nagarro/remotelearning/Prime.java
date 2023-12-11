package com.nagarro.remotelearning;

public class Prime {
    // Function to check if a number is prime
    public  boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }


}

