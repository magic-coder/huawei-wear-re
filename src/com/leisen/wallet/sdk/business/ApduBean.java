package com.leisen.wallet.sdk.business;

public class ApduBean {
    private String apdu;
    private int index;
    private String[] sw;

    public ApduBean(String str) {
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

    public String[] getSw() {
        return this.sw;
    }

    public void setSw(String[] strArr) {
        this.sw = strArr;
    }
}
