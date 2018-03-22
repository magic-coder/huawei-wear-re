package com.huawei.datatype;

public class PayOpenChannelInfo {
    private String apdu = "";
    private int channelID;

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
