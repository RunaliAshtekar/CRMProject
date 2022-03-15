package com.rsd.crmroject;

public class MainObjectClass {
    private String status;
    private DataClass dataClass;
    private DataObjectClass dataObjectClass;


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public DataClass getDataClass() {
        return dataClass;
    }

    public void setDataClass(DataClass dataClass) {
        this.dataClass = dataClass;
    }

    public DataObjectClass getDataObjectClass() {
        return dataObjectClass;
    }

    public void setDataObjectClass(DataObjectClass dataObjectClass) {
        this.dataObjectClass = dataObjectClass;
    }

    public MainObjectClass(String status, DataClass dataClass, DataObjectClass dataObjectClass) {
        this.status = status;
        this.dataClass = dataClass;
        this.dataObjectClass = dataObjectClass;
    }


}
