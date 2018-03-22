package com.huawei.hwcloudmodel.model.kidsdevice;

import com.huawei.hwcloudmodel.model.CloudCommonReponse;

public class GetManagerNumRsp extends CloudCommonReponse {
    private String managerNum = "";

    public String getManagerPhoneNum() {
        return this.managerNum;
    }

    public void setManagerPhoneNum(String str) {
        this.managerNum = str;
    }

    public String toString() {
        return "GetManagerNumRsp{ managerNum = " + this.managerNum + '}';
    }
}
