package com.nagarro.remotelearning;

import org.junit.Test;

import java.io.IOException;
import java.io.RandomAccessFile;

import static org.junit.Assert.assertEquals;

public class RandomAccessFileTest {

    @Test
    public void testWriteIntegersToFile() throws IOException {
        String filename = "testIntegers.txt";

        RandomAccessFileExample example = new RandomAccessFileExample(filename);
        example.writeIntegersToFile();

        try (RandomAccessFile file = new RandomAccessFile(filename, "r")) {
            assertEquals(10, file.readInt());
            assertEquals(20, file.readInt());
            assertEquals(30, file.readInt());
            assertEquals(40, file.readInt());
        }
    }

    @Test
    public void testReadThirdAndFourthIntegerFromFile() {
        String filename = "testIntegers.txt";

        RandomAccessFileExample example = new RandomAccessFileExample(filename);
        int[] integers = example.readThirdAndFourthIntegerFromFile();

        assertEquals(30, integers[0]);
        assertEquals(40, integers[1]);
    }
}