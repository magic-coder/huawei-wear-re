package com.squareup.haha.guava.collect;

import com.squareup.haha.guava.base.Joiner;
import java.util.Collection;
import javax.annotation.Nullable;

public final class Collections2 {
    static final Joiner STANDARD_JOINER = new Joiner(", ").useForNull("null");

    static boolean safeContains(Collection<?> collection, @Nullable Object obj) {
        boolean z = false;
        Joiner.checkNotNull(collection);
        try {
            z = collection.contains(obj);
        } catch (ClassCastException e) {
        } catch (NullPointerException e2) {
        }
        return z;
    }
}
