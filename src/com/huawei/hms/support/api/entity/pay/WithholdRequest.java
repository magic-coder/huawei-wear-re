package com.huawei.hms.support.api.entity.pay;

import com.huawei.hms.core.aidl.p040a.C0860a;
import com.huawei.hms.support.api.entity.pay.internal.BaseReq;

public class WithholdRequest extends BaseReq {
    @C0860a
    public String amount;
    @C0860a
    public String country;
    @C0860a
    public String currency;
    @C0860a
    public String productDesc;
    @C0860a
    public String productName;
    @C0860a
    public String tradeType;

    public String getProductName() {
        return this.productName;
    }

    public String getProductDesc() {
        return this.productDesc;
    }

    public String getAmount() {
        return this.amount;
    }

    public String getCurrency() {
        return this.currency;
    }

    public String getCountry() {
        return this.country;
    }

    public String getTradeType() {
        return this.tradeType;
    }
}
