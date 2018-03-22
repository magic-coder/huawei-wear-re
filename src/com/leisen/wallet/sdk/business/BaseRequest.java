package com.leisen.wallet.sdk.business;

public class BaseRequest<T extends Business> {
    private T business;
    private String clientVersion;
    private String cplc;
    private String functionCallId;
    private String imei;
    private String mobileType;
    private String seid;
    private String serviceId;
    private String version;

    public String getVersion() {
        return this.version;
    }

    public void setVersion(String str) {
        this.version = str;
    }

    public String getSeid() {
        return this.seid;
    }

    public void setSeid(String str) {
        this.seid = str;
    }

    public String getImei() {
        return this.imei;
    }

    public void setImei(String str) {
        this.imei = str;
    }

    public String getServiceId() {
        return this.serviceId;
    }

    public void setServiceId(String str) {
        this.serviceId = str;
    }

    public String getClientVersion() {
        return this.clientVersion;
    }

    public void setClientVersion(String str) {
        this.clientVersion = str;
    }

    public String getMobileType() {
        return this.mobileType;
    }

    public void setMobileType(String str) {
        this.mobileType = str;
    }

    public String getFunctionCallId() {
        return this.functionCallId;
    }

    public void setFunctionCallId(String str) {
        this.functionCallId = str;
    }

    public T getBusiness() {
        return this.business;
    }

    public void setBusiness(T t) {
        this.business = t;
    }

    public String getCplc() {
        return this.cplc;
    }

    public void setCplc(String str) {
        this.cplc = str;
    }
}
