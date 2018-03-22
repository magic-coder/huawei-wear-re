package com.snowballtech.business.bean;

public class AppletStatus {
    private String aid;
    private String status;

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String str) {
        this.status = str;
    }

    public String getAid() {
        return this.aid;
    }

    public void setAid(String str) {
        this.aid = str;
    }

    public String toString() {
        return "aid:" + this.aid + ",status:" + this.status;
    }
}
