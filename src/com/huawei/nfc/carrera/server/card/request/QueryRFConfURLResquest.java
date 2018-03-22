package com.huawei.nfc.carrera.server.card.request;

public class QueryRFConfURLResquest extends CardServerBaseRequest {
    private String issuerId;
    private String model;
    private String romVersion;
    private long timestamp;

    public QueryRFConfURLResquest(String str, String str2, String str3, long j) {
        this.model = str;
        this.romVersion = str2;
        this.issuerId = str3;
        this.timestamp = j;
    }

    public String getModel() {
        return this.model;
    }

    public void setModel(String str) {
        this.model = str;
    }

    public String getRomVersion() {
        return this.romVersion;
    }

    public void setRomVersion(String str) {
        this.romVersion = str;
    }

    public String getIssuerId() {
        return this.issuerId;
    }

    public void setIssuerId(String str) {
        this.issuerId = str;
    }

    public long getTimeStamp() {
        return this.timestamp;
    }

    public void setTimeStamp(long j) {
        this.timestamp = j;
    }
}
