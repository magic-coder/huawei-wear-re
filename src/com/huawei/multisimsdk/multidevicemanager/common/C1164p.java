package com.huawei.multisimsdk.multidevicemanager.common;

import com.huawei.crowdtestsdk.constants.IntegrationConstants;
import com.huawei.multisimsdk.multidevicemanager.p105e.C1183h;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: RequesteSIMProfileInfo */
public class C1164p {
    private static final String f2516a = C1164p.class.getSimpleName();
    private String f2517b;
    private String f2518c;
    private String f2519d;
    private String f2520e;
    private String f2521f;
    private String f2522g = null;
    private C1151c f2523h = null;

    public JSONObject m5210a() {
        try {
            C1183h.m5282b(f2516a, "buildRequesteSIMProfileInfoJsonObj start");
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("Request", this.f2517b);
            jSONObject.put("Mainid", this.f2518c);
            jSONObject.put("Idtype", this.f2519d);
            if (this.f2520e != null) {
                jSONObject.put("EID", this.f2520e);
            }
            if (this.f2521f != null) {
                jSONObject.put("ICCID", this.f2521f);
            }
            if (this.f2522g != null) {
                jSONObject.put("IMSI", this.f2522g);
            }
            if (this.f2523h != null) {
                jSONObject.put(IntegrationConstants.DEVICE_ID, this.f2523h.m5130a());
            }
            if (!C1183h.f2599a.booleanValue()) {
                return jSONObject;
            }
            C1183h.m5282b(f2516a, "buildJsonObj-RequesteSIMProfileInfo end:" + jSONObject.toString());
            return jSONObject;
        } catch (JSONException e) {
            C1183h.m5286d(f2516a, "buildJsonObj-RequesteSIMProfileInfo error!");
            return null;
        }
    }
}
