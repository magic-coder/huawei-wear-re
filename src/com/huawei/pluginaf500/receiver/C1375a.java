package com.huawei.pluginaf500.receiver;

/* compiled from: PhoneCallStateMachine */
public class C1375a {
    private static final C1375a f2963a = new C1375a();
    private c f2964b = c.a;
    private Runnable f2965c = null;

    private C1375a() {
    }

    private void m6157d() {
        if (this.f2965c != null) {
            this.f2965c.run();
            this.f2965c = null;
        }
    }

    public static C1375a m6156a() {
        return f2963a;
    }

    private void m6158e() {
        m6157d();
        m6163c();
    }

    private void m6159f() {
        m6157d();
        m6163c();
    }

    private void m6160g() {
        m6157d();
        m6163c();
    }

    public void m6162b() {
        switch (b.a[this.f2964b.ordinal()]) {
            case 1:
                m6158e();
                return;
            case 2:
                m6160g();
                return;
            case 3:
                m6159f();
                return;
            default:
                return;
        }
    }

    public void m6161a(Runnable runnable) {
        this.f2965c = runnable;
    }

    public void m6163c() {
        this.f2964b = c.a;
    }
}
