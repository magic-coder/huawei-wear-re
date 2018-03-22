package com.google.tagmanager;

import java.util.List;

/* compiled from: DataLayerPersistentStoreImpl */
class C3690p implements Runnable {
    final /* synthetic */ List f14348a;
    final /* synthetic */ long f14349b;
    final /* synthetic */ C3688n f14350c;

    C3690p(C3688n c3688n, List list, long j) {
        this.f14350c = c3688n;
        this.f14348a = list;
        this.f14349b = j;
    }

    public void run() {
        this.f14350c.m18595b(this.f14348a, this.f14349b);
    }
}
