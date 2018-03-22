package com.amap.api.services.core;

public class ServiceSettings {
    public static final String CHINESE = "zh-CN";
    public static final String ENGLISH = "en";
    public static final int HTTP = 1;
    public static final int HTTPS = 2;
    private static ServiceSettings f12289c;
    private String f12290a = "zh-CN";
    private int f12291b = 1;
    private int f12292d = 20000;
    private int f12293e = 20000;

    public int getConnectionTimeOut() {
        return this.f12292d;
    }

    public int getSoTimeOut() {
        return this.f12293e;
    }

    public void setConnectionTimeOut(int i) {
        if (i < 5000) {
            this.f12292d = 5000;
        } else if (i > 30000) {
            this.f12292d = 30000;
        } else {
            this.f12292d = i;
        }
    }

    public void setSoTimeOut(int i) {
        if (i < 5000) {
            this.f12293e = 5000;
        } else if (i > 30000) {
            this.f12293e = 30000;
        } else {
            this.f12293e = i;
        }
    }

    private ServiceSettings() {
    }

    public static ServiceSettings getInstance() {
        if (f12289c == null) {
            f12289c = new ServiceSettings();
        }
        return f12289c;
    }

    public void setLanguage(String str) {
        if ("en".equals(str) || "zh-CN".equals(str)) {
            this.f12290a = str;
        }
    }

    public void setProtocol(int i) {
        this.f12291b = i;
    }

    public String getLanguage() {
        return this.f12290a;
    }

    public int getProtocol() {
        return this.f12291b;
    }

    public void setApiKey(String str) {
        C3435x.m16995a(str);
    }
}
