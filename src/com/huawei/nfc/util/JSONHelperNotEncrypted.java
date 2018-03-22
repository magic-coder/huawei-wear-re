package com.huawei.nfc.util;

import android.content.Context;
import com.huawei.p190v.C2538c;
import org.json.JSONException;
import org.json.JSONObject;

public class JSONHelperNotEncrypted {
    private static final String CARD_SERVER_PROTOCAL_VERSION = "1.0";

    public static JSONObject createHeaderStr(String str, String str2) {
        if (str2 == null) {
            return null;
        }
        JSONObject jSONObject;
        C2538c.b("createHeaderStr commandStr : " + str2, new Object[]{Boolean.valueOf(true)});
        try {
            jSONObject = new JSONObject();
            jSONObject.put("srcTranID", str);
            jSONObject.put("version", "1.0");
            jSONObject.put("ts", System.currentTimeMillis() / 1000);
            jSONObject.put("commander", str2);
        } catch (JSONException e) {
            C2538c.e("createHeaderObject, params invalid.", new Object[0]);
            jSONObject = null;
        }
        return jSONObject;
    }

    public static String createRequestStr(String str, int i, JSONObject jSONObject, Context context) {
        if (jSONObject == null) {
            return null;
        }
        JSONObject jSONObject2;
        C2538c.b("prepareRequestStr dataStr : " + jSONObject.toString(), new Object[]{Boolean.valueOf(true)});
        try {
            jSONObject2 = new JSONObject();
            jSONObject2.put("merchantID", str);
            jSONObject2.put("keyIndex", i);
            jSONObject2.put("data", jSONObject.toString());
        } catch (JSONException e) {
            C2538c.e("createRequestStr, params invalid.", new Object[0]);
            jSONObject2 = null;
        }
        if (jSONObject2 != null) {
            return jSONObject2.toString();
        }
        return null;
    }

    public static String getStringValue(JSONObject jSONObject, String str) throws JSONException {
        if (jSONObject.has(str)) {
            return jSONObject.getString(str);
        }
        return null;
    }

    public static long getLongValue(JSONObject jSONObject, String str) throws JSONException {
        if (jSONObject.has(str)) {
            return jSONObject.getLong(str);
        }
        return -1;
    }

    public static int getIntValue(JSONObject jSONObject, String str) throws JSONException {
        if (jSONObject.has(str)) {
            return jSONObject.getInt(str);
        }
        return -1;
    }
}
