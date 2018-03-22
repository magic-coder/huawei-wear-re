package com.huawei.nfc.carrera.server.card.request;

public class ServerAccessQueryAmountRequest extends ServerAccessBaseRequest {
    private String flag = null;

    public ServerAccessQueryAmountRequest(String str, String str2, String str3, String str4, String str5, String str6) {
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
