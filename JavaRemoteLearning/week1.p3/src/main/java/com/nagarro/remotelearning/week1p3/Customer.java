package com.nagarro.remotelearning.week1p3;

public class Customer {
    private  String domainName;
    private  String ownerDetails;
    private  String hosts;
    private  Reseller reseller;

    public Customer(String domainName, String ownerDetails, String hosts,Reseller reseller) {
        this.domainName = domainName;
        this.ownerDetails = ownerDetails;
        this.hosts = hosts;
        this.reseller=reseller;
    }

    public  Domain contactReseller(String domainName, String ownerDetails, String hosts)
    {

        return reseller.contactRegistrar(domainName,ownerDetails,hosts);

    }
}
