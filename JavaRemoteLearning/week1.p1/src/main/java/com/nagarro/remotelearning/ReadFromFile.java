package com.nagarro.remotelearning;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ReadFromFile {

    public static String[] readLinesFromTextFile(String file) throws IOException {
        String[] result = new String[0];
        DataInputStream inputStream = new DataInputStream(new FileInputStream(file));
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String strLine = null;
        try {
            while ((strLine = bufferedReader.readLine()) != null) {
                result = addLineToArray(result, strLine);
            }
        } finally {
            inputStream.close();
        }
        return result;
    }

    private static String[] addLineToArray(String[] input, String line) {
        String[] result = new String[input.length + 1];
        System.arraycopy(input, 0, result, 0, input.length);
        result[input.length] = line;
        return result;
    }
    public static void main(String[] args) {
        String filePath = "";

        try {
            //Read from file
            String[] lines = ReadFromFile.readLinesFromTextFile(filePath);

            //Filter out duplicated elements
            List<String> persons = new ArrayList<String>();

            for (int i = 0; i < lines.length ; i++) {
                if(!persons.contains(lines[i])){
                    persons.add(lines[i]);
                }
            }
            //Desired Format
            for(String element : persons){
                String[] parts = element.split(",");
                if (parts.length >= 3) {
                    String firstName = parts[0].trim();
                    String lastName = parts[1].trim();
                    String dob = parts[2].trim();
                    String dod = "now";
                    if(parts.length ==4)
                        dod=parts[3].trim();


                    String formatted = firstName + " " + lastName + " (" + dob + "-" + dod + ")";
                    System.out.println(formatted);
                }
            }

        } catch (IOException e) {
            System.out.println("An error occurred while reading the file: " + e.getMessage());
        }
    }

}
