package com.google.tagmanager;

import com.google.analytics.p268a.p270b.C3642j;

/* compiled from: Container */
public class C3679d {
    private final be f14322a;
    private C3642j f14323b;
    private C3680e f14324c;
    private aw f14325d;
    private C3678c f14326e;
    private volatile String f14327f;
    private volatile long f14328g;
    private volatile int f14329h;

    public synchronized void refresh() {
        if (m18546b() == null) {
            C3700z.m18626b("refresh called for closed container");
        } else {
            try {
                if (m18548c()) {
                    C3700z.m18626b("Container is in DEFAULT_CONTAINER mode. Refresh request is ignored.");
                } else {
                    long a = this.f14326e.mo4295a();
                    if (m18547b(a)) {
                        C3700z.m18628d("Container refresh requested");
                        m18550a(0);
                        this.f14328g = a;
                    } else {
                        C3700z.m18628d("Container refresh was called too often. Ignored.");
                    }
                }
            } catch (Exception e) {
                C3700z.m18624a("Calling refresh() throws an exception: " + e.getMessage());
            }
        }
    }

    void m18551a(String str) {
        m18546b().m18499a(str);
    }

    synchronized void m18550a(long j) {
        if (!(this.f14324c == null || m18548c())) {
            this.f14324c.m18553a(j, this.f14323b.f14024d);
        }
    }

    private synchronized aw m18546b() {
        return this.f14325d;
    }

    synchronized void m18552b(String str) {
        this.f14327f = str;
        if (this.f14324c != null) {
            this.f14324c.m18554a(str);
        }
    }

    String m18549a() {
        return this.f14327f;
    }

    private boolean m18548c() {
        return this.f14322a.m18519a() == bj.DEFAULT_CONTAINER;
    }

    private boolean m18547b(long j) {
        if (this.f14328g == 0) {
            this.f14329h--;
            return true;
        }
        long j2 = j - this.f14328g;
        if (j2 < 5000) {
            return false;
        }
        if (this.f14329h < 30) {
            this.f14329h = Math.min(30, ((int) Math.floor((double) (j2 / 900000))) + this.f14329h);
        }
        if (this.f14329h <= 0) {
            return false;
        }
        this.f14329h--;
        return true;
    }
}
