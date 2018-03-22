package com.huawei.nfc.carrera.server.card.model;

import com.huawei.nfc.carrera.server.card.impl.JSONHelper;
import com.huawei.nfc.carrera.util.LogX;
import org.json.JSONException;
import org.json.JSONObject;

public class ServerAccessAPDU {
    private String apduContent = null;
    private String apduId = null;
    private String apduStatus = null;

    public String getApduId() {
        return this.apduId;
    }

    public void setApduId(String str) {
        this.apduId = str;
    }

    public String getApduContent() {
        return this.apduContent;
    }

    public void setApduContent(String str) {
        this.apduContent = str;
    }

    public String getApduStatus() {
        return this.apduStatus;
    }

    public void setApduStatus(String str) {
        this.apduStatus = str;
    }

    public static ServerAccessAPDU buildFromJson(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        ServerAccessAPDU serverAccessAPDU = new ServerAccessAPDU();
        try {
            serverAccessAPDU.apduId = JSONHelper.getStringValue(jSONObject, "apduNo");
            serverAccessAPDU.apduContent = JSONHelper.getStringValue(jSONObject, "apduContent");
            serverAccessAPDU.apduStatus = JSONHelper.getStringValue(jSONObject, "apduStatus");
        } catch (JSONException e) {
            LogX.e("ServerAccessAPDU buildFromJson, JSONException");
            serverAccessAPDU = null;
        }
        return serverAccessAPDU;
    }
}
