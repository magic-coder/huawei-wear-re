package com.huawei.crowdtestsdk.bases;

public class AuthRequestItem {
    private String deviceId;
    private int productFlag;
    private int queryFlag;
    private String sign;
    private String sn;
    private Long timeStamp;
    private String userName;

    public String getDeviceId() {
        return this.deviceId;
    }

    public void setDeviceId(String str) {
        this.deviceId = str;
    }

    public String getSn() {
        return this.sn;
    }

    public void setSn(String str) {
        this.sn = str;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String str) {
        this.userName = str;
    }

    public int getQueryFlag() {
        return this.queryFlag;
    }

    public void setQueryFlag(int i) {
        this.queryFlag = i;
    }

    public Long getTimeStamp() {
        return this.timeStamp;
    }

    public void setTimeStamp(Long l) {
        this.timeStamp = l;
    }

    public String getSign() {
        return this.sign;
    }

    public void setSign(String str) {
        this.sign = str;
    }

    public int getProductFlag() {
        return this.productFlag;
    }

    public void setProductFlag(int i) {
        this.productFlag = i;
    }

    public String toString() {
        return "AuthRequestItem{deviceId='" + this.deviceId + '\'' + ", sn='" + this.sn + '\'' + ", userName='" + this.userName + '\'' + ", queryFlag=" + this.queryFlag + ", productFlag=" + this.productFlag + ", timeStamp=" + this.timeStamp + ", sign='" + this.sign + '\'' + '}';
    }
}
