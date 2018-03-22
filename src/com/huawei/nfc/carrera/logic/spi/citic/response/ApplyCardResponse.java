package com.huawei.nfc.carrera.logic.spi.citic.response;

public class ApplyCardResponse extends BaseResponse {
    public static final int RESULT_CODE_APPLYCARD_EXCEED_LIMIT = -11;
    public static final int RESULT_CODE_CARD_APPLYED = -12;
    public static final int RESULT_CODE_ERROR_ACCOUNT_PHONE_UNREGISTERED = -17;
    public static final int RESULT_CODE_ERROR_ACCOUNT_STATUS = -15;
    public static final int RESULT_CODE_ERROR_CARDNUM_ASSOCIATED_OVERRUN = -16;
    public static final int RESULT_CODE_ERROR_CARD_BIND_EXCEED_LIMIT = -18;
    public static final int RESULT_CODE_ERROR_CARD_STATUS = -14;
    public static final int RESULT_CODE_ERROR_CONTACT_BANK = -20;
    public static final int RESULT_CODE_ERROR_CUSTOMER_STATUS = -19;
    public static final int RESULT_CODE_ERROR_INPUT_INFO = -13;
    public String dPan;

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(super.toString());
        stringBuilder.append("dPan: ").append(this.dPan);
        return stringBuilder.toString();
    }
}
