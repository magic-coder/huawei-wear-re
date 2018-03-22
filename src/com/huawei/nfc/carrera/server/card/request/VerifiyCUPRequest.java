package com.huawei.nfc.carrera.server.card.request;

public class VerifiyCUPRequest extends CardServerBaseRequest {
    private String cardRefId;
    private String cplc;
    private String optValue;

    public void setCplc(String str) {
        this.cplc = str;
    }

    public void setOptValue(String str) {
        this.optValue = str;
    }

    public void setCardRefId(String str) {
        this.cardRefId = str;
    }

    public String getCplc() {
        return this.cplc;
    }

    public String getOptValue() {
        return this.optValue;
    }

    public String getCardRefId() {
        return this.cardRefId;
    }
}
