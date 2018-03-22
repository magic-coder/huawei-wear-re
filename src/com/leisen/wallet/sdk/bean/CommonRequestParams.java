package com.leisen.wallet.sdk.bean;

import java.util.Locale;

public class CommonRequestParams {
    private String cplc;
    private String funCallId;
    private String serviceId;

    public CommonRequestParams(String str, String str2, String str3) {
        this.serviceId = str;
        this.funCallId = str2;
        this.cplc = str3;
    }

    public String getServiceId() {
        return this.serviceId;
    }

    public void setServiceId(String str) {
        this.serviceId = str;
    }

    public String getFunCallId() {
        return this.funCallId;
    }

    public void setFunCallId(String str) {
        this.funCallId = str;
    }

    public String getCplc() {
        return this.cplc;
    }

    public void setCplc(String str) {
        this.cplc = str;
    }

    public String getSeid() {
        if (this.cplc == null || "".equals(this.cplc) || this.cplc.length() <= 42) {
            return null;
        }
        return (this.cplc.substring(0, 4) + this.cplc.substring(20, 36)).toUpperCase(Locale.getDefault());
    }

    public void commonRequestParamsSAI1() {
    }

    public void commonRequestParamsSAI2() {
    }

    public void commonRequestParamsSAI3() {
    }

    public void commonRequestParamsSAI4() {
    }

    public void commonRequestParamsSAI5() {
    }
}
