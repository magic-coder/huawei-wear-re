package com.huawei.multisimsdk.multidevicemanager.common;

import com.huawei.multisimsdk.multidevicemanager.p105e.C1183h;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: RequestServiceProvisionInfo */
public class C1163o {
    private static final String f2508a = C1163o.class.getSimpleName();
    private int f2509b;
    private String f2510c = "ServiceProvisionRequest";
    private String f2511d;
    private String f2512e;
    private String f2513f;
    private C1162n f2514g = null;
    private C1164p f2515h = null;

    public void m5205a(int i) {
        this.f2509b = i;
    }

    public void m5207a(String str) {
        this.f2511d = str;
    }

    public void m5208b(String str) {
        this.f2512e = str;
    }

    public void m5209c(String str) {
        this.f2513f = str;
    }

    public void m5206a(C1162n c1162n) {
        this.f2514g = c1162n;
    }

    public JSONObject m5204a() {
        try {
            C1183h.m5282b(f2508a, "buildJsonObj-RequestServiceProvisionInfo start");
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("ReqSN", this.f2509b);
            jSONObject.put("ReqName", this.f2510c);
            jSONObject.put("PrimaryIDType", this.f2511d);
            jSONObject.put("PrimaryID", this.f2512e);
            jSONObject.put("Services", this.f2513f);
            if (this.f2514g != null) {
                jSONObject.put("MultiSIMServiceRequest", this.f2514g.m5197a());
            }
            if (this.f2515h != null) {
                jSONObject.put("eSIMProfileRequest", this.f2515h.m5210a());
            }
            if (!C1183h.f2599a.booleanValue()) {
                return jSONObject;
            }
            C1183h.m5282b(f2508a, "buildJsonObj-RequestServiceProvisionInfo end:" + jSONObject.toString());
            return jSONObject;
        } catch (JSONException e) {
            C1183h.m5286d(f2508a, "buildJsonObj-RequestServiceProvisionInfo error!");
            return null;
        }
    }
}
