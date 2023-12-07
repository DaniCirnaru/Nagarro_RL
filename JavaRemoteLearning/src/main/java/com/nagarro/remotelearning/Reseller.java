package com.nagarro.remotelearning;

public class Reseller {


    public static void contactRegistrar(String domainName,String ownerDetails,String hosts)
    {
        Registrar.createDomain(domainName,ownerDetails,hosts);

    }


}
