package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.C0502h;
import java.lang.ref.WeakReference;
import java.util.Map;

class ax<T> extends bu<Status> {
    private WeakReference<Map<T, cl<T>>> f960a;
    private WeakReference<T> f961b;

    ax(Map<T, cl<T>> map, T t, C0502h<Status> c0502h) {
        super(c0502h);
        this.f960a = new WeakReference(map);
        this.f961b = new WeakReference(t);
    }

    public void mo1926a(Status status) {
        Map map = (Map) this.f960a.get();
        Object obj = this.f961b.get();
        if (!(status.getStatus().getStatusCode() != 4002 || map == null || obj == null)) {
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
