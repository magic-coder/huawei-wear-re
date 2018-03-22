package com.amap.api.mapcore.util;

/* compiled from: CityStateImp */
public abstract class al {
    protected int f11422a;
    protected C3323g f11423b;

    public abstract void mo4006c();

    public al(int i, C3323g c3323g) {
        this.f11422a = i;
        this.f11423b = c3323g;
    }

    public int m15488b() {
        return this.f11422a;
    }

    public boolean m15487a(al alVar) {
        return alVar.m15488b() == m15488b();
    }

    public void m15489b(al alVar) {
        ag.m15453a(m15488b() + " ==> " + alVar.m15488b() + "   " + getClass() + "==>" + alVar.getClass());
    }

    public void mo4008d() {
        ag.m15453a("Wrong call start()  State: " + m15488b() + "  " + getClass());
    }

    public void mo4012e() {
        ag.m15453a("Wrong call continueDownload()  State: " + m15488b() + "  " + getClass());
    }

    public void mo4009f() {
        ag.m15453a("Wrong call pause()  State: " + m15488b() + "  " + getClass());
    }

    public void mo4005a() {
        ag.m15453a("Wrong call delete()  State: " + m15488b() + "  " + getClass());
    }

    public void mo4010g() {
        ag.m15453a("Wrong call fail()  State: " + m15488b() + "  " + getClass());
    }

    public void mo4007h() {
        ag.m15453a("Wrong call hasNew()  State: " + m15488b() + "  " + getClass());
    }

    public void mo4011i() {
        ag.m15453a("Wrong call complete()  State: " + m15488b() + "  " + getClass());
    }
}
