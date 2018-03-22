package com.huawei.nfc.carrera.logic.security.fingerprint;

public class FingerPrintAuthUnusableException extends Exception {
    private int code;

    public FingerPrintAuthUnusableException(int i) {
        this.code = i;
    }

    public long getCode() {
        return (long) this.code;
    }
}
