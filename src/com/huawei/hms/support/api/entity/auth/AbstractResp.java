package com.huawei.hms.support.api.entity.auth;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.p040a.C0860a;

public abstract class AbstractResp implements IMessageEntity {
    @C0860a
    private String errorReason;
    @C0860a
    private int rtnCode = 0;

    public int getRtnCode() {
        return this.rtnCode;
    }

    public void setRtnCode(int i) {
        this.rtnCode = i;
    }

    public String getErrorReason() {
        return this.errorReason;
    }

    public void setErrorReason(String str) {
        this.errorReason = str;
    }
}
