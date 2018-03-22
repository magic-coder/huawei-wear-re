package com.huawei.hms.support.api.entity.pay;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.p040a.C0860a;

public class ProductFailObject implements IMessageEntity {
    @C0860a
    public int code;
    @C0860a
    public String msg;
    @C0860a
    public String productNo;

    public String getProductNo() {
        return this.productNo;
    }

    public int getCode() {
        return this.code;
    }

    public String getMsg() {
        return this.msg;
    }
}
