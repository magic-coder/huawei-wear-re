package com.squareup.haha.guava.collect;

import com.squareup.haha.guava.base.Joiner;
import java.util.Iterator;

abstract class TransformedIterator<F, T> implements Iterator<T> {
    private Iterator<? extends F> backingIterator;

    abstract T transform(F f);

    TransformedIterator(Iterator<? extends F> it) {
        this.backingIterator = (Iterator) Joiner.checkNotNull(it);
    }

    public final boolean hasNext() {
        return this.backingIterator.hasNext();
    }

    public final T next() {
        return transform(this.backingIterator.next());
    }

    public final void remove() {
        this.backingIterator.remove();
    }
}
