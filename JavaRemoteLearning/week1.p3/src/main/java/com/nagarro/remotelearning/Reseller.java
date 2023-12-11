package com.nagarro.remotelearning;

public class Reseller {

    public Domain  contactRegistrar(String domainName,String ownerDetails,String hosts)
    {
        Registrar registrar=new Registrar();
        return registrar.createDomain(domainName,ownerDetails,hosts);

    }


}
