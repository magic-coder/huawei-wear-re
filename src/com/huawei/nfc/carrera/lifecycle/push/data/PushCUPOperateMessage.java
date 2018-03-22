package com.huawei.nfc.carrera.lifecycle.push.data;

import java.util.ArrayList;

public class PushCUPOperateMessage {
    static final String CUP_PUSH_MSG_KEY_CPLC = "cplc";
    static final String CUP_PUSH_MSG_KEY_TSMLIBDATA = "tsmLibData";
    static final String CUP_PUSH_MSG_KEY_VIRTUAL_CARD = "virtualCards";
    static final String CUP_PUSH_MSG_TYPE = "UnionPayPush";
    static final String TSMLIBDATA_KEY_EVENT = "event";
    static final String TSMLIBDATA_KEY_SIGN = "sign";
    static final String TSMLIBDATA_KEY_SSID = "ssid";
    private String cplc;
    private String event;
    private String sign;
    private String ssid;
    private ArrayList<String> virtualCards;

    public String getCplc() {
        return this.cplc;
    }

    public void setCplc(String str) {
        this.cplc = str;
    }

    public ArrayList<String> getVirtualCards() {
        return this.virtualCards;
    }

    public void setVirtualCards(ArrayList<String> arrayList) {
        this.virtualCards = arrayList;
    }

    public String getSsid() {
        return this.ssid;
    }

    public void setSsid(String str) {
        this.ssid = str;
    }

    public String getSign() {
        return this.sign;
    }

    public void setSign(String str) {
        this.sign = str;
    }

    public String getEvent() {
        return this.event;
    }

    public void setEvent(String str) {
        this.event = str;
    }
}
