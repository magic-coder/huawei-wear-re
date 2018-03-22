package com.huawei.nfc.carrera.logic.spi.snb.response;

import com.huawei.nfc.carrera.logic.spi.snb.constant.SNBConstant;
import com.huawei.nfc.carrera.server.card.impl.JSONHelper;
import org.json.JSONException;
import org.json.JSONObject;

public class RechargeActResponse extends SNBBaseResponse {
    private String activityAmount = "";
    private String activityDes;
    private int activityFlg;
    private String rechargeStdAmount = "";
    private String rechargeStdDes;

    public String toString() {
        return "RechargeActResponse [activityFlg=" + this.activityFlg + ", rechargeStdAmount=" + this.rechargeStdAmount + ", rechargeStdDes=" + this.rechargeStdDes + ", activityAmount=" + this.activityAmount + ", activityDes=" + this.activityDes + "]";
    }

    public static RechargeActResponse build(String str) throws JSONException {
        RechargeActResponse rechargeActResponse = new RechargeActResponse();
        try {
            JSONObject jSONObject = new JSONObject(str);
            rechargeActResponse.rechargeStdAmount = JSONHelper.getStringValue(jSONObject, SNBConstant.FIELD_RECHARGE_AMOUNT);
            rechargeActResponse.rechargeStdDes = JSONHelper.getStringValue(jSONObject, SNBConstant.FIELD_RECHARGE_DESC);
            rechargeActResponse.activityFlg = JSONHelper.getIntValue(jSONObject, SNBConstant.FIELD_ACTIVITY_FLG);
            rechargeActResponse.activityAmount = JSONHelper.getStringValue(jSONObject, SNBConstant.FIELD_ACTIVITY_AMOUNT);
            rechargeActResponse.activityDes = JSONHelper.getStringValue(jSONObject, SNBConstant.FIELD_ACTIVITY_DESC);
            return rechargeActResponse;
        } catch (JSONException e) {
            throw e;
        }
    }

    public int getActivityFlg() {
        return this.activityFlg;
    }

    public void setActivityFlg(int i) {
        this.activityFlg = i;
    }

    public String getRechargeStdAmount() {
        return this.rechargeStdAmount;
    }

    public void setRechargeStdAmount(String str) {
        this.rechargeStdAmount = str;
    }

    public String getRechargeStdDes() {
        return this.rechargeStdDes;
    }

    public void setRechargeStdDes(String str) {
        this.rechargeStdDes = str;
    }

    public String getActivityAmount() {
        return this.activityAmount;
    }

    public void setActivityAmount(String str) {
        this.activityAmount = str;
    }

    public String getActivityDes() {
        return this.activityDes;
    }

    public void setActivityDes(String str) {
        this.activityDes = str;
    }
}
