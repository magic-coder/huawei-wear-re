package com.huawei.nfc.carrera.logic.spi.citic.request;

public class BaseRequest {
    private String cplc;
    private String timeStamp;
    private String walletSignature;

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(super.toString());
        stringBuilder.append("request sign: ").append(this.walletSignature).append(",");
        stringBuilder.append("timeStamp: ").append(this.timeStamp).append(",");
        stringBuilder.append("cplc: ").append(this.cplc).append(",");
        return stringBuilder.toString();
    }

    public String getWalletSignature() {
        return this.walletSignature;
    }

    public void setWalletSignature(String str) {
        this.walletSignature = str;
    }

    public String getTimeStamp() {
        return this.timeStamp;
    }

    public void setTimeStamp(String str) {
        this.timeStamp = str;
    }

    public String getCplc() {
        return this.cplc;
    }

    public void setCplc(String str) {
        this.cplc = str;
    }
}
