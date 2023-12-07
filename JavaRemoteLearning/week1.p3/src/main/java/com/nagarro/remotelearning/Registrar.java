package com.nagarro.remotelearning;

public class Registrar {

    //other details
    //setters and getters

    public static void createDomain(String domainName,String ownerDetails,String hosts) {
        // Logic to interact with the registry and create the domain
        Domain domain= new Domain(domainName,ownerDetails,hosts);

        System.out.println("Creating domain...");


        // Additional domain creation logic
    }

}
