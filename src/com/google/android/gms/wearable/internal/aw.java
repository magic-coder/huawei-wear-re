package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.C0502h;
import java.lang.ref.WeakReference;
import java.util.Map;

class aw<T> extends bu<Status> {
    private WeakReference<Map<T, cl<T>>> f958a;
    private WeakReference<T> f959b;

    aw(Map<T, cl<T>> map, T t, C0502h<Status> c0502h) {
        super(c0502h);
        this.f958a = new WeakReference(map);
        this.f959b = new WeakReference(t);
    }

    public void mo1926a(Status status) {
        Map map = (Map) this.f958a.get();
        Object obj = this.f959b.get();
        if (!(status.getStatus().isSuccess() || map == null || obj == null)) {
            synchronized (map) {
                cl clVar = (cl) map.remove(obj);
                if (clVar != null) {
                    clVar.m2060a();
                }
            }
        }
        m1943a(status);
    }
}
