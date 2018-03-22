package com.huawei.hms.core.aidl;

import com.huawei.hms.core.aidl.p040a.C0860a;

public class ResponseHeader implements IMessageEntity {
    @C0860a
    protected int statusCode;

    public ResponseHeader(int i) {
        this.statusCode = i;
    }

    public int getStatusCode() {
        return this.statusCode;
    }
}
