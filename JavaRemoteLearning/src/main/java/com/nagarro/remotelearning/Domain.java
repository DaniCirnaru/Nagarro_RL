package com.nagarro.remotelearning;

public class Domain {
    private  String name;
    private  String ownerDetails;
    private  String hosts;


    public  Domain(String domainName, String ownerDetails, String hosts) {
        this.name = domainName;
        this.ownerDetails = ownerDetails;
        this.hosts = hosts;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOwnerDetails() {
        return ownerDetails;
    }

    public void setOwnerDetails(String ownerDetails) {
        this.ownerDetails = ownerDetails;
    }

    public String getHosts() {
        return hosts;
    }

    public void setHosts(String hosts) {
        this.hosts = hosts;
    }
}
