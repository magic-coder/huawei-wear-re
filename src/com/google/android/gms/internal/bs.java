package com.google.android.gms.internal;

import android.os.Looper;
import android.support.annotation.NonNull;
import com.google.android.gms.common.internal.C0424f;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;

public class bs {
    private final Set<zzabh<?>> f627a = Collections.newSetFromMap(new WeakHashMap());

    public static <L> zzabh<L> m1110b(@NonNull L l, @NonNull Looper looper, @NonNull String str) {
        C0424f.m650a((Object) l, (Object) "Listener must not be null");
        C0424f.m650a((Object) looper, (Object) "Looper must not be null");
        C0424f.m650a((Object) str, (Object) "Listener type must not be null");
        return new zzabh(looper, l, str);
    }

    public <L> zzabh<L> m1111a(@NonNull L l, Looper looper) {
        return m1112a(l, looper, "NO_TYPE");
    }

    public <L> zzabh<L> m1112a(@NonNull L l, @NonNull Looper looper, @NonNull String str) {
        zzabh<L> b = m1110b(l, looper, str);
        this.f627a.add(b);
        return b;
    }

    public void m1113a() {
        for (zzabh a : this.f627a) {
            a.m1636a();
        }
        this.f627a.clear();
    }
}
