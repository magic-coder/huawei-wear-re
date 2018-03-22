package com.squareup.haha.guava.base;

import java.io.Serializable;
import java.util.Collection;
import javax.annotation.Nullable;

public final class Predicates {

    final class InPredicate<T> implements Predicate<T>, Serializable {
        private final Collection<?> target;

        private InPredicate(Collection<?> collection) {
            this.target = (Collection) Joiner.checkNotNull(collection);
        }

        public final boolean apply(@Nullable T t) {
            boolean z = false;
            try {
                z = this.target.contains(t);
            } catch (NullPointerException e) {
            } catch (ClassCastException e2) {
            }
            return z;
        }

        public final boolean equals(@Nullable Object obj) {
            if (!(obj instanceof InPredicate)) {
                return false;
            }
            return this.target.equals(((InPredicate) obj).target);
        }

        public final int hashCode() {
            return this.target.hashCode();
        }

        public final String toString() {
            return "Predicates.in(" + this.target + ")";
        }
    }

    public static <T> Predicate<T> in(Collection<? extends T> collection) {
        return new InPredicate(collection);
    }

    static {
        Joiner joiner = new Joiner(",");
    }
}
