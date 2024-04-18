package com.nagarro.remotelearning;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PersonStreamTest {
    private PersonStream personStream;
    private ByteArrayOutputStream outContent;

    @BeforeEach
    public void setUp() {
        List<String> persons = Arrays.asList("18:Maria", "18:Marioara", "17:Ionut", "15:Marcel", "21:Vasile", "20:Mihai");
        personStream = new PersonStream(persons);
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void testPrintPersonsOlderThan18() {
        personStream.printPersonsOlderThan18();
        String expected = "21:Vasile" + System.lineSeparator() + "20:Mihai";
        assertEquals(expected, outContent.toString().trim());
    }


    @Test
    public void testPrintOldestPerson() {
        personStream.printOldestPerson();
        assertEquals("21:Vasile", outContent.toString().trim());
    }

    @Test
    public void testPrintIfAllYoungerThan80() {
        personStream.printIfAllYoungerThan80();
        assertEquals("Yes", outContent.toString().trim());
    }

    @Test
    public void testPrintPersonsGroupedByAge() {
        personStream.printPersonsGroupedByAge();
        String expectedOutput = "17 Ionut" + System.lineSeparator() +
                "18 Maria, Marioara" + System.lineSeparator() +
                "20 Mihai" + System.lineSeparator() +
                "21 Vasile" + System.lineSeparator() +
                "15 Marcel" + System.lineSeparator();


        assertEquals(expectedOutput, outContent.toString());
    }
    /* @Test
    public void testPrintPersonsGroupedByAge2() {
        personStream.printPersonsGroupedByAge();
        String expectedOutput = "17 Ionut\n18 Maria, Marioara\n20 Mihai\n21 Vasile\n15 Marcel";
        assertEquals(expectedOutput, outContent.toString().trim());
    }*/

}
