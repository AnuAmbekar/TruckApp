package com.example.myapplication;

public class Trucks {
    private String title, vehicle, service, available;

    public Trucks(String title, String vehicle, String service, String available) {
        this.title = title;
        this.vehicle = vehicle;
        this.available = available;
        this.service = service;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setVehicle(String vehicle) {
        this.vehicle = vehicle;
    }

    public String getVehicle() {
        return vehicle;
    }

    public void setAvailable(String available) {
        this.available = available;
    }

    public String getAvailable() {
        return available;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getService() {
        return service;
    }
}
