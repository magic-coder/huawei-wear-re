package com.leisen.wallet.sdk.business;

public class SSDOperBusinessForReq extends BaseBusinessForReq {
    private int operType;
    private String ssdAid;

    public String getSsdAid() {
        return this.ssdAid;
    }

    public void setSsdAid(String str) {
        this.ssdAid = str;
    }

    public int getOperType() {
        return this.operType;
    }

    public void setOperType(int i) {
        this.operType = i;
    }
}
