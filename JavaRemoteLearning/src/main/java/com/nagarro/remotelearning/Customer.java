package com.nagarro.remotelearning;

public class Customer {
    private  String domainName;
    private  String ownerDetails;
    private  String hosts;

    public Customer(String domainName, String ownerDetails, String hosts) {
        this.domainName = domainName;
        this.ownerDetails = ownerDetails;
        this.hosts = hosts;
    }

    public static void contactReseller(String domainName, String ownerDetails, String hosts)
    {

        Reseller.contactRegistrar(domainName,ownerDetails,hosts);

    }
}
