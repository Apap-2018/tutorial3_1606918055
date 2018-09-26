package com.apap.tutorial3.model;

public class CarModel {
    private String id;
    private String brand;
    private String type;
    private long price;
    private int amount;

    public CarModel(String id, String brand, String type, long price, int amount) {
        this.id = id;
        this.brand = brand;
        this.type = type;
        this.price = price;
        this.amount = amount;
    }

    public String getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
