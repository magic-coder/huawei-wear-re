package com.huawei.appmarket.sdk.foundation.p356b.p357a.p358a.p361d;

import com.huawei.appmarket.sdk.foundation.p356b.p357a.p358a.p360b.C4243b;

public abstract class C4244c extends Thread {
    private volatile boolean f15916a;
    private volatile boolean f15917b;
    private C4267d f15918c;

    public C4244c(String str) {
        this(str, null);
    }

    public C4244c(String str, C4267d c4267d) {
        super(str);
        this.f15916a = true;
        this.f15917b = false;
        this.f15918c = c4267d;
    }

    private boolean m20554f() {
        C4243b.m20543c().m20548a((Object) "thread begin").m20552e();
        boolean a = mo4388a();
        if (!a) {
            C4243b.m20543c().m20548a((Object) "thread begin failure").m20552e();
        }
        return a;
    }

    private void m20555g() {
        m20561e();
        mo4390c();
        C4243b.m20543c().m20548a((Object) "thread end").m20552e();
    }

    private boolean m20556h() {
        boolean b = mo4389b();
        if (!b) {
            C4243b.m20543c().m20548a((Object) "thread loop broken").m20552e();
        }
        return b;
    }

    protected boolean mo4388a() {
        return true;
    }

    protected abstract boolean mo4389b();

    protected void mo4390c() {
    }

    public String m20560d() {
        StringBuilder stringBuilder = new StringBuilder(64);
        stringBuilder.append(getName());
        stringBuilder.append("{");
        stringBuilder.append(getId());
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    protected void m20561e() {
        if (!this.f15917b && this.f15918c != null) {
            C4243b.m20543c().m20548a((Object) "notify owner I'm exit").m20552e();
            this.f15918c.m20639a(this);
        }
    }

    public void run() {
        if (m20554f()) {
            while (this.f15916a) {
                try {
                    if (!m20556h()) {
                        break;
                    }
                } catch (Throwable e) {
                    C4243b.m20544d().m20549a(e).m20552e();
                    try {
                        C4244c.sleep(1000);
                    } catch (Throwable e2) {
                        C4243b.m20544d().m20549a(e2).m20552e();
                    }
                }
            }
        }
        m20555g();
    }

    public String toString() {
        return m20560d();
    }
}
