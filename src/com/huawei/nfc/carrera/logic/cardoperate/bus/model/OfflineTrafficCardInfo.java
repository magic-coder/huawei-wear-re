package com.huawei.nfc.carrera.logic.cardoperate.bus.model;

public class OfflineTrafficCardInfo {
    private String balance = "0";
    private String cardNo;
    private String expireDate;
    private String startdate;

    public String getCardNo() {
        return this.cardNo;
    }

    public void setCardNo(String str) {
        this.cardNo = str;
    }

    public String getBalance() {
        return this.balance;
    }

    public void setBalance(String str) {
        this.balance = str;
    }

    public String getExpireDate() {
        return this.expireDate;
    }

    public void setExpireDate(String str) {
        this.expireDate = str;
    }

    public String getStartdate() {
        return this.startdate;
    }

    public void setStartdate(String str) {
        this.startdate = str;
    }
}
