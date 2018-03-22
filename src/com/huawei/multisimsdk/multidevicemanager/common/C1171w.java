package com.huawei.multisimsdk.multidevicemanager.common;

import android.text.TextUtils;
import com.huawei.multisimsdk.multidevicemanager.p105e.C1183h;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ResponseeSIMProfileInfo */
public class C1171w {
    private static final String f2563a = C1171w.class.getSimpleName();
    private String f2564b;
    private String f2565c;
    private String f2566d;
    private String f2567e;

    public void m5239a(String str) {
        try {
            JSONObject jSONObject;
            if (TextUtils.isEmpty(str)) {
                jSONObject = new JSONObject();
            } else {
                jSONObject = new JSONObject(str);
            }
            this.f2564b = jSONObject.optString("AC_Format");
            this.f2565c = jSONObject.optString("SM-DP+Address");
            this.f2566d = jSONObject.optString("AC_Token");
            this.f2567e = jSONObject.optString("SM-DP+OID");
            if (C1183h.f2599a.booleanValue()) {
                C1183h.m5282b(f2563a, "put jsonObj.toString() = " + jSONObject.toString());
            }
        } catch (JSONException e) {
            C1183h.m5282b(f2563a, "ResponseeSIMProfileInfo-parseResponseInfo  JSONException");
        }
    }
}
