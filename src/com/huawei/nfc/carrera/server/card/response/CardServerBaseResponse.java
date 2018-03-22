package com.huawei.nfc.carrera.server.card.response;

public class CardServerBaseResponse {
    public static final int RESPONSE_CODE_CANNOT_BE_RESOLVED = -98;
    public static final int RESPONSE_CODE_CONNECTION_FAILED = -2;
    public static final int RESPONSE_CODE_INTERNAL_ERROR = 3;
    public static final int RESPONSE_CODE_NO_ACCESS_AUTHORITY = 4;
    public static final int RESPONSE_CODE_NO_NETWORK_FAILED = -1;
    public static final int RESPONSE_CODE_OPERATION_FAILED = 5;
    public static final int RESPONSE_CODE_OTHER_ERRORS = -99;
    public static final int RESPONSE_CODE_PARAMS_ERROR = 1;
    public static final int RESPONSE_CODE_SERVER_OVERLOAD_ERROR = -4;
    public static final int RESPONSE_CODE_SIGNATURE_ERROR = 2;
    public static final int RESPONSE_CODE_SUCCESS = 0;
    public int returnCode = -99;

    public CardServerBaseResponse(int i) {
        this.returnCode = i;
    }
}
