package com.nagarro.remotelearning;


import org.junit.Test;

import java.io.File;

import static org.junit.Assert.assertTrue;


public class SubdirectoryFinderTest {

    @Test
    public void testFindSubdirectoriesLambda() {
        File directory = new File("C:\\Games");
        File[] subdirectories = SubdirectoryFinder.findSubdirectoriesLambda(directory);
        for (File subdirectory : subdirectories) {
            assertTrue(subdirectory.getAbsolutePath().startsWith(directory.getAbsolutePath() + File.separator));
        }
    }

    @Test
    public void testFindSubdirectoriesMethodRef() {
        File directory = new File("C:\\Games");
        File[] subdirectories = SubdirectoryFinder.findSubdirectoriesMethodRef(directory);
        for (File subdirectory : subdirectories) {
            assertTrue(subdirectory.getAbsolutePath().startsWith(directory.getAbsolutePath() + File.separator));
        }
    }
}