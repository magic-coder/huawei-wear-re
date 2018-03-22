package com.huawei.hms.api.internal;

import android.content.Context;
import android.os.Build.VERSION;
import com.huawei.hms.api.HuaweiApiAvailability;
import com.huawei.hms.p039c.C0852a;
import com.huawei.hms.p039c.C0857e;
import com.huawei.hms.p039c.C0857e.C0856a;

/* compiled from: HuaweiMobileServicesUtil */
public abstract class C0845e {
    public static int m2995a(Context context) {
        C0852a.m3001a(context, "context must not be null.");
        if (VERSION.SDK_INT < 15) {
            return 21;
        }
        C0857e c0857e = new C0857e(context);
        C0856a a = c0857e.m3015a("com.huawei.hwid");
        if (C0856a.NOT_INSTALLED.equals(a)) {
            return 1;
        }
        if (C0856a.DISABLED.equals(a)) {
            return 3;
        }
        if (!HuaweiApiAvailability.SERVICES_SIGNATURE.equalsIgnoreCase(c0857e.m3020d("com.huawei.hwid"))) {
            return 9;
        }
        if (c0857e.m3018b("com.huawei.hwid") < 20502300) {
            return 2;
        }
        return 0;
    }
}
