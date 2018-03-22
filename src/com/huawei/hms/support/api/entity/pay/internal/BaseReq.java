package com.huawei.hms.support.api.entity.pay.internal;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.p040a.C0860a;

public class BaseReq implements IMessageEntity {
    @C0860a
    public String applicationID;
    @C0860a
    public String extReserved;
    @C0860a
    public String merchantId;
    @C0860a
    public String merchantName;
    @C0860a
    public String requestId;
    @C0860a
    public int sdkChannel;
    @C0860a
    public String serviceCatalog;
    @C0860a
    public String sign;
    @C0860a
    public String url;
    @C0860a
    public String urlVer;

    public String getMerchantId() {
        return this.merchantId;
    }

    public String getMerchantName() {
        return this.merchantName;
    }

    public String getApplicationID() {
        return this.applicationID;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public String getUrlVer() {
        return this.urlVer;
    }

    public int getSdkChannel() {
        return this.sdkChannel;
    }

    public String getExtReserved() {
        return this.extReserved;
    }

    public String getServiceCatalog() {
        return this.serviceCatalog;
    }

    public String getUrl() {
        return this.url;
    }

    public String getSign() {
        return this.sign;
    }
}
