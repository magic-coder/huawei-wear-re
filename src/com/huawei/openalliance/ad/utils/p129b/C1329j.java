package com.huawei.openalliance.ad.utils.p129b;

public abstract class C1329j extends Thread {
    private volatile boolean f2868a;
    private volatile boolean f2869b;
    private C1344l f2870c;

    public C1329j(String str) {
        this(str, null);
    }

    public C1329j(String str, C1344l c1344l) {
        super(str);
        this.f2868a = true;
        this.f2869b = false;
        this.f2870c = c1344l;
    }

    private boolean m5851f() {
        return mo2455a();
    }

    private void m5852g() {
        m5858e();
        mo2457c();
    }

    private boolean m5853h() {
        return mo2456b();
    }

    protected boolean mo2455a() {
        return true;
    }

    protected abstract boolean mo2456b();

    protected void mo2457c() {
    }

    public String m5857d() {
        StringBuilder stringBuilder = new StringBuilder(64);
        stringBuilder.append(getName());
        stringBuilder.append('{');
        stringBuilder.append(getId());
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    protected void m5858e() {
        if (!this.f2869b && this.f2870c != null) {
            this.f2870c.m5933a(this);
        }
    }

    public void run() {
        if (m5851f()) {
            while (this.f2868a) {
                try {
                    if (!m5853h()) {
                        break;
                    }
                } catch (Exception e) {
                    try {
                        C1329j.sleep(1000);
                    } catch (InterruptedException e2) {
                    }
                }
            }
        }
        m5852g();
    }

    public String toString() {
        return m5857d();
    }
}
