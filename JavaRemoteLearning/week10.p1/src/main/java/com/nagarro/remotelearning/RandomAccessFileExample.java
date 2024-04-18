package com.nagarro.remotelearning;

import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileExample {
    private final String filename;

    public RandomAccessFileExample(String filename) {
        this.filename = filename;
    }

    public void writeIntegersToFile() {
        try (RandomAccessFile file = new RandomAccessFile(filename, "rw")) {
            file.writeInt(10);
            file.writeInt(20);
            file.writeInt(30);
            file.writeInt(40);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int[] readThirdAndFourthIntegerFromFile() {
        int[] integers = new int[2];
        try (RandomAccessFile file = new RandomAccessFile(filename, "r")) {

            file.seek(2 * 4);
            integers[0] = file.readInt();

            file.seek(3 * 4);
            integers[1] = file.readInt();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return integers;
    }
}

