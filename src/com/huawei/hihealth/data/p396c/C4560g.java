package com.huawei.hihealth.data.p396c;

import com.huawei.hwid.core.constants.HwAccountConstants;
import com.huawei.pluginmessagecenter.service.MessageObserver;

/* compiled from: HiSyncType */
public class C4560g {
    public static boolean m21813a(int i) {
        switch (i) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 10001:
            case 10002:
            case HwAccountConstants.MY_PERMISSIONS_REQUEST_READ_PHONE_STATE /*10003*/:
            case 10004:
            case MessageObserver.RET_AUTH_ERROR /*10005*/:
            case HwAccountConstants.MY_PERMISSIONS_REQUEST_lOCTION /*10006*/:
            case 10007:
            case MessageObserver.RET_CHECK_PARAM_ERROR /*10008*/:
            case 20000:
                return true;
            default:
                return false;
        }
    }
}
