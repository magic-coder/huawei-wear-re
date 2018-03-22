package com.huawei.hwappdfxmgr;

import com.huawei.hwappdfxmgr.p056f.C4592c;
import com.huawei.p190v.C2538c;

/* compiled from: HWAppDFXMgr */
class C4585b implements Runnable {
    final /* synthetic */ boolean f16793a;
    final /* synthetic */ C4583a f16794b;

    C4585b(C4583a c4583a, boolean z) {
        this.f16794b = c4583a;
        this.f16793a = z;
    }

    public void run() {
        C2538c.b("HWAppDFXMgr", new Object[]{"BuildConfig.RELEASE_EVENT_LOG_UPLOAD: true"});
        C4592c.m21873b(this.f16794b.f16790c);
    }
}
