package com.huawei.nfc.carrera.logic.spi.citic.request;

public class ActivateCardRequest extends BaseRequest {
    private String aid;
    private String dPan;
    private String smsCode;
    private String verifyToken;

    public interface ActivateCardRequestSai1 {
    }

    public interface ActivateCardRequestSai2 {
    }

    public interface ActivateCardRequestSai3 {
    }

    public interface ActivateCardRequestSai4 {
    }

    public interface ActivateCardRequestSai5 {
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(super.toString());
        stringBuilder.append("verifyToken: ").append(this.verifyToken).append(",");
        stringBuilder.append("dPan: ").append(this.dPan).append(",");
        stringBuilder.append("aid: ").append(this.aid).append(",");
        stringBuilder.append("smsCode: ").append(this.smsCode).append(",");
        return stringBuilder.toString();
    }

    public String getVerifyToken() {
        return this.verifyToken;
    }

    public void setVerifyToken(String str) {
        this.verifyToken = str;
    }

    public String getdPan() {
        return this.dPan;
    }

    public void setdPan(String str) {
        this.dPan = str;
    }

    public String getAid() {
        return this.aid;
    }

    public void setAid(String str) {
        this.aid = str;
    }

    public String getSmsCode() {
        return this.smsCode;
    }

    public void setSmsCode(String str) {
        this.smsCode = str;
    }
}
