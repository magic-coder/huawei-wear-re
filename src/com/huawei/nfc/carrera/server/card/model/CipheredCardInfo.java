package com.huawei.nfc.carrera.server.card.model;

import com.huawei.nfc.carrera.util.StringUtil;
import org.json.JSONException;
import org.json.JSONObject;

public class CipheredCardInfo {
    private static final String KEY_CARD_INFO = "cardInfo";
    private static final String KEY_PIN = "pin";
    public String mCardInfo;
    public String mPin;

    public CipheredCardInfo(String str, String str2) {
        this.mCardInfo = str;
        this.mPin = str2;
    }

    public JSONObject toJasonString() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(KEY_CARD_INFO, this.mCardInfo);
        if (!StringUtil.isEmpty(this.mPin, true)) {
            jSONObject.put("pin", this.mPin);
        }
        return jSONObject;
    }
}
