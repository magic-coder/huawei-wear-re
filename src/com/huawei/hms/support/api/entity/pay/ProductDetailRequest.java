package com.huawei.hms.support.api.entity.pay;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.p040a.C0860a;

public class ProductDetailRequest implements IMessageEntity {
    @C0860a
    public String applicationID;
    @C0860a
    public String merchantId;
    @C0860a
    public String productNos;
    @C0860a
    public String requestId;

    public String getMerchantId() {
        return this.merchantId;
    }

    public String getApplicationID() {
        return this.applicationID;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public String getProductNos() {
        return this.productNos;
    }
}
