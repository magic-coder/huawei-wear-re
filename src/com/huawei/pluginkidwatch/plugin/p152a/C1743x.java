package com.huawei.pluginkidwatch.plugin.p152a;

import android.content.Context;
import com.huawei.p190v.C2538c;
import java.util.HashMap;
import java.util.Map;

/* compiled from: KWBtDeviceManager */
public final class C1743x {
    private static C1743x f4688d;
    private Context f4689a;
    private Map<String, C1723d> f4690b = new HashMap();
    private C1723d f4691c = null;

    private C1743x(Context context) {
        this.f4689a = context;
    }

    public static C1743x m8322a(Context context) {
        if (f4688d == null) {
            f4688d = new C1743x(context);
        }
        return f4688d;
    }

    public void m8324a(C1723d c1723d) {
        synchronized (this) {
            this.f4691c = c1723d;
        }
        C2538c.m12674b("KidWatchManager", "setCurrentConnectKid:" + this.f4691c);
    }

    public C1723d m8323a() {
        if (this.f4691c != null) {
            return this.f4691c;
        }
        return null;
    }
}
