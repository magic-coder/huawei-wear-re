package com.huawei.nfc.carrera.logic.spi.fm.request;

public class ApplyRechargeOrderRequest extends FMBaseRequest {
    private byte[] actCode;
    private String aid;
    private int amount;

    public int getAmount() {
        return this.amount;
    }

    public void setAmount(int i) {
        this.amount = i;
    }

    public byte[] getActCode() {
        return this.actCode;
    }

    public void setActCode(byte[] bArr) {
        this.actCode = bArr;
    }

    public String getAid() {
        return this.aid;
    }

    public void setAid(String str) {
        this.aid = str;
    }

    public static ApplyRechargeOrderRequest build(int i, byte[] bArr, String str) {
        ApplyRechargeOrderRequest applyRechargeOrderRequest = new ApplyRechargeOrderRequest();
        applyRechargeOrderRequest.amount = i;
        applyRechargeOrderRequest.actCode = bArr;
        applyRechargeOrderRequest.aid = str;
        return applyRechargeOrderRequest;
    }
}
