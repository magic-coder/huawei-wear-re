package com.huawei.nfc.carrera.logic.cardinfo.model;

import android.graphics.Bitmap;

public class SupportedTrafficCardListItem {
    private String aid;
    private String cardName;
    private String issuerId;
    private Bitmap logo;
    private String productId;
    private int status;

    public String toString() {
        return "SupportedTrafficCardListItem{logo=" + this.logo + ", cardName='" + this.cardName + '\'' + ", status=" + this.status + ", issuerId='" + this.issuerId + '\'' + ", productId='" + this.productId + '\'' + ", aid='" + this.aid + '\'' + '}';
    }

    public static SupportedTrafficCardListItem build(Bitmap bitmap, String str, int i, String str2, String str3) {
        SupportedTrafficCardListItem supportedTrafficCardListItem = new SupportedTrafficCardListItem();
        supportedTrafficCardListItem.logo = bitmap;
        supportedTrafficCardListItem.cardName = str;
        supportedTrafficCardListItem.status = i;
        supportedTrafficCardListItem.issuerId = str2;
        supportedTrafficCardListItem.productId = str3;
        return supportedTrafficCardListItem;
    }

    public Bitmap getLogo() {
        return this.logo;
    }

    public String getCardName() {
        return this.cardName;
    }

    public int getStatus() {
        return this.status;
    }

    public String getIssuerId() {
        return this.issuerId;
    }

    public String getProductId() {
        return this.productId;
    }

    public String getAid() {
        return this.aid;
    }

    public void setLogo(Bitmap bitmap) {
        this.logo = bitmap;
    }

    public void setCardName(String str) {
        this.cardName = str;
    }

    public void setStatus(int i) {
        this.status = i;
    }

    public void setIssuerId(String str) {
        this.issuerId = str;
    }

    public void setProductId(String str) {
        this.productId = str;
    }

    public void setAid(String str) {
        this.aid = str;
    }
}
