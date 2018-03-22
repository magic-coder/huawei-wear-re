package com.tencent.stat.p545b;

import android.content.Context;
import com.huawei.hwid.core.constants.HwAccountConstants;
import org.json.JSONObject;

public class C6453c {
    static C6455e f22387a;
    private static C6452b f22388d = C6463m.m29449b();
    private static JSONObject f22389e = null;
    Integer f22390b = null;
    String f22391c = null;

    public C6453c(Context context) {
        try {
            C6453c.m29414a(context);
            this.f22390b = C6463m.m29475q(context.getApplicationContext());
            this.f22391c = C6463m.m29474p(context);
        } catch (Throwable th) {
            f22388d.m29411f(th);
        }
    }

    static synchronized C6455e m29414a(Context context) {
        C6455e c6455e;
        synchronized (C6453c.class) {
            if (f22387a == null) {
                f22387a = new C6455e(context.getApplicationContext());
            }
            c6455e = f22387a;
        }
        return c6455e;
    }

    public void m29415a(JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            if (f22387a != null) {
                f22387a.m29416a(jSONObject2);
            }
            C6463m.m29445a(jSONObject2, HwAccountConstants.DEFAULT_SIMPLE_COUNTRY_CODE, this.f22391c);
            if (this.f22390b != null) {
                jSONObject2.put("tn", this.f22390b);
            }
            jSONObject.put("ev", jSONObject2);
            if (f22389e != null && f22389e.length() > 0) {
                jSONObject.put("eva", f22389e);
            }
        } catch (Throwable th) {
            f22388d.m29411f(th);
        }
    }
}
