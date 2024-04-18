package com.nagarro.remotelearning;

import java.util.concurrent.locks.ReentrantLock;

public class LockHelper {

    public static void withLock(ReentrantLock lock, Runnable action) {
        lock.lock();
        try {
            action.run();
        } finally {
            lock.unlock();
        }
    }


    public static void main(String[] args) {
        ReentrantLock myLock = new ReentrantLock();

        withLock(myLock, () -> {

            System.out.println("Action  inside lock");
        });
    }
}
