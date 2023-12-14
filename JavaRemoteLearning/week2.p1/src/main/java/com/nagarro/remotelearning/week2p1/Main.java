package com.nagarro.remotelearning.week2p1;

public class Main {
    public static void main(String[] args) {
        //Creating persons
        Person person1 = new Person("John", "Doe");
        Person person2 = new Person("Alice Smith Johnson");
        Person person3 = new Person("Maria Ana Ioana Mihaela");
        //Displaying persons
        person1.displayPerson();
        person2.displayPerson();

        System.out.println(person2.getFirstname());//Displaying person2 firstname
        System.out.println(person2.getSurname());//Displaying person2 surname

        System.out.println(person3.getFirstname());//Displaying person3 firstname
        System.out.println(person3.getSurname());//Displaying person3 surname
    }
}
