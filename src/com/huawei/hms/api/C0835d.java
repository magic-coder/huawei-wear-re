package com.huawei.hms.api;

import com.huawei.hms.api.HuaweiApiClientImpl.C0828a;
import com.huawei.hms.support.api.ResolveResult;

/* compiled from: HuaweiApiClientImpl */
class C0835d implements Runnable {
    final /* synthetic */ ResolveResult f1324a;
    final /* synthetic */ C0828a f1325b;

    C0835d(C0828a c0828a, ResolveResult resolveResult) {
        this.f1325b = c0828a;
        this.f1324a = resolveResult;
    }

    public void run() {
        this.f1325b.f1305a.m2936b(this.f1324a);
    }
}
