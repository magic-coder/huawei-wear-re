package com.snowballtech.business.bean;

public class WSProviderBean {
    public String category;
    private String cplc;
    private String data;
    private String extra_info;
    public String instance_id;
    public String operation;
    private String refundData;
    private String result;
    public String sp_id;
    private String tag;
    public String token;

    public String getCategory() {
        return this.category;
    }

    public void setCategory(String str) {
        this.category = str;
    }

    public String getOperation() {
        return this.operation;
    }

    public void setOperation(String str) {
        this.operation = str;
    }

    public String getExtra_info() {
        return this.extra_info;
    }

    public void setExtra_info(String str) {
        this.extra_info = str;
    }

    public String getInstance_id() {
        return this.instance_id;
    }

    public void setInstance_id(String str) {
        this.instance_id = str;
    }

    public String getToken() {
        return this.token;
    }

    public void setToken(String str) {
        this.token = str;
    }

    public String getSp_id() {
        return this.sp_id;
    }

    public void setSp_id(String str) {
        this.sp_id = str;
    }

    public String getCplc() {
        return this.cplc;
    }

    public void setCplc(String str) {
        this.cplc = str;
    }

    public String getResult() {
        return this.result;
    }

    public void setResult(String str) {
        this.result = str;
    }

    public String getTag() {
        return this.tag;
    }

    public void setTag(String str) {
        this.tag = str;
    }

    public String getData() {
        return this.data;
    }

    public void setData(String str) {
        this.data = str;
    }

    public String getRefundData() {
        return this.refundData;
    }

    public void setRefundData(String str) {
        this.refundData = str;
    }
}
