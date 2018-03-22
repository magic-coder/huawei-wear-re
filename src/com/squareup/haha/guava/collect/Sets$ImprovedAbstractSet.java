package com.squareup.haha.guava.collect;

import com.squareup.haha.guava.base.Joiner;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Set;

abstract class Sets$ImprovedAbstractSet<E> extends AbstractSet<E> {
    Sets$ImprovedAbstractSet() {
    }

    public boolean removeAll(Collection<?> collection) {
        return Joiner.removeAllImpl((Set) this, (Collection) collection);
    }

    public boolean retainAll(Collection<?> collection) {
        return super.retainAll((Collection) Joiner.checkNotNull(collection));
    }
}
