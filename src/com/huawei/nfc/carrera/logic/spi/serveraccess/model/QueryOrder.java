package com.huawei.nfc.carrera.logic.spi.serveraccess.model;

public class QueryOrder {
    public static final String ORDER_TYPE_OPEN_CARD = "0";
    public static final String ORDER_TYPE_OPEN_CARD_AND_RECHARGE = "2";
    public static final String ORDER_TYPE_RECHARGE = "1";
    public static final String STATUS_CREATE_SSD_FAIL = "801";
    public static final String STATUS_DOWNLOAD_CAP_FAIL = "802";
    public static final String STATUS_OPEN_CARD_SUCCESS = "804";
    public static final String STATUS_OTHER = "999";
    public static final String STATUS_PERSONALIZED_FAIL = "803";
    public static final String STATUS_RECHARGE_FAIL = "900";
    public static final String STATUS_RECHARGE_SUCCESS = "902";
    public static final String STATUS_RECHARGE_UNKNOWN = "906";
    public static final String STATUS_REFUND_FAIL = "903";
    private String amount = null;
    private String currency = null;
    private String issuerId = null;
    private String orderId = null;
    private String orderTime = null;
    private String orderType = null;
    private String status = null;

    public String getCurrency() {
        return this.currency;
    }

    public void setCurrency(String str) {
        this.currency = str;
    }

    public String getOrderTime() {
        return this.orderTime;
    }

    public void setOrderTime(String str) {
        this.orderTime = str;
    }

    public String getAmount() {
        return this.amount;
    }

    public void setAmount(String str) {
        this.amount = str;
    }

    public String getOrderId() {
        return this.orderId;
    }

    public void setOrderId(String str) {
        this.orderId = str;
    }

    public String getOrderType() {
        return this.orderType;
    }

    public void setOrderType(String str) {
        this.orderType = str;
    }

    public String getIssuerId() {
        return this.issuerId;
    }

    public void setIssuerId(String str) {
        this.issuerId = str;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String str) {
        this.status = str;
    }
}
