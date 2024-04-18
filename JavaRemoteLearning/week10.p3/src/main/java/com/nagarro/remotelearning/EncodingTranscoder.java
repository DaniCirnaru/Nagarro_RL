package com.nagarro.remotelearning;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Objects;

public class EncodingTranscoder {

    public void transcodeLatin1ToUTF8(String inputFile, String outputFile) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(Objects.requireNonNull(EncodingTranscoder.class.getClassLoader().getResourceAsStream(inputFile)), "ISO-8859-1"));
             BufferedWriter writer = Files.newBufferedWriter(Paths.get(outputFile), StandardCharsets.UTF_8)) {

            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line);
                writer.newLine();
            }
            System.out.println("Latin1 to UTF-8 transcoding complete.");



        }}
    }

    public void transcodeUTF8ToLatin1(String inputFile, String outputFile) {
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(inputFile), StandardCharsets.UTF_8);
             BufferedWriter writer = Files.newBufferedWriter(Paths.get(outputFile), StandardCharsets.ISO_8859_1)) {

            transcodeAllLines(reader, writer);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void transcodeAllLines(BufferedReader reader, BufferedWriter writer) throws IOException {
        String line;
        while ((line = reader.readLine()) != null) {
            writeLine(writer, line);
        }
        System.out.println("UTF-8 to Latin1 transcoding complete.");
    }

    private void writeLine(BufferedWriter writer, String line) {
        try {
            writer.write(line);
            writer.newLine();
        } catch (IOException e) {
            printC(line);
        }
    }

    private void printC(String line) {
        System.out.println("Cannot transcode the following characters to Latin1:");
        for (char c : line.toCharArray()) {
            if (!canEncodeLatin1(c)) {
                System.out.println(c);
            }
        }
    }

    private boolean canEncodeLatin1(char c) {
        return c < 256; // Latin1 range
    }

}
