package com.huawei.membercenter.sdk.membersdklibrary.api.model;

public class MemberInfoResponse {
    private int code;
    private String curTime;
    private String deviceLevel;
    private String expireTime;
    private int intentGrowth;
    private int intentLevel;
    private String intentLevelName;
    private String levelIconUrl;
    private String levelName;
    private String memAdDesc;
    private String memAdLevel;
    private String memAdTitle;
    private String memLevel;
    private String reason;

    public int getCode() {
        return this.code;
    }

    public void setCode(int i) {
        this.code = i;
    }

    public String getReason() {
        return this.reason;
    }

    public void setReason(String str) {
        this.reason = str;
    }

    public String getMemLevel() {
        return this.memLevel;
    }

    public void setMemLevel(String str) {
        this.memLevel = str;
    }

    public String getMemAdLevel() {
        return this.memAdLevel;
    }

    public void setMemAdLevel(String str) {
        this.memAdLevel = str;
    }

    public int getIntentLevel() {
        return this.intentLevel;
    }

    public void setIntentLevel(int i) {
        this.intentLevel = i;
    }

    public String getIntentLevelName() {
        return this.intentLevelName;
    }

    public void setIntentLevelName(String str) {
        this.intentLevelName = str;
    }

    public int getIntentGrowth() {
        return this.intentGrowth;
    }

    public void setIntentGrowth(int i) {
        this.intentGrowth = i;
    }

    public String getMemAdDesc() {
        return this.memAdDesc;
    }

    public void setMemAdDesc(String str) {
        this.memAdDesc = str;
    }

    public String getMemAdTitle() {
        return this.memAdTitle;
    }

    public void setMemAdTitle(String str) {
        this.memAdTitle = str;
    }

    public String getLevelName() {
        return this.levelName;
    }

    public void setLevelName(String str) {
        this.levelName = str;
    }

    public String getLevelIconUrl() {
        return this.levelIconUrl;
    }

    public void setLevelIconUrl(String str) {
        this.levelIconUrl = str;
    }

    public String getExpireTime() {
        return this.expireTime;
    }

    public void setExpireTime(String str) {
        this.expireTime = str;
    }

    public String getDeviceLevel() {
        return this.deviceLevel;
    }

    public void setDeviceLevel(String str) {
        this.deviceLevel = str;
    }

    public String getCurTime() {
        return this.curTime;
    }

    public void setCurTime(String str) {
        this.curTime = str;
    }
}
