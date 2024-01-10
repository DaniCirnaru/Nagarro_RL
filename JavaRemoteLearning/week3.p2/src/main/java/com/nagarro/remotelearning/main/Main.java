package com.nagarro.remotelearning.main;

import com.nagarro.remotelearning.person.FrenchPerson;
import com.nagarro.remotelearning.person.SpanishPerson;

public class Main {
    public static void main(String[] args) {
        FrenchPerson frenchPerson = new FrenchPerson("Jean", "Dupont", "01/01/1990", 32);
        SpanishPerson spanishPerson = new SpanishPerson("Maria", "Garcia", "15/05/1985", 37);

        System.out.println("French person:");
        frenchPerson.selfDescribe();

        System.out.println("Spanish person:");
        spanishPerson.selfDescribe();

    }
}
