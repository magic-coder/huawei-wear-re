package com.squareup.haha.guava.collect;

import com.squareup.haha.guava.base.Joiner;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
import javax.annotation.Nullable;

public abstract class ImmutableCollection<E> extends AbstractCollection<E> implements Serializable {
    private transient ImmutableList<E> asList;

    abstract boolean isPartialView();

    public abstract UnmodifiableIterator<E> iterator();

    ImmutableCollection() {
    }

    public final Object[] toArray() {
        if (size() == 0) {
            return ObjectArrays.EMPTY_ARRAY;
        }
        Object[] objArr = new Object[size()];
        copyIntoArray(objArr, 0);
        return objArr;
    }

    public final <T> T[] toArray(T[] tArr) {
        Joiner.checkNotNull(tArr);
        int size = size();
        if (tArr.length < size) {
            tArr = ObjectArrays.newArray(tArr, size);
        } else if (tArr.length > size) {
            tArr[size] = null;
        }
        copyIntoArray(tArr, 0);
        return tArr;
    }

    public boolean contains(@Nullable Object obj) {
        return obj != null && super.contains(obj);
    }

    @Deprecated
    public final boolean add(E e) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final boolean remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final boolean addAll(Collection<? extends E> collection) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final boolean removeAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final boolean retainAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    public ImmutableList<E> asList() {
        ImmutableList<E> immutableList = this.asList;
        if (immutableList == null) {
            switch (size()) {
                case 0:
                    immutableList = ImmutableList.of();
                    break;
                case 1:
                    immutableList = ImmutableList.of(iterator().next());
                    break;
                default:
                    immutableList = new RegularImmutableAsList(this, toArray());
                    break;
            }
            this.asList = immutableList;
        }
        return immutableList;
    }

    int copyIntoArray(Object[] objArr, int i) {
        Iterator it = iterator();
        while (it.hasNext()) {
            int i2 = i + 1;
            objArr[i] = it.next();
            i = i2;
        }
        return i;
    }
}
