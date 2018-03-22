package com.amap.api.mapcore.util;

import java.util.concurrent.Callable;

/* compiled from: DiskLruCache */
class df implements Callable<Void> {
    final /* synthetic */ de f11712a;

    df(de deVar) {
        this.f11712a = deVar;
    }

    public /* synthetic */ Object call() throws Exception {
        return m16053a();
    }

    public Void m16053a() throws Exception {
        synchronized (this.f11712a) {
            if (this.f11712a.f11706k == null) {
            } else {
                this.f11712a.m16045j();
                if (this.f11712a.m16043h()) {
                    this.f11712a.m16042g();
                    this.f11712a.f11708m = 0;
                }
            }
        }
        return null;
    }
}
