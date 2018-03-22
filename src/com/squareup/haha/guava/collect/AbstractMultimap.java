package com.squareup.haha.guava.collect;

import com.squareup.haha.guava.base.Joiner;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.annotation.Nullable;

abstract class AbstractMultimap<K, V> implements Multimap<K, V> {
    private transient Map<K, Collection<V>> asMap;
    private transient Collection<Entry<K, V>> entries;
    private transient Set<K> keySet;
    private transient Collection<V> values;

    class Entries extends Multimaps$Entries<K, V> {
        private Entries() {
        }

        final Multimap<K, V> multimap() {
            return AbstractMultimap.this;
        }

        public Iterator<Entry<K, V>> iterator() {
            return AbstractMultimap.this.entryIterator();
        }
    }

    final class EntrySet extends Entries implements Set<Entry<K, V>> {
        private EntrySet(AbstractMultimap abstractMultimap) {
            super();
        }

        public final int hashCode() {
            int i = 0;
            for (Object next : this) {
                int hashCode;
                if (next != null) {
                    hashCode = next.hashCode();
                } else {
                    hashCode = 0;
                }
                i = ((i + hashCode) ^ -1) ^ -1;
            }
            return i;
        }

        public final boolean equals(@Nullable Object obj) {
            return Joiner.equalsImpl(this, obj);
        }
    }

    final class Values extends AbstractCollection<V> {
        Values() {
        }

        public final Iterator<V> iterator() {
            return AbstractMultimap.this.valueIterator();
        }

        public final int size() {
            return AbstractMultimap.this.size();
        }

        public final boolean contains(@Nullable Object obj) {
            return AbstractMultimap.this.containsValue(obj);
        }

        public final void clear() {
            AbstractMultimap.this.clear();
        }
    }

    abstract Map<K, Collection<V>> createAsMap();

    abstract Iterator<Entry<K, V>> entryIterator();

    AbstractMultimap() {
    }

    public boolean containsValue(@Nullable Object obj) {
        for (Collection contains : asMap().values()) {
            if (contains.contains(obj)) {
                return true;
            }
        }
        return false;
    }

    public boolean containsEntry(@Nullable Object obj, @Nullable Object obj2) {
        Collection collection = (Collection) asMap().get(obj);
        return collection != null && collection.contains(obj2);
    }

    public boolean remove(@Nullable Object obj, @Nullable Object obj2) {
        Collection collection = (Collection) asMap().get(obj);
        return collection != null && collection.remove(obj2);
    }

    public boolean put(@Nullable K k, @Nullable V v) {
        return get(k).add(v);
    }

    public Collection<Entry<K, V>> entries() {
        Collection<Entry<K, V>> collection = this.entries;
        if (collection == null) {
            if (this instanceof SetMultimap) {
                collection = new EntrySet();
            } else {
                collection = new Entries();
            }
            this.entries = collection;
        }
        return collection;
    }

    public Set<K> keySet() {
        Set<K> set = this.keySet;
        if (set != null) {
            return set;
        }
        set = createKeySet();
        this.keySet = set;
        return set;
    }

    Set<K> createKeySet() {
        return new KeySet(asMap());
    }

    public Collection<V> values() {
        Collection<V> collection = this.values;
        if (collection != null) {
            return collection;
        }
        collection = new Values();
        this.values = collection;
        return collection;
    }

    Iterator<V> valueIterator() {
        return Maps.valueIterator(entries().iterator());
    }

    public Map<K, Collection<V>> asMap() {
        Map<K, Collection<V>> map = this.asMap;
        if (map != null) {
            return map;
        }
        map = createAsMap();
        this.asMap = map;
        return map;
    }

    public int hashCode() {
        return asMap().hashCode();
    }

    public String toString() {
        return asMap().toString();
    }

    public boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Multimap)) {
            return false;
        }
        return asMap().equals(((Multimap) obj).asMap());
    }
}
