package com.amap.api.services.core;

import android.content.Context;
import java.util.List;

/* compiled from: SDKDBOperation */
public class an {
    private ai f12352a = m16664a(this.f12353b);
    private Context f12353b;

    public an(Context context) {
        this.f12353b = context;
    }

    private ai m16664a(Context context) {
        try {
            return new ai(context);
        } catch (Throwable th) {
            ay.m16709a(th, "SDKDB", "getDB");
            th.printStackTrace();
            return null;
        }
    }

    public void m16666a(ad adVar) {
        if (adVar != null) {
            try {
                if (this.f12352a == null) {
                    this.f12352a = m16664a(this.f12353b);
                }
                ap aoVar = new ao();
                aoVar.mo4104a(adVar);
                String a = ao.m16667a(adVar.m16613a());
                List c = this.f12352a.m16645c(a, new ao());
                if (c == null || c.size() == 0) {
                    this.f12352a.m16642a(aoVar);
                } else {
                    this.f12352a.m16644b(a, aoVar);
                }
            } catch (Throwable th) {
                ay.m16709a(th, "SDKDB", "insert");
                th.printStackTrace();
            }
        }
    }

    public List<ad> m16665a() {
        List<ad> list = null;
        try {
            ap aoVar = new ao();
            list = this.f12352a.m16645c(ao.m16670c(), aoVar);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return list;
    }
}
