package com.huawei.nfc.carrera.server.card.response;

public class QueryUnionPayPushResponse extends CardServerBaseResponse {
    private String pushMsg;
    private String pushTime;
    private String systemCurrentTime;

    public String getPushMsg() {
        return this.pushMsg;
    }

    public void setPushMsg(String str) {
        this.pushMsg = str;
    }

    public String getPushTime() {
        return this.pushTime;
    }

    public void setPushTime(String str) {
        this.pushTime = str;
    }

    public String getSystemCurrentTime() {
        return this.systemCurrentTime;
    }

    public void setSystemCurrentTime(String str) {
        this.systemCurrentTime = str;
    }
}
