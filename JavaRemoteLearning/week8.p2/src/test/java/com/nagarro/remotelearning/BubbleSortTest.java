package com.nagarro.remotelearning;


import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class BubbleSortTest {

    @Test
    public void testBubbleSort() {
        BubbleSort bubbleSort = new BubbleSort();

        List<Integer> list = new ArrayList<>(Arrays.asList(5, 3, 8, 1, 2));

        bubbleSort.bubbleSort(list);

        List<Integer> expected = Arrays.asList(1, 2, 3, 5, 8);

        assertEquals(expected, list);
    }
}

