package com.squareup.haha.guava.collect;

import com.squareup.haha.guava.base.Function;
import com.squareup.haha.guava.base.Joiner;
import com.squareup.haha.guava.base.Joiner.MapJoiner;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.annotation.Nullable;

public final class Maps {

    abstract class EntrySet<K, V> extends Sets$ImprovedAbstractSet<Entry<K, V>> {
        abstract Map<K, V> map();

        EntrySet() {
        }

        public int size() {
            return map().size();
        }

        public void clear() {
            map().clear();
        }

        public boolean contains(Object obj) {
            if (!(obj instanceof Entry)) {
                return false;
            }
            Entry entry = (Entry) obj;
            Object key = entry.getKey();
            Object safeGet = Maps.safeGet(map(), key);
            if (!Joiner.equal(safeGet, entry.getValue())) {
                return false;
            }
            if (safeGet != null || map().containsKey(key)) {
                return true;
            }
            return false;
        }

        public boolean isEmpty() {
            return map().isEmpty();
        }

        public boolean remove(Object obj) {
            if (!contains(obj)) {
                return false;
            }
            return map().keySet().remove(((Entry) obj).getKey());
        }

        public boolean removeAll(Collection<?> collection) {
            try {
                return super.removeAll((Collection) Joiner.checkNotNull(collection));
            } catch (UnsupportedOperationException e) {
                return Joiner.removeAllImpl((Set) this, collection.iterator());
            }
        }

        public boolean retainAll(Collection<?> collection) {
            try {
                return super.retainAll((Collection) Joiner.checkNotNull(collection));
            } catch (UnsupportedOperationException e) {
                Collection hashSet = new HashSet(Maps.capacity(collection.size()));
                for (Object next : collection) {
                    if (contains(next)) {
                        hashSet.add(((Entry) next).getKey());
                    }
                }
                return map().keySet().retainAll(hashSet);
            }
        }
    }

    abstract class ImprovedAbstractMap<K, V> extends AbstractMap<K, V> {
        private transient Set<Entry<K, V>> entrySet;
        private transient Set<K> keySet;
        private transient Collection<V> values;

        abstract Set<Entry<K, V>> createEntrySet();

        ImprovedAbstractMap() {
        }

        public Set<Entry<K, V>> entrySet() {
            Set<Entry<K, V>> set = this.entrySet;
            if (set != null) {
                return set;
            }
            set = createEntrySet();
            this.entrySet = set;
            return set;
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
            return new KeySet(this);
        }

        public Collection<V> values() {
            Collection<V> collection = this.values;
            if (collection != null) {
                return collection;
            }
            collection = new Values(this);
            this.values = collection;
            return collection;
        }
    }

    class KeySet<K, V> extends Sets$ImprovedAbstractSet<K> {
        final Map<K, V> map;

        KeySet(Map<K, V> map) {
            this.map = (Map) Joiner.checkNotNull(map);
        }

        public boolean remove(Object obj) {
            if (!contains(obj)) {
                return false;
            }
            this.map.remove(obj);
            return true;
        }

        public Iterator<K> iterator() {
            return Maps.keyIterator(this.map.entrySet().iterator());
        }

        public int size() {
            return this.map.size();
        }

        public boolean isEmpty() {
            return this.map.isEmpty();
        }

        public boolean contains(Object obj) {
            return this.map.containsKey(obj);
        }

        public void clear() {
            this.map.clear();
        }
    }

    enum EntryFunction implements Function<Entry<?, ?>, Object> {
        KEY {
            public final /* synthetic */ Object apply(Object obj) {
                return ((Entry) obj).getKey();
            }
        },
        VALUE {
            public final /* synthetic */ Object apply(Object obj) {
                return ((Entry) obj).getValue();
            }
        };

        static {
            KEY = new C25591("KEY", 0);
            VALUE = new C25602("VALUE", 1);
            EntryFunction[] entryFunctionArr = new EntryFunction[]{KEY, VALUE};
        }
    }

    final class Values<K, V> extends AbstractCollection<V> {
        private Map<K, V> map;

        Values(Map<K, V> map) {
            this.map = (Map) Joiner.checkNotNull(map);
        }

        public final boolean remove(Object obj) {
            try {
                return super.remove(obj);
            } catch (UnsupportedOperationException e) {
                for (Entry entry : this.map.entrySet()) {
                    if (Joiner.equal(obj, entry.getValue())) {
                        this.map.remove(entry.getKey());
                        return true;
                    }
                }
                return false;
            }
        }

        public final boolean removeAll(Collection<?> collection) {
            try {
                return super.removeAll((Collection) Joiner.checkNotNull(collection));
            } catch (UnsupportedOperationException e) {
                Collection hashSet = new HashSet();
                for (Entry entry : this.map.entrySet()) {
                    if (collection.contains(entry.getValue())) {
                        hashSet.add(entry.getKey());
                    }
                }
                return this.map.keySet().removeAll(hashSet);
            }
        }

        public final boolean retainAll(Collection<?> collection) {
            try {
                return super.retainAll((Collection) Joiner.checkNotNull(collection));
            } catch (UnsupportedOperationException e) {
                Collection hashSet = new HashSet();
                for (Entry entry : this.map.entrySet()) {
                    if (collection.contains(entry.getValue())) {
                        hashSet.add(entry.getKey());
                    }
                }
                return this.map.keySet().retainAll(hashSet);
            }
        }

        public final Iterator<V> iterator() {
            return Maps.valueIterator(this.map.entrySet().iterator());
        }

        public final int size() {
            return this.map.size();
        }

        public final boolean isEmpty() {
            return this.map.isEmpty();
        }

        public final boolean contains(@Nullable Object obj) {
            return this.map.containsValue(obj);
        }

        public final void clear() {
            this.map.clear();
        }
    }

    public static <K, V> HashMap<K, V> newHashMap() {
        return new HashMap();
    }

    public static int capacity(int i) {
        if (i < 3) {
            String str = "expectedSize";
            if (i >= 0) {
                return i + 1;
            }
            throw new IllegalArgumentException(str + " cannot be negative but was: " + i);
        } else if (i < 1073741824) {
            return (i / 3) + i;
        } else {
            return Integer.MAX_VALUE;
        }
    }

    public static <K, V> Entry<K, V> immutableEntry(@Nullable K k, @Nullable V v) {
        return new ImmutableEntry(k, v);
    }

    static <V> V safeGet(Map<?, V> map, @Nullable Object obj) {
        V v = null;
        Joiner.checkNotNull(map);
        try {
            v = map.get(obj);
        } catch (ClassCastException e) {
        } catch (NullPointerException e2) {
        }
        return v;
    }

    static boolean safeContainsKey(Map<?, ?> map, Object obj) {
        boolean z = false;
        Joiner.checkNotNull(map);
        try {
            z = map.containsKey(obj);
        } catch (ClassCastException e) {
        } catch (NullPointerException e2) {
        }
        return z;
    }

    static <V> V safeRemove(Map<?, V> map, Object obj) {
        V v = null;
        Joiner.checkNotNull(map);
        try {
            v = map.remove(obj);
        } catch (ClassCastException e) {
        } catch (NullPointerException e2) {
        }
        return v;
    }

    static {
        MapJoiner mapJoiner = new MapJoiner("=");
    }

    static <K, V> Iterator<K> keyIterator(Iterator<Entry<K, V>> it) {
        return Iterators.transform(it, EntryFunction.KEY);
    }

    static <K, V> Iterator<V> valueIterator(Iterator<Entry<K, V>> it) {
        return Iterators.transform(it, EntryFunction.VALUE);
    }
}
