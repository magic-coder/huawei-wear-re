package com.huawei.nfc.carrera.logic.spi.citic.request;

public class SmsCodeRequest extends BaseRequest {
    private String aid;
    private String dPan;
    private String verifyToken;

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(super.toString());
        stringBuilder.append("verifyToken: ").append(this.verifyToken).append(",");
        stringBuilder.append("dPan: ").append(this.dPan).append(",");
        stringBuilder.append("aid: ").append(this.aid).append(",");
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
}
