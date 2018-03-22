package com.huawei.hwid.core.exception;

public class TokenInvalidatedException extends Exception {
    private String f18794a;

    public TokenInvalidatedException(String str) {
        super(str);
        this.f18794a = str;
    }

    public String getErrorDesc() {
        return this.f18794a;
    }

    public void setErrorDesc(String str) {
        this.f18794a = str;
    }
}
