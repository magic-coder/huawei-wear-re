package com.huawei.hwdevicedfxmanager.datatype;

public class BoneBroadcastJson {
    private int bugType;
    private String buildNumber;
    private String deviceID;
    private String productType;
    private int responseCode;
    private long uniqueID;

    public long getUniqueID() {
        return this.uniqueID;
    }

    public void setUniqueID(long j) {
        this.uniqueID = j;
    }

    public int getBugType() {
        return this.bugType;
    }

    public void setBugType(int i) {
        this.bugType = i;
    }

    public String getProductType() {
        return this.productType;
    }

    public void setProductType(String str) {
        this.productType = str;
    }

    public String getBuildNumber() {
        return this.buildNumber;
    }

    public void setBuildNumber(String str) {
        this.buildNumber = str;
    }

    public int getResponseCode() {
        return this.responseCode;
    }

    public void setResponseCode(int i) {
        this.responseCode = i;
    }

    public String getDeviceID() {
        return this.deviceID;
    }

    public void setDeviceID(String str) {
        this.deviceID = str;
    }
}
