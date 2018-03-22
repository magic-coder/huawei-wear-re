package com.huawei.hwdatamigrate.hihealth.p068d;

import android.util.LruCache;
import com.huawei.hwdatamigrate.hihealth.d.g;

/* compiled from: ClientCache */
public class C4870a {
    private LruCache<String, g> f17888a = new LruCache(20);

    public g m23630a(String str) {
        if (str == null) {
            return null;
        }
        return (g) this.f17888a.get(str);
    }

    public void m23631a(String str, g gVar) {
        if (str != null) {
            this.f17888a.put(str, gVar);
        }
    }
}
