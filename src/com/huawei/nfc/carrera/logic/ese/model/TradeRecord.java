package com.huawei.nfc.carrera.logic.ese.model;

import com.huawei.nfc.util.JSONHelperNotEncrypted;
import com.huawei.p190v.C2538c;
import org.json.JSONException;
import org.json.JSONObject;

public class TradeRecord {
    public static final String TYPE_CONSUME = "2";
    public static final String TYPE_RECHARGE = "1";
    private String amount;
    private String status;
    private String time;
    private String type;

    public void setAmount(String str) {
        this.amount = str;
    }

    public void setType(String str) {
        this.type = str;
    }

    public void setTime(String str) {
        this.time = str;
    }

    public void setStatus(String str) {
        this.status = str;
    }

    public String getAmount() {
        return this.amount;
    }

    public String getType() {
        return this.type;
    }

    public String getTime() {
        return this.time;
    }

    public String getStatus() {
        return this.status;
    }

    public TradeRecord(String str, String str2, String str3) {
        this.amount = str;
        this.type = str2;
        this.time = str3;
    }

    public static TradeRecord build(JSONObject jSONObject) throws JSONException {
        TradeRecord tradeRecord = new TradeRecord();
        try {
            tradeRecord.amount = JSONHelperNotEncrypted.getStringValue(jSONObject, "transaction_amount");
            tradeRecord.time = JSONHelperNotEncrypted.getStringValue(jSONObject, "transaction_time");
            tradeRecord.type = JSONHelperNotEncrypted.getStringValue(jSONObject, "transaction_type");
            tradeRecord.status = JSONHelperNotEncrypted.getStringValue(jSONObject, "transaction_status");
            return tradeRecord;
        } catch (JSONException e) {
            C2538c.e("TradeRecord", new Object[]{"TradeRecord build JSONException", e});
            throw e;
        }
    }
}
