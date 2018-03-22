package com.huawei.nfc.carrera.logic.spi.serveraccess.request;

public class RefundRequest extends BaseRequest {
    public RefundRequest(String str, String str2, String str3, String str4, String str5, String str6) {
        setIssuerId(str);
        setAppletAid(str2);
        setOrderId(str3);
        setDeviceModel(str4);
        setSeChipManuFacturer(str5);
        setCplc(str6);
    }
}
