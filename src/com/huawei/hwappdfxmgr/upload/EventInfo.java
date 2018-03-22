package com.huawei.hwappdfxmgr.upload;

public class EventInfo {
    private String appId;
    private String deviceId;
    private int iversion;
    private int siteId;
    private int source;
    private String token;
    private int tokenType;
    private long ts;

    public long getTs() {
        return this.ts;
    }

    public void setTs(long j) {
        this.ts = j;
    }

    public int getTokenType() {
        return this.tokenType;
    }

    public void setTokenType(int i) {
        this.tokenType = i;
    }

    public String getToken() {
        return this.token;
    }

    public void setToken(String str) {
        this.token = str;
    }

    public String getAppId() {
        return this.appId;
    }

    public void setAppId(String str) {
        this.appId = str;
    }

    public String getDeviceId() {
        return this.deviceId;
    }

    public void setDeviceId(String str) {
        this.deviceId = str;
    }

    public int getSiteId() {
        return this.siteId;
    }

    public void setSiteId(int i) {
        this.siteId = i;
    }

    public int getIversion() {
        return this.iversion;
    }

    public void setIversion(int i) {
        this.iversion = i;
    }

    public int getSource() {
        return this.source;
    }

    public void setSource(int i) {
        this.source = i;
    }

    public String toString() {
        return "EventInfo{ts=" + this.ts + ", tokenType=" + this.tokenType + ", token='" + this.token + '\'' + ", appId='" + this.appId + '\'' + ", deviceId='" + this.deviceId + '\'' + ", siteId='" + this.siteId + '\'' + ", iversion='" + this.iversion + '\'' + ", source='" + this.source + '\'' + '}';
    }
}
