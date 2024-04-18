package com.nagarro.remotelearning;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

public class ZipStreamsTest {

    @Test
    public void testZipWhenSecondStreamIsShorter() {
        Stream<String> first = Stream.of("a", "b", "c");
        Stream<String> second = Stream.of("1", "2");

        List<String> zipped = ZipStreams.zip(first, second).collect(Collectors.toList());

        assertEquals(Arrays.asList("a", "1", "b", "2"), zipped);
    }

    @Test
    public void testZipWhenFirstStreamIsShorter() {
        Stream<String> first = Stream.of("a", "b");
        Stream<String> second = Stream.of("1", "2", "3");

        List<String> zipped = ZipStreams.zip(first, second).collect(Collectors.toList());

        assertEquals(Arrays.asList("a", "1", "b", "2"), zipped);
    }

}

