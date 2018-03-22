package com.huawei.multisimsdk.multidevicemanager.common;

import android.text.TextUtils;
import com.huawei.multisimsdk.multidevicemanager.p105e.C1183h;
import com.huawei.multisimsdk.multidevicemanager.p105e.C1185k;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ResponseInfo */
public class C1168t {
    private static final String f2548d = C1168t.class.getSimpleName();
    C1165q f2549a;
    C1167s f2550b = null;
    C1170v f2551c = null;

    public C1165q m5228a() {
        return this.f2549a;
    }

    public C1167s m5230b() {
        return this.f2550b;
    }

    public C1170v m5231c() {
        return this.f2551c;
    }

    private void m5227a(String str, String str2) {
        if ("DevAuth".equals(str)) {
            this.f2549a = new C1165q();
            this.f2549a.m5215b(str2);
            if (C1183h.f2599a.booleanValue()) {
                C1183h.m5282b(f2548d, "put jsonObj.Token() = " + str2);
            }
        } else if ("GetDevServInfo".equals(str)) {
            this.f2550b = new C1167s();
            this.f2550b.m5224a(str2);
            if (C1183h.f2599a.booleanValue()) {
                C1183h.m5282b(f2548d, "put jsonObj.GetDevServInfo() = " + str2);
            }
        } else if ("ServiceProvisionRequest".equals(str)) {
            this.f2551c = new C1170v();
            this.f2551c.m5237a(str2);
            if (C1183h.f2599a.booleanValue()) {
                C1183h.m5282b(f2548d, "put jsonObj.ServiceProvisionRequest() = " + str2);
            }
        }
    }

    public void m5229a(String str) {
        if (C1185k.m5301b(str)) {
            this.f2549a = new C1165q();
            this.f2549a.m5212a(Integer.valueOf(str).intValue());
            return;
        }
        try {
            JSONArray jSONArray;
            if (TextUtils.isEmpty(str)) {
                jSONArray = new JSONArray();
            } else {
                jSONArray = new JSONArray(str);
            }
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                if (jSONObject != null) {
                    m5227a(jSONObject.optString("ReqName"), jSONObject.toString());
                }
            }
            if (C1183h.f2599a.booleanValue()) {
                C1183h.m5282b(f2548d, "put jsonObj.toString() = " + jSONArray.toString());
            }
        } catch (JSONException e) {
            C1183h.m5282b(f2548d, "ResponseInfo-parseResponseInfo  JSONException");
        }
    }
}
