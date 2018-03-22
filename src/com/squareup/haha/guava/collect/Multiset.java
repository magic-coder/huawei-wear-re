package com.squareup.haha.guava.collect;

import java.util.Collection;
import java.util.Set;

public interface Multiset<E> extends Collection<E> {
    Set<E> elementSet();
}
