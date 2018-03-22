package com.huawei.nfc.carrera.logic.spi.tsm;

import com.huawei.nfc.carrera.logic.spi.tsm.request.CommandRequest;

public interface LaserTSMService {
    public static final int EXCUTE_OTA_RESULT_APPLET_AID_IS_NULL = 100006;
    public static final int EXCUTE_OTA_RESULT_APPLET_VERSION_IS_NULL = 100007;
    public static final int EXCUTE_OTA_RESULT_COMMON_REQUEST_PARAMS_IS_NULL = 100001;
    public static final int EXCUTE_OTA_RESULT_CPLC_IS_NULL = 100008;
    public static final int EXCUTE_OTA_RESULT_DEFAULT_ERROR = -100099;
    public static final int EXCUTE_OTA_RESULT_ESE_CARD_OPER_FAILED = 100009;
    public static final int EXCUTE_OTA_RESULT_FAILED_UNKOWN_ERROR = 100011;
    public static final int EXCUTE_OTA_RESULT_FUNCALL_ID_IS_NULL = 100004;
    public static final int EXCUTE_OTA_RESULT_NETWORK_REQUEST_FAILED = 100010;
    public static final int EXCUTE_OTA_RESULT_OPER_APPLET_PARAMS_IS_NULL = 100002;
    public static final int EXCUTE_OTA_RESULT_SERVICE_ID_IS_NULL = 100003;
    public static final int EXCUTE_OTA_RESULT_SSD_AID_IS_NULL = 100005;
    public static final int EXCUTE_OTA_RESULT_SUCCESS = 100000;

    int excuteTsmCommand(CommandRequest commandRequest);

    int excuteTsmCommandByBasicChannel(CommandRequest commandRequest);
}
