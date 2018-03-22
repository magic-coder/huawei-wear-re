package com.huawei.nfc.carrera.lifecycle.push.data;

public class PushConsumeMessage {
    static final String CONSUME_PUSH_MSG_KEY_AMOUNT = "amount";
    static final String CONSUME_PUSH_MSG_KEY_CPLC = "cplc";
    static final String CONSUME_PUSH_MSG_KEY_CURRENCY = "currency";
    static final String CONSUME_PUSH_MSG_KEY_MERCHANTNAME = "merchantName";
    static final String CONSUME_PUSH_MSG_KEY_PRODUCTNAME = "productName";
    static final String CONSUME_PUSH_MSG_KEY_TIME = "time";
    static final String CONSUME_PUSH_MSG_TYPE = "consume";
    private String consumeAccount;
    private String consumeTime;
    private String cplc;
    private String currency;
    private String merchantName;
    private String productName;

    public String getCplc() {
        return this.cplc;
    }

    public void setCplc(String str) {
        this.cplc = str;
    }

    public String getConsumeTime() {
        return this.consumeTime;
    }

    public void setConsumeTime(String str) {
        this.consumeTime = str;
    }

    public String getConsumeAccount() {
        return this.consumeAccount;
    }

    public void setConsumeAccount(String str) {
        this.consumeAccount = str;
    }

    public String getCurrency() {
        return this.currency;
    }

    public void setCurrency(String str) {
        this.currency = str;
    }

    public String getMerchantName() {
        return this.merchantName;
    }

    public void setMerchantName(String str) {
        this.merchantName = str;
    }

    public String getProductName() {
        return this.productName;
    }

    public void setProductName(String str) {
        this.productName = str;
    }
}
