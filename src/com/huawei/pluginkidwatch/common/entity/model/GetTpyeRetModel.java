package com.huawei.pluginkidwatch.common.entity.model;

public class GetTpyeRetModel extends BaseEntityModel {
    private static final long serialVersionUID = 9077384547756030938L;
    public String deviceCode = "-1";
    public String nickname;
    public String phoneNum;
    public String type;

    public String toString() {
        return "GetTpyeRetModel [deviceCode=" + this.deviceCode + ", type=" + this.type + ", phoneNum=" + this.phoneNum + ", nickname=" + this.nickname + "]";
    }

    public void retModelType() {
    }

    public void setPhoneNumByNickname() {
    }

    public void setNickNameByDeviceCode() {
    }

    public void processNickNameDeviceCode() {
    }
}
