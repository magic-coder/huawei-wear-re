package com.leisen.wallet.sdk.business;

public class BaseResponse<T extends Business> {
    private T business;
    private String version;

    public String getVersion() {
        return this.version;
    }

    public void setVersion(String str) {
        this.version = str;
    }

    public T getBusiness() {
        return this.business;
    }

    public void setBusiness(T t) {
        this.business = t;
    }
}
