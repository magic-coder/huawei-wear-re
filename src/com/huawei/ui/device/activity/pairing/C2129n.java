package com.huawei.ui.device.activity.pairing;

import com.huawei.p190v.C2538c;

/* compiled from: DevicePairGuideActivity */
class C2129n implements Runnable {
    final /* synthetic */ int f7535a;
    final /* synthetic */ Object f7536b;
    final /* synthetic */ C2128m f7537c;

    C2129n(C2128m c2128m, int i, Object obj) {
        this.f7537c = c2128m;
        this.f7535a = i;
        this.f7536b = obj;
    }

    public void run() {
        boolean booleanValue;
        ClassCastException e;
        if (this.f7535a == 0) {
            try {
                booleanValue = ((Boolean) this.f7536b).booleanValue();
                try {
                    this.f7537c.f7534a.an = booleanValue;
                } catch (ClassCastException e2) {
                    e = e2;
                    C2538c.m12677c("DevicePairGuideActivity", "ClassCastException:" + e.getMessage());
                    C2538c.m12677c("DevicePairGuideActivity", "isSupportInHealth:" + booleanValue);
                    if (booleanValue) {
                        this.f7537c.f7534a.m10922c();
                        return;
                    } else {
                        this.f7537c.f7534a.m10914b();
                        return;
                    }
                }
            } catch (ClassCastException e3) {
                e = e3;
                booleanValue = false;
                C2538c.m12677c("DevicePairGuideActivity", "ClassCastException:" + e.getMessage());
                C2538c.m12677c("DevicePairGuideActivity", "isSupportInHealth:" + booleanValue);
                if (booleanValue) {
                    this.f7537c.f7534a.m10914b();
                    return;
                } else {
                    this.f7537c.f7534a.m10922c();
                    return;
                }
            }
            C2538c.m12677c("DevicePairGuideActivity", "isSupportInHealth:" + booleanValue);
            if (booleanValue) {
                this.f7537c.f7534a.m10922c();
                return;
            } else {
                this.f7537c.f7534a.m10914b();
                return;
            }
        }
        this.f7537c.f7534a.m10914b();
    }
}
