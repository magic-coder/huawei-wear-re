package com.snowballtech.business.bean;

public class CplcCacheForWatch {
    private String cplc;
    private String device_uid;

    public CplcCacheForWatch(String str, String str2) {
        this.cplc = str;
        this.device_uid = str2;
    }

    public String getDevice_uid() {
        return this.device_uid;
    }

    public void setDevice_uid(String str) {
        this.device_uid = str;
    }

    public String getCplc() {
        return this.cplc;
    }

    public void setCplc(String str) {
        this.cplc = str;
    }
}
