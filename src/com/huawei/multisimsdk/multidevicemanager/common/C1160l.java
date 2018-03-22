package com.huawei.multisimsdk.multidevicemanager.common;

import com.huawei.multisimsdk.multidevicemanager.p105e.C1183h;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: RequestGetDevServInfo */
public class C1160l {
    private static final String f2487a = C1160l.class.getSimpleName();
    private int f2488b;
    private String f2489c;
    private String f2490d;
    private String f2491e;
    private String f2492f;
    private String f2493g = null;
    private String f2494h = null;
    private String f2495i = null;

    public void m5185a(int i) {
        this.f2488b = i;
    }

    public void m5186a(String str) {
        this.f2489c = str;
    }

    public void m5187b(String str) {
        this.f2491e = str;
    }

    public void m5188c(String str) {
        this.f2492f = str;
    }

    public void m5189d(String str) {
        this.f2490d = str;
    }

    public void m5190e(String str) {
        this.f2493g = str;
    }

    public void m5191f(String str) {
        this.f2494h = str;
    }

    public void m5192g(String str) {
        this.f2495i = str;
    }

    public JSONObject m5184a() {
        try {
            C1183h.m5282b(f2487a, "buildJsonObj start");
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("ReqSN", this.f2488b);
            jSONObject.put("ReqName", this.f2489c);
            jSONObject.put("PrimaryIDType", this.f2491e);
            jSONObject.put("PrimaryID", this.f2492f);
            jSONObject.put("Services", this.f2490d);
            if (this.f2493g != null) {
                jSONObject.put("SecondaryIDType", this.f2493g);
            }
            if (this.f2494h != null) {
                jSONObject.put("SecondaryID", this.f2494h);
            }
            if (this.f2495i != null) {
                jSONObject.put("OldTimeStamp", this.f2495i);
            }
            if (!C1183h.f2599a.booleanValue()) {
                return jSONObject;
            }
            C1183h.m5282b(f2487a, "buildJsonObj end:" + jSONObject.toString());
            return jSONObject;
        } catch (JSONException e) {
            C1183h.m5286d(f2487a, "buildJsonObj error!");
            return null;
        }
    }
}
