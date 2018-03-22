package com.tencent.wxop.stat.p547b;

import android.content.Context;
import com.huawei.hwid.core.constants.HwAccountConstants;
import com.tencent.wxop.stat.C6548z;
import org.json.JSONObject;

public final class C6509d {
    static C6510e f22668a;
    private static C6507b f22669d = C6517l.m29740c();
    private static JSONObject f22670e = new JSONObject();
    Integer f22671b = null;
    String f22672c = null;

    public C6509d(Context context) {
        try {
            C6509d.m29716a(context);
            this.f22671b = C6517l.m29758l(context.getApplicationContext());
            this.f22672c = C6548z.m29898a(context).m29904b();
        } catch (Throwable th) {
            f22669d.m29705b(th);
        }
    }

    private static synchronized C6510e m29716a(Context context) {
        C6510e c6510e;
        synchronized (C6509d.class) {
            if (f22668a == null) {
                f22668a = new C6510e(context.getApplicationContext());
            }
            c6510e = f22668a;
        }
        return c6510e;
    }

    public final void m29717a(JSONObject jSONObject, Thread thread) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            if (f22668a != null) {
                f22668a.m29718a(jSONObject2, thread);
            }
            C6523r.m29785a(jSONObject2, HwAccountConstants.DEFAULT_SIMPLE_COUNTRY_CODE, this.f22672c);
            if (this.f22671b != null) {
                jSONObject2.put("tn", this.f22671b);
            }
            if (thread == null) {
                jSONObject.put("ev", jSONObject2);
            } else {
                jSONObject.put("errkv", jSONObject2.toString());
            }
            if (f22670e != null && f22670e.length() > 0) {
                jSONObject.put("eva", f22670e);
            }
        } catch (Throwable th) {
            f22669d.m29705b(th);
        }
    }
}
