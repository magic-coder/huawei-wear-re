package com.huawei.hwcloudmodel.model.userprofile;

import com.huawei.hwcloudmodel.model.CloudCommonReponse;

public class BindDeviceRsp extends CloudCommonReponse {
    private Long deviceCode = Long.valueOf(0);

    public Long getDeviceCode() {
        return this.deviceCode;
    }

    public void setDeviceCode(Long l) {
        this.deviceCode = l;
    }

    public String toString() {
        return "BindDeviceRsp{deviceCode=" + this.deviceCode + '}';
    }
}
