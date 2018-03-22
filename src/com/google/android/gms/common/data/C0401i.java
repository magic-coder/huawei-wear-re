package com.google.android.gms.common.data;

import com.google.android.gms.common.internal.C0424f;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class C0401i<T> implements Iterator<T> {
    protected final C0393b<T> f325a;
    protected int f326b = -1;

    public C0401i(C0393b<T> c0393b) {
        this.f325a = (C0393b) C0424f.m649a((Object) c0393b);
    }

    public boolean hasNext() {
        return this.f326b < this.f325a.mo1751b() + -1;
    }

    public T next() {
        if (hasNext()) {
            C0393b c0393b = this.f325a;
            int i = this.f326b + 1;
            this.f326b = i;
            return c0393b.mo1752a(i);
        }
        throw new NoSuchElementException("Cannot advance the iterator beyond " + this.f326b);
    }

    public void remove() {
        throw new UnsupportedOperationException("Cannot remove elements from a DataBufferIterator");
    }
}
