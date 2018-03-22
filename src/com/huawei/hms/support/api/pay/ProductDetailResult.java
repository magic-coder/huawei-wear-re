package com.huawei.hms.support.api.pay;

import com.huawei.hms.support.api.client.Result;
import com.huawei.hms.support.api.entity.pay.ProductDetail;
import com.huawei.hms.support.api.entity.pay.ProductFailObject;
import java.util.List;

public class ProductDetailResult extends Result {
    private String f1393a;
    private List<ProductDetail> f1394b;
    private List<ProductFailObject> f1395c;

    public String getRequestId() {
        return this.f1393a;
    }

    public void setRequestId(String str) {
        this.f1393a = str;
    }

    public List<ProductDetail> getProductList() {
        return this.f1394b;
    }

    public void setProductList(List<ProductDetail> list) {
        this.f1394b = list;
    }

    public List<ProductFailObject> getFailList() {
        return this.f1395c;
    }

    public void setFailList(List<ProductFailObject> list) {
        this.f1395c = list;
    }
}
