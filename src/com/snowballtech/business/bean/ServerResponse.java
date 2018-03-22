package com.snowballtech.business.bean;

import java.io.Serializable;

public class ServerResponse implements Serializable {
    private String data;
    private String response_time_stamp;
    private String result_code;
    private String result_msg;

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

    public String getResponse_time_stamp() {
        return this.response_time_stamp;
    }

    public void setResponse_time_stamp(String str) {
        this.response_time_stamp = str;
    }

    public String getData() {
        return this.data;
    }

    public void setData(String str) {
        this.data = str;
    }
}
