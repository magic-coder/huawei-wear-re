package com.snowballtech.apdu.util;

import com.snowballtech.apdu.constant.CodeMessage;
import com.snowballtech.apdu.smartdevice_oma.constant.SmartDeviceCode;
import com.snowballtech.common.util.ValueUtil;

public class Utils {
    public static int convertDetailErrorCodeForSe(int i, String str) {
        if (ValueUtil.isEmpty(str)) {
            return i;
        }
        if (str.toLowerCase().contains("nfcee_access.xml denied for org.simalliance.service")) {
            return CodeMessage.NFC_OMA_NO_ACCESS_SE;
        }
        if (str.toLowerCase().contains("no apdu access allowed")) {
            return CodeMessage.NFC_NO_APDU_ACCESS_ALLOWED;
        }
        if (str.toLowerCase().contains("basic channel in use")) {
            return CodeMessage.NFC_BASIC_CHANNEL_IN_USE;
        }
        if (str.toLowerCase().contains("nosuchelement")) {
            return CodeMessage.NFC_AID_NO_EXIST;
        }
        if (str.toLowerCase().contains("secure element is not present")) {
            return CodeMessage.NFC_SE_NO_EXIST;
        }
        if (str.toLowerCase().contains("isnfceventallowed exception")) {
            return CodeMessage.NFC_EVENT_IS_EXCEPTION;
        }
        if (str.toLowerCase().contains("ara-m couldn't be selected")) {
            return CodeMessage.NFC_ARAM_COUldNOT_SELECT;
        }
        if (str.toLowerCase().contains("access control enforcer:access denied")) {
            return CodeMessage.NFC_ACCESS_DENIED_INITIAL;
        }
        if (str.toLowerCase().contains("open se failed")) {
            return CodeMessage.NFC_OPEN_SE_FAILURE;
        }
        if (str.toLowerCase().contains("cannot get nfc default adapter")) {
            return CodeMessage.NFC_CANNOT_GET_DEFAULT_ADAPTER;
        }
        if (str.toLowerCase().contains("cannot get nfc extra interface")) {
            return CodeMessage.NFC_CANNOT_GET_EXTRA_INTERFACE;
        }
        if (str.toLowerCase().contains("close se failed")) {
            return CodeMessage.NFC_CLOSE_SE_FAILURE;
        }
        if (str.toLowerCase().contains("exchange apdu failed")) {
            return CodeMessage.NFC_APDU_EXECUTE_ERROR;
        }
        if (str.toLowerCase().contains("get secure element uid failed")) {
            return CodeMessage.NFC_GET_SECUREELEMENT_UID_FAILURE;
        }
        if (str.toLowerCase().contains("response too small")) {
            return CodeMessage.NFC_RESPONSE_TOO_SMALL;
        }
        if (str.toLowerCase().contains("no channels left to access ara-m")) {
            return CodeMessage.NFC_NO_CHANNELS_LEFT_ACCESS;
        }
        if (str.toLowerCase().contains("ara-m can not be accessed")) {
            return CodeMessage.NFC_ARAM_CANNOT_BE_ACCESSED;
        }
        if (str.toLowerCase().contains("fail to special access check within openbasicchannelaid")) {
            return CodeMessage.NFC_CHECK_OPENBASICCHANNELAID_ACCESS_FAILURE;
        }
        if (str.toLowerCase().contains("applet returned invalid or wrong data object")) {
            return CodeMessage.NFC_APPLET_RETURNED_INVALID;
        }
        if (str.toLowerCase().contains("get data (all) not successfull")) {
            return CodeMessage.NFC_GET_ALL_DATA_NOT_SUCCESS;
        }
        if (str.toLowerCase().contains("get data (next) not successfull")) {
            return CodeMessage.NFC_GET_DATA_NEXT_SUCCESS;
        }
        if (str.toLowerCase().contains("service not connected to system")) {
            return CodeMessage.NFC_SERVICE_NOT_CONNECTED_TO_SYSTEM;
        }
        return (str.toLowerCase().contains("6a82") || str.toLowerCase().contains("6999")) ? CodeMessage.NFC_AID_NO_EXIST : i;
    }

    public static String specialCheckForOmaException(String str) {
        String str2 = "";
        if (ValueUtil.isEmpty(str)) {
            return str2;
        }
        if (str.toLowerCase().contains("6a82")) {
            return SmartDeviceCode.AID_NOT_EXIST;
        }
        if (str.toLowerCase().contains("6999")) {
            return "6999";
        }
        return str2;
    }
}
