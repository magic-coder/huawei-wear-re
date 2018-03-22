package com.huawei.nfc.carrera.logic.spi.unionpay.response;

public class CUPBaseResponse {
    public static final int RESPONSE_CODE_FAILED_CANNOT_BIND_CUP_SERVICE = -5;
    public static final int RESPONSE_CODE_FAILED_CUP_SERVICE_EXCEPTION = -4;
    public static final int RESPONSE_CODE_FAILED_CUP_TSM_SERVICE_UNREACHABLE = -3;
    public static final int RESPONSE_CODE_FAILED_NOT_INSTALLED = -1;
    public static final int RESPONSE_CODE_FAILED_OPERATION_ERR = -6;
    public static final int RESPONSE_CODE_FAILED_OPERATION_FATAL_ERR = -7;
    public static final int RESPONSE_CODE_FAILED_PARAMS_ILLEGAL = -2;
    public static final int RESPONSE_CODE_FAILED_UNKNOWN_ERRORS = -99;
    public static final int RESPONSE_CODE_SUCCESS = 0;
    public int responseCode;
}
