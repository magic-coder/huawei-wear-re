package com.huawei.hwid.update.p449a;

import android.content.Context;
import com.huawei.hwid.p075d.C5209d;
import com.huawei.hwid.p075d.C5209d.C5208a;
import com.huawei.hwid.update.p454e.C5309a;

/* compiled from: UpdatePolicy */
class C5270i {
    private final Context f18953a;
    private int f18954b;
    private String f18955c;

    public C5270i(Context context) {
        if (context == null) {
            throw new NullPointerException("context must not be null.");
        }
        this.f18953a = context;
        m25527c();
    }

    public int m25529a() {
        return this.f18954b;
    }

    public String m25530b() {
        return this.f18955c;
    }

    private void m25527c() {
        C5209d c5209d = new C5209d(this.f18953a);
        int b = c5209d.m25339b("com.huawei.hwid");
        String c = c5209d.m25340c("com.huawei.hwid");
        if (b == 0 || c.isEmpty() || c5209d.m25336a("com.huawei.hwid") == C5208a.NOT_INSTALLED) {
            this.f18954b = 20101000;
            m25528d();
            return;
        }
        this.f18954b = b;
        if (c.endsWith("OVE")) {
            this.f18955c = c;
        } else if (c.endsWith("EU")) {
            this.f18955c = "2.1.1.0_OVE";
        } else if (b < 20101302) {
            m25528d();
        } else {
            this.f18955c = c;
        }
    }

    private void m25528d() {
        if (C5309a.m25670c(this.f18953a)) {
            this.f18955c = "2.1.1.0";
        } else {
            this.f18955c = "2.1.1.0_OVE";
        }
    }
}
