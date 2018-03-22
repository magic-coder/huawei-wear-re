package com.huawei.nfc.carrera.lifecycle.push.data;

public class PushNullifyAccountMessage {
    static final String NULLIFY_PUSH_MSG_KEY_CPLC = "cplc";
    static final String NULLIFY_PUSH_MSG_KEY_SIGN = "sign";
    static final String NULLIFY_PUSH_MSG_KEY_USERID = "uid";
    static final String NULLIFY_PUSH_MSG_TYPE = "delaccount";
    private String cplc;
    private String sign;
    private String user;

    public String getUser() {
        return this.user;
    }

    public void setUser(String str) {
        this.user = str;
    }

    public String getCplc() {
        return this.cplc;
    }

    public void setCplc(String str) {
        this.cplc = str;
    }

    public String getSign() {
        return this.sign;
    }

    public void setSign(String str) {
        this.sign = str;
    }
}
