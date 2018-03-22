package com.huawei.nfc.carrera.logic.spi.citic.impl;

import com.huawei.nfc.carrera.util.LogX;

public class ResultCodeInterpreter {
    private static final String CITIC_SDK_RESULT_CODE_APPLYCARD_CARD_APPLYED = "HW00102";
    private static final String CITIC_SDK_RESULT_CODE_APPLYCARD_EXCEED_LIMIT = "HW00101";
    private static final String CITIC_SDK_RESULT_CODE_APPLYCARD_INPUT_ERROR = "HW00001";
    private static final String CITIC_SDK_RESULT_CODE_APPLYCARD_INPUT_ILLEGAL = "HW00002";
    private static final String CITIC_SDK_RESULT_CODE_APPLYCARD_STATUS_EXCEPTION = "HW00003";
    private static final String CITIC_SDK_RESULT_CODE_GENERAL_SERVER_ANSWER_FAILED = "HW99999";
    private static final String CITIC_SDK_RESULT_CODE_GENERAL_SIGNATURE_VERIFY_FAILED = "HW11111";
    private static final String CITIC_SDK_RESULT_CODE_GENERAL_SUCCESS = "HW00000";
    private static final String CITIC_SDK_RESULT_CODE_GENERAL_TOKEN_VERIFY_FAILED = "HW22222";
    private static final String CITIC_SDK_RESULT_CODE_REQUESTSMS_CARD_NULLIFIED = "HW00401";
    private static final String CITIC_SDK_RESULT_CODE_REQUESTSMS_EXCEED_LIMIT = "HW00201";
    private static final String CITIC_SDK_RESULT_CODE_VERIFYSMS_SMS_EFFICACY = "HW00302";
    private static final String CITIC_SDK_RESULT_CODE_VERIFYSMS_SMS_NULL = "HW00301";
    private static final String CITIC_SDK_RESULT_CODE_VERIFYSMS_SMS_UNMATCH = "HW00303";

    int handleBaseResultCode(String str) {
        LogX.i("handleBaseResultCode, resultCode : " + str);
        if (CITIC_SDK_RESULT_CODE_GENERAL_SUCCESS.equals(str)) {
            return 0;
        }
        if (CITIC_SDK_RESULT_CODE_GENERAL_SERVER_ANSWER_FAILED.equals(str)) {
            return -1;
        }
        if (CITIC_SDK_RESULT_CODE_GENERAL_SIGNATURE_VERIFY_FAILED.equals(str)) {
            return -2;
        }
        if (CITIC_SDK_RESULT_CODE_GENERAL_TOKEN_VERIFY_FAILED.equals(str)) {
            return -3;
        }
        return -7;
    }

    int handleApplyCardResultCode(String str) {
        LogX.i("handleApplyCardResultCode, resultCode : " + str);
        if (CITIC_SDK_RESULT_CODE_APPLYCARD_EXCEED_LIMIT.equals(str)) {
            return -11;
        }
        if (CITIC_SDK_RESULT_CODE_APPLYCARD_CARD_APPLYED.equals(str)) {
            return -12;
        }
        if (CITIC_SDK_RESULT_CODE_APPLYCARD_INPUT_ERROR.equals(str) || CITIC_SDK_RESULT_CODE_APPLYCARD_INPUT_ILLEGAL.equals(str)) {
            return -13;
        }
        if (CITIC_SDK_RESULT_CODE_APPLYCARD_STATUS_EXCEPTION.equals(str)) {
            return -14;
        }
        return handleBaseResultCode(str);
    }

    int handleGetSMSResultCode(String str) {
        LogX.i("handleGetSMSResultCode, resultCode : " + str);
        if (CITIC_SDK_RESULT_CODE_REQUESTSMS_EXCEED_LIMIT.equals(str)) {
            return -21;
        }
        if (CITIC_SDK_RESULT_CODE_REQUESTSMS_CARD_NULLIFIED.equals(str)) {
            return -22;
        }
        return handleBaseResultCode(str);
    }

    int handleVerifySMSCodeResultCode(String str) {
        LogX.i("handleVerifySMSCodeResultCode, resultCode : " + str);
        if (CITIC_SDK_RESULT_CODE_VERIFYSMS_SMS_NULL.equals(str)) {
            return -31;
        }
        if (CITIC_SDK_RESULT_CODE_VERIFYSMS_SMS_EFFICACY.equals(str)) {
            return -32;
        }
        if (CITIC_SDK_RESULT_CODE_VERIFYSMS_SMS_UNMATCH.equals(str)) {
            return -33;
        }
        return handleBaseResultCode(str);
    }
}
