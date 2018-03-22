package com.huawei.pluginkidwatch.common.entity.model;

import java.io.Serializable;

public class Banlance implements Serializable {
    public String balanceMessage;
    public String time;

    public String getBalanceMessage() {
        return this.balanceMessage;
    }

    public void setBalanceMessage(String str) {
        this.balanceMessage = str;
    }

    public String getTime() {
        return this.time;
    }

    public void setTime(String str) {
        this.time = str;
    }

    public String toString() {
        return "Banlance{balanceMessage='" + this.balanceMessage + '\'' + ", time='" + this.time + '\'' + '}';
    }
}
