package com.huawei.nfc.carrera.logic.spi.serveraccess.request;

public class DownloadAndInstallAppletRequest extends BaseRequest {
    public DownloadAndInstallAppletRequest(String str, String str2, String str3, String str4, String str5) {
        setIssuerId(str);
        setCplc(str2);
        setAppletAid(str3);
        setDeviceModel(str4);
        setSeChipManuFacturer(str5);
    }
}
