package com.huawei.datatype;

public class PayAPDUInfo {
    private String apdu;
    private int channelID;
    private int reqid;

    public int getReqid() {
        return this.reqid;
    }

    public void setReqid(int i) {
        this.reqid = i;
    }

    public String getApdu() {
        return this.apdu;
    }

    public void setApdu(String str) {
        this.apdu = str;
    }

    public int getChannelID() {
        return this.channelID;
    }

    public void setChannelID(int i) {
        this.channelID = i;
    }
}
