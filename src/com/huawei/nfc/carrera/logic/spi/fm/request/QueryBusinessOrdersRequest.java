package com.huawei.nfc.carrera.logic.spi.fm.request;

public class QueryBusinessOrdersRequest extends FMBaseRequest {
    private String aid;
    private int businessOrderType;
    private int[] orderStatuses;
    private byte[] seid;
    private int start;

    public static QueryBusinessOrdersRequest build(int i, int[] iArr, int i2, byte[] bArr, String str) {
        QueryBusinessOrdersRequest queryBusinessOrdersRequest = new QueryBusinessOrdersRequest();
        queryBusinessOrdersRequest.start = i;
        queryBusinessOrdersRequest.orderStatuses = iArr;
        queryBusinessOrdersRequest.businessOrderType = i2;
        queryBusinessOrdersRequest.seid = bArr;
        queryBusinessOrdersRequest.aid = str;
        return queryBusinessOrdersRequest;
    }

    public int getStart() {
        return this.start;
    }

    public void setStart(int i) {
        this.start = i;
    }

    public int[] getOrderStatuses() {
        return this.orderStatuses;
    }

    public void setOrderStatuses(int[] iArr) {
        this.orderStatuses = iArr;
    }

    public int getBusinessOrderType() {
        return this.businessOrderType;
    }

    public void setBusinessOrderType(int i) {
        this.businessOrderType = i;
    }

    public byte[] getSeid() {
        return this.seid;
    }

    public void setSeid(byte[] bArr) {
        this.seid = bArr;
    }

    public String getAid() {
        return this.aid;
    }

    public void setAid(String str) {
        this.aid = str;
    }
}
