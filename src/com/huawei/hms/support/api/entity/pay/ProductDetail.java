package com.huawei.hms.support.api.entity.pay;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.p040a.C0860a;

public class ProductDetail implements IMessageEntity {
    @C0860a
    public String country;
    @C0860a
    public String currency;
    @C0860a
    public long microsPrice;
    @C0860a
    public String price;
    @C0860a
    public String productDesc;
    @C0860a
    public String productName;
    @C0860a
    public String productNo;

    public String getProductNo() {
        return this.productNo;
    }

    public long getMicrosPrice() {
        return this.microsPrice;
    }

    public String getPrice() {
        return this.price;
    }

    public String getCurrency() {
        return this.currency;
    }

    public String getCountry() {
        return this.country;
    }

    public String getProductName() {
        return this.productName;
    }

    public String getProductDesc() {
        return this.productDesc;
    }
}
