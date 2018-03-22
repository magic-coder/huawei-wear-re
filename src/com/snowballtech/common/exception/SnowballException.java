package com.snowballtech.common.exception;

import com.snowballtech.common.constant.CodeMessage;
import com.snowballtech.common.log.LogUtil;

public class SnowballException extends Exception {
    private int result_code = CodeMessage.EXCEPTION_ERROR;

    public SnowballException(String str) {
        super(str);
    }

    public SnowballException(String str, int i) {
        super(str);
        this.result_code = i;
        LogUtil.log("set code is " + getResult_code() + "message is " + getMessage());
    }

    public SnowballException(String str, Throwable th) {
        super(str, th);
    }

    public SnowballException(Throwable th) {
        super(th);
    }

    public int getResult_code() {
        return this.result_code;
    }

    public void setResult_code(int i) {
        this.result_code = i;
    }
}
