package com.huawei.common.applog.bean;

public class Event {
    private String appPackageName;
    private String appVersionName;
    private String clientErrorCode;
    private String connTime;
    private String dnsTime;
    private String domain;
    private String errorReason;
    private ExtraBundle extraData;
    private String operationType;
    private String preTranTime;
    private String resourcePath;
    private String returnCode;
    private String serverIp;
    private String sizeDownload;
    private String sizeUpload;
    private String startTranTime;
    private String totalTime;

    public ExtraBundle getExtraData() {
        return this.extraData;
    }

    public void setExtraData(ExtraBundle extraBundle) {
        this.extraData = extraBundle;
    }

    public String getOperationType() {
        return this.operationType;
    }

    public void setOperationType(String str) {
        this.operationType = str;
    }

    public String getResourcePath() {
        return this.resourcePath;
    }

    public void setResourcePath(String str) {
        this.resourcePath = str;
    }

    public String getClientErrorCode() {
        return this.clientErrorCode;
    }

    public void setClientErrorCode(String str) {
        this.clientErrorCode = str;
    }

    public String getErrorReason() {
        return this.errorReason;
    }

    public void setErrorReason(String str) {
        this.errorReason = str;
    }

    public String getReturnCode() {
        return this.returnCode;
    }

    public void setReturnCode(String str) {
        this.returnCode = str;
    }

    public String getSizeUpload() {
        return this.sizeUpload;
    }

    public void setSizeUpload(String str) {
        this.sizeUpload = str;
    }

    public String getSizeDownload() {
        return this.sizeDownload;
    }

    public void setSizeDownload(String str) {
        this.sizeDownload = str;
    }

    public String getTotalTime() {
        return this.totalTime;
    }

    public void setTotalTime(String str) {
        this.totalTime = str;
    }

    public String getStartTranTime() {
        return this.startTranTime;
    }

    public void setStartTranTime(String str) {
        this.startTranTime = str;
    }

    public String getPreTranTime() {
        return this.preTranTime;
    }

    public void setPreTranTime(String str) {
        this.preTranTime = str;
    }

    public String getConnTime() {
        return this.connTime;
    }

    public void setConnTime(String str) {
        this.connTime = str;
    }

    public String getDnsTime() {
        return this.dnsTime;
    }

    public void setDnsTime(String str) {
        this.dnsTime = str;
    }

    public String getServerIp() {
        return this.serverIp;
    }

    public void setServerIp(String str) {
        this.serverIp = str;
    }

    public String getDomain() {
        return this.domain;
    }

    public void setDomain(String str) {
        this.domain = str;
    }

    public String getAppPackageName() {
        return this.appPackageName;
    }

    public void setAppPackageName(String str) {
        this.appPackageName = str;
    }

    public String getAppVersionName() {
        return this.appVersionName;
    }

    public void setAppVersionName(String str) {
        this.appVersionName = str;
    }
}
