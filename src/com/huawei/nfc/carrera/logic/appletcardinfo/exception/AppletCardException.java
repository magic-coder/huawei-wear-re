package com.huawei.nfc.carrera.logic.appletcardinfo.exception;

public class AppletCardException extends Exception {
    private int errCode;

    public AppletCardException(int i) {
        this.errCode = i;
    }

    public AppletCardException(int i, String str) {
        super(str);
        this.errCode = i;
    }

    public int getErrCode() {
        return this.errCode;
    }
}
