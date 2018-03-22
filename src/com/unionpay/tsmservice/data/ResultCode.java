package com.unionpay.tsmservice.data;

import android.text.TextUtils;
import com.huawei.hwid.core.constants.HwAccountConstants;

public class ResultCode {
    public static final String ERROR_DETAIL_DEFAULT = "0000";
    public static final String ERROR_DETAIL_FORCE_UPDATE = "0019";
    public static final String ERROR_DETAIL_ILLEGAL_CHANNEL = "0013";
    public static final String ERROR_DETAIL_NETWORK = "0001";
    public static final String ERROR_DETAIL_NFC_NOT_ENABLE = "0009";
    public static final String ERROR_DETAIL_NOT_SUPPORT = "0004";
    public static final String ERROR_DETAIL_NO_AVAILABLE_CHANNEL = "0014";
    public static final String ERROR_DETAIL_NO_PERMISSION = "0003";
    public static final String ERROR_DETAIL_SE_BUSY = "0012";
    public static final String ERROR_DETAIL_SE_SERVICE_CONNTECT = "0010";
    public static final String ERROR_DETAIL_SIGNATURE_INVALID = "0015";
    public static final String ERROR_DETAIL_SKMS_AGENT_ERROR = "0008";
    public static final String ERROR_DETAIL_SKMS_AGENT_MUST_UPDATE = "0007";
    public static final String ERROR_DETAIL_SKMS_AGENT_NEED_UPDATE = "0006";
    public static final String ERROR_DETAIL_SKMS_AGENT_NOT_INSTALL = "0005";
    public static final String ERROR_DETAIL_TRANSMIT_APDU = "0011";
    public static final String ERROR_DETAIL_UNKNOWN_HOST = "0002";
    public static final String ERROR_DOWNLOAD_FILE = "10004";
    public static final String ERROR_INTERFACE_APP_DATA_UPDATE = "10015";
    public static final String ERROR_INTERFACE_APP_DELETE = "10014";
    public static final String ERROR_INTERFACE_APP_DOWNLOAD = "10013";
    public static final String ERROR_INTERFACE_APP_DOWNLOAD_APPLY = "10012";
    public static final String ERROR_INTERFACE_APP_LOCK = "10016";
    public static final String ERROR_INTERFACE_APP_UNLOCK = "10017";
    public static final String ERROR_INTERFACE_BLE_KEY_EXCHANGE = "10031";
    public static final String ERROR_INTERFACE_CALL_OVERTIME = "10099";
    public static final String ERROR_INTERFACE_CHECK_BIN_CODE = "10032";
    public static final String ERROR_INTERFACE_CLOSE_CHANNEL = "10029";
    public static final String ERROR_INTERFACE_ECASH_TOPUP = "10020";
    public static final String ERROR_INTERFACE_ENCRYPT_DATA = "10004";
    public static final String ERROR_INTERFACE_EXCHANGE_KEY = "10003";
    public static final String ERROR_INTERFACE_EXECUTE_CMD = "10030";
    public static final String ERROR_INTERFACE_GET_ACCOUNT_BALANCE = "10023";
    public static final String ERROR_INTERFACE_GET_ACCOUNT_INFO = "10022";
    public static final String ERROR_INTERFACE_GET_ACTIVE_CODE = "10037";
    public static final String ERROR_INTERFACE_GET_APP_DETAIL = "10010";
    public static final String ERROR_INTERFACE_GET_APP_LIST = "10008";
    public static final String ERROR_INTERFACE_GET_APP_STATUS = "10009";
    public static final String ERROR_INTERFACE_GET_ASSOCIATED_APP = "10006";
    public static final String ERROR_INTERFACE_GET_CARD_INFO = "10024";
    public static final String ERROR_INTERFACE_GET_DEFAULT_CARD = "10026";
    public static final String ERROR_INTERFACE_GET_PUBLIC_KEY = "10002";
    public static final String ERROR_INTERFACE_GET_SAFETYKEYBOARD_ENCRYPTEDDATA = "10042";
    public static final String ERROR_INTERFACE_GET_SE_APP_LIST = "10007";
    public static final String ERROR_INTERFACE_GET_SE_ID = "10005";
    public static final String ERROR_INTERFACE_GET_SMS_AUTH_CODE = "10019";
    public static final String ERROR_INTERFACE_GET_SUPPORTED_CARD_TYPE_LIST = "10039";
    public static final String ERROR_INTERFACE_GET_TRANS_ELEMENTS = "10011";
    public static final String ERROR_INTERFACE_GET_TRANS_RECORD = "10021";
    public static final String ERROR_INTERFACE_HIDE_APP_APPLY = "10018";
    public static final String ERROR_INTERFACE_INIT = "10001";
    public static final String ERROR_INTERFACE_OPEN_CHANNEL = "10027";
    public static final String ERROR_INTERFACE_OPEN_UNITE_CARD_APPLY_ACTIVITY = "10033";
    public static final int ERROR_INTERFACE_REEXEC_METHOD = 1000;
    public static final String ERROR_INTERFACE_SEND_APDU = "10028";
    public static final String ERROR_INTERFACE_SET_DEFAULT_CARD = "10025";
    public static final String ERROR_INTERFACE_SET_SAFETYKEYBOARD_BITMAP = "10040";
    public static final String ERROR_INTERFACE_SHOW_SAFETYKEYBOARD = "10041";
    public static final String ERROR_INTERFACE_UNITE_APP_DELETE = "10036";
    public static final String ERROR_INTERFACE_UNITE_APP_DOWNLOAD = "10034";
    public static final String ERROR_INTERFACE_UNITE_APP_LIST = "10035";
    public static final String ERROR_INTERFACE_UNITE_CARD_ACTIVE = "10038";
    public static final String ERROR_LOCAL_BEGIN = "10000";
    public static final String ERROR_NETWORK = "10001";
    public static final String ERROR_RESPONSE_FORMAT = "10002";
    public static final String ERROR_SOURCE_ADDON = "0";
    public static final String ERROR_SOURCE_TSM = "1";
    public static final String ERROR_STORAGE_NOT_ENOUGHT = "10003";
    public static final String FAKE_ERROR_DUPLICATE_ACTIVE = "99999";
    public static final String SUCCESS = "10000";

    public static String getResultCode(String str) {
        if (TextUtils.isEmpty(str)) {
            return HwAccountConstants.DEFAULT_DEVICEPLMN;
        }
        if ("0000".equals(str)) {
            return "";
        }
        if ("10001".equals(str)) {
            return "00001";
        }
        if (ERROR_INTERFACE_APP_UNLOCK.equals(str)) {
            return "00004";
        }
        if (ERROR_INTERFACE_GET_SMS_AUTH_CODE.equals(str)) {
            return "00005";
        }
        if (ERROR_INTERFACE_GET_ACCOUNT_INFO.equals(str)) {
            return "00006";
        }
        if (ERROR_INTERFACE_GET_ACCOUNT_BALANCE.equals(str)) {
            return "00007";
        }
        if (ERROR_INTERFACE_HIDE_APP_APPLY.equals(str)) {
            return "00008";
        }
        if (ERROR_INTERFACE_GET_CARD_INFO.equals(str)) {
            return "00009";
        }
        if (ERROR_INTERFACE_GET_TRANS_RECORD.equals(str)) {
            return "00010";
        }
        if (ERROR_INTERFACE_ECASH_TOPUP.equals(str)) {
            return "00011";
        }
        if ("10004".equals(str)) {
            return "00001";
        }
        if (ERROR_INTERFACE_GET_APP_DETAIL.equals(str)) {
            return "00001";
        }
        if (ERROR_INTERFACE_APP_LOCK.equals(str)) {
            return "00001";
        }
        return "1" + str;
    }
}
