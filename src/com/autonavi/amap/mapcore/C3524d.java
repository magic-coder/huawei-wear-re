package com.autonavi.amap.mapcore;

import java.util.Hashtable;

/* compiled from: TilesProcessingCtrl */
class C3524d {
    int f13280a = 0;
    long f13281b;
    boolean f13282c = true;
    private Hashtable<String, C3523c> f13283d = new Hashtable();

    public void m17634a(String str) {
        this.f13283d.remove(str);
    }

    public boolean m17636b(String str) {
        return this.f13283d.get(str) != null;
    }

    public void m17637c(String str) {
        this.f13283d.put(str, new C3523c(str, 0));
    }

    public void m17633a() {
        this.f13283d.clear();
    }

    public C3524d() {
        m17635b();
    }

    public void m17635b() {
        this.f13281b = System.currentTimeMillis();
    }
}
