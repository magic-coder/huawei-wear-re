package com.autonavi.amap.mapcore;

/* compiled from: ConnectionManager */
class C3521a implements Runnable {
    public BaseMapLoader f13275a = null;

    public C3521a(BaseMapLoader baseMapLoader) {
        this.f13275a = baseMapLoader;
    }

    public void run() {
        try {
            this.f13275a.doRequest();
        } catch (Throwable th) {
        }
    }
}
