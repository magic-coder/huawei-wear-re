package com.huawei.pluginkidwatch.common.entity.model;

public class BindDeviceIOEntityModel extends BaseEntityModel {
    private static final long serialVersionUID = 8410434297630866357L;
    public int bindType = 0;
    public String deviceCode = "";
    public String imei = "";
    public String nickname = "";
    public String phoneNum = "";
    public String type = "0";

    public void setBindDevice(String str, String str2, String str3, int i) {
        this.imei = str;
        this.nickname = str2;
        this.type = str3;
        this.bindType = i;
    }

    public String toString() {
        return " deviceCode=" + this.deviceCode + " nickname=" + this.nickname + " imei=" + this.imei + " phoneNum=" + this.phoneNum + ", bindType = " + this.bindType;
    }

    public void getBindIOModelNameByBindIOModel() {
    }

    public void requestBindIOModelHeadUrl() {
    }

    public void downloadBindIOModelNameUrl() {
    }

    public void judgeBindIOModelWeightBySomeInfo() {
    }

    public void setBindIOModelSwitchUpload() {
    }

    public void updataBindIOModelLocalTable() {
    }

    public void dealWithBindIOModelResetFactory() {
    }

    public void refreshBindIOModelInitData() {
    }

    public void queryBindIOModelProcessData() {
    }

    public void contrustBindIOModelHeadImage() {
    }

    public void changeBindIOModelDeviceInfo() {
    }
}
