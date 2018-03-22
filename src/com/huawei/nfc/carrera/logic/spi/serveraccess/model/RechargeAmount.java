package com.huawei.nfc.carrera.logic.spi.serveraccess.model;

public class RechargeAmount {
    private String amountRecharge = null;
    private String denomination = null;

    public RechargeAmount(String str, String str2) {
        this.denomination = str;
        this.amountRecharge = str2;
    }

    public String getDenomination() {
        return this.denomination;
    }

    public void setDenomination(String str) {
        this.denomination = str;
    }

    public String getAmountRecharge() {
        return this.amountRecharge;
    }

    public void setAmountRecharge(String str) {
        this.amountRecharge = str;
    }
}
