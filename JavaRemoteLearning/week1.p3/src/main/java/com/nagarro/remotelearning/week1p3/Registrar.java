package com.nagarro.remotelearning.week1p3;

public class Registrar {
    private Registry registry;

    public Registrar(Registry registry) {
        this.registry = registry;
    }

    public Domain contactRegistry(String domainName, String ownerDetails, String hosts) {
        return registry.createDomain(domainName, ownerDetails, hosts);
    }

}
