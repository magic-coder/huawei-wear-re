package com.huawei.hwlocationmgr.p457b;

import android.content.Context;
import com.huawei.hwlocationmgr.p456a.C5314a;
import com.huawei.hwlocationmgr.util.C5316a;
import com.huawei.p190v.C2538c;

/* compiled from: HWLocationManager */
public class C5315a {
    private static C5315a f19024a = null;
    private C5316a f19025b = null;

    public static C5315a m25697a(Context context) {
        C5315a c5315a;
        synchronized (C5315a.class) {
            if (f19024a == null) {
                f19024a = new C5315a(context);
            }
            c5315a = f19024a;
        }
        return c5315a;
    }

    private C5315a(Context context) {
        if (this.f19025b == null) {
            this.f19025b = C5316a.m25703a(context);
        }
    }

    public void m25698a(C5314a c5314a) {
        C2538c.b("LocationManager", new Object[]{"getWeatherObj Enter ... "});
        if (this.f19025b != null) {
            this.f19025b.m25730a(c5314a);
        }
    }

    public void m25699a(C5314a c5314a, long j, float f) {
        if (this.f19025b != null) {
            this.f19025b.m25731a(c5314a, j, f);
        }
    }

    public void m25700b(C5314a c5314a) {
        if (this.f19025b != null) {
            this.f19025b.m25732b(c5314a);
        }
    }
}
