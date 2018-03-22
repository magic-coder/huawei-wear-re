package com.squareup.haha.guava.collect;

import com.squareup.haha.guava.base.Joiner;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import javax.annotation.Nullable;

public abstract class ImmutableList<E> extends ImmutableCollection<E> implements List<E>, RandomAccess {
    static final ImmutableList<Object> EMPTY = new RegularImmutableList(ObjectArrays.EMPTY_ARRAY);

    final class ReverseImmutableList<E> extends ImmutableList<E> {
        private final transient ImmutableList<E> forwardList;

        public final /* bridge */ /* synthetic */ Iterator iterator() {
            return super.iterator();
        }

        public final /* bridge */ /* synthetic */ ListIterator listIterator(int i) {
            return super.listIterator(i);
        }

        ReverseImmutableList(ImmutableList<E> immutableList) {
            this.forwardList = immutableList;
        }

        private int reverseIndex(int i) {
            return (size() - 1) - i;
        }

        public final ImmutableList<E> reverse() {
            return this.forwardList;
        }

        public final boolean contains(@Nullable Object obj) {
            return this.forwardList.contains(obj);
        }

        public final int indexOf(@Nullable Object obj) {
            int lastIndexOf = this.forwardList.lastIndexOf(obj);
            return lastIndexOf >= 0 ? reverseIndex(lastIndexOf) : -1;
        }

        public final int lastIndexOf(@Nullable Object obj) {
            int indexOf = this.forwardList.indexOf(obj);
            return indexOf >= 0 ? reverseIndex(indexOf) : -1;
        }

        public final ImmutableList<E> subList(int i, int i2) {
            Joiner.checkPositionIndexes(i, i2, size());
            return this.forwardList.subList(size() - i2, size() - i).reverse();
        }

        public final E get(int i) {
            Joiner.checkElementIndex(i, size());
            return this.forwardList.get(reverseIndex(i));
        }

        public final int size() {
            return this.forwardList.size();
        }

        final boolean isPartialView() {
            return this.forwardList.isPartialView();
        }

        public final /* bridge */ /* synthetic */ ListIterator listIterator() {
            return listIterator(0);
        }
    }

    final class SubList extends ImmutableList<E> {
        private transient int length;
        private transient int offset;

        public final /* bridge */ /* synthetic */ Iterator iterator() {
            return super.iterator();
        }

        public final /* bridge */ /* synthetic */ ListIterator listIterator(int i) {
            return super.listIterator(i);
        }

        SubList(int i, int i2) {
            this.offset = i;
            this.length = i2;
        }

        public final int size() {
            return this.length;
        }

        public final E get(int i) {
            Joiner.checkElementIndex(i, this.length);
            return ImmutableList.this.get(this.offset + i);
        }

        public final ImmutableList<E> subList(int i, int i2) {
            Joiner.checkPositionIndexes(i, i2, this.length);
            return ImmutableList.this.subList(this.offset + i, this.offset + i2);
        }

        final boolean isPartialView() {
            return true;
        }

        public final /* bridge */ /* synthetic */ ListIterator listIterator() {
            return listIterator(0);
        }
    }

    public static <E> ImmutableList<E> of() {
        return EMPTY;
    }

    public static <E> ImmutableList<E> of(E e) {
        return new SingletonImmutableList(e);
    }

    public static <E> ImmutableList<E> of(E e, E e2) {
        return asImmutableList(ObjectArrays.checkElementsNotNull(e, e2));
    }

    public static <E> ImmutableList<E> copyOf(Collection<? extends E> collection) {
        if (!(collection instanceof ImmutableCollection)) {
            return asImmutableList(ObjectArrays.checkElementsNotNull(collection.toArray()));
        }
        ImmutableList<E> asList = ((ImmutableCollection) collection).asList();
        if (asList.isPartialView()) {
            return asImmutableList(asList.toArray());
        }
        return asList;
    }

    static <E> ImmutableList<E> asImmutableList(Object[] objArr) {
        int length = objArr.length;
        switch (length) {
            case 0:
                return EMPTY;
            case 1:
                return new SingletonImmutableList(objArr[0]);
            default:
                if (length < objArr.length) {
                    objArr = ObjectArrays.arraysCopyOf(objArr, length);
                }
                return new RegularImmutableList(objArr);
        }
    }

    ImmutableList() {
    }

    public UnmodifiableListIterator<E> listIterator(int i) {
        return new AbstractIndexedListIterator<E>(size(), i) {
            protected final E get(int i) {
                return ImmutableList.this.get(i);
            }
        };
    }

    public int indexOf(@Nullable Object obj) {
        if (obj != null) {
            ListIterator listIterator = listIterator();
            while (listIterator.hasNext()) {
                if (Joiner.equal(obj, listIterator.next())) {
                    return listIterator.previousIndex();
                }
            }
        }
        return -1;
    }

    public int lastIndexOf(@Nullable Object obj) {
        if (obj != null) {
            ListIterator listIterator = listIterator(size());
            while (listIterator.hasPrevious()) {
                if (Joiner.equal(obj, listIterator.previous())) {
                    return listIterator.nextIndex();
                }
            }
        }
        return -1;
    }

    public boolean contains(@Nullable Object obj) {
        return indexOf(obj) >= 0;
    }

    public ImmutableList<E> subList(int i, int i2) {
        Joiner.checkPositionIndexes(i, i2, size());
        switch (i2 - i) {
            case 0:
                return EMPTY;
            case 1:
                return of(get(i));
            default:
                return subListUnchecked(i, i2);
        }
    }

    ImmutableList<E> subListUnchecked(int i, int i2) {
        return new SubList(i, i2 - i);
    }

    @Deprecated
    public final boolean addAll(int i, Collection<? extends E> collection) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final E set(int i, E e) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final void add(int i, E e) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final E remove(int i) {
        throw new UnsupportedOperationException();
    }

    public final ImmutableList<E> asList() {
        return this;
    }

    int copyIntoArray(Object[] objArr, int i) {
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            objArr[i + i2] = get(i2);
        }
        return i + size;
    }

    public ImmutableList<E> reverse() {
        return new ReverseImmutableList(this);
    }

    public boolean equals(@Nullable Object obj) {
        if (obj == Joiner.checkNotNull(this)) {
            return true;
        }
        if (obj instanceof List) {
            List list = (List) obj;
            if (size() == list.size() && Iterators.elementsEqual(iterator(), list.iterator())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < size(); i2++) {
            i = (((i * 31) + get(i2).hashCode()) ^ -1) ^ -1;
        }
        return i;
    }

    public UnmodifiableIterator<E> iterator() {
        return listIterator(0);
    }

    public /* bridge */ /* synthetic */ ListIterator listIterator() {
        return listIterator(0);
    }
}
