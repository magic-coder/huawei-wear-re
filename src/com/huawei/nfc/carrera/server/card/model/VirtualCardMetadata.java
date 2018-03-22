package com.huawei.nfc.carrera.server.card.model;

import org.json.JSONException;
import org.json.JSONObject;

public class VirtualCardMetadata {
    public static final String KEY_VIRTUAL_CARD_NUM = "virtualCardNum";
    public static final String KEY_VIRTUAL_CARD_REF_ID = "virtualCardRefId";
    public String virtualCardNum;
    public String virtualCardRefId;

    public VirtualCardMetadata(JSONObject jSONObject) throws JSONException {
        this.virtualCardRefId = jSONObject.getString(KEY_VIRTUAL_CARD_REF_ID);
        this.virtualCardNum = jSONObject.getString(KEY_VIRTUAL_CARD_NUM);
    }

    public String toString() {
        return "VirtualCardMetadata [virtualCardRefId=" + this.virtualCardRefId + ", virtualCardNum=" + this.virtualCardNum + "]";
    }
}
