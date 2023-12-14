package com.nagarro.remotelearning.week1p3;


public class Main {
    public static void main(String[] args) {
        // Initialize Registry, Registrar, Reseller
        Registry registry = new Registry();
        Registrar registrar = new Registrar(registry);
        Reseller reseller = new Reseller(registrar);

        // Set Reseller for Customer
        Customer customer = new Customer("Domain Name", "Owner Details", "hosts", reseller);

        // Use the contactReseller method to create a domain
        Domain domain = customer.contactReseller("Domain Name", "Owner Details", "hosts");

    }
}