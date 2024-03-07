package com.nagarro.remotelearning;


import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class TrainTest
{
    @Test
    public void testStoreEqualTrains()
    {
        Set<Train> trainSet = new HashSet<>();

        Train train1 = new Train(123, "Passenger", 5);
        Train train2 = new Train(456, "Cargo", 10);
        Train train3 = new Train(123, "Passenger", 5);

        trainSet.add(train1);
        trainSet.add(train2);
        trainSet.add(train3);

        assertEquals(2, trainSet.size());
    }

}