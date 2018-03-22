package com.tencent.stat.p545b;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import com.tencent.stat.C6470c;
import java.util.Locale;
import java.util.TimeZone;
import org.json.JSONObject;

class C6455e {
    String f22392a;
    String f22393b;
    DisplayMetrics f22394c;
    int f22395d;
    String f22396e;
    String f22397f;
    String f22398g;
    String f22399h;
    String f22400i;
    String f22401j;
    String f22402k;
    int f22403l;
    String f22404m;
    Context f22405n;
    private String f22406o;
    private String f22407p;
    private String f22408q;
    private String f22409r;

    private C6455e(Context context) {
        this.f22393b = "1.6.2";
        this.f22395d = VERSION.SDK_INT;
        this.f22396e = Build.MODEL;
        this.f22397f = Build.MANUFACTURER;
        this.f22398g = Locale.getDefault().getLanguage();
        this.f22403l = 0;
        this.f22404m = null;
        this.f22405n = null;
        this.f22406o = null;
        this.f22407p = null;
        this.f22408q = null;
        this.f22409r = null;
        this.f22405n = context;
        this.f22394c = C6463m.m29456d(context);
        this.f22392a = C6463m.m29472n(context);
        this.f22399h = C6470c.m29512b(context);
        this.f22400i = C6463m.m29471m(context);
        this.f22401j = TimeZone.getDefault().getID();
        this.f22403l = C6463m.m29477s(context);
        this.f22402k = C6463m.m29478t(context);
        this.f22404m = context.getPackageName();
        if (this.f22395d >= 14) {
            this.f22406o = C6463m.m29433A(context);
        }
        this.f22407p = C6463m.m29484z(context).toString();
        this.f22408q = C6463m.m29482x(context);
        this.f22409r = C6463m.m29458e();
    }

    void m29416a(JSONObject jSONObject) {
        jSONObject.put("sr", this.f22394c.widthPixels + "*" + this.f22394c.heightPixels);
        C6463m.m29445a(jSONObject, "av", this.f22392a);
        C6463m.m29445a(jSONObject, "ch", this.f22399h);
        C6463m.m29445a(jSONObject, "mf", this.f22397f);
        C6463m.m29445a(jSONObject, "sv", this.f22393b);
        C6463m.m29445a(jSONObject, "ov", Integer.toString(this.f22395d));
        jSONObject.put("os", 1);
        C6463m.m29445a(jSONObject, "op", this.f22400i);
        C6463m.m29445a(jSONObject, "lg", this.f22398g);
        C6463m.m29445a(jSONObject, "md", this.f22396e);
        C6463m.m29445a(jSONObject, "tz", this.f22401j);
        if (this.f22403l != 0) {
            jSONObject.put("jb", this.f22403l);
        }
        C6463m.m29445a(jSONObject, "sd", this.f22402k);
        C6463m.m29445a(jSONObject, "apn", this.f22404m);
        if (C6463m.m29465h(this.f22405n)) {
            JSONObject jSONObject2 = new JSONObject();
            C6463m.m29445a(jSONObject2, "bs", C6463m.m29435C(this.f22405n));
            C6463m.m29445a(jSONObject2, "ss", C6463m.m29436D(this.f22405n));
            if (jSONObject2.length() > 0) {
                C6463m.m29445a(jSONObject, "wf", jSONObject2.toString());
            }
        }
        C6463m.m29445a(jSONObject, "sen", this.f22406o);
        C6463m.m29445a(jSONObject, "cpu", this.f22407p);
        C6463m.m29445a(jSONObject, "ram", this.f22408q);
        C6463m.m29445a(jSONObject, "rom", this.f22409r);
    }
}
