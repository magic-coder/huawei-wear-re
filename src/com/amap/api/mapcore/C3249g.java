package com.amap.api.mapcore;

/* compiled from: AMapDelegateImp */
class C3249g implements Runnable {
    final /* synthetic */ AMapDelegateImp f11225a;

    C3249g(AMapDelegateImp aMapDelegateImp) {
        this.f11225a = aMapDelegateImp;
    }

    public void run() {
        if (this.f11225a.ab != null) {
            this.f11225a.aK = false;
            this.f11225a.ab.setVisibility(8);
        }
    }
}
