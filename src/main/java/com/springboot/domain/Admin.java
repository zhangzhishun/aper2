package com.springboot.domain;

/**
 * @author eternalSy
 * @version 1.0.0
 */
public class Admin {
    private Integer ADMIN_ID;
    private String ADMIN_NAME;
    private String ADMIN_PASSWORD;

    public Admin() {
    }

    public Integer getADMIN_ID() {
        return ADMIN_ID;
    }

    public void setADMIN_ID(Integer ADMIN_ID) {
        this.ADMIN_ID = ADMIN_ID;
    }

    public String getADMIN_NAME() {
        return ADMIN_NAME;
    }

    public void setADMIN_NAME(String ADMIN_NAME) {
        this.ADMIN_NAME = ADMIN_NAME;
    }

    public String getADMIN_PASSWORD() {
        return ADMIN_PASSWORD;
    }

    public void setADMIN_PASSWORD(String ADMIN_PASSWORD) {
        this.ADMIN_PASSWORD = ADMIN_PASSWORD;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "ADMIN_ID=" + ADMIN_ID +
                ", ADMIN_NAME='" + ADMIN_NAME + '\'' +
                ", ADMIN_PASSWORD='" + ADMIN_PASSWORD + '\'' +
                '}';
    }
}
