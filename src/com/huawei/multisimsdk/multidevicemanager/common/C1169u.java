package com.huawei.multisimsdk.multidevicemanager.common;

import android.text.TextUtils;
import com.huawei.multisimsdk.multidevicemanager.p105e.C1183h;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ResponseMultiSIMService */
public class C1169u {
    private static final String f2552a = C1169u.class.getSimpleName();
    private String f2553b;
    private String f2554c;
    private int f2555d;

    public String m5232a() {
        return this.f2553b;
    }

    public String m5234b() {
        return this.f2554c;
    }

    public int m5235c() {
        return this.f2555d;
    }

    public void m5233a(String str) {
        try {
            JSONObject jSONObject;
            if (TextUtils.isEmpty(str)) {
                jSONObject = new JSONObject();
            } else {
                jSONObject = new JSONObject(str);
            }
            this.f2553b = jSONObject.optString("ManageUrl");
            this.f2554c = jSONObject.optString("PostData");
            this.f2555d = jSONObject.optInt("Timer2");
            if (C1183h.f2599a.booleanValue()) {
                C1183h.m5282b(f2552a, "put jsonObj.toString() = " + jSONObject.toString());
            }
        } catch (JSONException e) {
            C1183h.m5282b(f2552a, "ResponseMultiSIMService-parseResponseInfo  JSONException");
        }
    }
}
