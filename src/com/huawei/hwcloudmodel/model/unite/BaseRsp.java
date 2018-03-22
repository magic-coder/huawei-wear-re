package com.huawei.hwcloudmodel.model.unite;

public class BaseRsp {
    public static final int ERROR_AUTH_FAILED = 1002;
    public static final int ERROR_TOKEN_TIMEOUT = 1004;
    public int resultCode = 0;

    public String toString() {
        return "ErrorCode{" + this.resultCode;
    }
}
