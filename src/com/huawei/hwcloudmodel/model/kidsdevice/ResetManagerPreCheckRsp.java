package com.huawei.hwcloudmodel.model.kidsdevice;

import com.huawei.hwcloudmodel.model.CloudCommonReponse;

public class ResetManagerPreCheckRsp extends CloudCommonReponse {
    private String imei = "";
    private String managerPhoneNum = "";

    public String getDeviceIMEI() {
        return this.imei;
    }

    public void setDeviceIMEI(String str) {
        this.imei = str;
    }

    public String getManagerPhoneNum() {
        return this.managerPhoneNum;
    }

    public void setManagerPhoneNum(String str) {
        this.managerPhoneNum = str;
    }

    public String toString() {
        return "ResetManagerPreCheckRsp{ imei = " + this.imei + " managerPhoneNum = " + this.managerPhoneNum + '}';
    }
}
