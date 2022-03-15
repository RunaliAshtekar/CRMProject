package com.rsd.crmroject;

public class DataClass {
    public DataClass(DataObjectClass dataObjectClass) {
        this.dataObjectClass = dataObjectClass;
    }

    private DataObjectClass dataObjectClass;

    public DataObjectClass getDataObjectClass() {
        return dataObjectClass;
    }

    public void setDataObjectClass(DataObjectClass dataObjectClass) {
        this.dataObjectClass = dataObjectClass;
    }
}
