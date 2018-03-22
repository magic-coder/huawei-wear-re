package com.huawei.multisimsdk.multidevicemanager.common;

import com.huawei.multisimsdk.multidevicemanager.p105e.C1183h;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: DeviceID */
public class C1151c {
    private static final String f2434a = C1151c.class.getSimpleName();
    private String f2435b = null;
    private String f2436c = null;
    private String f2437d = null;

    public JSONObject m5130a() {
        try {
            C1183h.m5282b(f2434a, "buildJsonObj start");
            JSONObject jSONObject = new JSONObject();
            if (this.f2435b != null) {
                jSONObject.put("IMEI", this.f2435b);
            }
            if (this.f2436c != null) {
                jSONObject.put("MEID", this.f2436c);
            }
            if (this.f2437d != null) {
                jSONObject.put("SN", this.f2437d);
            }
            if (!C1183h.f2599a.booleanValue()) {
                return jSONObject;
            }
            C1183h.m5282b(f2434a, "buildJsonObj end:" + jSONObject.toString());
            return jSONObject;
        } catch (JSONException e) {
            C1183h.m5286d(f2434a, "buildJsonObj error!");
            return null;
        }
    }

    public void m5131a(String str) {
        JSONObject jSONObject;
        if (str == null) {
            try {
                jSONObject = new JSONObject();
            } catch (JSONException e) {
                C1183h.m5282b(f2434a, "parseResponseAuthInfo  JSONException");
                return;
            }
        }
        jSONObject = new JSONObject(str);
        this.f2435b = jSONObject.optString("IMEI");
        this.f2436c = jSONObject.optString("MEID");
        this.f2437d = jSONObject.optString("SN");
        if (C1183h.f2599a.booleanValue()) {
            C1183h.m5282b(f2434a, "put jsonObj.toString() = " + jSONObject.toString());
        }
    }
}
