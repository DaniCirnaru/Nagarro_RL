package com.nagarro.remotelearning;

public class Registrar {

    public  Domain createDomain(String domainName,String ownerDetails,String hosts)
    {
        Domain domain= new Domain(domainName,ownerDetails,hosts);
        return domain;
    }

}
