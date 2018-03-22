package com.huawei.multisimsdk.multidevicemanager.common;

import android.text.TextUtils;
import com.huawei.multisimsdk.multidevicemanager.p105e.C1183h;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ResponseServiceProvisionInfo */
public class C1170v {
    private static final String f2556a = C1170v.class.getSimpleName();
    private int f2557b;
    private String f2558c;
    private int f2559d;
    private String f2560e = null;
    private String f2561f = null;
    private C1169u f2562g = null;

    public int m5236a() {
        return this.f2559d;
    }

    public C1169u m5238b() {
        return this.f2562g;
    }

    public void m5237a(String str) {
        try {
            JSONObject jSONObject;
            if (TextUtils.isEmpty(str)) {
                jSONObject = new JSONObject();
            } else {
                jSONObject = new JSONObject(str);
            }
            this.f2557b = jSONObject.optInt("RespSN");
            this.f2558c = jSONObject.optString("ReqName");
            this.f2559d = jSONObject.optInt("ResultCode");
            this.f2560e = jSONObject.optString("WSAddress");
            this.f2561f = jSONObject.optString("WSUrlDataPart");
            C1169u c1169u = new C1169u();
            JSONObject optJSONObject = jSONObject.optJSONObject("MultiSIMServiceRequestResponse");
            if (optJSONObject != null) {
                c1169u.m5233a(optJSONObject.toString());
            }
            this.f2562g = c1169u;
            if (C1183h.f2599a.booleanValue()) {
                C1183h.m5282b(f2556a, "put jsonObj.toString() = " + jSONObject.toString());
            }
        } catch (JSONException e) {
            C1183h.m5282b(f2556a, "ResponseServiceProvisionInfo-parseResponseInfo  JSONException");
        }
    }
}
