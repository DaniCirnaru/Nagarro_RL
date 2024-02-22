package com.nagarro.remotelearning.main;

import com.nagarro.remotelearning.model.StringList;

public class Main {
    public static void main(String[] args) {
        // Create a new StringList instance
        StringList stringList1 = new StringList();

        // Add elements to the list
        stringList1.add("12");
        stringList1.add("23");
        stringList1.add("34");

        StringList stringList2 = new StringList();
        stringList2.add("12");
        stringList2.add("23");
        stringList2.add("34");

        System.out.println("Element at position 1: " + stringList1.get(1));

        System.out.println("Contains '23': " + stringList1.contains("23"));
        System.out.println("Contains '45': " + stringList1.contains("45"));

        System.out.println("Contains all: " + stringList1.containsAll(stringList2));

        System.out.println("Size of the list: " + stringList1.size());

        System.out.println("Operations log: " + stringList1.getOperationsLog());
    }
}
