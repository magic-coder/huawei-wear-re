package com.huawei.nfc.carrera.lifecycle.push.data;

public class PushCUPPersonalizedMessage {
    static final String CUP_PPMSG_KEY_AID = "aid";
    static final String CUP_PPMSG_KEY_CPLC = "cplc";
    static final String CUP_PPMSG_KEY_VIRTUAL_CARD_REF_ID = "cardRefId";
    static final String CUP_PPMSG_TYPE = "personizedPush";
    private String aid;
    private String cplc;
    private String virtualCardRefID;

    public String getCplc() {
        return this.cplc;
    }

    public void setCplc(String str) {
        this.cplc = str;
    }

    public String getVirtualCardRefID() {
        return this.virtualCardRefID;
    }

    public void setVirtualCardRefID(String str) {
        this.virtualCardRefID = str;
    }

    public String getAid() {
        return this.aid;
    }

    public void setAid(String str) {
        this.aid = str;
    }
}
