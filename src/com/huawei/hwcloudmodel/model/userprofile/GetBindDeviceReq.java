package com.huawei.hwcloudmodel.model.userprofile;

public class GetBindDeviceReq {
    private Long deviceCode;

    public Long getDeviceCode() {
        return this.deviceCode;
    }

    public void setDeviceCode(Long l) {
        this.deviceCode = l;
    }

    public String toString() {
        return "GetBindDeviceReq{deviceCode=" + this.deviceCode + '}';
    }
}
