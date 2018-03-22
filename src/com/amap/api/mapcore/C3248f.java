package com.amap.api.mapcore;

/* compiled from: AMapDelegateImp */
class C3248f implements Runnable {
    final /* synthetic */ AMapDelegateImp f11224a;

    C3248f(AMapDelegateImp aMapDelegateImp) {
        this.f11224a = aMapDelegateImp;
    }

    public void run() {
        if (this.f11224a.ab != null) {
            this.f11224a.aK = true;
            if (this.f11224a.ad != null) {
                this.f11224a.ad.mo3700c(false);
            }
        }
    }
}
