package com.huawei.hms.support.api.entity.auth;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.p040a.C0860a;

public class PermissionInfo implements IMessageEntity {
    @C0860a
    private String appID;
    @C0860a
    private String packageName;
    @C0860a
    private String permission;

    public PermissionInfo(String str, String str2, String str3) {
        this.appID = str;
        this.packageName = str2;
        this.permission = str3;
    }

    public String getAppID() {
        return this.appID;
    }

    public void setAppID(String str) {
        this.appID = str;
    }

    public String getPackageName() {
        return this.packageName;
    }

    public void setPackageName(String str) {
        this.packageName = str;
    }

    public String getPermission() {
        return this.permission;
    }

    public PermissionInfo setPermissionUri(String str) {
        this.permission = str;
        return this;
    }

    public void setPermission(String str) {
        this.permission = str;
    }
}
