package com.huawei.nfc.carrera.logic.spi.cmb.impl;

import com.huawei.nfc.carrera.util.LogX;
import com.unionpay.tsmservice.data.ResultCode;

public class CMBResultCodeInterpreter {
    private static final String CMB_SDK_RESULT_CODE_ACTIVATE_ACCOUNT_ERROR_OR_DPAN_EXPIRED = "3606";
    private static final String CMB_SDK_RESULT_CODE_ACTIVATE_CARD_ACTIVATED = "3613";
    private static final String CMB_SDK_RESULT_CODE_ACTIVATE_CREDIT_ACCOUNT_FAIL = "3106";
    private static final String CMB_SDK_RESULT_CODE_ACTIVATE_INVALID_PARAM = "3107";
    private static final String CMB_SDK_RESULT_CODE_ACTIVATE_QUERY_DB_FAILED = "3601";
    private static final String CMB_SDK_RESULT_CODE_ACTIVATE_SMS_CODE_WRONG = "8123";
    private static final String CMB_SDK_RESULT_CODE_ACTIVATE_SMS_EXPIRED = "3614";
    private static final String CMB_SDK_RESULT_CODE_ACTIVATE_SMS_LEN_WRONG = "8116";
    private static final String CMB_SDK_RESULT_CODE_ACTIVATE_SMS_TIME_EXPIRED = "8120";
    private static final String CMB_SDK_RESULT_CODE_ACTIVATE_SMS_WRONG = "3612";
    private static final String CMB_SDK_RESULT_CODE_ACTIVATE_TOKEN_WRONG = "fail";
    private static final String CMB_SDK_RESULT_CODE_APPLYAID_CARDTYPE_ERROR = "3602";
    private static final String CMB_SDK_RESULT_CODE_APPLYAID_DEL_APP = "3319";
    private static final String CMB_SDK_RESULT_CODE_APPLYAID_DEL_APP_AND_SSD = "3401";
    private static final String CMB_SDK_RESULT_CODE_APPLYAID_DPAN_REACH_MAX = "3600";
    private static final String CMB_SDK_RESULT_CODE_APPLYAID_INVALID_PARAM = "3106";
    private static final String CMB_SDK_RESULT_CODE_APPLYAID_SERVER_SYSTEM_ERROR = "3102";
    private static final String CMB_SDK_RESULT_CODE_APPLYAID_SSD_ERROR = "3634";
    private static final String CMB_SDK_RESULT_CODE_APPLYAID_VERIFY_KEY_FAIL = "3702";
    private static final String CMB_SDK_RESULT_CODE_APPLYCARD_ACCOUNT_EXPIRED = "3626";
    private static final String CMB_SDK_RESULT_CODE_APPLYCARD_ACCOUNT_FROZEN = "3622";
    private static final String CMB_SDK_RESULT_CODE_APPLYCARD_ACCOUNT_NOT_ACTIVATED = "3624";
    private static final String CMB_SDK_RESULT_CODE_APPLYCARD_CARDTYPE_ERROR = "3602";
    private static final String CMB_SDK_RESULT_CODE_APPLYCARD_CARD_HOUSEHOLD = "3625";
    private static final String CMB_SDK_RESULT_CODE_APPLYCARD_CARD_NOT_SUPPORT_BUSINESS = "3630";
    private static final String CMB_SDK_RESULT_CODE_APPLYCARD_CARD_NUMBER_NOT_EXIST = "3631";
    private static final String CMB_SDK_RESULT_CODE_APPLYCARD_CARD_VOUCHER_DISABLED = "3621";
    private static final String CMB_SDK_RESULT_CODE_APPLYCARD_CREDIT_APPLY_ERROR1 = "3635";
    private static final String CMB_SDK_RESULT_CODE_APPLYCARD_CREDIT_APPLY_ERROR2 = "3636";
    private static final String CMB_SDK_RESULT_CODE_APPLYCARD_DEBIT_EXISTED = "3632";
    private static final String CMB_SDK_RESULT_CODE_APPLYCARD_EXCEED_LIMIT = "3633";
    private static final String CMB_SDK_RESULT_CODE_APPLYCARD_FPAN_EXISTED = "3608";
    private static final String CMB_SDK_RESULT_CODE_APPLYCARD_INFORMATION_NOT_REGISTERED = "3629";
    private static final String CMB_SDK_RESULT_CODE_APPLYCARD_INFO_INCOMPLETE = "3610";
    private static final String CMB_SDK_RESULT_CODE_APPLYCARD_INVALID_PARAM = "3106";
    private static final String CMB_SDK_RESULT_CODE_APPLYCARD_NOT_ONE_NET_CARD = "3617";
    private static final String CMB_SDK_RESULT_CODE_APPLYCARD_NOT_REAL_NAME_ACCOUNT = "3623";
    private static final String CMB_SDK_RESULT_CODE_APPLYCARD_NUMBER_ASSOCIATED_OVERRUN = "3628";
    private static final String CMB_SDK_RESULT_CODE_APPLYCARD_OTHER_SYSTEM_ERROR = "3102";
    private static final String CMB_SDK_RESULT_CODE_APPLYCARD_PASSWORD_DECLARED_LOST = "3619";
    private static final String CMB_SDK_RESULT_CODE_APPLYCARD_PASSWORD_ERROR_COUNT_EXCEEDED = "3620";
    private static final String CMB_SDK_RESULT_CODE_APPLYCARD_PASSWORD_WRONG = "3618";
    private static final String CMB_SDK_RESULT_CODE_APPLYCARD_QUERY_AID_FAIL = "3301";
    private static final String CMB_SDK_RESULT_CODE_APPLYCARD_SYSTEM_BUSY = "3104";
    private static final String CMB_SDK_RESULT_CODE_APPLYCARD_UNABLE_TO_TRANSACT_BUSINESS = "3627";
    private static final String CMB_SDK_RESULT_CODE_APPLYCARD_VERIFY_KEY_FAIL = "3702";
    private static final String CMB_SDK_RESULT_CODE_CONTACT_YOUR_DISPOSAL = "3702";
    private static final String CMB_SDK_RESULT_CODE_GENERAL_CONNECT_FAIL = "0001";
    private static final String CMB_SDK_RESULT_CODE_GENERAL_GET_SESSION_FAIL = "0004";
    private static final String CMB_SDK_RESULT_CODE_GENERAL_SDK_INIT_FAIL = "0002";
    private static final String CMB_SDK_RESULT_CODE_GENERAL_SUCCESS = "0000";
    private static final String CMB_SDK_RESULT_CODE_GET_BRANCH_NUMBER_FAILED = "3616";
    private static final String CMB_SDK_RESULT_CODE_INTERNAL_SERVER_BUSY = "OTA0001";
    private static final String CMB_SDK_RESULT_CODE_INVALID_PARAM = "3106";
    private static final String CMB_SDK_RESULT_CODE_NULLIFY_INVALID_PARAM = "3108";
    private static final String CMB_SDK_RESULT_CODE_NULLIFY_OTHER_SYSTEM_ERROR = "3108";
    private static final String CMB_SDK_RESULT_CODE_NULLIFY_VERIFY_SIGN_FAIL = "3108";
    private static final String CMB_SDK_RESULT_CODE_OBTAIN_VOUCHER_NUM_FAIL = "3615";
    private static final String CMB_SDK_RESULT_CODE_OTA_INIT_CARD_FAIL = "OTA0003";
    private static final String CMB_SDK_RESULT_CODE_OTA_PERSONALIZE_FAIL = "3323";
    private static final String CMB_SDK_RESULT_CODE_OTHER_SYSTEM_ERROR = "3102";
    private static final String CMB_SDK_RESULT_CODE_REQUESTSMS_CARD_ACTIVATED = "3613";
    private static final String CMB_SDK_RESULT_CODE_REQUESTSMS_CREDIT_ERROR = "3636";
    private static final String CMB_SDK_RESULT_CODE_REQUESTSMS_DPAN_NOT_EXIST = "3319";
    private static final String CMB_SDK_RESULT_CODE_REQUESTSMS_INVALID_PARAM = "3106";
    private static final String CMB_SDK_RESULT_CODE_REQUESTSMS_QUERY_DB_FAILED = "3601";
    private static final String CMB_SDK_RESULT_CODE_REQUESTSMS_VERIFY_SIGN_FAIL = "3103";
    private static final String CMB_SDK_RESULT_CODE_SESSION_CLOSE = "OTA0002";
    private static final String CMB_SDK_RESULT_CODE_SESSION_TIMED_OUT = "0004";

    int handleBaseResultCode(String str) {
        LogX.i("handleBaseResultCode, resultCode : " + str);
        if ("0000".equals(str)) {
            return 0;
        }
        if ("0001".equals(str)) {
            return -4;
        }
        return -7;
    }

    int handleApplyAidResultCode(String str) {
        LogX.i("handleApplyAidResultCode, resultCode : " + str);
        if ("3106".equals(str) || "3702".equals(str) || "3602".equals(str) || "3102".equals(str) || CMB_SDK_RESULT_CODE_APPLYAID_SSD_ERROR.equals(str)) {
            return -8;
        }
        if ("3319".equals(str)) {
            return -42;
        }
        if (CMB_SDK_RESULT_CODE_APPLYAID_DEL_APP_AND_SSD.equals(str)) {
            return -43;
        }
        if (CMB_SDK_RESULT_CODE_APPLYAID_DPAN_REACH_MAX.equals(str) || CMB_SDK_RESULT_CODE_APPLYAID_DPAN_REACH_MAX.equals(str)) {
            return -44;
        }
        return handleBaseResultCode(str);
    }

    int handleApplyCardResultCode(String str) {
        LogX.i("handleApplyCardResultCode, resultCode : " + str);
        if (checkApplyCardErrorByBankSystemError(str) || checkApplyCardErrorByBankBusiness(str)) {
            return -8;
        }
        if (checkApplyCardErrorByErrorInputInfo(str)) {
            return -13;
        }
        if (checkApplyCardErrorByExceedLimit(str)) {
            return -11;
        }
        if (checkApplyCardErrorByAssociatedOverrun(str)) {
            return -16;
        }
        if (checkApplyCardErrorByErrorCardStatus(str)) {
            return -14;
        }
        if (checkApplyCardErrorByErrorAccountStatus(str)) {
            return -15;
        }
        if (checkApplyCardErrorByAccountPhoneUnregistered(str)) {
            return -17;
        }
        if (CMB_SDK_RESULT_CODE_APPLYCARD_DEBIT_EXISTED.equals(str)) {
            return -18;
        }
        if (CMB_SDK_RESULT_CODE_APPLYCARD_CREDIT_APPLY_ERROR1.equals(str)) {
            return -19;
        }
        if ("3636".equals(str)) {
            return -20;
        }
        return handleBaseResultCode(str);
    }

    private boolean checkApplyCardErrorByAccountPhoneUnregistered(String str) {
        return CMB_SDK_RESULT_CODE_APPLYCARD_INFORMATION_NOT_REGISTERED.equals(str) || CMB_SDK_RESULT_CODE_APPLYCARD_INFO_INCOMPLETE.equals(str);
    }

    private boolean checkApplyCardErrorByAssociatedOverrun(String str) {
        return CMB_SDK_RESULT_CODE_APPLYCARD_NUMBER_ASSOCIATED_OVERRUN.equals(str) || CMB_SDK_RESULT_CODE_APPLYCARD_FPAN_EXISTED.equals(str);
    }

    private boolean checkApplyCardErrorByExceedLimit(String str) {
        return CMB_SDK_RESULT_CODE_APPLYCARD_PASSWORD_ERROR_COUNT_EXCEEDED.equals(str) || CMB_SDK_RESULT_CODE_APPLYCARD_EXCEED_LIMIT.equals(str);
    }

    private boolean checkApplyCardErrorByErrorAccountStatus(String str) {
        return CMB_SDK_RESULT_CODE_APPLYCARD_ACCOUNT_FROZEN.equals(str) || CMB_SDK_RESULT_CODE_APPLYCARD_NOT_REAL_NAME_ACCOUNT.equals(str) || CMB_SDK_RESULT_CODE_APPLYCARD_ACCOUNT_NOT_ACTIVATED.equals(str) || CMB_SDK_RESULT_CODE_APPLYCARD_UNABLE_TO_TRANSACT_BUSINESS.equals(str);
    }

    private boolean checkApplyCardErrorByErrorCardStatus(String str) {
        return CMB_SDK_RESULT_CODE_APPLYCARD_CARD_VOUCHER_DISABLED.equals(str) || CMB_SDK_RESULT_CODE_APPLYCARD_ACCOUNT_EXPIRED.equals(str) || CMB_SDK_RESULT_CODE_APPLYCARD_CARD_NOT_SUPPORT_BUSINESS.equals(str);
    }

    private boolean checkApplyCardErrorByErrorInputInfo(String str) {
        return CMB_SDK_RESULT_CODE_APPLYCARD_PASSWORD_WRONG.equals(str) || CMB_SDK_RESULT_CODE_APPLYCARD_NOT_ONE_NET_CARD.equals(str) || CMB_SDK_RESULT_CODE_APPLYCARD_CARD_HOUSEHOLD.equals(str) || CMB_SDK_RESULT_CODE_APPLYCARD_CARD_NUMBER_NOT_EXIST.equals(str);
    }

    private boolean checkApplyCardErrorByBankBusiness(String str) {
        return CMB_SDK_RESULT_CODE_APPLYCARD_PASSWORD_DECLARED_LOST.equals(str) || CMB_SDK_RESULT_CODE_APPLYCARD_NUMBER_ASSOCIATED_OVERRUN.equals(str);
    }

    private boolean checkApplyCardErrorByBankSystemError(String str) {
        if (CMB_SDK_RESULT_CODE_APPLYCARD_QUERY_AID_FAIL.equals(str) || "3702".equals(str) || "3102".equals(str) || "3602".equals(str) || "3106".equals(str) || "3104".equals(str)) {
            return true;
        }
        return false;
    }

    int handlePersonalizeCardResultCode(String str) {
        LogX.i("handlePersonalizeCardResultCode, resultCode : " + str);
        if ("3702".equals(str) || "3106".equals(str) || CMB_SDK_RESULT_CODE_OBTAIN_VOUCHER_NUM_FAIL.equals(str) || CMB_SDK_RESULT_CODE_GET_BRANCH_NUMBER_FAILED.equals(str) || CMB_SDK_RESULT_CODE_OTA_INIT_CARD_FAIL.equals(str) || CMB_SDK_RESULT_CODE_INTERNAL_SERVER_BUSY.equals(str) || "3102".equals(str) || CMB_SDK_RESULT_CODE_OTA_PERSONALIZE_FAIL.equals(str) || ResultCode.ERROR_DETAIL_NOT_SUPPORT.equals(str) || CMB_SDK_RESULT_CODE_SESSION_CLOSE.equals(str)) {
            return -8;
        }
        return handleBaseResultCode(str);
    }

    int handleGetSMSResultCode(String str) {
        LogX.i("handleGetSMSResultCode, resultCode : " + str);
        if ("3103".equals(str) || "3106".equals(str) || "3601".equals(str)) {
            return -8;
        }
        if ("3613".equals(str)) {
            return -23;
        }
        if ("3319".equals(str)) {
            return -22;
        }
        if ("3636".equals(str)) {
            return -24;
        }
        return handleBaseResultCode(str);
    }

    int handleVerifySMSCodeResultCode(String str) {
        LogX.i("handleVerifySMSCodeResultCode, resultCode : " + str);
        if ("3106".equals(str) || "3107".equals(str) || "3601".equals(str)) {
            return -8;
        }
        if (CMB_SDK_RESULT_CODE_ACTIVATE_SMS_EXPIRED.equals(str) || CMB_SDK_RESULT_CODE_ACTIVATE_SMS_TIME_EXPIRED.equals(str)) {
            return -32;
        }
        if (CMB_SDK_RESULT_CODE_ACTIVATE_SMS_WRONG.equals(str) || "fail".equals(str) || CMB_SDK_RESULT_CODE_ACTIVATE_SMS_LEN_WRONG.equals(str) || CMB_SDK_RESULT_CODE_ACTIVATE_SMS_CODE_WRONG.equals(str)) {
            return -33;
        }
        if (CMB_SDK_RESULT_CODE_ACTIVATE_ACCOUNT_ERROR_OR_DPAN_EXPIRED.equals(str)) {
            return -34;
        }
        if ("3613".equals(str)) {
            return 0;
        }
        return handleBaseResultCode(str);
    }

    int handleNullifyResultCode(String str) {
        LogX.i("handleNullifyResultCode, resultCode : " + str);
        if ("3108".equals(str) || "3108".equals(str) || "3108".equals(str)) {
            return -8;
        }
        return handleBaseResultCode(str);
    }
}
