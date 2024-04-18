package com.nagarro.remotelearning;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PersonStream {
    private List<String> persons;

    public PersonStream(List<String> persons) {
        this.persons = persons;
    }

    public void printPersonsOlderThan18() {
        persons.stream()
                .filter(person -> Integer.parseInt(person.split(":")[0]) > 18)
                .forEach(System.out::println);
    }

    public void printOldestPerson() {
        persons.stream()
                .max(Comparator.comparingInt(p -> Integer.parseInt(p.split(":")[0])))
                .ifPresent(System.out::println);
    }

    public void printIfAllYoungerThan80() {
        boolean allYoungerThan80 = persons.stream()
                .allMatch(person -> Integer.parseInt(person.split(":")[0]) < 80);
        System.out.println(allYoungerThan80 ? "Yes" : "No");
    }

    public void printPersonsGroupedByAge() {
        Map<Integer, String> groupedByAge = persons.stream()
                .collect(Collectors.groupingBy(
                        person -> Integer.parseInt(person.split(":")[0]),
                        Collectors.mapping(person -> person.split(":")[1], Collectors.joining(", "))));
        groupedByAge.forEach((age, names) -> System.out.println(age + " " + names));
    }

}
