package com.huawei.nfc.carrera.logic.spi.serveraccess.model;

public class IssueAmount {
    private String amountEnroll = null;
    private String amountRecharge = null;
    private String denomination = null;
    private String priceEnroll = null;
    private String priceRecharge = null;

    public IssueAmount(String str, String str2, String str3) {
        this.denomination = str;
        this.priceEnroll = str2;
        this.priceRecharge = str3;
    }

    public String getDenomination() {
        return this.denomination;
    }

    public void setDenomination(String str) {
        this.denomination = str;
    }

    public String getPriceEnroll() {
        return this.priceEnroll;
    }

    public void setPriceEnroll(String str) {
        this.priceEnroll = str;
    }

    public String getAmountEnroll() {
        return this.amountEnroll;
    }

    public void setAmountEnroll(String str) {
        this.amountEnroll = str;
    }

    public String getPriceRecharge() {
        return this.priceRecharge;
    }

    public void setPriceRecharge(String str) {
        this.priceRecharge = str;
    }

    public String getAmountRecharge() {
        return this.amountRecharge;
    }

    public void setAmountRecharge(String str) {
        this.amountRecharge = str;
    }
}
