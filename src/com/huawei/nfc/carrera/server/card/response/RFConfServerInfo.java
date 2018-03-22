package com.huawei.nfc.carrera.server.card.response;

public class RFConfServerInfo {
    private String issuerId;
    private String model;
    private String rfURL;
    private String romVersion;
    private long timestamp;

    public interface RfConfServerinfoSAI1 {
    }

    public interface RfConfServerinfoSAI2 {
    }

    public interface RfConfServerinfoSAI3 {
    }

    public interface RfConfServerinfoSAI4 {
    }

    public interface RfConfServerinfoSAI5 {
    }

    public interface RfConfServerinfoSAI6 {
    }

    public interface RfConfServerinfoSAI7 {
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

    public String getRfURL() {
        return this.rfURL;
    }

    public void setRfURL(String str) {
        this.rfURL = str;
    }

    public long getTimeStamp() {
        return this.timestamp;
    }

    public void setTimeStamp(long j) {
        this.timestamp = j;
    }
}
