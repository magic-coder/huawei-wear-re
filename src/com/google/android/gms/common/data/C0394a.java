package com.google.android.gms.common.data;

import java.util.Iterator;

public abstract class C0394a<T> implements C0393b<T> {
    protected final DataHolder f318a;

    protected C0394a(DataHolder dataHolder) {
        this.f318a = dataHolder;
    }

    public void mo1750a() {
        if (this.f318a != null) {
            this.f318a.close();
        }
    }

    public int mo1751b() {
        return this.f318a == null ? 0 : this.f318a.getCount();
    }

    public Iterator<T> iterator() {
        return new C0401i(this);
    }
}
