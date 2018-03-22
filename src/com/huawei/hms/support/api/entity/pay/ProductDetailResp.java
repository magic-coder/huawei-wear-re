package com.huawei.hms.support.api.entity.pay;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.p040a.C0860a;
import java.util.List;

public class ProductDetailResp implements IMessageEntity {
    @C0860a
    public String errMsg;
    @C0860a
    public List<ProductFailObject> failList;
    @C0860a
    public List<ProductDetail> productList;
    @C0860a
    public String requestId;
    @C0860a
    public int returnCode;

    public int getReturnCode() {
        return this.returnCode;
    }

    public String getErrMsg() {
        return this.errMsg;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public List<ProductDetail> getProductList() {
        return this.productList;
    }

    public List<ProductFailObject> getFailList() {
        return this.failList;
    }
}
