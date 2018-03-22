package com.huawei.hwcloudmodel.model.kidsdevice;

import com.huawei.hwcloudmodel.model.CloudCommonReponse;

public class ResetManagerRsp extends CloudCommonReponse {
    private static final String TAG = "ResetManagerRsp";
    private String imei = "";
    private long watchNo = 0;

    public String getImei() {
        return this.imei;
    }

    public void setImei(String str) {
        this.imei = str;
    }

    public long getwatchNo() {
        return this.watchNo;
    }

    public void setwatchNo(long j) {
        this.watchNo = j;
    }

    public String toString() {
        return "ResetManagerRsp{ imei = " + this.imei + " watchNo = " + this.watchNo + '}';
    }
}
