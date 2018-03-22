package com.huawei.multisimsdk.multidevicemanager.common;

import com.huawei.crowdtestsdk.constants.IntegrationConstants;
import com.huawei.multisimsdk.multidevicemanager.p105e.C1183h;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: RequestMultiSIMServiceInfo */
public class C1162n {
    private static final String f2500a = C1162n.class.getSimpleName();
    private String f2501b;
    private String f2502c;
    private String f2503d;
    private String f2504e = null;
    private String f2505f = null;
    private String f2506g = null;
    private C1151c f2507h = null;

    public void m5198a(String str) {
        this.f2501b = str;
    }

    public void m5199b(String str) {
        this.f2502c = str;
    }

    public void m5200c(String str) {
        this.f2503d = str;
    }

    public void m5201d(String str) {
        this.f2504e = str;
    }

    public void m5202e(String str) {
        this.f2505f = str;
    }

    public void m5203f(String str) {
        this.f2506g = str;
    }

    public JSONObject m5197a() {
        try {
            C1183h.m5282b(f2500a, "buildRequesteJsonObj-RequestMultiSIMServiceInfo start");
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("Request", this.f2501b);
            jSONObject.put("PrimaryIDType", this.f2502c);
            jSONObject.put("PrimaryID", this.f2503d);
            if (this.f2504e != null) {
                jSONObject.put("SecondaryIDType", this.f2504e);
            }
            if (this.f2505f != null) {
                jSONObject.put("SecondaryID", this.f2505f);
            }
            if (this.f2506g != null) {
                jSONObject.put("SecondaryDeviceName", this.f2506g);
            }
            if (this.f2507h != null) {
                jSONObject.put(IntegrationConstants.DEVICE_ID, this.f2507h.m5130a());
            }
            if (!C1183h.f2599a.booleanValue()) {
                return jSONObject;
            }
            C1183h.m5282b(f2500a, "buildJsonObj-RequestMultiSIMServiceInfo end:" + jSONObject.toString());
            return jSONObject;
        } catch (JSONException e) {
            C1183h.m5286d(f2500a, "buildJsonObj-RequestMultiSIMServiceInfo error!");
            return null;
        }
    }
}
