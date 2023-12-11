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

    public  Domain contactReseller(String domainName, String ownerDetails, String hosts)
    {
        Reseller reseller = new Reseller();
        return reseller.contactRegistrar(domainName,ownerDetails,hosts);

    }
}
