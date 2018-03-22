package com.huawei.hms.support.api.entity.pay;

import com.huawei.hms.core.aidl.p040a.C0860a;
import com.huawei.hms.support.api.entity.pay.internal.BaseReq;

public class ProductPayRequest extends BaseReq {
    @C0860a
    public String expireTime;
    @C0860a
    public String productNo;
    @C0860a
    public int validTime;

    public String getProductNo() {
        return this.productNo;
    }

    public int getValidTime() {
        return this.validTime;
    }

    public String getExpireTime() {
        return this.expireTime;
    }
}
