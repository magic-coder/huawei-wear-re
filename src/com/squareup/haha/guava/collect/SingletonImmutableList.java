package com.squareup.haha.guava.collect;

import com.squareup.haha.guava.base.Joiner;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nullable;

final class SingletonImmutableList<E> extends ImmutableList<E> {
    private transient E element;

    SingletonImmutableList(E e) {
        this.element = Joiner.checkNotNull(e);
    }

    public final E get(int i) {
        Joiner.checkElementIndex(i, 1);
        return this.element;
    }

    public final int indexOf(@Nullable Object obj) {
        return this.element.equals(obj) ? 0 : -1;
    }

    public final UnmodifiableIterator<E> iterator() {
        return Iterators.singletonIterator(this.element);
    }

    public final int lastIndexOf(@Nullable Object obj) {
        return indexOf(obj);
    }

    public final int size() {
        return 1;
    }

    public final ImmutableList<E> subList(int i, int i2) {
        Joiner.checkPositionIndexes(i, i2, 1);
        if (i == i2) {
            return ImmutableList.EMPTY;
        }
        return this;
    }

    public final ImmutableList<E> reverse() {
        return this;
    }

    public final boolean contains(@Nullable Object obj) {
        return this.element.equals(obj);
    }

    public final boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof List)) {
            return false;
        }
        List list = (List) obj;
        if (list.size() == 1 && this.element.equals(list.get(0))) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return this.element.hashCode() + 31;
    }

    public final String toString() {
        String obj = this.element.toString();
        return new StringBuilder(obj.length() + 2).append('[').append(obj).append(']').toString();
    }

    public final boolean isEmpty() {
        return false;
    }

    final boolean isPartialView() {
        return false;
    }

    final int copyIntoArray(Object[] objArr, int i) {
        objArr[i] = this.element;
        return i + 1;
    }

    public final /* synthetic */ Iterator m30216iterator() {
        return Iterators.singletonIterator(this.element);
    }
}
