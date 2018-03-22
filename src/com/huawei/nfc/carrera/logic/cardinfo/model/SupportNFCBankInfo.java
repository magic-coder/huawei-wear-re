package com.huawei.nfc.carrera.logic.cardinfo.model;

public class SupportNFCBankInfo {
    private String bankName;
    private String issuerId = "";
    public int mode;
    private int supportCardType;

    public String getIssuerId() {
        return this.issuerId;
    }

    public void setIssuerId(String str) {
        this.issuerId = str;
    }

    public String getNfcBankName() {
        return this.bankName;
    }

    public void setNfcBankName(String str) {
        this.bankName = str;
    }

    public int getSupportCardType() {
        return this.supportCardType;
    }

    public void setSupportCardType(int i) {
        this.supportCardType = i;
    }

    public int getMode() {
        return this.mode;
    }

    public void setMode(int i) {
        this.mode = i;
    }

    public String toString() {
        return "SupportNFCBankInfo{issuerId='" + this.issuerId + '\'' + ", bankName='" + this.bankName + '\'' + ", supportCardType=" + this.supportCardType + ", mode=" + this.mode + '}';
    }

    public void supportNFCBankInfoSAI1() {
    }

    public void supportNFCBankInfoSAI2() {
    }

    public void supportNFCBankInfoSAI3() {
    }

    public void supportNFCBankInfoSAI4() {
    }

    public void supportNFCBankInfoSAI5() {
    }
}
