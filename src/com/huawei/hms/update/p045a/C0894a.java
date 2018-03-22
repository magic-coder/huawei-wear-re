package com.huawei.hms.update.p045a;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import com.huawei.hms.p037a.C0826a.C0825a;
import com.huawei.hms.p039c.C0852a;
import com.huawei.hms.p039c.C0857e;
import com.huawei.hms.support.log.C0887a;
import com.huawei.hms.update.p051f.C0950a;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: CheckParams */
class C0894a {
    private final Context f1439a;
    private final String f1440b = Build.MODEL;
    private final String f1441c = Build.DISPLAY;
    private final String f1442d = Build.HARDWARE;
    private final String f1443e = Build.FINGERPRINT;
    private final String f1444f = ("Android " + VERSION.RELEASE);
    private final String f1445g = C0950a.m3305a(this.f1439a);
    private final String f1446h = String.valueOf(C0825a.f1293a);
    private final String f1447i = "full";
    private final String f1448j = "com.huawei.hwid";
    private final int f1449k;
    private final String f1450l;
    private final String f1451m;
    private final String f1452n;

    public C0894a(Context context) {
        C0852a.m3001a(context, "context must not be null.");
        this.f1439a = context;
        C0857e c0857e = new C0857e(context);
        this.f1451m = c0857e.m3020d("com.huawei.hwid");
        this.f1452n = C0950a.m3307b(context);
        C0908o c0908o = new C0908o(this.f1439a);
        this.f1449k = c0908o.m3175a();
        this.f1450l = c0908o.m3176b();
    }

    public String toString() {
        try {
            return m3124a().toString(2);
        } catch (JSONException e) {
            return super.toString();
        }
    }

    public JSONObject m3124a() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("DeviceName", this.f1440b);
            jSONObject.put("Firmware", this.f1441c);
            jSONObject.put("Hardware", this.f1442d);
            jSONObject.put("FingerPrint", this.f1443e);
            jSONObject.put("Language", this.f1445g);
            jSONObject.put("OS", this.f1444f);
            jSONObject.put("EmotionUI", this.f1446h);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("PackageType", this.f1447i);
            jSONObject2.put("PackageName", this.f1448j);
            jSONObject2.put("PackageVersionCode", String.valueOf(this.f1449k));
            jSONObject2.put("PackageVersionName", this.f1450l);
            jSONObject2.put("PackageFingerprint", this.f1451m);
            jSONObject2.put("SystemRegion", this.f1452n);
            return new JSONObject().put("rules", jSONObject).put("components", new JSONArray().put(jSONObject2));
        } catch (JSONException e) {
            C0887a.m3098d("CheckParams", "In toJSON, Failed to build json for check-update request." + e.getMessage());
            return new JSONObject();
        }
    }
}
