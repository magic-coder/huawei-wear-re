package com.huawei.multisimsdk.multidevicemanager.common;

import com.huawei.crowdtestsdk.constants.IntegrationConstants;
import com.huawei.multisimsdk.multidevicemanager.p105e.C1183h;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: PrimaryDevice */
public class C1156h {
    private static final String f2453a = C1156h.class.getSimpleName();
    private String f2454b;
    private String f2455c;
    private C1151c f2456d = null;
    private String f2457e;

    public String m5148a() {
        return this.f2454b;
    }

    public void m5149a(String str) {
        JSONObject jSONObject;
        if (str == null) {
            try {
                jSONObject = new JSONObject();
            } catch (JSONException e) {
                C1183h.m5282b(f2453a, "PrimaryDevice-parseResponseInfo  JSONException");
                return;
            }
        }
        jSONObject = new JSONObject(str);
        this.f2454b = jSONObject.optString("MSISDN");
        this.f2455c = jSONObject.optString("IMSI");
        C1151c c1151c = new C1151c();
        JSONObject optJSONObject = jSONObject.optJSONObject(IntegrationConstants.DEVICE_ID);
        if (optJSONObject != null) {
            c1151c.m5131a(optJSONObject.toString());
        }
        this.f2456d = c1151c;
        this.f2457e = jSONObject.optString("ServStatus");
        if (C1183h.f2599a.booleanValue()) {
            C1183h.m5282b(f2453a, "put jsonObj.toString() = " + jSONObject.toString());
        }
    }
}
