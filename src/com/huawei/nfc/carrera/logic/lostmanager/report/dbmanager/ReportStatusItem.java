package com.huawei.nfc.carrera.logic.lostmanager.report.dbmanager;

public class ReportStatusItem {
    private String aid;
    private String cardName;
    private String cardNumber;
    private String cardStatus;
    private int cardType;
    private String dpanId;
    private boolean ifNotify;
    private String issuerID;
    private String userId;

    public String getAid() {
        return this.aid;
    }

    public void setAid(String str) {
        this.aid = str;
    }

    public String getCardStatus() {
        return this.cardStatus;
    }

    public void setCardStatus(String str) {
        this.cardStatus = str;
    }

    public String getCardName() {
        return this.cardName;
    }

    public void setCardName(String str) {
        this.cardName = str;
    }

    public String getCardNumber() {
        return this.cardNumber;
    }

    public void setCardNumber(String str) {
        this.cardNumber = str;
    }

    public int getCardType() {
        return this.cardType;
    }

    public void setCardType(int i) {
        this.cardType = i;
    }

    public boolean isIfNotify() {
        return this.ifNotify;
    }

    public void setIfNotify(boolean z) {
        this.ifNotify = z;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String str) {
        this.userId = str;
    }

    public String getDpanId() {
        return this.dpanId;
    }

    public void setDpanId(String str) {
        this.dpanId = str;
    }

    public String getIssuerID() {
        return this.issuerID;
    }

    public void setIssuerID(String str) {
        this.issuerID = str;
    }
}
