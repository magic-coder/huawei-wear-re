package com.huawei.nfc.carrera.server.card.response;

import com.huawei.hwcommonmodel.p064d.C0978h;

public class IssuerInfoServerItem {
    private String appInfo;
    private String contactNumber;
    private String creditCallCenterNumber;
    private String creditTcUrl;
    private String creditWebsite;
    private String debitCallCenterNumber;
    private String debitTcUrl;
    private String debitWebsite;
    private String description;
    private String issuerId;
    private int issuerType;
    private String logoUrl;
    private int mode;
    private String name;
    private String reservedInfo;
    private int sn;
    private int supportType;
    private long timeStamp;
    private String walletVersion;

    public String getIssuerId() {
        return (String) C0978h.a(this.issuerId);
    }

    public void setIssuerId(String str) {
        this.issuerId = (String) C0978h.a(str);
    }

    public String getName() {
        return (String) C0978h.a(this.name);
    }

    public void setName(String str) {
        this.name = (String) C0978h.a(str);
    }

    public String getDescription() {
        return (String) C0978h.a(this.description);
    }

    public void setDescription(String str) {
        this.description = (String) C0978h.a(str);
    }

    public String getLogoUrl() {
        return (String) C0978h.a(this.logoUrl);
    }

    public void setLogoUrl(String str) {
        this.logoUrl = (String) C0978h.a(str);
    }

    public int getIssuerType() {
        return ((Integer) C0978h.a(Integer.valueOf(this.issuerType))).intValue();
    }

    public void setIssuerType(int i) {
        this.issuerType = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public int getSupportType() {
        return ((Integer) C0978h.a(Integer.valueOf(this.supportType))).intValue();
    }

    public void setSupportType(int i) {
        this.supportType = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public int getMode() {
        return ((Integer) C0978h.a(Integer.valueOf(this.mode))).intValue();
    }

    public void setMode(int i) {
        this.mode = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public String getWalletVersion() {
        return (String) C0978h.a(this.walletVersion);
    }

    public void setWalletVersion(String str) {
        this.walletVersion = (String) C0978h.a(str);
    }

    public String getContactNumber() {
        return (String) C0978h.a(this.contactNumber);
    }

    public void setContactNumber(String str) {
        this.contactNumber = (String) C0978h.a(str);
    }

    public String getDebitCallCenterNumber() {
        return (String) C0978h.a(this.debitCallCenterNumber);
    }

    public void setDebitCallCenterNumber(String str) {
        this.debitCallCenterNumber = (String) C0978h.a(str);
    }

    public String getCreditCallCenterNumber() {
        return (String) C0978h.a(this.creditCallCenterNumber);
    }

    public void setCreditCallCenterNumber(String str) {
        this.creditCallCenterNumber = (String) C0978h.a(str);
    }

    public String getDebitTcUrl() {
        return (String) C0978h.a(this.debitTcUrl);
    }

    public void setDebitTcUrl(String str) {
        this.debitTcUrl = (String) C0978h.a(str);
    }

    public String getCreditTcUrl() {
        return (String) C0978h.a(this.creditTcUrl);
    }

    public void setCreditTcUrl(String str) {
        this.creditTcUrl = (String) C0978h.a(str);
    }

    public String getDebitWebsite() {
        return (String) C0978h.a(this.debitWebsite);
    }

    public void setDebitWebsite(String str) {
        this.debitWebsite = (String) C0978h.a(str);
    }

    public String getCreditWebsite() {
        return (String) C0978h.a(this.creditWebsite);
    }

    public void setCreditWebsite(String str) {
        this.creditWebsite = (String) C0978h.a(str);
    }

    public String getAppInfo() {
        return (String) C0978h.a(this.appInfo);
    }

    public void setAppInfo(String str) {
        this.appInfo = (String) C0978h.a(str);
    }

    public long getTimeStamp() {
        return ((Long) C0978h.a(Long.valueOf(this.timeStamp))).longValue();
    }

    public void setTimeStamp(long j) {
        this.timeStamp = ((Long) C0978h.a(Long.valueOf(j))).longValue();
    }

    public String getReservedInfo() {
        return (String) C0978h.a(this.reservedInfo);
    }

    public void setReservedInfo(String str) {
        this.reservedInfo = (String) C0978h.a(str);
    }

    public int getSn() {
        return ((Integer) C0978h.a(Integer.valueOf(this.sn))).intValue();
    }

    public void setSn(int i) {
        this.sn = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }
}
