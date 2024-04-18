package com.nagarro.remotelearning;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;

public class FileCompressionExample {

    public static void main(String[] args) {
        FileCompressionExample compressor = new FileCompressionExample();
        String sourceFilePath = "src/main/resources/input.txt";
        String compressedFilePath = "src/main/resources/compressed.gz";

        try {
            compressor.compressFile(sourceFilePath, compressedFilePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void compressFile(String sourceFilePath, String compressedFilePath) throws IOException {
        // Read the source file
        File sourceFile = new File(sourceFilePath);
        if (!sourceFile.exists()) {
            System.err.println("Source file does not exist.");
            return;
        }

        FileInputStream fis = new FileInputStream(sourceFile);
        byte[] buffer = new byte[(int) sourceFile.length()];
        fis.read(buffer);
        fis.close();

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try (GZIPOutputStream gzos = new GZIPOutputStream(baos)) {
            gzos.write(buffer);
        }

        try (FileOutputStream fos = new FileOutputStream(compressedFilePath)) {
            fos.write(baos.toByteArray());
        }

        // Display compression ratio
        double originalSize = sourceFile.length();
        double compressedSize = new File(compressedFilePath).length();
        double ratio = (compressedSize / originalSize) * 100;
        System.out.println("Compression ratio: " + String.format("%.2f", ratio) + "%");
    }
}
