package com.springboot.domain;

/**
 * @author eternalSy
 * @version 1.0.0
 */
public class Advice {

    Integer ADVICE_ID;
    String ADVICE_TITLE;
    String ADVICE_CONTENT;
    String ADVICE_TIME;
    String ADVICE_REPLY;
    String ADVICE_REPLY_TIME;
    Integer USER_ID;

    public Advice() {
    }

    @Override
    public String toString() {
        return "ADVICE{" +
                "ADVICE_ID=" + ADVICE_ID +
                ", ADVICE_TITLE='" + ADVICE_TITLE + '\'' +
                ", ADVICE_CONTENT='" + ADVICE_CONTENT + '\'' +
                ", ADVICE_TIME='" + ADVICE_TIME + '\'' +
                ", ADVICE_REPLY='" + ADVICE_REPLY + '\'' +
                ", ADVICE_REPLY_TIME='" + ADVICE_REPLY_TIME + '\'' +
                ", USER_ID='" + USER_ID + '\'' +
                '}';
    }

    public Integer getUSER_ID() {
        return USER_ID;
    }

    public void setUSER_ID(Integer USER_ID) {
        this.USER_ID = USER_ID;
    }

    public Integer getADVICE_ID() {
        return ADVICE_ID;
    }

    public void setADVICE_ID(Integer ADVICE_ID) {
        this.ADVICE_ID = ADVICE_ID;
    }

    public String getADVICE_TITLE() {
        return ADVICE_TITLE;
    }

    public void setADVICE_TITLE(String ADVICE_TITLE) {
        this.ADVICE_TITLE = ADVICE_TITLE;
    }

    public String getADVICE_CONTENT() {
        return ADVICE_CONTENT;
    }

    public void setADVICE_CONTENT(String ADVICE_CONTENT) {
        this.ADVICE_CONTENT = ADVICE_CONTENT;
    }

    public String getADVICE_TIME() {
        return ADVICE_TIME;
    }

    public void setADVICE_TIME(String ADVICE_TIME) {
        this.ADVICE_TIME = ADVICE_TIME;
    }

    public String getADVICE_REPLY() {
        return ADVICE_REPLY;
    }

    public void setADVICE_REPLY(String ADVICE_REPLY) {
        this.ADVICE_REPLY = ADVICE_REPLY;
    }

    public String getADVICE_REPLY_TIME() {
        return ADVICE_REPLY_TIME;
    }

    public void setADVICE_REPLY_TIME(String ADVICE_REPLY_TIME) {
        this.ADVICE_REPLY_TIME = ADVICE_REPLY_TIME;
    }
}
