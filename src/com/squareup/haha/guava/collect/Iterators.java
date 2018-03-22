package com.squareup.haha.guava.collect;

import com.squareup.haha.guava.base.Function;
import com.squareup.haha.guava.base.Joiner;
import com.squareup.haha.guava.base.Predicate;
import com.squareup.haha.guava.base.Predicates;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import javax.annotation.Nullable;

public final class Iterators {
    private static UnmodifiableListIterator<Object> EMPTY_LIST_ITERATOR = new C25541();
    private static final Iterator<Object> EMPTY_MODIFIABLE_ITERATOR = new C25552();

    final class AnonymousClass11 extends AbstractIndexedListIterator<T> {
        private /* synthetic */ Object[] val$array;
        private /* synthetic */ int val$offset;

        AnonymousClass11(int i, int i2, Object[] objArr, int i3) {
            this.val$array = objArr;
            this.val$offset = i3;
            super(i, i2);
        }

        protected final T get(int i) {
            return this.val$array[this.val$offset + i];
        }
    }

    final class AnonymousClass12 extends UnmodifiableIterator<T> {
        private boolean done;
        private /* synthetic */ Object val$value;

        AnonymousClass12(Object obj) {
            this.val$value = obj;
        }

        public final boolean hasNext() {
            return !this.done;
        }

        public final T next() {
            if (this.done) {
                throw new NoSuchElementException();
            }
            this.done = true;
            return this.val$value;
        }
    }

    final class C25541 extends UnmodifiableListIterator<Object> {
        C25541() {
        }

        public final boolean hasNext() {
            return false;
        }

        public final Object next() {
            throw new NoSuchElementException();
        }

        public final boolean hasPrevious() {
            return false;
        }

        public final Object previous() {
            throw new NoSuchElementException();
        }

        public final int nextIndex() {
            return 0;
        }

        public final int previousIndex() {
            return -1;
        }
    }

    final class C25552 implements Iterator<Object> {
        C25552() {
        }

        public final boolean hasNext() {
            return false;
        }

        public final Object next() {
            throw new NoSuchElementException();
        }

        public final void remove() {
            Joiner.checkRemove(false);
        }
    }

    final class C25565 implements Iterator<T> {
        private Iterator<? extends T> current = Iterators.emptyIterator();
        private Iterator<? extends T> removeFrom;
        private /* synthetic */ Iterator val$inputs;

        C25565(Iterator it) {
            this.val$inputs = it;
        }

        public final boolean hasNext() {
            boolean hasNext;
            while (true) {
                hasNext = ((Iterator) Joiner.checkNotNull(this.current)).hasNext();
                if (hasNext || !this.val$inputs.hasNext()) {
                    return hasNext;
                }
                this.current = (Iterator) this.val$inputs.next();
            }
            return hasNext;
        }

        public final T next() {
            if (hasNext()) {
                this.removeFrom = this.current;
                return this.current.next();
            }
            throw new NoSuchElementException();
        }

        public final void remove() {
            Joiner.checkRemove(this.removeFrom != null);
            this.removeFrom.remove();
            this.removeFrom = null;
        }
    }

    final class C25578 extends TransformedIterator<F, T> {
        private /* synthetic */ Function val$function;

        C25578(Iterator it, Function function) {
            this.val$function = function;
            super(it);
        }

        final T transform(F f) {
            return this.val$function.apply(f);
        }
    }

    static <T> Iterator<T> emptyModifiableIterator() {
        return EMPTY_MODIFIABLE_ITERATOR;
    }

    public static boolean removeAll(Iterator<?> it, Collection<?> collection) {
        Predicate in = Predicates.in(collection);
        Joiner.checkNotNull(in);
        boolean z = false;
        while (it.hasNext()) {
            if (in.apply(it.next())) {
                it.remove();
                z = true;
            }
        }
        return z;
    }

    public static boolean elementsEqual(Iterator<?> it, Iterator<?> it2) {
        while (it.hasNext()) {
            if (!it2.hasNext()) {
                return false;
            }
            if (!Joiner.equal(it.next(), it2.next())) {
                return false;
            }
        }
        if (it2.hasNext()) {
            return false;
        }
        return true;
    }

    public static String toString(Iterator<?> it) {
        return Collections2.STANDARD_JOINER.appendTo(new StringBuilder("["), it).append(']').toString();
    }

    public static <T> Iterator<T> concat(Iterator<? extends Iterator<? extends T>> it) {
        Joiner.checkNotNull(it);
        return new C25565(it);
    }

    public static <F, T> Iterator<T> transform(Iterator<F> it, Function<? super F, ? extends T> function) {
        Joiner.checkNotNull(function);
        return new C25578(it, function);
    }

    static void clear(Iterator<?> it) {
        Joiner.checkNotNull(it);
        while (it.hasNext()) {
            it.next();
            it.remove();
        }
    }

    static <T> UnmodifiableListIterator<T> forArray(T[] tArr, int i, int i2, int i3) {
        Joiner.checkArgument(i2 >= 0);
        Joiner.checkPositionIndexes(i, i + i2, tArr.length);
        Joiner.checkPositionIndex(i3, i2);
        if (i2 == 0) {
            return EMPTY_LIST_ITERATOR;
        }
        return new AnonymousClass11(i2, i3, tArr, i);
    }

    public static <T> UnmodifiableIterator<T> singletonIterator(@Nullable T t) {
        return new AnonymousClass12(t);
    }

    public static <T> UnmodifiableIterator<T> emptyIterator() {
        return EMPTY_LIST_ITERATOR;
    }
}
