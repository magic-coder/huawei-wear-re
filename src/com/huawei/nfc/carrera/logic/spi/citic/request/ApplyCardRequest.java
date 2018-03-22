package com.huawei.nfc.carrera.logic.spi.citic.request;

public class ApplyCardRequest extends BaseRequest {
    private String aid;
    private String cardNum;
    private int cardType;
    private String cvv2Code;
    private String idNum;
    private String passcode;
    private String validDate;
    private String verifyToken;

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(super.toString());
        stringBuilder.append("verifyToken: ").append(this.verifyToken).append(",");
        stringBuilder.append("cvv2Code: ").append(this.cvv2Code).append(",");
        stringBuilder.append("aid: ").append(this.aid).append(",");
        stringBuilder.append("validDate: ").append(this.validDate).append(",");
        return stringBuilder.toString();
    }

    public String getVerifyToken() {
        return this.verifyToken;
    }

    public void setVerifyToken(String str) {
        this.verifyToken = str;
    }

    public String getCardNum() {
        return this.cardNum;
    }

    public void setCardNum(String str) {
        this.cardNum = str;
    }

    public String getCvv2Code() {
        return this.cvv2Code;
    }

    public void setCvv2Code(String str) {
        this.cvv2Code = str;
    }

    public String getAid() {
        return this.aid;
    }

    public void setAid(String str) {
        this.aid = str;
    }

    public String getPasscode() {
        return this.passcode;
    }

    public void setPasscode(String str) {
        this.passcode = str;
    }

    public int getCardType() {
        return this.cardType;
    }

    public void setCardType(int i) {
        this.cardType = i;
    }

    public String getValidDate() {
        return this.validDate;
    }

    public void setValidDate(String str) {
        this.validDate = str;
    }

    public String getIdNum() {
        return this.idNum;
    }

    public void setIdNum(String str) {
        this.idNum = str;
    }
}
