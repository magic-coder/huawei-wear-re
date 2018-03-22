package com.huawei.nfc.carrera.logic.spi.snb.response;

import com.huawei.nfc.carrera.logic.spi.snb.constant.SNBConstant;
import com.huawei.nfc.carrera.server.card.impl.JSONHelper;
import com.huawei.nfc.carrera.util.LogX;
import org.json.JSONException;
import org.json.JSONObject;

public class RecordServerInfo {
    private String orderAmount;
    private String orderId;
    private int orderStatus;
    private String orderTime;
    private int orderType;

    public String toString() {
        return "RecordServerInfo [orderId=" + this.orderId + ", orderType=" + this.orderType + ", orderStatus=" + this.orderStatus + ", orderTime=" + this.orderTime + ", orderAmount=" + this.orderAmount + "]";
    }

    public static RecordServerInfo build(JSONObject jSONObject) throws JSONException {
        RecordServerInfo recordServerInfo = new RecordServerInfo();
        try {
            recordServerInfo.orderId = JSONHelper.getStringValue(jSONObject, SNBConstant.FIELD_ORDER_ID);
            recordServerInfo.orderAmount = JSONHelper.getStringValue(jSONObject, SNBConstant.FIELD_ORDER_AMOUNT);
            recordServerInfo.orderTime = JSONHelper.getStringValue(jSONObject, SNBConstant.FIELD_ORDER_TIME);
            recordServerInfo.orderType = JSONHelper.getIntValue(jSONObject, SNBConstant.FIELD_ORDER_TYPE);
            recordServerInfo.orderStatus = JSONHelper.getIntValue(jSONObject, SNBConstant.FIELD_ORDER_STATUS);
            return recordServerInfo;
        } catch (Throwable e) {
            LogX.e("RecordServerInfo, JSONException", e);
            throw e;
        }
    }

    public String getOrderId() {
        return this.orderId;
    }

    public void setOrderId(String str) {
        this.orderId = str;
    }

    public int getOrderType() {
        return this.orderType;
    }

    public void setOrderType(int i) {
        this.orderType = i;
    }

    public int getOrderStatus() {
        return this.orderStatus;
    }

    public void setOrderStatus(int i) {
        this.orderStatus = i;
    }

    public String getOrderTime() {
        return this.orderTime;
    }

    public void setOrderTime(String str) {
        this.orderTime = str;
    }

    public String getOrderAmount() {
        return this.orderAmount;
    }

    public void setOrderAmount(String str) {
        this.orderAmount = str;
    }
}
