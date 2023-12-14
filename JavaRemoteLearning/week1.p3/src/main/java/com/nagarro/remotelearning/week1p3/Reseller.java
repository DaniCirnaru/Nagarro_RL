package com.nagarro.remotelearning.week1p3;

public class Reseller {
    private Registrar registrar;

    public Reseller(Registrar registrar) {
        this.registrar = registrar;
    }

    public Domain contactRegistrar(String domainName, String ownerDetails, String hosts) {
        return registrar.contactRegistry(domainName, ownerDetails, hosts);

    }


}
