package com.huawei.hms.support.api.pay;

import android.content.Intent;
import com.huawei.hms.api.HuaweiApiClient;
import com.huawei.hms.support.api.client.PendingResult;
import com.huawei.hms.support.api.entity.pay.PayReq;
import com.huawei.hms.support.api.entity.pay.ProductDetailRequest;
import com.huawei.hms.support.api.entity.pay.ProductPayRequest;
import com.huawei.hms.support.api.entity.pay.WithholdRequest;

public interface HuaweiPayApi {
    PendingResult<PayResult> addWithholdingPlan(HuaweiApiClient huaweiApiClient, WithholdRequest withholdRequest);

    PayResultInfo getPayResultInfoFromIntent(Intent intent);

    PendingResult<ProductDetailResult> getProductDetails(HuaweiApiClient huaweiApiClient, ProductDetailRequest productDetailRequest);

    ProductPayResultInfo getProductPayResultFromIntent(Intent intent);

    PendingResult<PayResult> pay(HuaweiApiClient huaweiApiClient, PayReq payReq);

    PendingResult<PayResult> productPay(HuaweiApiClient huaweiApiClient, ProductPayRequest productPayRequest);
}
