package com.nagarro.remotelearning.week1p1;

public class Person {
    private String firstName;
    private String lastName;
    private String dob;
    private String dod;

    public Person(String firstName, String lastName, String dob, String dod) {
        this.firstName = firstName.trim();
        this.lastName = lastName.trim();
        this.dob = dob.trim();
        this.dod = dod.trim();
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + " (" + dob + "-" + dod + ")";
    }
}
