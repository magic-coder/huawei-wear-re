package cn.com.fmsh.util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class FM_Collection<T, E> {
    private /* synthetic */ Map<T, E> f9847a = new HashMap();

    public E get(T t) {
        return this.f9847a.get(t);
    }

    public Iterator<T> iterator() {
        return this.f9847a.keySet().iterator();
    }

    public void put(T t, E e) {
        this.f9847a.put(t, e);
    }
}
