package com.huawei.multisimsdk.multidevicemanager.common;

import com.huawei.crowdtestsdk.constants.IntegrationConstants;
import com.huawei.multisimsdk.multidevicemanager.p105e.C1183h;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: PairedDeviceList */
public class C1155g {
    private static final String f2445a = C1155g.class.getSimpleName();
    private String f2446b;
    private String f2447c;
    private String f2448d;
    private String f2449e;
    private String f2450f;
    private String f2451g;
    private C1151c f2452h = null;

    public String m5145a() {
        return this.f2448d;
    }

    public String m5147b() {
        return this.f2449e;
    }

    public void m5146a(String str) {
        JSONObject jSONObject;
        if (str == null) {
            try {
                jSONObject = new JSONObject();
            } catch (JSONException e) {
                C1183h.m5282b(f2445a, "PairedDeviceList-parseResponseInfo  JSONException");
                return;
            }
        }
        jSONObject = new JSONObject(str);
        this.f2446b = jSONObject.optString("DevType");
        this.f2447c = jSONObject.optString("ICCID");
        this.f2448d = jSONObject.optString("IMSI");
        this.f2449e = jSONObject.optString("MSISDN");
        this.f2450f = jSONObject.optString("Status");
        this.f2451g = jSONObject.optString("DeviceName");
        C1151c c1151c = new C1151c();
        JSONObject optJSONObject = jSONObject.optJSONObject(IntegrationConstants.DEVICE_ID);
        if (optJSONObject != null) {
            c1151c.m5131a(optJSONObject.toString());
        }
        this.f2452h = c1151c;
        if (C1183h.f2599a.booleanValue()) {
            C1183h.m5282b(f2445a, "put jsonObj.toString() = " + jSONObject.toString());
        }
    }
}
