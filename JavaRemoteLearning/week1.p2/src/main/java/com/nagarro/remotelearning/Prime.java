package com.nagarro.remotelearning;

public class Prime {
    // Function to check if a number is prime
    private static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        if (n > 1) {
            for (int i = 1; i <= n; i++) {
                if (isPrime(i)) {
                    System.out.println(i + "-PRIME");
                } else {
                    System.out.println(i);
                }
            }
        }

    }
}

