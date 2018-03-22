package com.amap.api.services.core;

import java.util.concurrent.Callable;

/* compiled from: DiskLruCache */
class bl implements Callable<Void> {
    final /* synthetic */ bk f12454a;

    bl(bk bkVar) {
        this.f12454a = bkVar;
    }

    public /* synthetic */ Object call() throws Exception {
        return m16841a();
    }

    public Void m16841a() throws Exception {
        synchronized (this.f12454a) {
            if (this.f12454a.f12448k == null) {
            } else {
                this.f12454a.m16833j();
                if (this.f12454a.m16831h()) {
                    this.f12454a.m16830g();
                    this.f12454a.f12450m = 0;
                }
            }
        }
        return null;
    }
}
