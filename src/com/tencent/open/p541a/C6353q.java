package com.tencent.open.p541a;

/* compiled from: ProGuard */
public abstract class C6353q {
    private volatile int f22097a;
    private volatile boolean f22098b;
    private C6369p f22099c;

    protected abstract void mo5332a(int i, Thread thread, long j, String str, String str2, Throwable th);

    public C6353q() {
        this(C6359f.f22126a, true, C6369p.f22154a);
    }

    public C6353q(int i, boolean z, C6369p c6369p) {
        this.f22097a = C6359f.f22126a;
        this.f22098b = true;
        this.f22099c = C6369p.f22154a;
        m29045a(i);
        m29048a(z);
        m29047a(c6369p);
    }

    public void m29049b(int i, Thread thread, long j, String str, String str2, Throwable th) {
        if (m29050d() && C6361h.m29090a(this.f22097a, i)) {
            mo5332a(i, thread, j, str, str2, th);
        }
    }

    public void m29045a(int i) {
        this.f22097a = i;
    }

    public boolean m29050d() {
        return this.f22098b;
    }

    public void m29048a(boolean z) {
        this.f22098b = z;
    }

    public C6369p m29051e() {
        return this.f22099c;
    }

    public void m29047a(C6369p c6369p) {
        this.f22099c = c6369p;
    }
}
