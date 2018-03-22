package com.huawei.multisimsdk.multidevicemanager.common;

import com.huawei.crowdtestsdk.constants.IntegrationConstants;
import com.huawei.multisimsdk.multidevicemanager.p105e.C1183h;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: RequestAuthSecondInfo */
public class C1159k {
    private static final String f2478a = C1159k.class.getSimpleName();
    private int f2479b;
    private String f2480c;
    private String f2481d;
    private String f2482e;
    private C1151c f2483f = null;
    private String f2484g = null;
    private String f2485h = null;
    private int f2486i;

    public void m5178a(int i) {
        this.f2479b = i;
    }

    public void m5179a(String str) {
        this.f2480c = str;
    }

    public void m5182b(String str) {
        this.f2482e = str;
    }

    public void m5183c(String str) {
        this.f2485h = str;
    }

    public void m5181b(int i) {
        this.f2486i = i;
    }

    public JSONArray m5177a() {
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(m5180b());
        return jSONArray;
    }

    public JSONObject m5180b() {
        try {
            C1183h.m5282b(f2478a, "buildJsonObj start");
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("ReqSN", this.f2479b);
            jSONObject.put("AuthType", this.f2481d);
            jSONObject.put("ReqName", this.f2480c);
            jSONObject.put("Payload", this.f2482e);
            if (this.f2483f != null) {
                jSONObject.put(IntegrationConstants.DEVICE_ID, this.f2483f.m5130a());
            }
            if (this.f2484g != null) {
                jSONObject.put("Sessionid", this.f2484g);
            }
            if (this.f2485h != null) {
                jSONObject.put("MSISDN", this.f2485h);
            }
            jSONObject.put("Timer", this.f2486i);
            if (!C1183h.f2599a.booleanValue()) {
                return jSONObject;
            }
            C1183h.m5282b(f2478a, "buildJsonObj end:" + jSONObject.toString());
            return jSONObject;
        } catch (JSONException e) {
            C1183h.m5286d(f2478a, "buildJsonObj error!");
            return null;
        }
    }
}
