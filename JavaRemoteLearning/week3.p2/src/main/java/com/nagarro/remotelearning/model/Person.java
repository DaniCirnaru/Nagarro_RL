package com.nagarro.remotelearning.model;

public abstract class Person {
    private String firstname;
    private String surname;

    public Person(String firstname, String surname) {
        this.firstname = firstname;
        this.surname = surname;
    }

    public Person(String fullName) {
        String[] names = fullName.split(" ");
        setFirstName(names);
        this.surname = names[names.length - 1];
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

    private void setFirstName(String[] names) {
        this.firstname = "";
        for (int i = 0; i < names.length - 1; i++) {
            this.firstname += names[i] + " ";
        }
        this.firstname = this.firstname.trim();
    }

    public abstract String getBirthDate();

    public abstract void selfDescribe();
}
