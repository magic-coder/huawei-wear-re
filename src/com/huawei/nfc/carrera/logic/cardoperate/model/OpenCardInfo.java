package com.huawei.nfc.carrera.logic.cardoperate.model;

public class OpenCardInfo {
    private String captureMethod;
    private String cardNum;
    private int cardType;
    private String cvv2;
    private String date;
    private String idNum;
    private String issuerId;
    private String location;
    private String phone;
    private String pwd;

    public String getCardNum() {
        return this.cardNum;
    }

    public void setCardNum(String str) {
        this.cardNum = str;
    }

    public int getCardType() {
        return this.cardType;
    }

    public void setCardType(int i) {
        this.cardType = i;
    }

    public String getIssuerId() {
        return this.issuerId;
    }

    public void setIssuerId(String str) {
        this.issuerId = str;
    }

    public String getPwd() {
        return this.pwd;
    }

    public void setPwd(String str) {
        this.pwd = str;
    }

    public String getDate() {
        return this.date;
    }

    public void setDate(String str) {
        this.date = str;
    }

    public String getCvv2() {
        return this.cvv2;
    }

    public void setCvv2(String str) {
        this.cvv2 = str;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String str) {
        this.phone = str;
    }

    public String getIdNum() {
        return this.idNum;
    }

    public void setIdNum(String str) {
        this.idNum = str;
    }

    public String getCaptureMethod() {
        return this.captureMethod;
    }

    public void setCaptureMethod(String str) {
        this.captureMethod = str;
    }

    public String getLocation() {
        return this.location;
    }

    public void setLocation(String str) {
        this.location = str;
    }
}
