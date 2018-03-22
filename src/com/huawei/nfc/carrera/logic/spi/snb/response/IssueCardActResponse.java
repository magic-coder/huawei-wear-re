package com.huawei.nfc.carrera.logic.spi.snb.response;

import com.huawei.nfc.carrera.logic.spi.snb.constant.SNBConstant;
import com.huawei.nfc.carrera.server.card.impl.JSONHelper;
import org.json.JSONException;
import org.json.JSONObject;

public class IssueCardActResponse extends SNBBaseResponse {
    private String activityAmount;
    private String activityDes;
    private int activityFlg;
    private String cardID;
    private int chargeSwitch;
    private String issueStdAmount;
    private String issueStdDes;

    public String toString() {
        return "IssueCardActResponse [cardID=" + this.cardID + ", chargeSwitch=" + this.chargeSwitch + ", activityFlg=" + this.activityFlg + ", issueStdAmount=" + this.issueStdAmount + ", issueStdDes=" + this.issueStdDes + ", activityAmount=" + this.activityAmount + ", activityDes=" + this.activityDes + "]";
    }

    public static IssueCardActResponse build(String str) throws JSONException {
        IssueCardActResponse issueCardActResponse = new IssueCardActResponse();
        try {
            JSONObject jSONObject = new JSONObject(str);
            issueCardActResponse.cardID = JSONHelper.getStringValue(jSONObject, SNBConstant.FIELD_CARD_ID);
            issueCardActResponse.chargeSwitch = JSONHelper.getIntValue(jSONObject, SNBConstant.FIELD_CARD_SWITCH_STATUS);
            issueCardActResponse.issueStdAmount = JSONHelper.getStringValue(jSONObject, SNBConstant.FIELD_CHARGE_AMOUNT);
            issueCardActResponse.issueStdDes = JSONHelper.getStringValue(jSONObject, SNBConstant.FIELD_CHARGE_DESC);
            issueCardActResponse.activityFlg = JSONHelper.getIntValue(jSONObject, SNBConstant.FIELD_ACTIVITY_FLG);
            issueCardActResponse.activityAmount = JSONHelper.getStringValue(jSONObject, SNBConstant.FIELD_ACTIVITY_AMOUNT);
            issueCardActResponse.activityDes = JSONHelper.getStringValue(jSONObject, SNBConstant.FIELD_ACTIVITY_DESC);
            return issueCardActResponse;
        } catch (JSONException e) {
            throw e;
        }
    }

    public String getCardID() {
        return this.cardID;
    }

    public void setCardID(String str) {
        this.cardID = str;
    }

    public int getChargeSwitch() {
        return this.chargeSwitch;
    }

    public void setChargeSwitch(int i) {
        this.chargeSwitch = i;
    }

    public int getActivityFlg() {
        return this.activityFlg;
    }

    public void setActivityFlg(int i) {
        this.activityFlg = i;
    }

    public String getIssueStdAmount() {
        return this.issueStdAmount;
    }

    public void setIssueStdAmount(String str) {
        this.issueStdAmount = str;
    }

    public String getIssueStdDes() {
        return this.issueStdDes;
    }

    public void setIssueStdDes(String str) {
        this.issueStdDes = str;
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
