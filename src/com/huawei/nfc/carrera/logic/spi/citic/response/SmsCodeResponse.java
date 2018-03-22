package com.huawei.nfc.carrera.logic.spi.citic.response;

public class SmsCodeResponse extends BaseResponse {
    public static final int RESULT_CODE_GETSMS_CARD_ACTIVATED = -23;
    public static final int RESULT_CODE_GETSMS_CARD_NULLIFIED = -22;
    public static final int RESULT_CODE_GETSMS_CONTACT_BANK = -24;
    public static final int RESULT_CODE_GETSMS_EXCEED_LIMIT = -21;
    public String phone;

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(super.toString());
        stringBuilder.append("phone: " + this.phone);
        return stringBuilder.toString();
    }
}
