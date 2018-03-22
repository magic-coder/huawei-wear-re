package com.huawei.crowdtestsdk.bases.bean_new;

public class CloudLoginBean {
    private String appID;
    private String deviceId;
    private Integer deviceType;
    private Integer loginChannel;
    private String serviceToken;
    private String siteId;
    private String terminalType;
    private String userName;

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String str) {
        this.userName = str;
    }

    public String getServiceToken() {
        return this.serviceToken;
    }

    public void setServiceToken(String str) {
        this.serviceToken = str;
    }

    public String getDeviceId() {
        return this.deviceId;
    }

    public void setDeviceId(String str) {
        this.deviceId = str;
    }

    public Integer getDeviceType() {
        return this.deviceType;
    }

    public void setDeviceType(Integer num) {
        this.deviceType = num;
    }

    public String getTerminalType() {
        return this.terminalType;
    }

    public void setTerminalType(String str) {
        this.terminalType = str;
    }

    public String getAppID() {
        return this.appID;
    }

    public void setAppID(String str) {
        this.appID = str;
    }

    public Integer getLoginChannel() {
        return this.loginChannel;
    }

    public void setLoginChannel(Integer num) {
        this.loginChannel = num;
    }

    public String getSiteId() {
        return this.siteId;
    }

    public void setSiteId(String str) {
        this.siteId = str;
    }

    public String toString() {
        return "CloudLoginBean{userName='" + this.userName + '\'' + ", serviceToken='" + this.serviceToken + '\'' + ", deviceId='" + this.deviceId + '\'' + ", deviceType=" + this.deviceType + ", terminalType='" + this.terminalType + '\'' + ", appID='" + this.appID + '\'' + ", loginChannel=" + this.loginChannel + ", siteId='" + this.siteId + '\'' + '}';
    }
}
