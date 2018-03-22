package com.snowballtech.business.bean;

import java.io.Serializable;

public class ServerOtherResponse implements Serializable {
    private CardcouponData data;
    private String message;
    private String response_time_stamp;
    private String status;

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String str) {
        this.status = str;
    }

    public String getResponse_time_stamp() {
        return this.response_time_stamp;
    }

    public void setResponse_time_stamp(String str) {
        this.response_time_stamp = str;
    }

    public CardcouponData getData() {
        return this.data;
    }

    public void setData(CardcouponData cardcouponData) {
        this.data = cardcouponData;
    }
}
