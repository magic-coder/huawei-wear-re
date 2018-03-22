package com.huawei.nfc.carrera.logic.spi.citic.response;

public class ApplyAidResponse extends BaseResponse {
    public static final int RESULT_CODE_APPLYAID_DEL_APPLET = -42;
    public static final int RESULT_CODE_APPLYAID_DEL_SSD = -43;
    public static final int RESULT_CODE_APPLYAID_DPAN_INF = -44;
    public static final int RESULT_CODE_APPLYAID_EXCEED_LIMIT = -41;
    public String aid;
    public String dPan;

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(super.toString());
        stringBuilder.append("aid: ").append(this.aid);
        return stringBuilder.toString();
    }
}
