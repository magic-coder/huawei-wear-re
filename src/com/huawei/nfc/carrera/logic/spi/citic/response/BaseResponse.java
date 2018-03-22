package com.huawei.nfc.carrera.logic.spi.citic.response;

public class BaseResponse {
    public static final int RESULT_CODE_CONNECT_SERVER_FAILED = -4;
    public static final int RESULT_CODE_CONTACT_BANK_CALLING_CENTER = -8;
    public static final int RESULT_CODE_NO_NETWORK = -5;
    public static final int RESULT_CODE_OTHER_ERRORS = -7;
    public static final int RESULT_CODE_PARAMS_ILLEGAL = -6;
    public static final int RESULT_CODE_SERVER_ERROR = -1;
    public static final int RESULT_CODE_SIGNATURE_VERIFY_FAILED = -2;
    public static final int RESULT_CODE_SUCCESS = 0;
    public static final int RESULT_CODE_TOKEN_VERIFY_FAILED = -3;
    private int resultCode;
    private String timeStamp;
    private String token;
    private String verifySignature;

    public void setResultCode(int i) {
        this.resultCode = i;
    }

    public void setVerifySignature(String str) {
        this.verifySignature = str;
    }

    public void setTimeStamp(String str) {
        this.timeStamp = str;
    }

    public void setToken(String str) {
        this.token = str;
    }

    public int getResultCode() {
        return this.resultCode;
    }

    public String getVerifySignature() {
        return this.verifySignature;
    }

    public String getTimeStamp() {
        return this.timeStamp;
    }

    public String getToken() {
        return this.token;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(super.toString());
        stringBuilder.append("response resultCode: ").append(getResultCode()).append(",");
        stringBuilder.append("response sign: ").append(this.verifySignature).append(",");
        stringBuilder.append("timeStamp: ").append(this.timeStamp).append(",");
        stringBuilder.append("token: ").append(this.token).append(",");
        return stringBuilder.toString();
    }
}
