package com.huawei.multisimsdk.multidevicemanager.common;

import android.text.TextUtils;
import com.huawei.multisimsdk.multidevicemanager.p105e.C1183h;
import com.huawei.multisimsdk.multidevicemanager.p105e.C1185k;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ResponseAuthSecondInfo */
public class C1166r {
    private static final String f2534a = C1166r.class.getSimpleName();
    private int f2535b;
    private String f2536c;
    private String f2537d;
    private int f2538e;
    private String f2539f;

    public int m5217a() {
        return this.f2535b;
    }

    public int m5219b() {
        return this.f2538e;
    }

    public String m5221c() {
        return this.f2537d;
    }

    public String m5222d() {
        return this.f2536c;
    }

    public void m5218a(String str) {
        if (C1185k.m5301b(str)) {
            this.f2538e = Integer.valueOf(str).intValue();
            if (408 == this.f2538e) {
                this.f2538e = 1008;
                return;
            }
            return;
        }
        try {
            JSONArray jSONArray;
            if (TextUtils.isEmpty(str)) {
                jSONArray = new JSONArray();
            } else {
                jSONArray = new JSONArray(str);
            }
            JSONObject jSONObject = jSONArray.getJSONObject(0);
            if (jSONObject != null) {
                m5220b(jSONObject.toString());
            }
            if (C1183h.f2599a.booleanValue()) {
                C1183h.m5282b(f2534a, "put jsonObj.toString() = " + jSONArray.toString());
            }
        } catch (JSONException e) {
            C1183h.m5282b(f2534a, "ResponseAuthSecondInfo-parseResponseAuthInfoArray  JSONException");
        }
    }

    public void m5220b(String str) {
        if (C1185k.m5301b(str)) {
            this.f2538e = Integer.valueOf(str).intValue();
            if (408 == this.f2538e) {
                this.f2538e = 1008;
                return;
            }
            return;
        }
        JSONObject jSONObject;
        if (str == null) {
            try {
                jSONObject = new JSONObject();
            } catch (JSONException e) {
                C1183h.m5282b(f2534a, "ResponseAuthSecondInfo-parseResponseAuthInfo  JSONException");
                return;
            }
        }
        jSONObject = new JSONObject(str);
        this.f2535b = jSONObject.optInt("RespSN");
        this.f2536c = jSONObject.optString("ReqName");
        this.f2537d = jSONObject.optString("AuthToken");
        this.f2538e = jSONObject.optInt("ResultCode");
        this.f2539f = jSONObject.optString("MSISDN");
        if (C1183h.f2599a.booleanValue()) {
            C1183h.m5282b(f2534a, "put jsonObj.toString() = " + jSONObject.toString());
        }
    }
}
