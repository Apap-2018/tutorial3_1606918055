package com.apap.tutorial3.model;

public class PilotModel {
    private String id;
    private String licenseNumber;
    private String name;
    private int flyHour;

    public PilotModel(String id, String licenseNumber, String name, int flyHour) {
        this.id = id;
        this.licenseNumber = licenseNumber;
        this.name = name;
        this.flyHour = flyHour;
    }

    public String getId() {
        return id;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFlyHour() {
        return flyHour;
    }

    public void setFlyHour(int flyHour) {
        this.flyHour = flyHour;
    }
}
