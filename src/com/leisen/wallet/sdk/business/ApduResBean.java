package com.leisen.wallet.sdk.business;

public class ApduResBean {
    private String apdu;
    private int index;
    private String sw;

    public ApduResBean(String str) {
        this.apdu = str;
    }

    public int getIndex() {
        return this.index;
    }

    public void setIndex(int i) {
        this.index = i;
    }

    public String getApdu() {
        return this.apdu;
    }

    public void setApdu(String str) {
        this.apdu = str;
    }

    public String getSw() {
        return this.sw;
    }

    public void setSw(String str) {
        this.sw = str;
    }
}
