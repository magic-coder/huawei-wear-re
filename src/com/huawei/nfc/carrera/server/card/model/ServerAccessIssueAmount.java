package com.huawei.nfc.carrera.server.card.model;

import com.huawei.nfc.carrera.server.card.impl.JSONHelper;
import com.huawei.nfc.carrera.util.LogX;
import org.json.JSONException;
import org.json.JSONObject;

public class ServerAccessIssueAmount {
    private String amountEnroll = null;
    private String amountRecharge = null;
    private String denomination = null;
    private String priceEnroll = null;
    private String priceRecharge = null;

    public String getDenomination() {
        return this.denomination;
    }

    public void setDenomination(String str) {
        this.denomination = str;
    }

    public String getPriceEnroll() {
        return this.priceEnroll;
    }

    public void setPriceEnroll(String str) {
        this.priceEnroll = str;
    }

    public String getAmountEnroll() {
        return this.amountEnroll;
    }

    public void setAmountEnroll(String str) {
        this.amountEnroll = str;
    }

    public String getPriceRecharge() {
        return this.priceRecharge;
    }

    public void setPriceRecharge(String str) {
        this.priceRecharge = str;
    }

    public String getAmountRecharge() {
        return this.amountRecharge;
    }

    public void setAmountRecharge(String str) {
        this.amountRecharge = str;
    }

    public static ServerAccessIssueAmount buildFromJson(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        ServerAccessIssueAmount serverAccessIssueAmount = new ServerAccessIssueAmount();
        try {
            serverAccessIssueAmount.denomination = JSONHelper.getStringValue(jSONObject, "denomination");
            serverAccessIssueAmount.priceRecharge = JSONHelper.getStringValue(jSONObject, "priceRecharge");
            serverAccessIssueAmount.amountRecharge = JSONHelper.getStringValue(jSONObject, "amountRecharge");
            serverAccessIssueAmount.priceEnroll = JSONHelper.getStringValue(jSONObject, "priceEnroll");
            serverAccessIssueAmount.amountEnroll = JSONHelper.getStringValue(jSONObject, "amountEnroll");
        } catch (JSONException e) {
            LogX.e("ServerAccessIssueAmount buildFromJson, JSONException");
            serverAccessIssueAmount = null;
        }
        return serverAccessIssueAmount;
    }
}
