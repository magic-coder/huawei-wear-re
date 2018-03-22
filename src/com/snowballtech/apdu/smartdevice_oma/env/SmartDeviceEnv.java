package com.snowballtech.apdu.smartdevice_oma.env;

import com.snowballtech.common.code.WSBaseMessageCode;
import com.snowballtech.common.env.IEnv;
import com.snowballtech.common.log.LogUtil;
import com.snowballtech.common.util.JsonUtil;
import com.snowballtech.smartdevice.Device;
import java.util.HashMap;
import java.util.Map;

public class SmartDeviceEnv implements IEnv {
    private String TAG = "SmartDeviceEnv";
    private Device smartDevice = null;

    public Map<String, String> fetchEnv() {
        Map<String, String> hashMap = new HashMap();
        if (this.smartDevice != null) {
            if (this.smartDevice.getDevice_uid() != null) {
                hashMap.put(WSBaseMessageCode.HEADER_SNBPS_IMEI, this.smartDevice.getDevice_uid());
                LogUtil.log(this.TAG, "dev uuid return " + this.smartDevice.getDevice_uid());
            } else {
                LogUtil.log(this.TAG, "dev uuid is null ");
            }
            if (this.smartDevice.getDevice_model() != null) {
                hashMap.put(WSBaseMessageCode.HEADER_SNBPS_MOBMOD, this.smartDevice.getDevice_model());
                LogUtil.log(this.TAG, " deviceModel return " + this.smartDevice.getDevice_model());
            } else {
                LogUtil.log(this.TAG, "deviceModel is null ");
            }
            if (this.smartDevice.getDevice_vendor() != null) {
                hashMap.put(WSBaseMessageCode.HEADER_SNBPS_MOBVDR, this.smartDevice.getDevice_vendor());
                LogUtil.log(this.TAG, " vendor return " + this.smartDevice.getDevice_vendor());
            } else {
                LogUtil.log(this.TAG, "vendor is null ");
            }
        }
        return hashMap;
    }

    public void SetDevice(String str) {
        this.smartDevice = (Device) JsonUtil.getInstance().deSerializeString(str, Device.class);
        LogUtil.log(this.TAG, " SetDevice done ");
    }
}
