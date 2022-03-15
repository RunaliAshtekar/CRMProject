package com.rsd.crmroject;

public class DataObjectClass {

    private String id;
    private String name;
    private String descriptiion;
    private String location;

    public DataObjectClass(String id, String name, String descriptiion, String location) {
        this.id = id;
        this.name = name;
        this.descriptiion = descriptiion;
        this.location = location;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescriptiion() {
        return descriptiion;
    }

    public void setDescriptiion(String descriptiion) {
        this.descriptiion = descriptiion;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
