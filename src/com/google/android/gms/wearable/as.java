package com.google.android.gms.wearable;

import com.google.android.gms.common.api.C0377o;
import com.huawei.nfc.carrera.logic.spi.serveraccess.response.BaseResponse;

public final class as extends C0377o {
    public static String m1714b(int i) {
        switch (i) {
            case 4000:
                return "TARGET_NODE_NOT_CONNECTED";
            case 4001:
                return "DUPLICATE_LISTENER";
            case 4002:
                return "UNKNOWN_LISTENER";
            case BaseResponse.RESULT_CODE_RECHARGE_SP_SERVER_ERROR /*4003*/:
                return "DATA_ITEM_TOO_LARGE";
            case BaseResponse.RESULT_CODE_RECHARGE_ABNORMAL_APPLET /*4004*/:
                return "INVALID_TARGET_NODE";
            case 4005:
                return "ASSET_UNAVAILABLE";
            default:
                return C0377o.m372a(i);
        }
    }
}
