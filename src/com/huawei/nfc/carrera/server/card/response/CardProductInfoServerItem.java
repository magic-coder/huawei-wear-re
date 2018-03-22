package com.huawei.nfc.carrera.server.card.response;

import com.huawei.hwcommonmodel.p064d.C0978h;

public class CardProductInfoServerItem {
    private String description;
    private String fontColor;
    private String issuerId;
    private String mktInfo;
    private String pictureUrl;
    private String productId;
    private String productName;
    private String reserved1;
    private String reserved2;
    private String reserved3;
    private String reserved4;
    private String reserved5;
    private String reserved6;
    private String reservedInfo;
    private long timeStamp;
    private int type;
    private String version;

    public String getProductId() {
        return (String) C0978h.a(this.productId);
    }

    public void setProductId(String str) {
        this.productId = (String) C0978h.a(str);
    }

    public String getProductName() {
        return (String) C0978h.a(this.productName);
    }

    public void setProductName(String str) {
        this.productName = (String) C0978h.a(str);
    }

    public String getPictureUrl() {
        return (String) C0978h.a(this.pictureUrl);
    }

    public void setPictureUrl(String str) {
        this.pictureUrl = (String) C0978h.a(str);
    }

    public String getDescription() {
        return (String) C0978h.a(this.description);
    }

    public void setDescription(String str) {
        this.description = (String) C0978h.a(str);
    }

    public int getType() {
        return ((Integer) C0978h.a(Integer.valueOf(this.type))).intValue();
    }

    public void setType(int i) {
        this.type = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public long getTimeStamp() {
        return ((Long) C0978h.a(Long.valueOf(this.timeStamp))).longValue();
    }

    public void setTimeStamp(long j) {
        this.timeStamp = ((Long) C0978h.a(Long.valueOf(j))).longValue();
    }

    public String getVersion() {
        return (String) C0978h.a(this.version);
    }

    public void setVersion(String str) {
        this.version = (String) C0978h.a(str);
    }

    public String getIssuerId() {
        return (String) C0978h.a(this.issuerId);
    }

    public void setIssuerId(String str) {
        this.issuerId = (String) C0978h.a(str);
    }

    public String getMktInfo() {
        return (String) C0978h.a(this.mktInfo);
    }

    public void setMktInfo(String str) {
        this.mktInfo = (String) C0978h.a(str);
    }

    public String getReservedInfo() {
        return (String) C0978h.a(this.reservedInfo);
    }

    public void setReservedInfo(String str) {
        this.reservedInfo = (String) C0978h.a(str);
    }

    public String getFontColor() {
        return (String) C0978h.a(this.fontColor);
    }

    public void setFontColor(String str) {
        this.fontColor = (String) C0978h.a(str);
    }

    public String getReserved1() {
        return (String) C0978h.a(this.reserved1);
    }

    public void setReserved1(String str) {
        this.reserved1 = (String) C0978h.a(str);
    }

    public String getReserved2() {
        return (String) C0978h.a(this.reserved2);
    }

    public void setReserved2(String str) {
        this.reserved2 = (String) C0978h.a(str);
    }

    public String getReserved3() {
        return (String) C0978h.a(this.reserved3);
    }

    public void setReserved3(String str) {
        this.reserved3 = (String) C0978h.a(str);
    }

    public String getReserved4() {
        return (String) C0978h.a(this.reserved4);
    }

    public void setReserved4(String str) {
        this.reserved4 = (String) C0978h.a(str);
    }

    public String getReserved5() {
        return (String) C0978h.a(this.reserved5);
    }

    public void setReserved5(String str) {
        this.reserved5 = (String) C0978h.a(str);
    }

    public String getReserved6() {
        return (String) C0978h.a(this.reserved6);
    }

    public void setReserved6(String str) {
        this.reserved6 = (String) C0978h.a(str);
    }
}
