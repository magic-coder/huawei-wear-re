package com.huawei.nfc.carrera.logic.spi.fm.request;

public class RechargeOrDoUnsolvedOrderRequest extends FMBaseRequest {
    private String aid;
    private byte[] order;

    public byte[] getOrder() {
        return this.order;
    }

    public void setOrder(byte[] bArr) {
        this.order = bArr;
    }

    public String getAid() {
        return this.aid;
    }

    public void setAid(String str) {
        this.aid = str;
    }
}
