package com.huawei.nfc.carrera.logic.oma.internal;

public class OmaException extends Exception {
    private int errorCode;

    public OmaException(int i, String str) {
        super(str);
        this.errorCode = i;
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public void setErrorCode(int i) {
        this.errorCode = i;
    }
}
