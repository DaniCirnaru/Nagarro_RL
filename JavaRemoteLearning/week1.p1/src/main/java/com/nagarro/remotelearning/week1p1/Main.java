package com.nagarro.remotelearning.week1p1;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        String filePath = "week1.p1/resources/data.txt"; // Relative path to the file

        // Using the processPersonData method to get the list of persons
        List<Person> persons = PersonProcessor.processPersonData(filePath);

        // Displaying the list of persons
        for (Person person : persons) {
            System.out.println(person.toString());
        }
    }
}
