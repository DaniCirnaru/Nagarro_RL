package com.nagarro.remotelearning;

import com.nagarro.remotelearning.exceptions.PriorityQueueEmptyException;
import com.nagarro.remotelearning.exceptions.PriorityQueueFullException;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class CustomPriorityQueueTest {
    @Test
    public void testInsert() {
        CustomPriorityQueue<Integer> priorityQueue = new CustomPriorityQueue<>();
        priorityQueue.insert(5);

        assertEquals(1, priorityQueue.getSize());
    }

    @Test(expected = PriorityQueueFullException.class)
    public void testFullPriorityQueueInsert() {
        CustomPriorityQueue<Integer> priorityQueue = new CustomPriorityQueue<>(2);
        priorityQueue.insert(5);
        priorityQueue.insert(3);
        priorityQueue.insert(7);
    }

    @Test
    public void testRemove() {
        CustomPriorityQueue<Integer> priorityQueue = new CustomPriorityQueue<>();
        priorityQueue.insert(5);
        priorityQueue.insert(7);

        assertEquals(Integer.valueOf(7), priorityQueue.remove());
        assertEquals(Integer.valueOf(5), priorityQueue.remove());

        assertEquals(0, priorityQueue.getSize());
    }

    @Test(expected = PriorityQueueEmptyException.class)
    public void testEmptyPriorityQueueRemove() {
        CustomPriorityQueue<Integer> priorityQueue = new CustomPriorityQueue<>();
        priorityQueue.remove();
    }

    @Test
    public void testClear() {
        CustomPriorityQueue<Integer> priorityQueue = new CustomPriorityQueue<>();
        priorityQueue.insert(5);

        priorityQueue.clear();

        assertEquals(0, priorityQueue.getSize());
    }

    @Test
    public void testIsEmpty() {
        CustomPriorityQueue<Integer> priorityQueue = new CustomPriorityQueue<>();
        priorityQueue.insert(5);
        priorityQueue.remove();
        assertTrue(priorityQueue.isEmpty());
    }

    @Test
    public void testHead() {
        CustomPriorityQueue<Integer> priorityQueue = new CustomPriorityQueue<>();
        priorityQueue.insert(5);
        priorityQueue.insert(7);
        priorityQueue.insert(3);
        assertEquals(Integer.valueOf(7), priorityQueue.head());
    }

    @Test
    public void testSort() {
        List<Integer> inputList = Arrays.asList(4, 2, 6, 1, 5, 3);

        CustomPriorityQueue<Integer> priorityQueue = new CustomPriorityQueue<>();
        List<Integer> sortedList = priorityQueue.sort(inputList);

        List<Integer> expectedList = Arrays.asList(1, 2, 3, 4, 5, 6);

        assertEquals(expectedList, sortedList);
    }
}

