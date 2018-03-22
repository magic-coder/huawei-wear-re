package com.huawei.hwdatamigrate.hihealth.p068d;

import android.util.LruCache;

/* compiled from: ObjectCache */
public class C4876h {
    private LruCache<Integer, Object> f17893a = new LruCache(20);

    public Object m23637a(int i) {
        return this.f17893a.get(Integer.valueOf(i));
    }

    public void m23638a(int i, Object obj) {
        this.f17893a.put(Integer.valueOf(i), obj);
    }
}
