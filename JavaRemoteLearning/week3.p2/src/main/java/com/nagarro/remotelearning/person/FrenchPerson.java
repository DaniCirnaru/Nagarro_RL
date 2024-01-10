package com.nagarro.remotelearning.person;

import com.nagarro.remotelearning.model.Person;

public class FrenchPerson extends Person {
    private final String birthDate;
    private final int age;

    public FrenchPerson(String firstname, String surname, String birthDate, int age) {
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
        System.out.println("Bonjour ! Je m'appelle " + getFirstname() + " " + getSurname() + ". Je suis né(e) le " + getBirthDate() + ". J'ai " + age + " ans.");
    }

}
