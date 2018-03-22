package com.aps;

import java.util.concurrent.Callable;

/* compiled from: DiskLruCache */
class bd implements Callable<Void> {
    final /* synthetic */ ay f13017a;

    bd(ay ayVar) {
        this.f13017a = ayVar;
    }

    public /* synthetic */ Object call() throws Exception {
        return m17404a();
    }

    public Void m17404a() throws Exception {
        synchronized (this.f13017a) {
            if (this.f13017a.f12995k == null) {
            } else {
                this.f13017a.m17377h();
                if (this.f13017a.m17375f()) {
                    this.f13017a.m17372e();
                    this.f13017a.f12997m = 0;
                }
            }
        }
        return null;
    }
}
