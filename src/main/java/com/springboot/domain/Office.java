package com.springboot.domain;

/**
 * @author eternalSy
 * @version 1.0.0
 */
public class Office {
    private Integer OFFICE_ID;
    private String OFFICE_NAME;

    public Office() {
    }

    public Integer getOFFICE_ID() {
        return OFFICE_ID;
    }

    public void setOFFICE_ID(Integer OFFICE_ID) {
        this.OFFICE_ID = OFFICE_ID;
    }

    public String getOFFICE_NAME() {
        return OFFICE_NAME;
    }

    public void setOFFICE_NAME(String OFFICE_NAME) {
        this.OFFICE_NAME = OFFICE_NAME;
    }

    @Override
    public String toString() {
        return "Office{" +
                "OFFICE_ID=" + OFFICE_ID +
                ", OFFICE_NAME='" + OFFICE_NAME + '\'' +
                '}';
    }
}
