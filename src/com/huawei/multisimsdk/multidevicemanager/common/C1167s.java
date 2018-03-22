package com.huawei.multisimsdk.multidevicemanager.common;

import android.text.TextUtils;
import com.huawei.multisimsdk.multidevicemanager.p105e.C1183h;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ResponseGetDevServInfo */
public class C1167s {
    private static final String f2540a = C1167s.class.getSimpleName();
    private int f2541b;
    private String f2542c;
    private int f2543d;
    private C1153e f2544e = null;
    private C1171w f2545f = null;
    private String f2546g = null;
    private int f2547h;

    public int m5223a() {
        return this.f2543d;
    }

    public C1153e m5225b() {
        return this.f2544e;
    }

    public String m5226c() {
        return this.f2546g;
    }

    public void m5224a(String str) {
        try {
            JSONObject jSONObject;
            if (TextUtils.isEmpty(str)) {
                jSONObject = new JSONObject();
            } else {
                jSONObject = new JSONObject(str);
            }
            this.f2541b = jSONObject.optInt("RespSN");
            this.f2542c = jSONObject.optString("ReqName");
            this.f2543d = jSONObject.optInt("ResultCode");
            C1183h.m5282b(f2540a, "ResultCode = " + this.f2543d);
            C1153e c1153e = new C1153e();
            JSONObject optJSONObject = jSONObject.optJSONObject("MultiSIMServiceInfo");
            if (optJSONObject != null) {
                c1153e.m5135a(optJSONObject.toString());
            }
            this.f2544e = c1153e;
            C1171w c1171w = new C1171w();
            JSONObject optJSONObject2 = jSONObject.optJSONObject("eSIMInfo");
            if (optJSONObject2 != null) {
                c1171w.m5239a(optJSONObject2.toString());
            }
            this.f2544e = c1153e;
            this.f2546g = jSONObject.optString("OldTimeStamp");
            this.f2547h = jSONObject.optInt("Timer1");
            if (C1183h.f2599a.booleanValue()) {
                C1183h.m5282b(f2540a, "put jsonObj.toString() = " + jSONObject.toString());
            }
        } catch (JSONException e) {
            C1183h.m5282b(f2540a, "ResponseGetDevServInfo-parseResponseInfo  JSONException");
        }
    }
}
