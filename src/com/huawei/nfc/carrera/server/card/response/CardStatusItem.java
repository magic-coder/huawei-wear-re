package com.huawei.nfc.carrera.server.card.response;

public class CardStatusItem {
    public static final String QUERIED_CARD_ACTION_LOST = "2";
    public static final String QUERIED_CARD_ACTION_NULLIFY = "5";
    public static final String QUERIED_CARD_ACTION_PAUSE = "1";
    public static final String QUERIED_CARD_ACTION_RESUME = "00";
    private String aid;
    private String cplc;
    private String dpanid;
    private String status;
    private String userID;

    public String getUserID() {
        return this.userID;
    }

    public void setUserID(String str) {
        this.userID = str;
    }

    public String getCplc() {
        return this.cplc;
    }

    public void setCplc(String str) {
        this.cplc = str;
    }

    public String getAid() {
        return this.aid;
    }

    public void setAid(String str) {
        this.aid = str;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String str) {
        this.status = str;
    }

    public String getDpanid() {
        return this.dpanid;
    }

    public void setDpanid(String str) {
        this.dpanid = str;
    }
}
