package com.huawei.nfc.carrera.logic.spi.unionpay.impl;

import com.huawei.nfc.carrera.constant.AutoReportErrorCode;
import com.huawei.nfc.carrera.ui.bus.exception.ShowBindBusResultActivity;
import com.huawei.nfc.carrera.util.LogX;
import com.huawei.nfc.carrera.util.logger.CloudEyeLogger;
import java.util.HashMap;
import java.util.Map;

class CUPResponseCodeInterpreter {
    static final int CUP_RESULT_CODE_ALLREADY_DELETED = 1001311318;
    static final int CUP_RESULT_CODE_ALLREADY_DOWNLOADED = 1001311312;
    static final int CUP_RESULT_CODE_ALLREADY_DOWNLOADED1 = 1003011312;
    static final int CUP_RESULT_CODE_APPLET_INSTALL_FAIL = 1001311502;
    static final int CUP_RESULT_CODE_APPLET_UNEXISTS = 1001311307;
    static final int CUP_RESULT_CODE_CARD_STATE_ERR = 1001311343;
    static final int CUP_RESULT_CODE_CMD_ERR = 1001311599;
    static final int CUP_RESULT_CODE_CMD_ERR1 = 1003000011;
    static final int CUP_RESULT_CODE_PERSONLIZED_ERR = 1001311323;
    static final int CUP_RESULT_CODE_PERSONLIZING_DATA_UNEXISTS = 1001311326;
    static final int CUP_RESULT_CODE_SUCCESS = 10000;
    static final int CUP_RESULT_CODE_UPTSM_ERR = 1001311102;
    static final int CUP_RESULT_TSM_SERVICE_KILLED_EXCEPTION = 99999;

    CUPResponseCodeInterpreter() {
    }

    int translateReponseCode(int i, String str, String str2) {
        int i2 = 0;
        LogX.d("===123===translateReponseCode responseCodeStr = " + i);
        boolean z = i % 10000 == 1;
        LogX.d("===123===enter isNetworkErr =" + z);
        if (z) {
            return -3;
        }
        switch (Integer.valueOf(i).intValue()) {
            case 10000:
            case CUP_RESULT_CODE_ALLREADY_DOWNLOADED /*1001311312*/:
            case CUP_RESULT_CODE_ALLREADY_DELETED /*1001311318*/:
            case CUP_RESULT_CODE_ALLREADY_DOWNLOADED1 /*1003011312*/:
                break;
            case CUP_RESULT_TSM_SERVICE_KILLED_EXCEPTION /*99999*/:
                i2 = -4;
                break;
            case CUP_RESULT_CODE_UPTSM_ERR /*1001311102*/:
            case CUP_RESULT_CODE_APPLET_UNEXISTS /*1001311307*/:
            case CUP_RESULT_CODE_PERSONLIZING_DATA_UNEXISTS /*1001311326*/:
            case CUP_RESULT_CODE_CARD_STATE_ERR /*1001311343*/:
                i2 = -7;
                break;
            case CUP_RESULT_CODE_PERSONLIZED_ERR /*1001311323*/:
            case CUP_RESULT_CODE_APPLET_INSTALL_FAIL /*1001311502*/:
            case CUP_RESULT_CODE_CMD_ERR /*1001311599*/:
            case CUP_RESULT_CODE_CMD_ERR1 /*1003000011*/:
                i2 = -6;
                break;
            default:
                Map hashMap = new HashMap();
                hashMap.put(ShowBindBusResultActivity.FAIL_REASON_KEY, str2);
                hashMap.put("fail_action", str);
                hashMap.put(CloudEyeLogger.FAIL_CODE, String.valueOf(i));
                LogX.e(AutoReportErrorCode.ERROR_EVENT_ID_NFC_CUP_ADDON_ERR, hashMap, "not send from ese broadcast", true, false);
                i2 = -99;
                break;
        }
        LogX.d("===123===translateReponseCode responseCode123 = " + i2);
        return i2;
    }
}
