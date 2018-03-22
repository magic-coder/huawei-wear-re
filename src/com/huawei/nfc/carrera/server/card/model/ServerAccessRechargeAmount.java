package com.huawei.nfc.carrera.server.card.model;

import com.huawei.nfc.carrera.server.card.impl.JSONHelper;
import com.huawei.nfc.carrera.util.LogX;
import org.json.JSONException;
import org.json.JSONObject;

public class ServerAccessRechargeAmount {
    private String amountRecharge = null;
    private String denomination = null;

    public String getDenomination() {
        return this.denomination;
    }

    public void setDenomination(String str) {
        this.denomination = str;
    }

    public String getAmountRecharge() {
        return this.amountRecharge;
    }

    public void setAmountRecharge(String str) {
        this.amountRecharge = str;
    }

    public static ServerAccessRechargeAmount buildFromJson(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        ServerAccessRechargeAmount serverAccessRechargeAmount = new ServerAccessRechargeAmount();
        try {
            serverAccessRechargeAmount.denomination = JSONHelper.getStringValue(jSONObject, "denomination");
            serverAccessRechargeAmount.amountRecharge = JSONHelper.getStringValue(jSONObject, "amountRecharge");
        } catch (JSONException e) {
            LogX.e("ServerAccessRechargeAmount buildFromJson, JSONException");
            serverAccessRechargeAmount = null;
        }
        return serverAccessRechargeAmount;
    }
}
