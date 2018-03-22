package com.leisen.wallet.sdk.business;

public class AppletOperBusinessForReq extends BaseBusinessForReq {
    private String appAid;
    private String appletVersion;
    private int operType;

    public String getAppAid() {
        return this.appAid;
    }

    public void setAppAid(String str) {
        this.appAid = str;
    }

    public String getAppletVersion() {
        return this.appletVersion;
    }

    public void setAppletVersion(String str) {
        this.appletVersion = str;
    }

    public int getOperType() {
        return this.operType;
    }

    public void setOperType(int i) {
        this.operType = i;
    }
}
