package com.huawei.multisimsdk.multidevicemanager.common;

import com.huawei.crowdtestsdk.constants.IntegrationConstants;
import com.huawei.multisimsdk.multidevicemanager.p105e.C1183h;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: RequestAuthInfo */
public class C1158j {
    private static final String f2468a = C1158j.class.getSimpleName();
    private int f2469b;
    private String f2470c;
    private String f2471d;
    private String f2472e = null;
    private String f2473f = null;
    private String f2474g = null;
    private C1151c f2475h = null;
    private String f2476i = null;
    private String f2477j = null;

    public void m5171a(int i) {
        this.f2469b = i;
    }

    public void m5172a(String str) {
        this.f2470c = str;
    }

    public void m5174b(String str) {
        this.f2471d = str;
    }

    public void m5175c(String str) {
        this.f2472e = str;
    }

    public void m5176d(String str) {
        this.f2474g = str;
    }

    public JSONArray m5170a() {
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(m5173b());
        if (C1183h.f2599a.booleanValue()) {
            C1183h.m5282b(f2468a, "buildJsonObj end:" + jSONArray.toString());
        }
        return jSONArray;
    }

    public JSONObject m5173b() {
        try {
            C1183h.m5282b(f2468a, "buildJsonObj start");
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("ReqSN", this.f2469b);
            jSONObject.put("ReqName", this.f2470c);
            jSONObject.put("AuthType", this.f2471d);
            if (this.f2473f != null) {
                jSONObject.put("Identity", this.f2473f);
            }
            if (this.f2472e != null) {
                jSONObject.put("MSISDN", this.f2472e);
            }
            if (this.f2474g != null) {
                jSONObject.put("AuthToken", this.f2474g);
            }
            if (this.f2475h != null) {
                jSONObject.put(IntegrationConstants.DEVICE_ID, this.f2475h.m5130a());
            }
            if (this.f2476i != null) {
                jSONObject.put("TerminalType", this.f2476i);
            }
            if (this.f2477j != null) {
                jSONObject.put("TerminalVersion", this.f2477j);
            }
            if (!C1183h.f2599a.booleanValue()) {
                return jSONObject;
            }
            C1183h.m5282b(f2468a, "buildJsonObj end:" + jSONObject.toString());
            return jSONObject;
        } catch (JSONException e) {
            C1183h.m5286d(f2468a, "buildJsonObj error!");
            return null;
        }
    }
}
