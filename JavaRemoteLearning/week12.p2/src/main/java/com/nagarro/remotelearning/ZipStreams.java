package com.nagarro.remotelearning;

import java.util.stream.Stream;

public class ZipStreams {

    public static <T> Stream<T> zip(Stream<T> first, Stream<T> second) {
        Object[] firstArray = first.toArray();
        Object[] secondArray = second.toArray();

        int size = Math.min(firstArray.length, secondArray.length);

        return Stream.iterate(0, i -> i + 1)
                .limit(size)
                .flatMap(i -> Stream.of((T) firstArray[i], (T) secondArray[i]));
    }
}

