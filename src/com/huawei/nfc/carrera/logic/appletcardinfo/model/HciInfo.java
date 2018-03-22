package com.huawei.nfc.carrera.logic.appletcardinfo.model;

public class HciInfo {
    public static final String HCI_TRANS_TYPE_BUS = "1";
    public static final String HCI_TRANS_TYPE_CONSUME = "0";
    public static final String HCI_TRANS_TYPE_METRO_IN = "2";
    public static final String HCI_TRANS_TYPE_METRO_OFF = "3";
    public static final int TYPE_CONFIG = 2;
    public static final int TYPE_TLV = 1;
    private String balance;
    private String currency;
    private String transAmount;
    private String transDate;
    private String transDateAndTime;
    private String transTerminal;
    private String transTime;
    private String transType;
    private int type;

    public HciInfo(int i) {
        this.type = i;
    }

    public int getType() {
        return this.type;
    }

    public void setType(int i) {
        this.type = i;
    }

    public String getTransAmount() {
        return this.transAmount;
    }

    public void setTransAmount(String str) {
        this.transAmount = str;
    }

    public String getBalance() {
        return this.balance;
    }

    public void setBalance(String str) {
        this.balance = str;
    }

    public String getTransType() {
        return this.transType;
    }

    public void setTransType(String str) {
        this.transType = str;
    }

    public String getTransDate() {
        return this.transDate;
    }

    public void setTransDate(String str) {
        this.transDate = str;
    }

    public String getTransTime() {
        return this.transTime;
    }

    public void setTransTime(String str) {
        this.transTime = str;
    }

    public String getTransDateAndTime() {
        return this.transDateAndTime;
    }

    public void setTransDateAndTime(String str) {
        this.transDateAndTime = str;
    }

    public String getTransTerminal() {
        return this.transTerminal;
    }

    public void setTransTerminal(String str) {
        this.transTerminal = str;
    }

    public String getCurrency() {
        return this.currency;
    }

    public void setCurrency(String str) {
        this.currency = str;
    }

    public static HciInfo build(int i, String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        HciInfo hciInfo = new HciInfo(i);
        hciInfo.transAmount = str;
        hciInfo.balance = str2;
        hciInfo.transType = str3;
        hciInfo.transDate = str4;
        hciInfo.transTime = str5;
        hciInfo.transTerminal = str6;
        hciInfo.currency = str7;
        return hciInfo;
    }

    public String toString() {
        return "HciInfo{transAmount='" + this.transAmount + '\'' + ", balance='" + this.balance + '\'' + ", transType='" + this.transType + '\'' + ", transDate='" + this.transDate + '\'' + ", transTime='" + this.transTime + '\'' + ", transTerminal='" + this.transTerminal + '\'' + '}';
    }
}
