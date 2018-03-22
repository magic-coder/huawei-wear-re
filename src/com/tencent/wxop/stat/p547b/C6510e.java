package com.tencent.wxop.stat.p547b;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import com.tencent.wxop.stat.C6544v;
import com.tencent.wxop.stat.C6548z;
import com.tencent.wxop.stat.am;
import java.util.Locale;
import java.util.TimeZone;
import org.json.JSONArray;
import org.json.JSONObject;

final class C6510e {
    String f22673a;
    String f22674b;
    DisplayMetrics f22675c;
    int f22676d;
    String f22677e;
    String f22678f;
    String f22679g;
    String f22680h;
    String f22681i;
    String f22682j;
    String f22683k;
    int f22684l;
    String f22685m;
    String f22686n;
    Context f22687o;
    private String f22688p;
    private String f22689q;
    private String f22690r;
    private String f22691s;

    private C6510e(Context context) {
        this.f22674b = "2.0.3";
        this.f22676d = VERSION.SDK_INT;
        this.f22677e = Build.MODEL;
        this.f22678f = Build.MANUFACTURER;
        this.f22679g = Locale.getDefault().getLanguage();
        this.f22684l = 0;
        this.f22685m = null;
        this.f22686n = null;
        this.f22687o = null;
        this.f22688p = null;
        this.f22689q = null;
        this.f22690r = null;
        this.f22691s = null;
        this.f22687o = context.getApplicationContext();
        this.f22675c = C6517l.m29744d(this.f22687o);
        this.f22673a = C6517l.m29756j(this.f22687o);
        this.f22680h = C6544v.m29827b(this.f22687o);
        this.f22681i = C6517l.m29753i(this.f22687o);
        this.f22682j = TimeZone.getDefault().getID();
        Context context2 = this.f22687o;
        this.f22684l = C6517l.m29737b();
        this.f22683k = C6517l.m29760n(this.f22687o);
        this.f22685m = this.f22687o.getPackageName();
        if (this.f22676d >= 14) {
            this.f22688p = C6517l.m29765s(this.f22687o);
        }
        context2 = this.f22687o;
        this.f22689q = C6517l.m29750g().toString();
        this.f22690r = C6517l.m29764r(this.f22687o);
        this.f22691s = C6517l.m29747f();
        this.f22686n = C6517l.m29770x(this.f22687o);
    }

    final void m29718a(JSONObject jSONObject, Thread thread) {
        if (thread == null) {
            if (this.f22675c != null) {
                jSONObject.put("sr", this.f22675c.widthPixels + "*" + this.f22675c.heightPixels);
                jSONObject.put("dpi", this.f22675c.xdpi + "*" + this.f22675c.ydpi);
            }
            if (C6548z.m29898a(this.f22687o).m29907e()) {
                JSONObject jSONObject2 = new JSONObject();
                C6523r.m29785a(jSONObject2, "bs", C6523r.m29789c(this.f22687o));
                C6523r.m29785a(jSONObject2, "ss", C6523r.m29790d(this.f22687o));
                if (jSONObject2.length() > 0) {
                    C6523r.m29785a(jSONObject, "wf", jSONObject2.toString());
                }
            }
            JSONArray f = C6523r.m29792f(this.f22687o);
            if (f != null && f.length() > 0) {
                C6523r.m29785a(jSONObject, "wflist", f.toString());
            }
            C6523r.m29785a(jSONObject, "sen", this.f22688p);
        } else {
            C6523r.m29785a(jSONObject, "thn", thread.getName());
            C6523r.m29785a(jSONObject, "qq", C6544v.m29831c(this.f22687o));
            C6523r.m29785a(jSONObject, "cui", C6544v.m29835d(this.f22687o));
            if (C6517l.m29742c(this.f22690r) && this.f22690r.split("/").length == 2) {
                C6523r.m29785a(jSONObject, "fram", this.f22690r.split("/")[0]);
            }
            if (C6517l.m29742c(this.f22691s) && this.f22691s.split("/").length == 2) {
                C6523r.m29785a(jSONObject, "from", this.f22691s.split("/")[0]);
            }
            if (am.m29668a(this.f22687o).m29697b(this.f22687o) != null) {
                jSONObject.put("ui", am.m29668a(this.f22687o).m29697b(this.f22687o).m29712a());
            }
            C6523r.m29785a(jSONObject, "mid", C6544v.m29838e(this.f22687o));
        }
        C6523r.m29785a(jSONObject, "pcn", C6517l.m29761o(this.f22687o));
        C6523r.m29785a(jSONObject, "osn", VERSION.RELEASE);
        C6523r.m29785a(jSONObject, "av", this.f22673a);
        C6523r.m29785a(jSONObject, "ch", this.f22680h);
        C6523r.m29785a(jSONObject, "mf", this.f22678f);
        C6523r.m29785a(jSONObject, "sv", this.f22674b);
        C6523r.m29785a(jSONObject, "osd", Build.DISPLAY);
        C6523r.m29785a(jSONObject, "prod", Build.PRODUCT);
        C6523r.m29785a(jSONObject, "tags", Build.TAGS);
        C6523r.m29785a(jSONObject, "id", Build.ID);
        C6523r.m29785a(jSONObject, "fng", Build.FINGERPRINT);
        C6523r.m29785a(jSONObject, "lch", this.f22686n);
        C6523r.m29785a(jSONObject, "ov", Integer.toString(this.f22676d));
        jSONObject.put("os", 1);
        C6523r.m29785a(jSONObject, "op", this.f22681i);
        C6523r.m29785a(jSONObject, "lg", this.f22679g);
        C6523r.m29785a(jSONObject, "md", this.f22677e);
        C6523r.m29785a(jSONObject, "tz", this.f22682j);
        if (this.f22684l != 0) {
            jSONObject.put("jb", this.f22684l);
        }
        C6523r.m29785a(jSONObject, "sd", this.f22683k);
        C6523r.m29785a(jSONObject, "apn", this.f22685m);
        C6523r.m29785a(jSONObject, "cpu", this.f22689q);
        C6523r.m29785a(jSONObject, "abi", Build.CPU_ABI);
        C6523r.m29785a(jSONObject, "abi2", Build.CPU_ABI2);
        C6523r.m29785a(jSONObject, "ram", this.f22690r);
        C6523r.m29785a(jSONObject, "rom", this.f22691s);
    }
}
