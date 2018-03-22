package com.snowballtech.business.bean;

public class HciData {
    private String amount;
    private String balance;
    private String currency;
    private String instance_id;
    private String trans_type;

    public String getInstance_id() {
        return this.instance_id;
    }

    public void setInstance_id(String str) {
        this.instance_id = str;
    }

    public String getTrans_type() {
        return this.trans_type;
    }

    public void setTrans_type(String str) {
        this.trans_type = str;
    }

    public String getCurrency() {
        return this.currency;
    }

    public void setCurrency(String str) {
        this.currency = str;
    }

    public String getAmount() {
        return this.amount;
    }

    public void setAmount(String str) {
        this.amount = str;
    }

    public String getBalance() {
        return this.balance;
    }

    public void setBalance(String str) {
        this.balance = str;
    }
}
