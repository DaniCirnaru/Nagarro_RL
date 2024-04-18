package com.nagarro.remotelearning;

import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        String inputFile = "classpath:latin1.txt";
        String outputFileUTF8 = "classpath:utf8.txt";
        String outputFileLatin1 = "classpath:latin1_output.txt";

        if (!Files.exists(Paths.get(inputFile))) {
            System.out.println("Input file does not exist.");
            return;
        }

        EncodingTranscoder transcoder = new EncodingTranscoder();
        transcoder.transcodeLatin1ToUTF8(inputFile, outputFileUTF8);
        transcoder.transcodeUTF8ToLatin1(outputFileUTF8, outputFileLatin1);
    }
}
