package com.huawei.nfc.carrera.logic.spi.fm.request;

public class QueryProductsRequest extends FMBaseRequest {
    private String aid;
    private String city4Current;
    private String city4sim;
    private String deviceModel;

    public String getAid() {
        return this.aid;
    }

    public void setAid(String str) {
        this.aid = str;
    }

    public String getDeviceModel() {
        return this.deviceModel;
    }

    public void setDeviceModel(String str) {
        this.deviceModel = str;
    }

    public String getCity4sim() {
        return this.city4sim;
    }

    public void setCity4sim(String str) {
        this.city4sim = str;
    }

    public String getCity4Current() {
        return this.city4Current;
    }

    public void setCity4Current(String str) {
        this.city4Current = str;
    }
}
