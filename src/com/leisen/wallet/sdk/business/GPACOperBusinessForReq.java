package com.leisen.wallet.sdk.business;

public class GPACOperBusinessForReq extends BaseBusinessForReq {
    private String appAid;
    private int operType;

    public String getAppAid() {
        return this.appAid;
    }

    public void setAppAid(String str) {
        this.appAid = str;
    }

    public int getOperType() {
        return this.operType;
    }

    public void setOperType(int i) {
        this.operType = i;
    }
}
