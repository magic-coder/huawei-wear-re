package com.huawei.hms.update.p045a.p046a;

import com.huawei.nfc.carrera.logic.cardoperate.bus.callback.IssueTrafficCardCallback;

/* compiled from: UpdateStatus */
public final class C0893d {
    public static String m3123a(int i) {
        switch (i) {
            case 1000:
                return "CHECK_OK";
            case IssueTrafficCardCallback.RETURN_FAILED_CARD_CNT_REACH_LIMIT /*1101*/:
                return "CHECK_CANCELED";
            case 1201:
                return "CHECK_FAILURE";
            case 1202:
                return "CHECK_NO_UPDATE";
            case 1203:
                return "CHECK_NO_SUPPORTED";
            case 2000:
                return "DOWNLOAD_SUCCESS";
            case 2100:
                return "DOWNLOADING";
            case 2101:
                return "DOWNLOAD_CANCELED";
            case 2201:
                return "DOWNLOAD_FAILURE";
            case 2202:
                return "DOWNLOAD_HASH_ERROR";
            case 2203:
                return "DOWNLOAD_NO_SPACE";
            case 2204:
                return "DOWNLOAD_NO_STORAGE";
            default:
                return "UNKNOWN - " + Integer.toString(i);
        }
    }
}
