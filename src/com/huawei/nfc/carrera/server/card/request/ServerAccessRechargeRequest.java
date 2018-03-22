package com.huawei.nfc.carrera.server.card.request;

public class ServerAccessRechargeRequest extends ServerAccessBaseRequest {
    public static final String RECHARGE_MODE_FIRST = "0";
    public static final String RECHARGE_MODE_REPEAT = "1";
    private String rechargeMode = null;

    public ServerAccessRechargeRequest(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        setIssuerId(str);
        setAppletAid(str2);
        setCplc(str3);
        setCardId(str5);
        setOrderId(str4);
        setSystemType(str6);
        setSystemVersion(str7);
        setDeviceModel(str8);
        setSeChipManuFacturer(str9);
    }

    public String getRechargeMode() {
        return this.rechargeMode;
    }

    public void setRechargeMode(String str) {
        this.rechargeMode = str;
    }
}
