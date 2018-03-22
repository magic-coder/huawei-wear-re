package com.huawei.nfc.carrera.lifecycle.push.data;

public class PushLostMessage {
    static final String LOST_PUSH_MSG_KEY_AID = "aid";
    static final String LOST_PUSH_MSG_KEY_CPLC = "cplc";
    static final String LOST_PUSH_MSG_KEY_DPANID = "dpanid";
    static final String LOST_PUSH_MSG_KEY_STATUS = "status";
    static final String LOST_PUSH_MSG_TYPE = "reportloss";
    private String aid;
    private String cplc;
    private String dpanid;
    private String status;

    public String getCplc() {
        return this.cplc;
    }

    public void setCplc(String str) {
        this.cplc = str;
    }

    public String getAid() {
        return this.aid;
    }

    public void setAid(String str) {
        this.aid = str;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String str) {
        this.status = str;
    }

    public String getDpanid() {
        return this.dpanid;
    }

    public void setDpanid(String str) {
        this.dpanid = str;
    }
}
