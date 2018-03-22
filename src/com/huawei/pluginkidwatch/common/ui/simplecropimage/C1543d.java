package com.huawei.pluginkidwatch.common.ui.simplecropimage;

import java.util.Iterator;
import java.util.WeakHashMap;

/* compiled from: BitmapManager */
public class C1543d implements Iterable<Thread> {
    private final WeakHashMap<Thread, Object> f3697a = new WeakHashMap();

    public Iterator<Thread> iterator() {
        return this.f3697a.keySet().iterator();
    }
}
