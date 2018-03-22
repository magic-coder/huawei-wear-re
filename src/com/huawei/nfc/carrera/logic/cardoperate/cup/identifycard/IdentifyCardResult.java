package com.huawei.nfc.carrera.logic.cardoperate.cup.identifycard;

public class IdentifyCardResult {
    public static final int RESULT_CODE_FAILED_CANNOT_BIND_CUP_SERVICE = -5;
    public static final int RESULT_CODE_FAILED_CONN_EXCEPTION = -3;
    public static final int RESULT_CODE_FAILED_NOT_INSTALLED = -1;
    public static final int RESULT_CODE_FAILED_NO_NETWORK = -2;
    public static final int RESULT_CODE_FAILED_UNKNOWN_ERROR = -99;
    public static final int RESULT_CODE_FAILED_UNSUPPORTED_CARD = -4;
    public static final int RESULT_CODE_SUCCESS = 0;
    private int bankCardType;
    private String issuerId;
    private int resultCode = -99;

    public int getResultCode() {
        return this.resultCode;
    }

    public void setResultCode(int i) {
        this.resultCode = i;
    }

    public String getIssuerId() {
        return this.issuerId;
    }

    public void setIssuerId(String str) {
        this.issuerId = str;
    }

    public int getBankCardType() {
        return this.bankCardType;
    }

    public void setBankCardType(int i) {
        this.bankCardType = i;
    }
}
