package com.amap.api.mapcore;

import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: MapMessageQueue */
class au {
    AMapDelegateImp f10934a;
    private CopyOnWriteArrayList<C3259o> f10935b = new CopyOnWriteArrayList();
    private CopyOnWriteArrayList<at> f10936c = new CopyOnWriteArrayList();

    public au(AMapDelegateImp aMapDelegateImp) {
        this.f10934a = aMapDelegateImp;
    }

    public synchronized void m14845a() {
        if (this.f10935b != null) {
            this.f10935b.clear();
            this.f10935b = null;
        }
        if (this.f10936c != null) {
            this.f10936c.clear();
            this.f10936c = null;
        }
    }

    public synchronized void m14846a(at atVar) {
        this.f10934a.mo3816e(false);
        this.f10936c.add(atVar);
        this.f10934a.mo3816e(false);
    }

    public at m14848b() {
        if (m14849c() == 0) {
            return null;
        }
        at atVar = (at) this.f10936c.get(0);
        this.f10936c.remove(atVar);
        return atVar;
    }

    public synchronized int m14849c() {
        return this.f10936c.size();
    }

    public void m14847a(C3259o c3259o) {
        this.f10934a.mo3816e(false);
        this.f10935b.add(c3259o);
        this.f10934a.mo3816e(false);
    }

    public C3259o m14850d() {
        if (m14851e() == 0) {
            return null;
        }
        C3259o c3259o = (C3259o) this.f10935b.get(0);
        this.f10935b.remove(c3259o);
        this.f10934a.mo3816e(false);
        return c3259o;
    }

    public int m14851e() {
        return this.f10935b.size();
    }

    public void m14852f() {
        this.f10935b.clear();
    }
}
