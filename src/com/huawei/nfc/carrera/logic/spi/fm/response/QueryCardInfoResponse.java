package com.huawei.nfc.carrera.logic.spi.fm.response;

public class QueryCardInfoResponse extends FMBaseResponse {
    private int balance;
    private String cardNo = null;
    private String time4Validity;

    public int getBalance() {
        return this.balance;
    }

    public void setBalance(int i) {
        this.balance = i;
    }

    public String getCardNo() {
        return this.cardNo;
    }

    public void setCardNo(String str) {
        this.cardNo = str;
    }

    public String getTime4Validity() {
        return this.time4Validity;
    }

    public void setTime4Validity(String str) {
        this.time4Validity = str;
    }
}
