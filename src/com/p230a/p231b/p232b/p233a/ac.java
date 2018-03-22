package com.p230a.p231b.p232b.p233a;

import android.os.SystemClock;
import java.util.ArrayList;
import java.util.List;

final class ac {
    public static final boolean f10404a = C3121x.f10470b;
    private final List f10405b = new ArrayList();
    private boolean f10406c = false;

    ac() {
    }

    public final synchronized void m13842a(String str) {
        long j;
        this.f10406c = true;
        if (this.f10405b.size() == 0) {
            j = 0;
        } else {
            j = ((ad) this.f10405b.get(this.f10405b.size() - 1)).f10409c - ((ad) this.f10405b.get(0)).f10409c;
        }
        if (j > 0) {
            long j2 = ((ad) this.f10405b.get(0)).f10409c;
            C3121x.m13907b("(%-4d ms) %s", Long.valueOf(j), str);
            j = j2;
            for (ad adVar : this.f10405b) {
                C3121x.m13907b("(+%-4d) [%2d] %s", Long.valueOf(adVar.f10409c - j), Long.valueOf(adVar.f10408b), adVar.f10407a);
                j = adVar.f10409c;
            }
        }
    }

    public final synchronized void m13843a(String str, long j) {
        if (this.f10406c) {
            throw new IllegalStateException("Marker added to finished log");
        }
        this.f10405b.add(new ad(str, j, SystemClock.elapsedRealtime()));
    }

    protected final void finalize() {
        if (!this.f10406c) {
            m13842a("Request on the loose");
            C3121x.m13908c("Marker log finalized without finish() - uncaught exit point for request", new Object[0]);
        }
    }
}
