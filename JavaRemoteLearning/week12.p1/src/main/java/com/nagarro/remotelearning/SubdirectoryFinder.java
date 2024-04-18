package com.nagarro.remotelearning;

import java.io.File;


public class SubdirectoryFinder {


    public static File[] findSubdirectoriesLambda(File directory) {
        return directory.listFiles(file -> file.isDirectory());
    }


    public static File[] findSubdirectoriesMethodRef(File directory) {
        return directory.listFiles(File::isDirectory);
    }
}
