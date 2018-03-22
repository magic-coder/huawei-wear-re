package com.snowballtech.common.bean;

import com.snowballtech.common.constant.CodeMessage;

public class TaskResult<T> {
    private T data;
    private String result_code = "499999";
    private String result_msg = CodeMessage.EXCEPTION_ERROR_MSG;

    public String getResult_code() {
        return this.result_code;
    }

    public void setResult_code(String str) {
        this.result_code = str;
    }

    public String getResult_msg() {
        return this.result_msg;
    }

    public void setResult_msg(String str) {
        this.result_msg = str;
    }

    public T getData() {
        return this.data;
    }

    public void setData(T t) {
        this.data = t;
    }
}
