package com.huawei.nfc.carrera.server.card.model;

import com.huawei.hms.support.api.entity.pay.HwPayConstant;
import com.huawei.nfc.carrera.server.card.impl.JSONHelper;
import com.huawei.nfc.carrera.util.LogX;
import org.json.JSONException;
import org.json.JSONObject;

public class ServerAccessQueryOrder {
    public static final String ORDER_TYPE_OPEN_CARD = "0";
    public static final String ORDER_TYPE_OPEN_CARD_AND_RECHARGE = "2";
    public static final String ORDER_TYPE_RECHARGE = "1";
    private String amount = null;
    private String currency = null;
    private String issuerId = null;
    private String orderId = null;
    private String orderTime = null;
    private String orderType = null;
    private String status = null;

    public String getCurrency() {
        return this.currency;
    }

    public void setCurrency(String str) {
        this.currency = str;
    }

    public String getOrderTime() {
        return this.orderTime;
    }

    public void setOrderTime(String str) {
        this.orderTime = str;
    }

    public String getAmount() {
        return this.amount;
    }

    public void setAmount(String str) {
        this.amount = str;
    }

    public String getOrderId() {
        return this.orderId;
    }

    public void setOrderId(String str) {
        this.orderId = str;
    }

    public String getOrderType() {
        return this.orderType;
    }

    public void setOrderType(String str) {
        this.orderType = str;
    }

    public String getIssuerId() {
        return this.issuerId;
    }

    public void setIssuerId(String str) {
        this.issuerId = str;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String str) {
        this.status = str;
    }

    public static ServerAccessQueryOrder buildFromJson(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        ServerAccessQueryOrder serverAccessQueryOrder = new ServerAccessQueryOrder();
        try {
            serverAccessQueryOrder.orderId = JSONHelper.getStringValue(jSONObject, "orderNo");
            serverAccessQueryOrder.orderType = String.valueOf(JSONHelper.getIntValue(jSONObject, "orderType"));
            serverAccessQueryOrder.issuerId = JSONHelper.getStringValue(jSONObject, "issuerid");
            serverAccessQueryOrder.status = JSONHelper.getStringValue(jSONObject, "status");
            serverAccessQueryOrder.amount = JSONHelper.getStringValue(jSONObject, "amount");
            serverAccessQueryOrder.orderTime = JSONHelper.getStringValue(jSONObject, "orderTime");
            serverAccessQueryOrder.currency = JSONHelper.getStringValue(jSONObject, HwPayConstant.KEY_CURRENCY);
        } catch (JSONException e) {
            LogX.e("ServerAccessQueryOrder buildFromJson, JSONException");
            serverAccessQueryOrder = null;
        }
        return serverAccessQueryOrder;
    }
}
