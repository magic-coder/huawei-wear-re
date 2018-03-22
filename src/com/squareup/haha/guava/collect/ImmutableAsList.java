package com.squareup.haha.guava.collect;

abstract class ImmutableAsList<E> extends ImmutableList<E> {
    abstract ImmutableCollection<E> delegateCollection();

    ImmutableAsList() {
    }

    public boolean contains(Object obj) {
        return delegateCollection().contains(obj);
    }

    public int size() {
        return delegateCollection().size();
    }

    public boolean isEmpty() {
        return delegateCollection().isEmpty();
    }

    final boolean isPartialView() {
        return delegateCollection().isPartialView();
    }
}
