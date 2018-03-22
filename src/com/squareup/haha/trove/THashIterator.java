package com.squareup.haha.trove;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

abstract class THashIterator<V> extends TIterator implements Iterator<V> {
    private TObjectHash _hash;

    protected abstract V objectAtIndex(int i);

    public THashIterator(TObjectHash tObjectHash) {
        super(tObjectHash);
        this._hash = tObjectHash;
    }

    public V next() {
        moveToNextIndex();
        return objectAtIndex(this._index);
    }

    protected final int nextIndex() {
        if (this._expectedSize != this._hash.size()) {
            throw new ConcurrentModificationException();
        }
        int i;
        Object[] objArr = this._hash._set;
        int i2 = this._index;
        while (true) {
            i = i2 - 1;
            if (i2 <= 0 || (objArr[i] != null && objArr[i] != TObjectHash.REMOVED)) {
                return i;
            }
            i2 = i;
        }
        return i;
    }
}
