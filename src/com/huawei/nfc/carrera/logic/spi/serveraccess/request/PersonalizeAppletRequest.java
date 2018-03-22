package com.huawei.nfc.carrera.logic.spi.serveraccess.request;

public class PersonalizeAppletRequest extends BaseRequest {
    public PersonalizeAppletRequest(String str, String str2, String str3, String str4, String str5, String str6) {
        setIssuerId(str);
        setOrderId(str2);
        setCplc(str3);
        setAppletAid(str4);
        setDeviceModel(str5);
        setSeChipManuFacturer(str6);
    }
}
