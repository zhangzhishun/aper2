package com.springboot.domain;

/**
 * @author eternalSy
 * @version 1.0.0
 */
public class Doctor {
    private Integer DOCTOR_ID;
    private String DOCTOR_NAME;
    private String DOCTOR_PASSWORD;
    private String DOCTOR_REALNAME;
    private String DOCTOR_SEX;
    private String DOCTOR_PHONE;
    private String DOCTOR_WECHAT;
    private Integer DOCTOR_OFFICEID;

    public Doctor() {
    }

    public Integer getDOCTOR_ID() {
        return DOCTOR_ID;
    }

    public void setDOCTOR_ID(Integer DOCTOR_ID) {
        this.DOCTOR_ID = DOCTOR_ID;
    }

    public String getDOCTOR_NAME() {
        return DOCTOR_NAME;
    }

    public void setDOCTOR_NAME(String DOCTOR_NAME) {
        this.DOCTOR_NAME = DOCTOR_NAME;
    }

    public String getDOCTOR_PASSWORD() {
        return DOCTOR_PASSWORD;
    }

    public void setDOCTOR_PASSWORD(String DOCTOR_PASSWORD) {
        this.DOCTOR_PASSWORD = DOCTOR_PASSWORD;
    }

    public String getDOCTOR_REALNAME() {
        return DOCTOR_REALNAME;
    }

    public void setDOCTOR_REALNAME(String DOCTOR_REALNAME) {
        this.DOCTOR_REALNAME = DOCTOR_REALNAME;
    }

    public String getDOCTOR_SEX() {
        return DOCTOR_SEX;
    }

    public void setDOCTOR_SEX(String DOCTOR_SEX) {
        this.DOCTOR_SEX = DOCTOR_SEX;
    }

    public String getDOCTOR_PHONE() {
        return DOCTOR_PHONE;
    }

    public void setDOCTOR_PHONE(String DOCTOR_PHONE) {
        this.DOCTOR_PHONE = DOCTOR_PHONE;
    }

    public String getDOCTOR_WECHAT() {
        return DOCTOR_WECHAT;
    }

    public void setDOCTOR_WECHAT(String DOCTOR_WECHAT) {
        this.DOCTOR_WECHAT = DOCTOR_WECHAT;
    }

    public Integer getDOCTOR_OFFICEID() {
        return DOCTOR_OFFICEID;
    }

    public void setDOCTOR_OFFICEID(Integer DOCTOR_OFFICEID) {
        this.DOCTOR_OFFICEID = DOCTOR_OFFICEID;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "DOCTOR_ID=" + DOCTOR_ID +
                ", DOCTOR_NAME='" + DOCTOR_NAME + '\'' +
                ", DOCTOR_PASSWORD='" + DOCTOR_PASSWORD + '\'' +
                ", DOCTOR_REALNAME='" + DOCTOR_REALNAME + '\'' +
                ", DOCTOR_SEX='" + DOCTOR_SEX + '\'' +
                ", DOCTOR_PHONE='" + DOCTOR_PHONE + '\'' +
                ", DOCTOR_WECHAT='" + DOCTOR_WECHAT + '\'' +
                ", DOCTOR_OFFICEID=" + DOCTOR_OFFICEID +
                '}';
    }
}
