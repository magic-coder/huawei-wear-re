package com.huawei.pluginkidwatch.common.entity.model;

public class WatchSecurityCodeIOEntityModel extends BaseEntityModel {
    private static final long serialVersionUID = 7792862515411955231L;
    public String deviceCode = "";
    public String phoneNum = "";

    public void setWatchPhoneNum(String str, String str2) {
        this.deviceCode = str;
        this.phoneNum = str2;
    }

    public String toString() {
        return "  deviceCode" + this.deviceCode + "  phoneNum = " + this.phoneNum;
    }
}
