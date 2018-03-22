package com.huawei.nfc.carrera.logic.spi.fm.request;

public class ApplyIssueOrderRequest extends FMBaseRequest {
    private byte[] actCode;
    private String aid;
    private int amount;
    private String module;
    private String productCode;
    private byte[] seid;

    public int getAmount() {
        return this.amount;
    }

    public byte[] getSeid() {
        return this.seid;
    }

    public String getModule() {
        return this.module;
    }

    public byte[] getActCode() {
        return this.actCode;
    }

    public void setAmount(int i) {
        this.amount = i;
    }

    public void setSeid(byte[] bArr) {
        this.seid = bArr;
    }

    public void setModule(String str) {
        this.module = str;
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

    public String getProductCode() {
        return this.productCode;
    }

    public void setProductCode(String str) {
        this.productCode = str;
    }

    public static ApplyIssueOrderRequest build(int i, byte[] bArr, String str, byte[] bArr2, String str2) {
        ApplyIssueOrderRequest applyIssueOrderRequest = new ApplyIssueOrderRequest();
        applyIssueOrderRequest.amount = i;
        applyIssueOrderRequest.seid = bArr;
        applyIssueOrderRequest.module = str;
        applyIssueOrderRequest.actCode = bArr2;
        applyIssueOrderRequest.aid = str2;
        return applyIssueOrderRequest;
    }

    public static ApplyIssueOrderRequest build(String str, byte[] bArr, String str2, byte[] bArr2, String str3) {
        ApplyIssueOrderRequest applyIssueOrderRequest = new ApplyIssueOrderRequest();
        applyIssueOrderRequest.productCode = str;
        applyIssueOrderRequest.seid = bArr;
        applyIssueOrderRequest.module = str2;
        applyIssueOrderRequest.actCode = bArr2;
        applyIssueOrderRequest.aid = str3;
        return applyIssueOrderRequest;
    }
}
