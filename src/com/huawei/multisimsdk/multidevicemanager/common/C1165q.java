package com.huawei.multisimsdk.multidevicemanager.common;

import android.text.TextUtils;
import com.huawei.multisimsdk.multidevicemanager.p105e.C1183h;
import com.huawei.multisimsdk.multidevicemanager.p105e.C1185k;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ResponseAuthFirstInfo */
public class C1165q {
    private static final String f2524a = C1165q.class.getSimpleName();
    private int f2525b;
    private String f2526c;
    private int f2527d;
    private String f2528e = null;
    private String f2529f = null;
    private String f2530g = null;
    private String f2531h = null;
    private String f2532i = null;
    private int f2533j;

    public int m5211a() {
        return this.f2525b;
    }

    public int m5214b() {
        return this.f2527d;
    }

    public void m5212a(int i) {
        this.f2527d = i;
    }

    public String m5216c() {
        return this.f2526c;
    }

    public void m5213a(String str) {
        if (C1185k.m5301b(str)) {
            this.f2527d = Integer.valueOf(str).intValue();
            if (408 == this.f2527d) {
                this.f2527d = 1008;
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
                m5215b(jSONObject.toString());
            }
            if (C1183h.f2599a.booleanValue()) {
                C1183h.m5282b(f2524a, "put jsonObj.toString() = " + jSONArray.toString());
            }
        } catch (JSONException e) {
            C1183h.m5282b(f2524a, "ResponseAuthFirstInfo-parseResponseAuthInfoArray  JSONException");
        }
    }

    public void m5215b(String str) {
        if (C1185k.m5301b(str)) {
            this.f2527d = Integer.valueOf(str).intValue();
            if (408 == this.f2527d) {
                this.f2527d = 1008;
                return;
            }
            return;
        }
        JSONObject jSONObject;
        if (str == null) {
            try {
                jSONObject = new JSONObject();
            } catch (JSONException e) {
                C1183h.m5282b(f2524a, "ResponseAuthFirstInfo-parseResponseAuthFirstInfo  JSONException");
                return;
            }
        }
        jSONObject = new JSONObject(str);
        this.f2525b = jSONObject.optInt("RespSN");
        this.f2526c = jSONObject.optString("ReqName");
        this.f2527d = jSONObject.optInt("ResultCode");
        this.f2528e = jSONObject.optString("Payload");
        this.f2529f = jSONObject.optString("AuthToken");
        this.f2530g = jSONObject.optString("RSPServerAddress");
        this.f2531h = jSONObject.optString("MSISDN");
        this.f2532i = jSONObject.optString("SessionID");
        this.f2533j = jSONObject.optInt("SMSAuthExpireTime");
        if (C1183h.f2599a.booleanValue()) {
            C1183h.m5282b(f2524a, "put jsonObj.toString() = " + jSONObject.toString());
        }
    }
}
