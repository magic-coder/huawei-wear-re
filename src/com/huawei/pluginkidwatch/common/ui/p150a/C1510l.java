package com.huawei.pluginkidwatch.common.ui.p150a;

import android.util.SparseArray;
import android.view.View;
import com.huawei.p190v.C2538c;
import java.lang.ref.SoftReference;

/* compiled from: RecycleViewList */
public class C1510l {
    private final SparseArray<SoftReference<View>> f3519a = new SparseArray(3);
    private Object f3520b = new Object();

    public void m6984a(int i, View view) {
        C2538c.m12674b("RecycleViewList", "addToCache: enter index = " + i);
        synchronized (this.f3520b) {
            int size = this.f3519a.size();
            C2538c.m12674b("RecycleViewList", "addToCache: index=" + i + ", size = " + size + ", view=" + view);
            this.f3519a.put(i, new SoftReference(view));
        }
        C2538c.m12674b("RecycleViewList", "addToCache: leave index = " + i);
    }

    public View m6983a(int i) {
        C2538c.m12674b("RecycleViewList", "fetchCacheView: enter index = " + i);
        synchronized (this.f3520b) {
            int size = this.f3519a.size();
            C2538c.m12674b("RecycleViewList", "fetchCacheView: size = " + size);
            if (i < 0) {
                return null;
            }
            C2538c.m12674b("RecycleViewList", "fetchCacheView: mViewCache.size() = " + this.f3519a.size());
            SoftReference softReference = (SoftReference) this.f3519a.get(i);
            if (softReference != null) {
                C2538c.m12674b("RecycleViewList", "fetchCacheView: cachedView= " + softReference);
                View view = (View) softReference.get();
                if (view != null) {
                    C2538c.m12674b("RecycleViewList", "fetchCacheView: leave with=" + view);
                    return view;
                }
            }
            C2538c.m12674b("RecycleViewList", "fetchCacheView: return null");
            return null;
        }
    }
}
