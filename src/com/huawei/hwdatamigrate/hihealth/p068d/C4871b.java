package com.huawei.hwdatamigrate.hihealth.p068d;

import android.util.LruCache;
import java.util.List;

/* compiled from: ClientsCache */
public class C4871b {
    private LruCache<String, List<Integer>> f17889a = new LruCache(10);

    public List<Integer> m23632a(String str) {
        if (str == null) {
            return null;
        }
        return (List) this.f17889a.get(str);
    }

    public void m23633a(String str, List<Integer> list) {
        if (str != null) {
            this.f17889a.put(str, list);
        }
    }
}
