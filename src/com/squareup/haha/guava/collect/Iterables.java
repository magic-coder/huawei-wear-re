package com.squareup.haha.guava.collect;

import com.squareup.haha.guava.base.Joiner;
import java.util.Iterator;

public final class Iterables {

    final class C25522 extends FluentIterable<T> {
        private /* synthetic */ Iterable val$inputs;

        C25522(Iterable iterable) {
            this.val$inputs = iterable;
        }

        public final Iterator<T> iterator() {
            return Iterators.concat(new C25533(this.val$inputs.iterator()));
        }
    }

    final class C25533 extends TransformedIterator<Iterable<? extends T>, Iterator<? extends T>> {
        C25533(Iterator it) {
            super(it);
        }

        final /* synthetic */ Object transform(Object obj) {
            return ((Iterable) obj).iterator();
        }
    }

    public static String toString(Iterable<?> iterable) {
        return Iterators.toString(iterable.iterator());
    }

    public static <T> Iterable<T> concat(Iterable<? extends T> iterable, Iterable<? extends T> iterable2) {
        Iterable of = ImmutableList.of(iterable, iterable2);
        Joiner.checkNotNull(of);
        return new C25522(of);
    }
}
