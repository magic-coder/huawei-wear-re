package com.huawei.hms.support.api.entity.pay;

import com.huawei.hms.core.aidl.p040a.C0860a;
import com.huawei.hms.support.api.entity.pay.internal.BaseReq;

public class PayReq extends BaseReq {
    @C0860a
    public String amount;
    @C0860a
    public String country;
    @C0860a
    public String currency;
    @C0860a
    public String expireTime;
    @C0860a
    public String partnerIDs;
    @C0860a
    public String productDesc;
    @C0860a
    public String productName;
    @C0860a
    public int validTime;

    public String getProductDesc() {
        return this.productDesc;
    }

    public String getProductName() {
        return this.productName;
    }

    public String getCurrency() {
        return this.currency;
    }

    public String getAmount() {
        return this.amount;
    }

    public String getCountry() {
        return this.country;
    }

    public String getPartnerIDs() {
        return this.partnerIDs;
    }

    public String getExpireTime() {
        return this.expireTime;
    }

    public int getValidTime() {
        return this.validTime;
    }
}
