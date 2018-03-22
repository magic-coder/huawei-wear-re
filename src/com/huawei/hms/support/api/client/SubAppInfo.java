package com.huawei.hms.support.api.client;

public class SubAppInfo {
    private String f1378a;

    public SubAppInfo(SubAppInfo subAppInfo) {
        if (subAppInfo != null) {
            this.f1378a = subAppInfo.getSubAppID();
        }
    }

    public SubAppInfo(String str) {
        this.f1378a = str;
    }

    public String getSubAppID() {
        return this.f1378a;
    }

    public void setSubAppID(String str) {
        this.f1378a = str;
    }
}
