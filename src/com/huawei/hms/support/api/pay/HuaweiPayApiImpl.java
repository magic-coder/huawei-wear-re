package com.huawei.hms.support.api.pay;

import android.content.Intent;
import android.os.Bundle;
import com.huawei.hms.api.HuaweiApiClient;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.support.api.C0871a;
import com.huawei.hms.support.api.client.ApiClient;
import com.huawei.hms.support.api.client.PendingResult;
import com.huawei.hms.support.api.client.Result;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.entity.pay.HwPayConstant;
import com.huawei.hms.support.api.entity.pay.PayNaming;
import com.huawei.hms.support.api.entity.pay.PayReq;
import com.huawei.hms.support.api.entity.pay.PayResp;
import com.huawei.hms.support.api.entity.pay.ProductDetailRequest;
import com.huawei.hms.support.api.entity.pay.ProductDetailResp;
import com.huawei.hms.support.api.entity.pay.ProductPayRequest;
import com.huawei.hms.support.api.entity.pay.WithholdRequest;
import com.huawei.hms.support.log.C0887a;
import com.huawei.nfc.carrera.logic.appletcardinfo.model.HciConfigInfo;

public class HuaweiPayApiImpl implements HuaweiPayApi {

    class C0879a extends C0871a<PayResult, PayResp> {
        public /* synthetic */ Result onComplete(IMessageEntity iMessageEntity) {
            return m3074a((PayResp) iMessageEntity);
        }

        public C0879a(ApiClient apiClient, String str, IMessageEntity iMessageEntity) {
            super(apiClient, str, iMessageEntity);
        }

        public PayResult m3074a(PayResp payResp) {
            if (payResp == null) {
                C0887a.m3098d("HuaweiPayApiImpl", "pay resp is null");
                return null;
            }
            if (C0887a.m3093a()) {
                C0887a.m3094b("HuaweiPayApiImpl", "pay resp :" + payResp.retCode);
            }
            PayResult payResult = new PayResult();
            payResult.setStatus(new Status(payResp.retCode, null, payResp.getPendingIntent()));
            return payResult;
        }
    }

    class C0880b extends C0871a<ProductDetailResult, ProductDetailResp> {
        public /* synthetic */ Result onComplete(IMessageEntity iMessageEntity) {
            return m3075a((ProductDetailResp) iMessageEntity);
        }

        public C0880b(ApiClient apiClient, String str, IMessageEntity iMessageEntity) {
            super(apiClient, str, iMessageEntity);
        }

        public ProductDetailResult m3075a(ProductDetailResp productDetailResp) {
            if (productDetailResp == null) {
                C0887a.m3098d("HuaweiPayApiImpl", "produuctDetailResp is null");
                return null;
            }
            if (C0887a.m3093a()) {
                C0887a.m3094b("HuaweiPayApiImpl", "produuctDetail resp :" + productDetailResp.returnCode);
            }
            ProductDetailResult productDetailResult = new ProductDetailResult();
            productDetailResult.setStatus(new Status(productDetailResp.returnCode, productDetailResp.errMsg));
            productDetailResult.setFailList(productDetailResp.getFailList());
            productDetailResult.setProductList(productDetailResp.getProductList());
            productDetailResult.setRequestId(productDetailResp.getRequestId());
            return productDetailResult;
        }
    }

    public PendingResult<PayResult> pay(HuaweiApiClient huaweiApiClient, PayReq payReq) {
        if (C0887a.m3093a()) {
            C0887a.m3094b("HuaweiPayApiImpl", "start to pay");
        }
        return new C0879a(huaweiApiClient, PayNaming.pay, payReq);
    }

    public PendingResult<PayResult> addWithholdingPlan(HuaweiApiClient huaweiApiClient, WithholdRequest withholdRequest) {
        if (C0887a.m3093a()) {
            C0887a.m3094b("HuaweiPayApiImpl", "start to addWithholdingPlan");
        }
        return new C0879a(huaweiApiClient, PayNaming.withhold, withholdRequest);
    }

    public PayResultInfo getPayResultInfoFromIntent(Intent intent) {
        PayResultInfo payResultInfo = null;
        if (intent == null) {
            C0887a.m3098d("HuaweiPayApiImpl", "getPayResultInfoFromIntent intent is null");
        } else {
            Bundle extras = intent.getExtras();
            if (extras == null) {
                C0887a.m3098d("HuaweiPayApiImpl", "getPayResultInfoFromIntent bundle is null");
            } else {
                payResultInfo = new PayResultInfo();
                payResultInfo.setReturnCode(extras.getInt("returnCode"));
                payResultInfo.setUserName(extras.getString(HwPayConstant.KEY_USER_NAME));
                payResultInfo.setOrderID(extras.getString("orderID"));
                payResultInfo.setAmount(extras.getString("amount"));
                payResultInfo.setErrMsg(extras.getString("errMsg"));
                payResultInfo.setTime(extras.getString(HciConfigInfo.HCI_DATA_TYPE_TRANSCTION_TIME));
                payResultInfo.setCountry(extras.getString("country"));
                payResultInfo.setCurrency(extras.getString(HwPayConstant.KEY_CURRENCY));
                payResultInfo.setWithholdID(extras.getString("withholdID"));
                payResultInfo.setRequestId(extras.getString(HwPayConstant.KEY_REQUESTID));
                payResultInfo.setSign(extras.getString("sign"));
                if (C0887a.m3095b()) {
                    C0887a.m3094b("HuaweiPayApiImpl", "final pay result info::" + payResultInfo.getReturnCode());
                }
            }
        }
        return payResultInfo;
    }

    public PendingResult<ProductDetailResult> getProductDetails(HuaweiApiClient huaweiApiClient, ProductDetailRequest productDetailRequest) {
        return new C0880b(huaweiApiClient, PayNaming.productdetail, productDetailRequest);
    }

    public PendingResult<PayResult> productPay(HuaweiApiClient huaweiApiClient, ProductPayRequest productPayRequest) {
        if (C0887a.m3093a()) {
            C0887a.m3094b("HuaweiPayApiImpl", "start to productPay");
        }
        return new C0879a(huaweiApiClient, PayNaming.pms, productPayRequest);
    }

    public ProductPayResultInfo getProductPayResultFromIntent(Intent intent) {
        ProductPayResultInfo productPayResultInfo = null;
        if (intent == null) {
            C0887a.m3098d("HuaweiPayApiImpl", "getProductPayResultFromIntent intent is null");
        } else {
            Bundle extras = intent.getExtras();
            if (extras == null) {
                C0887a.m3098d("HuaweiPayApiImpl", "getProductPayResultFromIntent bundle is null");
            } else {
                productPayResultInfo = new ProductPayResultInfo();
                productPayResultInfo.setReturnCode(extras.getInt("returnCode"));
                productPayResultInfo.setOrderID(extras.getString("orderID"));
                productPayResultInfo.setErrMsg(extras.getString("errMsg"));
                productPayResultInfo.setProductNo(extras.getString(HwPayConstant.KEY_PRODUCT_NO));
                productPayResultInfo.setMicrosAmount(extras.getLong("microsAmount"));
                productPayResultInfo.setTime(extras.getString(HciConfigInfo.HCI_DATA_TYPE_TRANSCTION_TIME));
                productPayResultInfo.setCountry(extras.getString("country"));
                productPayResultInfo.setCurrency(extras.getString(HwPayConstant.KEY_CURRENCY));
                productPayResultInfo.setRequestId(extras.getString(HwPayConstant.KEY_REQUESTID));
                productPayResultInfo.setMerchantId(extras.getString("merchantId"));
                productPayResultInfo.setSign(extras.getString("sign"));
                if (C0887a.m3095b()) {
                    C0887a.m3094b("HuaweiPayApiImpl", "final product pay result info::" + productPayResultInfo.getReturnCode());
                }
            }
        }
        return productPayResultInfo;
    }
}
