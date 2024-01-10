package com.nagarro.remotelearning.person;

import com.nagarro.remotelearning.model.Person;

public class SpanishPerson extends Person {
    private String birthDate;
    private int age;

    public SpanishPerson(String firstname, String surname, String birthDate, int age) {
        super(firstname, surname);
        this.birthDate = birthDate;
        this.age = age;
    }

    @Override
    public String getBirthDate() {
        return birthDate;
    }

    @Override
    public void selfDescribe() {
        System.out.println("Hola! Me llamo " + getFirstname() + " " + getSurname() + ". Nací el " + getBirthDate() + ". Tengo " + age + " años.");
    }

}
