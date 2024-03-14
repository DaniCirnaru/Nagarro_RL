package com.nagarro.remotelearning.exceptions;

public class PriorityQueueFullException extends RuntimeException {
    public PriorityQueueFullException() {
        super("Priority queue is full");
    }
}