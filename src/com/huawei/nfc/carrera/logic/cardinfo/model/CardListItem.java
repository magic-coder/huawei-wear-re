package com.huawei.nfc.carrera.logic.cardinfo.model;

public class CardListItem {
    private String aid;
    private int cardGroup;
    private String cardIconLocalPath;
    private String fontColor;
    private String fpanFour;
    private boolean isDefault;
    private String productId;
    private String referenceId;
    private long statusUpdateTime;

    public String getAid() {
        return this.aid;
    }

    public void setAid(String str) {
        this.aid = str;
    }

    public String getReferenceId() {
        return this.referenceId;
    }

    public void setReferenceId(String str) {
        this.referenceId = str;
    }

    public String getProductId() {
        return this.productId;
    }

    public void setProductId(String str) {
        this.productId = str;
    }

    public int getCardGroup() {
        return this.cardGroup;
    }

    public void setCardGroup(int i) {
        this.cardGroup = i;
    }

    public boolean isDefault() {
        return this.isDefault;
    }

    public void setDefault(boolean z) {
        this.isDefault = z;
    }

    public String getFpanFour() {
        return this.fpanFour;
    }

    public void setFpanFour(String str) {
        this.fpanFour = str;
    }

    public long getStatusUpdateTime() {
        return this.statusUpdateTime;
    }

    public void setStatusUpdateTime(long j) {
        this.statusUpdateTime = j;
    }

    public String getCardIconLocalPath() {
        return this.cardIconLocalPath;
    }

    public void setCardIconLocalPath(String str) {
        this.cardIconLocalPath = str;
    }

    public String getFontColor() {
        return this.fontColor;
    }

    public void setFontColor(String str) {
        this.fontColor = str;
    }
}
