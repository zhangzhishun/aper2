package com.springboot.domain;

/**
 * @author eternalSy
 * @version 1.0.0
 */
public class User {
    private Integer USER_ID;
    private String USER_NAME;
    private String USER_PASSWORD;
    private String USER_PHONE;
    private String USER_SEX;
    private String USER_REALNAME;
    private String USER_WECHAT;

    public User() {
    }

    public Integer getUSER_ID() {
        return USER_ID;
    }

    public void setUSER_ID(Integer USER_ID) {
        this.USER_ID = USER_ID;
    }

    public String getUSER_NAME() {
        return USER_NAME;
    }

    public void setUSER_NAME(String USER_NAME) {
        this.USER_NAME = USER_NAME;
    }

    public String getUSER_PASSWORD() {
        return USER_PASSWORD;
    }

    public void setUSER_PASSWORD(String USER_PASSWORD) {
        this.USER_PASSWORD = USER_PASSWORD;
    }

    public String getUSER_PHONE() {
        return USER_PHONE;
    }

    public void setUSER_PHONE(String USER_PHONE) {
        this.USER_PHONE = USER_PHONE;
    }

    public String getUSER_SEX() {
        return USER_SEX;
    }

    public void setUSER_SEX(String USER_SEX) {
        this.USER_SEX = USER_SEX;
    }

    public String getUSER_REALNAME() {
        return USER_REALNAME;
    }

    public void setUSER_REALNAME(String USER_REALNAME) {
        this.USER_REALNAME = USER_REALNAME;
    }

    public String getUSER_WECHAT() {
        return USER_WECHAT;
    }

    public void setUSER_WECHAT(String USER_WECHAT) {
        this.USER_WECHAT = USER_WECHAT;
    }

    @Override
    public String toString() {
        return "User{" +
                "USER_ID=" + USER_ID +
                ", USER_NAME='" + USER_NAME + '\'' +
                ", USER_PASSWORD='" + USER_PASSWORD + '\'' +
                ", USER_PHONE='" + USER_PHONE + '\'' +
                ", USER_SEX='" + USER_SEX + '\'' +
                ", USER_REALNAME='" + USER_REALNAME + '\'' +
                ", USER_WECHAT='" + USER_WECHAT + '\'' +
                '}';
    }
}
