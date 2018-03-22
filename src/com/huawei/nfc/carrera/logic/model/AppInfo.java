package com.huawei.nfc.carrera.logic.model;

import android.graphics.Bitmap;

public class AppInfo {
    private Bitmap apkIcon;
    private String apkIconUrl;
    private String apkName;
    private String issuerAppMarketId;
    private String issuerAppPkg;
    private int supportType;

    public String getIssuerAppPkg() {
        return this.issuerAppPkg;
    }

    public void setIssuerAppPkg(String str) {
        this.issuerAppPkg = str;
    }

    public String getIssuerAppMarketId() {
        return this.issuerAppMarketId;
    }

    public void setIssuerAppMarketId(String str) {
        this.issuerAppMarketId = str;
    }

    public int getSupportType() {
        return this.supportType;
    }

    public void setSupportType(int i) {
        this.supportType = i;
    }

    public String getApkIconUrl() {
        return this.apkIconUrl;
    }

    public void setApkIconUrl(String str) {
        this.apkIconUrl = str;
    }

    public Bitmap getApkIcon() {
        return this.apkIcon;
    }

    public void setApkIcon(Bitmap bitmap) {
        this.apkIcon = bitmap;
    }

    public String getApkName() {
        return this.apkName;
    }

    public void setApkName(String str) {
        this.apkName = str;
    }
}
