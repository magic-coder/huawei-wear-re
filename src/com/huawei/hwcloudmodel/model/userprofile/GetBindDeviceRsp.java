package com.huawei.hwcloudmodel.model.userprofile;

import com.huawei.hwcloudmodel.model.CloudCommonReponse;
import java.util.List;

public class GetBindDeviceRsp extends CloudCommonReponse {
    private List<DeviceInfo> deviceInfos;

    public List<DeviceInfo> getDeviceInfos() {
        return this.deviceInfos;
    }

    public void setDeviceInfos(List<DeviceInfo> list) {
        this.deviceInfos = list;
    }

    public String toString() {
        return "GetBindDeviceRsp{deviceInfos=" + this.deviceInfos + '}';
    }
}
