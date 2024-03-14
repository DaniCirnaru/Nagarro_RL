package com.nagarro.remotelearning.exceptions;

public class PriorityQueueEmptyException extends RuntimeException {
    public PriorityQueueEmptyException() {
        super("Priority queue is empty");
    }
}