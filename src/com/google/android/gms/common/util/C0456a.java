package com.google.android.gms.common.util;

import android.support.v4.util.ArrayMap;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;

public class C0456a<E> extends AbstractSet<E> {
    private final ArrayMap<E, E> f475a = new ArrayMap();

    public boolean m802a(C0456a<? extends E> c0456a) {
        int size = size();
        this.f475a.putAll(c0456a.f475a);
        return size() > size;
    }

    public boolean add(E e) {
        if (this.f475a.containsKey(e)) {
            return false;
        }
        this.f475a.put(e, e);
        return true;
    }

    public boolean addAll(Collection<? extends E> collection) {
        return collection instanceof C0456a ? m802a((C0456a) collection) : super.addAll(collection);
    }

    public void clear() {
        this.f475a.clear();
    }

    public boolean contains(Object obj) {
        return this.f475a.containsKey(obj);
    }

    public Iterator<E> iterator() {
        return this.f475a.keySet().iterator();
    }

    public boolean remove(Object obj) {
        if (!this.f475a.containsKey(obj)) {
            return false;
        }
        this.f475a.remove(obj);
        return true;
    }

    public int size() {
        return this.f475a.size();
    }
}
