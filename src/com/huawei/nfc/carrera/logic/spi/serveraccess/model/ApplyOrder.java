package com.huawei.nfc.carrera.logic.spi.serveraccess.model;

import com.huawei.hwcommonmodel.p064d.C0978h;

public class ApplyOrder {
    public static final String ORDER_TYPE_OPEN_CARD = "0";
    public static final String ORDER_TYPE_OPEN_CARD_AND_RECHARGE = "2";
    public static final String ORDER_TYPE_RECHARGE = "1";
    private String SPMerchantId = null;
    private String accessMode = null;
    private String amount = null;
    private String applicationId = null;
    private String currency = null;
    private String merchantName = null;
    private String orderId = null;
    private String orderTime = null;
    private String orderType = null;
    private String packageName = null;
    private String productDesc = null;
    private String productName = null;
    private String sdkChannel = "0";
    private String serviceCatalog = null;
    private String sign = null;
    private String signType = null;
    private String url = null;
    private String urlVer = null;

    public String getSdkChannel() {
        return (String) C0978h.a(this.sdkChannel);
    }

    public void setSdkChannel(String str) {
        this.sdkChannel = (String) C0978h.a(str);
    }

    public String getUrl() {
        return (String) C0978h.a(this.url);
    }

    public void setUrl(String str) {
        this.url = (String) C0978h.a(str);
    }

    public String getUrlVer() {
        return (String) C0978h.a(this.urlVer);
    }

    public void setUrlVer(String str) {
        this.urlVer = (String) C0978h.a(str);
    }

    public String getOrderId() {
        return (String) C0978h.a(this.orderId);
    }

    public void setOrderId(String str) {
        this.orderId = (String) C0978h.a(str);
    }

    public String getSPMerchantId() {
        return (String) C0978h.a(this.SPMerchantId);
    }

    public void setSPMerchantId(String str) {
        this.SPMerchantId = (String) C0978h.a(str);
    }

    public String getMerchantName() {
        return (String) C0978h.a(this.merchantName);
    }

    public void setMerchantName(String str) {
        this.merchantName = (String) C0978h.a(str);
    }

    public String getApplicationId() {
        return (String) C0978h.a(this.applicationId);
    }

    public void setApplicationId(String str) {
        this.applicationId = (String) C0978h.a(str);
    }

    public String getPackageName() {
        return (String) C0978h.a(this.packageName);
    }

    public void setPackageName(String str) {
        this.packageName = (String) C0978h.a(str);
    }

    public String getAccessMode() {
        return (String) C0978h.a(this.accessMode);
    }

    public void setAccessMode(String str) {
        this.accessMode = (String) C0978h.a(str);
    }

    public String getServiceCatalog() {
        return (String) C0978h.a(this.serviceCatalog);
    }

    public void setServiceCatalog(String str) {
        this.serviceCatalog = (String) C0978h.a(str);
    }

    public String getProductName() {
        return (String) C0978h.a(this.productName);
    }

    public void setProductName(String str) {
        this.productName = (String) C0978h.a(str);
    }

    public String getProductDesc() {
        return (String) C0978h.a(this.productDesc);
    }

    public void setProductDesc(String str) {
        this.productDesc = (String) C0978h.a(str);
    }

    public String getSignType() {
        return (String) C0978h.a(this.signType);
    }

    public void setSignType(String str) {
        this.signType = (String) C0978h.a(str);
    }

    public String getSign() {
        return (String) C0978h.a(this.sign);
    }

    public void setSign(String str) {
        this.sign = (String) C0978h.a(str);
    }

    public String getAmount() {
        return (String) C0978h.a(this.amount);
    }

    public void setAmount(String str) {
        this.amount = (String) C0978h.a(str);
    }

    public String getCurrency() {
        return (String) C0978h.a(this.currency);
    }

    public void setCurrency(String str) {
        this.currency = (String) C0978h.a(str);
    }

    public String getOrderType() {
        return (String) C0978h.a(this.orderType);
    }

    public void setOrderType(String str) {
        this.orderType = (String) C0978h.a(str);
    }

    public String getOrderTime() {
        return (String) C0978h.a(this.orderTime);
    }

    public void setOrderTime(String str) {
        this.orderTime = (String) C0978h.a(str);
    }
}
