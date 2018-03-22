package com.huawei.nfc.carrera.logic.spi.snb.response;

import com.huawei.nfc.carrera.server.card.impl.JSONHelper;
import org.json.JSONException;
import org.json.JSONObject;

public class RechargeResponse extends SNBBaseResponse {
    private String code;
    private String msg;
    private String snMsg;

    public static RechargeResponse build(String str) throws JSONException {
        RechargeResponse rechargeResponse = new RechargeResponse();
        try {
            JSONObject jSONObject = new JSONObject(str);
            rechargeResponse.setCode(JSONHelper.getStringValue(jSONObject, "code"));
            rechargeResponse.setMsg(JSONHelper.getStringValue(jSONObject, "msg"));
            rechargeResponse.setSnMsg(JSONHelper.getStringValue(jSONObject, "snMsg"));
            return rechargeResponse;
        } catch (JSONException e) {
            throw e;
        }
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String str) {
        this.code = str;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setMsg(String str) {
        this.msg = str;
    }

    public String getSnMsg() {
        return this.snMsg;
    }

    public void setSnMsg(String str) {
        this.snMsg = str;
    }
}
