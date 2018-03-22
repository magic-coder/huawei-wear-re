package com.huawei.hwcommonmodel.p063b;

import com.huawei.hwdevicedfxmanager.constants.HWDeviceDFXConstants;

/* compiled from: OTAErrorConstants */
public class C4715d {
    public static String m22592a(int i) {
        String str = "";
        switch (i) {
            case 100000:
                return HWDeviceDFXConstants.ERROR_CODE_INFO_OK;
            case 100001:
                return HWDeviceDFXConstants.ERROR_CODE_INFO_UNKNOW;
            case 100002:
                return HWDeviceDFXConstants.ERROR_CODE_INFO_REQUEST_UNSUPPORT;
            case 100003:
                return HWDeviceDFXConstants.ERROR_CODE_INFO_NO_PERMISSION;
            case 100004:
                return HWDeviceDFXConstants.ERROR_CODE_INFO_SYSTEM_BUSY;
            case 100005:
                return HWDeviceDFXConstants.ERROR_CODE_INFO_REQUEST_FORMAT_ERROR;
            case 100006:
                return HWDeviceDFXConstants.ERROR_CODE_INFO_REQUEST_PARAMETER_ERROR;
            case 100007:
                return HWDeviceDFXConstants.ERROR_CODE_INFO_SYSTEM_MEMORY_INADEQUATE;
            case 100008:
            case 100009:
                return HWDeviceDFXConstants.ERROR_CODE_INFO_RESPONSE_TIMEOUT;
            case HWDeviceDFXConstants.ERROR_CODE_NUMBER_HARDWARE_ERROR /*104001*/:
                return HWDeviceDFXConstants.ERROR_CODE_INFO_HARDWARE_ERROR;
            case HWDeviceDFXConstants.ERROR_CODE_NUMBER_BATTERY_LOW_POWE /*104002*/:
                return HWDeviceDFXConstants.ERROR_CODE_INFO_BATTERY_LOW_POWE;
            default:
                return str;
        }
    }
}
