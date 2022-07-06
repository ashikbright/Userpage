package com.ashik.userpage.utility;

public class Worker {
    String wType;
    String nWorkers;
    String nDays;
    String wLocation;

    public Worker(String wType, String nWorker, String nDays, String wLocation) {
        this.wType = wType;
        this.nWorkers = nWorker;
        this.nDays = nDays;
        this.wLocation = wLocation;
        
    }
        
    public String getWType() {
        return wType;
    }

    public String getNoWorker() {
        return nWorkers;
    }

    public String getNoDays() {
        return nDays;
    }

    public String getLocation() {
        return wLocation;
    }
}
