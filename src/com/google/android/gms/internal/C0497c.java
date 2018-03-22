package com.google.android.gms.internal;

import android.support.v4.util.ArrayMap;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.ac;
import com.google.android.gms.common.api.ad;
import com.google.android.gms.p015b.C0358b;
import com.google.android.gms.p015b.C0359c;
import java.util.Set;

public final class C0497c {
    private final ArrayMap<ez<?>, ConnectionResult> f644a = new ArrayMap();
    private final C0359c<Void> f645b = new C0359c();
    private int f646c;
    private boolean f647d = false;

    public C0497c(Iterable<? extends ad<?>> iterable) {
        for (ad b : iterable) {
            this.f644a.put(b.m344b(), null);
        }
        this.f646c = this.f644a.keySet().size();
    }

    public Set<ez<?>> m1131a() {
        return this.f644a.keySet();
    }

    public void m1132a(ez<?> ezVar, ConnectionResult connectionResult) {
        this.f644a.put(ezVar, connectionResult);
        this.f646c--;
        if (!connectionResult.isSuccess()) {
            this.f647d = true;
        }
        if (this.f646c != 0) {
            return;
        }
        if (this.f647d) {
            this.f645b.m309a(new ac(this.f644a));
            return;
        }
        this.f645b.m310a(null);
    }

    public C0358b<Void> m1133b() {
        return this.f645b.m308a();
    }

    public void m1134c() {
        this.f645b.m310a(null);
    }
}
