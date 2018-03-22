package com.huawei.hms.core.aidl;

import com.huawei.hms.core.aidl.p040a.C0860a;

public class RequestHeader implements IMessageEntity {
    @C0860a
    private String appId;
    @C0860a
    private String packageName;
    @C0860a
    private int sdkVersion;
    @C0860a
    private String sessionId;

    public RequestHeader(String str, String str2, int i, String str3) {
        this.appId = str;
        this.packageName = str2;
        this.sdkVersion = i;
        this.sessionId = str3;
    }

    public void setAppID(String str) {
        this.appId = str;
    }

    public String getAppID() {
        return this.appId;
    }

    public void setPackageName(String str) {
        this.packageName = str;
    }

    public String getPackageName() {
        return this.packageName;
    }

    public void setSdkVersion(int i) {
        this.sdkVersion = i;
    }

    public int getSdkVersion() {
        return this.sdkVersion;
    }

    public void setSessionId(String str) {
        this.sessionId = str;
    }

    public String getSessionId() {
        return this.sessionId;
    }
}
