package com.nagarro.remotelearning.week1p2;

public class Main {
    public static void main(String[] args) {
        try {
            if (args.length > 0) {
                int num = Integer.parseInt(args[0]);

                Prime primeChecker = new Prime();

                if (num > 1) {
                    for (int i = 1; i <= num; i++) {
                        if (primeChecker.isPrime(i)) {
                            System.out.println(i + "-PRIME");
                        } else {
                            System.out.println(i);
                        }
                    }
                }
            } else {
                System.out.println("Please provide an argument.");
            }
        } catch (NumberFormatException e) {
            System.out.println("The provided argument is not an integer.");
        }
    }
}
