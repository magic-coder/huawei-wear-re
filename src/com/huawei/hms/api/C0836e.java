package com.huawei.hms.api;

import com.huawei.hms.api.HuaweiApiClientImpl.C0829b;
import com.huawei.hms.support.api.ResolveResult;

/* compiled from: HuaweiApiClientImpl */
class C0836e implements Runnable {
    final /* synthetic */ ResolveResult f1326a;
    final /* synthetic */ C0829b f1327b;

    C0836e(C0829b c0829b, ResolveResult resolveResult) {
        this.f1327b = c0829b;
        this.f1326a = resolveResult;
    }

    public void run() {
        this.f1327b.f1306a.m2931a(this.f1326a);
    }
}
