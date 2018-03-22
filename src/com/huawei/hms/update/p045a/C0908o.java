package com.huawei.hms.update.p045a;

import android.content.Context;
import com.huawei.hms.p039c.C0857e;
import com.huawei.hms.p039c.C0857e.C0856a;
import com.huawei.hms.update.p051f.C0950a;

/* compiled from: UpdatePolicy */
class C0908o {
    private final Context f1499a;
    private int f1500b;
    private String f1501c;

    public C0908o(Context context) {
        if (context == null) {
            throw new NullPointerException("context must not be null.");
        }
        this.f1499a = context;
        m3173c();
    }

    public int m3175a() {
        return this.f1500b;
    }

    public String m3176b() {
        return this.f1501c;
    }

    private void m3173c() {
        C0857e c0857e = new C0857e(this.f1499a);
        int b = c0857e.m3018b("com.huawei.hwid");
        String c = c0857e.m3019c("com.huawei.hwid");
        if (b == 0 || c.isEmpty() || c0857e.m3015a("com.huawei.hwid") == C0856a.NOT_INSTALLED) {
            this.f1500b = 20101000;
            m3174d();
            return;
        }
        this.f1500b = b;
        if (c.endsWith("OVE")) {
            this.f1501c = c;
        } else if (c.endsWith("EU")) {
            this.f1501c = "2.1.1.0_OVE";
        } else if (b < 20101302) {
            m3174d();
        } else {
            this.f1501c = c;
        }
    }

    private void m3174d() {
        if (C0950a.m3308c(this.f1499a)) {
            this.f1501c = "2.1.1.0";
        } else {
            this.f1501c = "2.1.1.0_OVE";
        }
    }
}
