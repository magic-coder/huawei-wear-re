package com.google.android.gms.internal;

import android.support.annotation.WorkerThread;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.C0372j;
import com.google.android.gms.common.internal.C0434r;
import java.util.Map;

class al extends as {
    final /* synthetic */ ai f555a;
    private final Map<C0372j, ak> f556c;

    public al(ai aiVar, Map<C0372j, ak> map) {
        this.f555a = aiVar;
        super(aiVar);
        this.f556c = map;
    }

    @WorkerThread
    public void mo1822a() {
        int i;
        int i2 = 1;
        int i3 = 0;
        int i4 = 1;
        int i5 = 0;
        for (C0372j c0372j : this.f556c.keySet()) {
            if (!c0372j.mo2011e()) {
                i = 0;
                i4 = i5;
            } else if (!((ak) this.f556c.get(c0372j)).f553c) {
                i = 1;
                break;
            } else {
                i = i4;
                i4 = 1;
            }
            i5 = i4;
            i4 = i;
        }
        i2 = i5;
        i = 0;
        if (i2 != 0) {
            i3 = this.f555a.f532d.mo1742a(this.f555a.f531c);
        }
        if (i3 == 0 || (r0 == 0 && i4 == 0)) {
            if (this.f555a.f541m) {
                this.f555a.f539k.mo1869l();
            }
            for (C0372j c0372j2 : this.f556c.keySet()) {
                C0434r c0434r = (C0434r) this.f556c.get(c0372j2);
                if (!c0372j2.mo2011e() || i3 == 0) {
                    c0372j2.mo2010a(c0434r);
                } else {
                    this.f555a.f529a.m1623a(new an(this, this.f555a, c0434r));
                }
            }
            return;
        }
        this.f555a.f529a.m1623a(new am(this, this.f555a, new ConnectionResult(i3, null)));
    }
}
