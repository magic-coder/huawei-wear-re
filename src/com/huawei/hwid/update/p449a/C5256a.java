package com.huawei.hwid.update.p449a;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import com.huawei.hwid.core.p435d.p437b.C5165e;
import com.huawei.hwid.d.a;
import com.huawei.hwid.p075d.C5209d;
import com.huawei.hwid.p423a.C5061a.C5060a;
import com.huawei.hwid.update.p454e.C5309a;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: CheckParams */
class C5256a {
    private final Context f18893a;
    private final String f18894b = Build.MODEL;
    private final String f18895c = Build.DISPLAY;
    private final String f18896d = Build.HARDWARE;
    private final String f18897e = Build.FINGERPRINT;
    private final String f18898f = ("Android " + VERSION.RELEASE);
    private final String f18899g = C5309a.m25667a(this.f18893a);
    private final String f18900h = String.valueOf(C5060a.f18271a);
    private final String f18901i = "full";
    private final String f18902j = "com.huawei.hwid";
    private final int f18903k;
    private final String f18904l;
    private final String f18905m;
    private final String f18906n;

    public C5256a(Context context) {
        a.a(context, "context must not be null.");
        this.f18893a = context;
        C5209d c5209d = new C5209d(context);
        this.f18905m = c5209d.m25341d("com.huawei.hwid");
        this.f18906n = C5309a.m25669b(context);
        C5270i c5270i = new C5270i(this.f18893a);
        this.f18903k = c5270i.m25529a();
        this.f18904l = c5270i.m25530b();
    }

    public String toString() {
        try {
            return m25478a().toString(2);
        } catch (JSONException e) {
            return super.toString();
        }
    }

    public JSONObject m25478a() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("DeviceName", this.f18894b);
            jSONObject.put("Firmware", this.f18895c);
            jSONObject.put("Hardware", this.f18896d);
            jSONObject.put("FingerPrint", this.f18897e);
            jSONObject.put("Language", this.f18899g);
            jSONObject.put("OS", this.f18898f);
            jSONObject.put("EmotionUI", this.f18900h);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("PackageType", this.f18901i);
            jSONObject2.put("PackageName", this.f18902j);
            jSONObject2.put("PackageVersionCode", String.valueOf(this.f18903k));
            jSONObject2.put("PackageVersionName", this.f18904l);
            jSONObject2.put("PackageFingerprint", this.f18905m);
            jSONObject2.put("SystemRegion", this.f18906n);
            return new JSONObject().put("rules", jSONObject).put("components", new JSONArray().put(jSONObject2));
        } catch (JSONException e) {
            C5165e.m24910d("CheckParams", "In toJSON, Failed to build json for check-update request." + e.getMessage());
            return new JSONObject();
        }
    }
}
