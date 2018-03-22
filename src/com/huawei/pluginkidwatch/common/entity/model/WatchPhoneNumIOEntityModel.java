package com.huawei.pluginkidwatch.common.entity.model;

public class WatchPhoneNumIOEntityModel extends BaseEntityModel {
    private static final long serialVersionUID = 3381989301585026394L;
    public String deviceCode = "";
    public String phoneNum = "";
    public String securityCode = "";

    public void setWatchPhoneNumValue(String str, String str2, String str3) {
        this.deviceCode = str;
        this.phoneNum = str2;
        this.securityCode = str3;
    }

    public String toString() {
        return "  deviceCode = " + this.deviceCode + " phoneNum = " + this.phoneNum + " securityCode = " + this.securityCode;
    }
}
