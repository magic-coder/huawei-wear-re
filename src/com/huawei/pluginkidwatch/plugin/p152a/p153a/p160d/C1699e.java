package com.huawei.pluginkidwatch.plugin.p152a.p153a.p160d;

import android.content.Context;
import com.huawei.p190v.C2538c;

/* compiled from: BTBLEHealthManager */
public class C1699e extends am {
    private static C1699e f4501a = null;
    private static String f4502d = "BTBLEHealthManager";
    private Context f4503b = null;
    private C1697c f4504c = null;

    private C1699e(Context context, int i) {
        this.f4503b = context;
        this.f4504c = C1697c.m8023a(context, i);
        if (this.f4504c == null) {
            C2538c.m12680e(f4502d, "======== mBTBLEDeviceManager is null =========");
        }
    }

    public static C1699e m8039a(Context context, int i) {
        C2538c.m12674b(f4502d, "BTBLEHealthManager getInstance with deviceType: " + i);
        if (context != null) {
            synchronized (C1699e.class) {
                if (f4501a == null) {
                    C2538c.m12674b(f4502d, "BTBLEHealthManager is null");
                    f4501a = new C1699e(context, i);
                } else {
                    C2538c.m12674b(f4502d, "mBTBLEHealthManager is not null");
                }
            }
        }
        return f4501a;
    }

    public ak mo2587a() {
        return this.f4504c;
    }
}
