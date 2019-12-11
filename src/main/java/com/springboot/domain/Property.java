package com.springboot.domain;

/**
 * @author eternalSy
 * @version 1.0.0
 */
public class Property {
    String PROPERTY_ID;
    String PROPERTY_NAME;
    String PROPERTY_VALUE;

    public Property(String PROPERTY_ID, String PROPERTY_NAME, String PROPERTY_VALUE) {
        this.PROPERTY_ID = PROPERTY_ID;
        this.PROPERTY_NAME = PROPERTY_NAME;
        this.PROPERTY_VALUE = PROPERTY_VALUE;
    }

    public String getPROPERTY_ID() {
        return PROPERTY_ID;
    }

    public void setPROPERTY_ID(String PROPERTY_ID) {
        this.PROPERTY_ID = PROPERTY_ID;
    }

    public String getPROPERTY_NAME() {
        return PROPERTY_NAME;
    }

    public void setPROPERTY_NAME(String PROPERTY_NAME) {
        this.PROPERTY_NAME = PROPERTY_NAME;
    }

    public String getPROPERTY_VALUE() {
        return PROPERTY_VALUE;
    }

    public void setPROPERTY_VALUE(String PROPERTY_VALUE) {
        this.PROPERTY_VALUE = PROPERTY_VALUE;
    }

    @Override
    public String toString() {
        return "Property{" +
                "PROPERTY_ID='" + PROPERTY_ID + '\'' +
                ", PROPERTY_NAME='" + PROPERTY_NAME + '\'' +
                ", PROPERTY_VALUE='" + PROPERTY_VALUE + '\'' +
                '}';
    }
}
