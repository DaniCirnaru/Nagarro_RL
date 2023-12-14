package com.nagarro.remotelearning.week1p3;

public class Registry {
    public Domain createDomain(String domainName, String ownerDetails, String hosts) {
        return new Domain(domainName, ownerDetails, hosts);
    }
}
