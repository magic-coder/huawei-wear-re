package com.snowballtech.common.log;

public class LogFilter {
    private String logFilterTag;
    private String logShowTag;
    private int status;

    public String getLogShowTag() {
        return this.logShowTag;
    }

    public void setLogShowTag(String str) {
        this.logShowTag = str;
    }

    public String getLogFilterTag() {
        return this.logFilterTag;
    }

    public void setLogFilterTag(String str) {
        this.logFilterTag = str;
    }

    public int getStatus() {
        return this.status;
    }

    public void setStatus(int i) {
        this.status = i;
    }
}
