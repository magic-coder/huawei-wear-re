package com.huawei.nfc.carrera.server.card.model;

import com.huawei.hms.support.api.entity.pay.HwPayConstant;
import com.huawei.nfc.carrera.logic.spi.snb.constant.SNBConstant;
import com.huawei.nfc.carrera.server.card.impl.JSONHelper;
import com.huawei.nfc.carrera.util.LogX;
import org.json.JSONException;
import org.json.JSONObject;

public class ServerAccessApplyOrder {
    public static final String ORDER_TYPE_OPEN_CARD = "0";
    public static final String ORDER_TYPE_OPEN_CARD_AND_RECHARGE = "2";
    public static final String ORDER_TYPE_RECHARGE = "1";
    private String SPMerchantId = null;
    private String accessMode = null;
    private String amount = null;
    private String applicationId = null;
    private String currency = null;
    private String merchantName = null;
    private String orderId = null;
    private String orderTime = null;
    private String orderType = null;
    private String packageName = null;
    private String productDesc = null;
    private String productName = null;
    private String sdkChannel = null;
    private String serviceCatalog = null;
    private String sign = null;
    private String signType = null;
    private String url = null;
    private String urlVer = null;

    public String getSdkChannel() {
        return this.sdkChannel;
    }

    public void setSdkChannel(String str) {
        this.sdkChannel = str;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public String getUrlVer() {
        return this.urlVer;
    }

    public void setUrlVer(String str) {
        this.urlVer = str;
    }

    public String getOrderId() {
        return this.orderId;
    }

    public void setOrderId(String str) {
        this.orderId = str;
    }

    public String getSPMerchantId() {
        return this.SPMerchantId;
    }

    public void setSPMerchantId(String str) {
        this.SPMerchantId = str;
    }

    public String getMerchantName() {
        return this.merchantName;
    }

    public void setMerchantName(String str) {
        this.merchantName = str;
    }

    public String getApplicationId() {
        return this.applicationId;
    }

    public void setApplicationId(String str) {
        this.applicationId = str;
    }

    public String getPackageName() {
        return this.packageName;
    }

    public void setPackageName(String str) {
        this.packageName = str;
    }

    public String getAccessMode() {
        return this.accessMode;
    }

    public void setAccessMode(String str) {
        this.accessMode = str;
    }

    public String getServiceCatalog() {
        return this.serviceCatalog;
    }

    public void setServiceCatalog(String str) {
        this.serviceCatalog = str;
    }

    public String getProductName() {
        return this.productName;
    }

    public void setProductName(String str) {
        this.productName = str;
    }

    public String getProductDesc() {
        return this.productDesc;
    }

    public void setProductDesc(String str) {
        this.productDesc = str;
    }

    public String getSignType() {
        return this.signType;
    }

    public void setSignType(String str) {
        this.signType = str;
    }

    public String getSign() {
        return this.sign;
    }

    public void setSign(String str) {
        this.sign = str;
    }

    public String getAmount() {
        return this.amount;
    }

    public void setAmount(String str) {
        this.amount = str;
    }

    public String getCurrency() {
        return this.currency;
    }

    public void setCurrency(String str) {
        this.currency = str;
    }

    public String getOrderType() {
        return this.orderType;
    }

    public void setOrderType(String str) {
        this.orderType = str;
    }

    public String getOrderTime() {
        return this.orderTime;
    }

    public void setOrderTime(String str) {
        this.orderTime = str;
    }

    public static ServerAccessApplyOrder buildFromJson(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        ServerAccessApplyOrder serverAccessApplyOrder = new ServerAccessApplyOrder();
        try {
            serverAccessApplyOrder.setOrderId(JSONHelper.getStringValue(jSONObject, HwPayConstant.KEY_REQUESTID));
            serverAccessApplyOrder.setOrderType(String.valueOf(JSONHelper.getIntValue(jSONObject, "orderType")));
            serverAccessApplyOrder.setOrderTime(JSONHelper.getStringValue(jSONObject, "orderTime"));
            serverAccessApplyOrder.setSPMerchantId(JSONHelper.getStringValue(jSONObject, "merchantId"));
            serverAccessApplyOrder.setMerchantName(JSONHelper.getStringValue(jSONObject, "merchantName"));
            serverAccessApplyOrder.setApplicationId(JSONHelper.getStringValue(jSONObject, "applicationID"));
            serverAccessApplyOrder.setPackageName(JSONHelper.getStringValue(jSONObject, "packageName"));
            serverAccessApplyOrder.setAccessMode(JSONHelper.getStringValue(jSONObject, "accessMode"));
            serverAccessApplyOrder.setServiceCatalog(JSONHelper.getStringValue(jSONObject, "serviceCatalog"));
            serverAccessApplyOrder.setCurrency(JSONHelper.getStringValue(jSONObject, HwPayConstant.KEY_CURRENCY));
            serverAccessApplyOrder.setAmount(JSONHelper.getStringValue(jSONObject, "amount"));
            serverAccessApplyOrder.setProductName(JSONHelper.getStringValue(jSONObject, "productName"));
            serverAccessApplyOrder.setProductDesc(JSONHelper.getStringValue(jSONObject, "productDesc"));
            serverAccessApplyOrder.setSignType(JSONHelper.getStringValue(jSONObject, SNBConstant.FIELD_RSA_SIGN_TYPE));
            serverAccessApplyOrder.setSign(JSONHelper.getStringValue(jSONObject, "sign"));
            serverAccessApplyOrder.setUrl(JSONHelper.getStringValue(jSONObject, "url"));
            serverAccessApplyOrder.setUrlVer(JSONHelper.getStringValue(jSONObject, HwPayConstant.KEY_URLVER));
            if (jSONObject.has("sdkChannel")) {
                serverAccessApplyOrder.setSdkChannel(JSONHelper.getStringValue(jSONObject, "sdkChannel"));
            } else {
                serverAccessApplyOrder.setSdkChannel("0");
            }
        } catch (JSONException e) {
            LogX.e("ServerAccessApplyOrder buildFromJson, JSONException");
            serverAccessApplyOrder = null;
        }
        return serverAccessApplyOrder;
    }
}
