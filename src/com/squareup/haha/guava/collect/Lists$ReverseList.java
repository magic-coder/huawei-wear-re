package com.squareup.haha.guava.collect;

import com.squareup.haha.guava.base.Joiner;
import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import javax.annotation.Nullable;

public class Lists$ReverseList<T> extends AbstractList<T> {
    public final List<T> forwardList;

    public Lists$ReverseList(List<T> list) {
        this.forwardList = (List) Joiner.checkNotNull(list);
    }

    private int reverseIndex(int i) {
        int size = size();
        Joiner.checkElementIndex(i, size);
        return (size - 1) - i;
    }

    private int reversePosition(int i) {
        int size = size();
        Joiner.checkPositionIndex(i, size);
        return size - i;
    }

    public void add(int i, @Nullable T t) {
        this.forwardList.add(reversePosition(i), t);
    }

    public void clear() {
        this.forwardList.clear();
    }

    public T remove(int i) {
        return this.forwardList.remove(reverseIndex(i));
    }

    protected void removeRange(int i, int i2) {
        subList(i, i2).clear();
    }

    public T set(int i, @Nullable T t) {
        return this.forwardList.set(reverseIndex(i), t);
    }

    public T get(int i) {
        return this.forwardList.get(reverseIndex(i));
    }

    public int size() {
        return this.forwardList.size();
    }

    public List<T> subList(int i, int i2) {
        Joiner.checkPositionIndexes(i, i2, size());
        return Joiner.reverse(this.forwardList.subList(reversePosition(i2), reversePosition(i)));
    }

    public Iterator<T> iterator() {
        return listIterator();
    }

    public ListIterator<T> listIterator(int i) {
        final ListIterator listIterator = this.forwardList.listIterator(reversePosition(i));
        return new ListIterator<T>() {
            private boolean canRemoveOrSet;

            public final void add(T t) {
                listIterator.add(t);
                listIterator.previous();
                this.canRemoveOrSet = false;
            }

            public final boolean hasNext() {
                return listIterator.hasPrevious();
            }

            public final boolean hasPrevious() {
                return listIterator.hasNext();
            }

            public final T next() {
                if (hasNext()) {
                    this.canRemoveOrSet = true;
                    return listIterator.previous();
                }
                throw new NoSuchElementException();
            }

            public final int nextIndex() {
                return Lists$ReverseList.this.reversePosition(listIterator.nextIndex());
            }

            public final T previous() {
                if (hasPrevious()) {
                    this.canRemoveOrSet = true;
                    return listIterator.next();
                }
                throw new NoSuchElementException();
            }

            public final int previousIndex() {
                return nextIndex() - 1;
            }

            public final void remove() {
                Joiner.checkRemove(this.canRemoveOrSet);
                listIterator.remove();
                this.canRemoveOrSet = false;
            }

            public final void set(T t) {
                if (this.canRemoveOrSet) {
                    listIterator.set(t);
                    return;
                }
                throw new IllegalStateException();
            }
        };
    }
}
