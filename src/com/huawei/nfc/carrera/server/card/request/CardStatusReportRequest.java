package com.huawei.nfc.carrera.server.card.request;

public class CardStatusReportRequest extends CardServerBaseRequest {
    public static final String CARD_STATUS_REPORT_DELETED = "6";
    public static final String CARD_STATUS_REPORT_LOCKED = "3";
    public static final String CARD_STATUS_REPORT_NOT_ACTIVED = "7";
    public static final String CARD_STATUS_REPORT_OPENED = "0";
    private String aid;
    private String cardName;
    private String cardNumber;
    private int cardType;
    private String cplc;
    private String dpanid;
    private boolean ifNotify;
    private String imei;
    private String issuerId;
    private String status;
    private String terminal;
    private String userID;
    private String walletVersion;

    public String getCplc() {
        return this.cplc;
    }

    public String getTerminal() {
        return this.terminal;
    }

    public String getUserID() {
        return this.userID;
    }

    public String getAid() {
        return this.aid;
    }

    public String getStatus() {
        return this.status;
    }

    public String getImei() {
        return this.imei;
    }

    public String getDpanid() {
        return this.dpanid;
    }

    public String getCardName() {
        return this.cardName;
    }

    public String getCardNumber() {
        return this.cardNumber;
    }

    public String getWalletVersion() {
        return this.walletVersion;
    }

    public String getIssuerId() {
        return this.issuerId;
    }

    public int getCardType() {
        return this.cardType;
    }

    public boolean isIfNotify() {
        return this.ifNotify;
    }

    public void setCplc(String str) {
        this.cplc = str;
    }

    public void setTerminal(String str) {
        this.terminal = str;
    }

    public void setUserID(String str) {
        this.userID = str;
    }

    public void setAid(String str) {
        this.aid = str;
    }

    public void setStatus(String str) {
        this.status = str;
    }

    public void setImei(String str) {
        this.imei = str;
    }

    public void setDpanid(String str) {
        this.dpanid = str;
    }

    public void setCardName(String str) {
        this.cardName = str;
    }

    public void setCardNumber(String str) {
        this.cardNumber = str;
    }

    public void setWalletVersion(String str) {
        this.walletVersion = str;
    }

    public void setIssuerId(String str) {
        this.issuerId = str;
    }

    public void setCardType(int i) {
        this.cardType = i;
    }

    public void setIfNotify(boolean z) {
        this.ifNotify = z;
    }
}
