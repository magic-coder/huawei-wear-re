package com.amap.api.mapcore;

import com.amap.api.mapcore.util.ca;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: GLOverlayLayer */
class C3348w implements Runnable {
    final /* synthetic */ C3347v f11892a;

    C3348w(C3347v c3347v) {
        this.f11892a = c3347v;
    }

    public synchronized void run() {
        try {
            synchronized (this.f11892a) {
                Collection arrayList = new ArrayList(this.f11892a.f11888d);
                Collections.sort(arrayList, this.f11892a.f11887b);
                this.f11892a.f11888d = new CopyOnWriteArrayList(arrayList);
            }
        } catch (Throwable th) {
            ca.m15831a(th, "MapOverlayImageView", "changeOverlayIndex");
        }
    }
}
