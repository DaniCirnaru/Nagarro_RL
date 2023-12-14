package com.nagarro.remotelearning.week1p1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PersonProcessor {
    private static final int FIRST_NAME = 0;
    private static final int LAST_NAME = 1;
    private static final int DOB = 2;
    private static final int DOD = 3;

    public static List<Person> processPersonData(String filePath) {
        List<Person> personsList = new ArrayList<Person>();
        try {
            String[] lines = ReadFromFile.readLinesFromTextFile(filePath);

            List<String> uniquePersons = new ArrayList<String>();

            for (String line : lines) {
                if (!uniquePersons.contains(line)) {
                    uniquePersons.add(line);
                }
            }

            for (String element : uniquePersons) {
                String[] parts = element.split(",");
                if (parts.length >= 3) {
                    String firstName = parts[FIRST_NAME].trim();
                    String lastName = parts[LAST_NAME].trim();
                    String dob = parts[DOB].trim().replaceAll("^[a-zA-Z]\\.", "");// "Eliminate the prefix 'b.'"

                    if (parts.length == 4) {
                        String dod = parts[DOD].trim();
                        Person person = new Person(firstName, lastName, dob, dod);
                        personsList.add(person);
                    } else {
                        Person person = new Person(firstName, lastName, dob, "now");
                        personsList.add(person);
                    }

                }

            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file: " + e.getMessage());
        }

        return personsList;
    }

}