package com.huawei.nfc.carrera.logic.spi.serveraccess.request;

public class QueryAmountRequest extends BaseRequest {
    public static final String FLAG_ISSUE = "3";
    public static final String FLAG_ISSUE_RECHARGE = "1";
    public static final String FLAG_RECHARGE = "2";
    private String flag = null;

    public QueryAmountRequest(String str, String str2, String str3, String str4, String str5, String str6) {
        setIssuerId(str);
        setCplc(str3);
        setAppletAid(str4);
        setDeviceModel(str5);
        setSeChipManuFacturer(str6);
        this.flag = str2;
    }

    public String getFlag() {
        return this.flag;
    }

    public void setFlag(String str) {
        this.flag = str;
    }
}
