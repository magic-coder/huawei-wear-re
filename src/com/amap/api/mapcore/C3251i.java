package com.amap.api.mapcore;

/* compiled from: AMapDelegateImp */
class C3251i implements Runnable {
    final /* synthetic */ AMapDelegateImp f11227a;

    C3251i(AMapDelegateImp aMapDelegateImp) {
        this.f11227a = aMapDelegateImp;
    }

    public synchronized void run() {
        if (this.f11227a.aQ) {
            this.f11227a.aP = true;
            this.f11227a.aQ = false;
        }
    }
}
