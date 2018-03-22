package com.huawei.nfc.carrera.server.card.request;

import com.unionpay.tsmservice.data.Constant;

public class ApplyCUPVerificationRequest extends CardServerBaseRequest {
    private String cardRefId;
    private String cplc;
    private String method = Constant.SMS_OTP_METHOD_STR;

    public String getCplc() {
        return this.cplc;
    }

    public String getMethod() {
        return this.method;
    }

    public String getCardRefId() {
        return this.cardRefId;
    }

    public void setCplc(String str) {
        this.cplc = str;
    }

    public void setMethod(String str) {
        this.method = str;
    }

    public void setCardRefId(String str) {
        this.cardRefId = str;
    }
}
