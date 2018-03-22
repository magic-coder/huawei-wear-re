package com.huawei.hms.support.api.pay;

public class PayResultInfo {
    private int f1382a;
    private String f1383b;
    private String f1384c;
    private String f1385d;
    private String f1386e;
    private String f1387f;
    private String f1388g;
    private String f1389h;
    private String f1390i;
    private String f1391j;
    private String f1392k;

    public int getReturnCode() {
        return this.f1382a;
    }

    public void setReturnCode(int i) {
        this.f1382a = i;
    }

    public String getErrMsg() {
        return this.f1383b;
    }

    public void setErrMsg(String str) {
        this.f1383b = str;
    }

    public String getOrderID() {
        return this.f1384c;
    }

    public void setOrderID(String str) {
        this.f1384c = str;
    }

    public String getAmount() {
        return this.f1385d;
    }

    public void setAmount(String str) {
        this.f1385d = str;
    }

    public String getCurrency() {
        return this.f1386e;
    }

    public void setCurrency(String str) {
        this.f1386e = str;
    }

    public String getCountry() {
        return this.f1387f;
    }

    public String getTime() {
        return this.f1388g;
    }

    public void setCountry(String str) {
        this.f1387f = str;
    }

    public void setTime(String str) {
        this.f1388g = str;
    }

    public String getWithholdID() {
        return this.f1389h;
    }

    public void setWithholdID(String str) {
        this.f1389h = str;
    }

    public String getRequestId() {
        return this.f1390i;
    }

    public void setRequestId(String str) {
        this.f1390i = str;
    }

    public String getUserName() {
        return this.f1391j;
    }

    public void setUserName(String str) {
        this.f1391j = str;
    }

    public String getSign() {
        return this.f1392k;
    }

    public void setSign(String str) {
        this.f1392k = str;
    }
}
