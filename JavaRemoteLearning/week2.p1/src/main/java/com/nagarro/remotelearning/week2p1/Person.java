package com.nagarro.remotelearning.week2p1;

public class Person {
    private String firstname;
    private String surname;

    public Person(String firstname, String surname) {
        this.firstname = firstname;
        this.surname = surname;
    }

    public Person(String fullName) {
        String[] names = fullName.split(" ");
        this.firstname = "";
        for (int i = 0; i < names.length - 1; i++) {
            this.firstname += names[i] + " ";
        }
        this.surname = names[names.length - 1];
        this.firstname = this.firstname.trim();
    }

    public void displayPerson() {
        System.out.println("Person: " + firstname + " " + surname);
    }

    public String getFirstname() {
        return firstname;
    }

    public String getSurname() {
        return surname;
    }
}
