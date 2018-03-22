package com.google.android.gms.internal;

import com.google.android.gms.common.api.C0366w;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.p015b.C0359c;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.WeakHashMap;

public class ab {
    private final Map<C0501m<?>, Boolean> f517a = Collections.synchronizedMap(new WeakHashMap());
    private final Map<C0359c<?>, Boolean> f518b = Collections.synchronizedMap(new WeakHashMap());

    private void m881a(boolean z, Status status) {
        synchronized (this.f517a) {
            Map hashMap = new HashMap(this.f517a);
        }
        synchronized (this.f518b) {
            Map hashMap2 = new HashMap(this.f518b);
        }
        for (Entry entry : hashMap.entrySet()) {
            if (z || ((Boolean) entry.getValue()).booleanValue()) {
                ((C0501m) entry.getKey()).m1480b(status);
            }
        }
        for (Entry entry2 : hashMap2.entrySet()) {
            if (z || ((Boolean) entry2.getValue()).booleanValue()) {
                ((C0359c) entry2.getKey()).m311b(new com.google.android.gms.common.api.ab(status));
            }
        }
    }

    void m882a(C0501m<? extends C0366w> c0501m, boolean z) {
        this.f517a.put(c0501m, Boolean.valueOf(z));
        c0501m.mo1848a(new ac(this, c0501m));
    }

    boolean m883a() {
        return (this.f517a.isEmpty() && this.f518b.isEmpty()) ? false : true;
    }

    public void m884b() {
        m881a(false, az.f570a);
    }

    public void m885c() {
        m881a(true, cg.f659a);
    }
}
