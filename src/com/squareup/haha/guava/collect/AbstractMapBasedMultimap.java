package com.squareup.haha.guava.collect;

import com.squareup.haha.guava.base.Joiner;
import com.squareup.haha.guava.collect.AbstractMapBasedMultimap$WrappedCollection.WrappedIterator;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.RandomAccess;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import javax.annotation.Nullable;

abstract class AbstractMapBasedMultimap<K, V> extends AbstractMultimap<K, V> implements Serializable {
    private transient Map<K, Collection<V>> map;
    private transient int totalSize;

    abstract class Itr<T> implements Iterator<T> {
        private Collection<V> collection = null;
        private K key = null;
        private Iterator<Entry<K, Collection<V>>> keyIterator;
        private Iterator<V> valueIterator = Iterators.emptyModifiableIterator();

        abstract T output(K k, V v);

        Itr() {
            this.keyIterator = AbstractMapBasedMultimap.this.map.entrySet().iterator();
        }

        public boolean hasNext() {
            return this.keyIterator.hasNext() || this.valueIterator.hasNext();
        }

        public T next() {
            if (!this.valueIterator.hasNext()) {
                Entry entry = (Entry) this.keyIterator.next();
                this.key = entry.getKey();
                this.collection = (Collection) entry.getValue();
                this.valueIterator = this.collection.iterator();
            }
            return output(this.key, this.valueIterator.next());
        }

        public void remove() {
            this.valueIterator.remove();
            if (this.collection.isEmpty()) {
                this.keyIterator.remove();
            }
            AbstractMapBasedMultimap.this.totalSize = AbstractMapBasedMultimap.this.totalSize - 1;
        }
    }

    final class C25481 extends Itr<V> {
        C25481(AbstractMapBasedMultimap abstractMapBasedMultimap) {
            super();
        }

        final V output(K k, V v) {
            return v;
        }
    }

    final class C25492 extends Itr<Entry<K, V>> {
        C25492(AbstractMapBasedMultimap abstractMapBasedMultimap) {
            super();
        }

        final /* synthetic */ Object output(Object obj, Object obj2) {
            return Maps.immutableEntry(obj, obj2);
        }
    }

    class AsMap extends ImprovedAbstractMap<K, Collection<V>> {
        final transient Map<K, Collection<V>> submap;

        final class AsMapEntries extends EntrySet<K, Collection<V>> {
            AsMapEntries() {
            }

            final Map<K, Collection<V>> map() {
                return AsMap.this;
            }

            public final Iterator<Entry<K, Collection<V>>> iterator() {
                return new AsMapIterator();
            }

            public final boolean contains(Object obj) {
                return Collections2.safeContains(AsMap.this.submap.entrySet(), obj);
            }

            public final boolean remove(Object obj) {
                if (!contains(obj)) {
                    return false;
                }
                AbstractMapBasedMultimap.access$400(AbstractMapBasedMultimap.this, ((Entry) obj).getKey());
                return true;
            }
        }

        final class AsMapIterator implements Iterator<Entry<K, Collection<V>>> {
            private Collection<V> collection;
            private Iterator<Entry<K, Collection<V>>> delegateIterator = AsMap.this.submap.entrySet().iterator();

            AsMapIterator() {
            }

            public final boolean hasNext() {
                return this.delegateIterator.hasNext();
            }

            public final void remove() {
                this.delegateIterator.remove();
                AbstractMapBasedMultimap.access$220(AbstractMapBasedMultimap.this, this.collection.size());
                this.collection.clear();
            }

            public final /* synthetic */ Object next() {
                Entry entry = (Entry) this.delegateIterator.next();
                this.collection = (Collection) entry.getValue();
                AsMap asMap = AsMap.this;
                Object key = entry.getKey();
                return Maps.immutableEntry(key, AbstractMapBasedMultimap.this.wrapCollection(key, (Collection) entry.getValue()));
            }
        }

        AsMap(Map<K, Collection<V>> map) {
            this.submap = map;
        }

        protected final Set<Entry<K, Collection<V>>> createEntrySet() {
            return new AsMapEntries();
        }

        public boolean containsKey(Object obj) {
            return Maps.safeContainsKey(this.submap, obj);
        }

        public Set<K> keySet() {
            return AbstractMapBasedMultimap.this.keySet();
        }

        public int size() {
            return this.submap.size();
        }

        public boolean equals(@Nullable Object obj) {
            return this == obj || this.submap.equals(obj);
        }

        public int hashCode() {
            return this.submap.hashCode();
        }

        public String toString() {
            return this.submap.toString();
        }

        public void clear() {
            if (this.submap == AbstractMapBasedMultimap.this.map) {
                AbstractMapBasedMultimap.this.clear();
            } else {
                Iterators.clear(new AsMapIterator());
            }
        }

        public /* synthetic */ Object remove(Object obj) {
            Collection collection = (Collection) this.submap.remove(obj);
            if (collection == null) {
                return null;
            }
            Collection createCollection = AbstractMapBasedMultimap.this.createCollection();
            createCollection.addAll(collection);
            AbstractMapBasedMultimap.access$220(AbstractMapBasedMultimap.this, collection.size());
            collection.clear();
            return createCollection;
        }

        public /* synthetic */ Object get(Object obj) {
            Collection collection = (Collection) Maps.safeGet(this.submap, obj);
            if (collection == null) {
                return null;
            }
            return AbstractMapBasedMultimap.this.wrapCollection(obj, collection);
        }
    }

    class KeySet extends KeySet<K, Collection<V>> {
        KeySet(Map<K, Collection<V>> map) {
            super(map);
        }

        public boolean remove(Object obj) {
            int i;
            Collection collection = (Collection) this.map.remove(obj);
            if (collection != null) {
                int size = collection.size();
                collection.clear();
                AbstractMapBasedMultimap.access$220(AbstractMapBasedMultimap.this, size);
                i = size;
            } else {
                i = 0;
            }
            return i > 0;
        }

        public void clear() {
            Iterators.clear(iterator());
        }

        public boolean equals(@Nullable Object obj) {
            return this == obj || this.map.keySet().equals(obj);
        }

        public Iterator<K> iterator() {
            final Iterator it = this.map.entrySet().iterator();
            return new Iterator<K>() {
                private Entry<K, Collection<V>> entry;

                public final boolean hasNext() {
                    return it.hasNext();
                }

                public final K next() {
                    this.entry = (Entry) it.next();
                    return this.entry.getKey();
                }

                public final void remove() {
                    Joiner.checkRemove(this.entry != null);
                    Collection collection = (Collection) this.entry.getValue();
                    it.remove();
                    AbstractMapBasedMultimap.access$220(AbstractMapBasedMultimap.this, collection.size());
                    collection.clear();
                }
            };
        }

        public boolean containsAll(Collection<?> collection) {
            return this.map.keySet().containsAll(collection);
        }

        public int hashCode() {
            return this.map.keySet().hashCode();
        }
    }

    class WrappedCollection extends AbstractCollection<V> {
        final WrappedCollection ancestor;
        private Collection<V> ancestorDelegate;
        Collection<V> delegate;
        final K key;

        class WrappedIterator implements Iterator<V> {
            final Iterator<V> delegateIterator;
            private Collection<V> originalDelegate = WrappedCollection.this.delegate;

            WrappedIterator() {
                this.delegateIterator = AbstractMapBasedMultimap.access$100(AbstractMapBasedMultimap.this, WrappedCollection.this.delegate);
            }

            WrappedIterator(Iterator<V> it) {
                this.delegateIterator = it;
            }

            final void validateIterator() {
                WrappedCollection.this.refreshIfEmpty();
                if (WrappedCollection.this.delegate != this.originalDelegate) {
                    throw new ConcurrentModificationException();
                }
            }

            public boolean hasNext() {
                validateIterator();
                return this.delegateIterator.hasNext();
            }

            public V next() {
                validateIterator();
                return this.delegateIterator.next();
            }

            public void remove() {
                this.delegateIterator.remove();
                AbstractMapBasedMultimap.this.totalSize = AbstractMapBasedMultimap.this.totalSize - 1;
                WrappedCollection.this.removeIfEmpty();
            }
        }

        WrappedCollection(K k, @Nullable Collection<V> collection, WrappedCollection wrappedCollection) {
            Collection collection2;
            this.key = k;
            this.delegate = collection;
            this.ancestor = wrappedCollection;
            if (wrappedCollection == null) {
                collection2 = null;
            } else {
                collection2 = wrappedCollection.delegate;
            }
            this.ancestorDelegate = collection2;
        }

        final void refreshIfEmpty() {
            if (this.ancestor != null) {
                this.ancestor.refreshIfEmpty();
                if (this.ancestor.delegate != this.ancestorDelegate) {
                    throw new ConcurrentModificationException();
                }
            } else if (this.delegate.isEmpty()) {
                Collection collection = (Collection) AbstractMapBasedMultimap.this.map.get(this.key);
                if (collection != null) {
                    this.delegate = collection;
                }
            }
        }

        final void removeIfEmpty() {
            if (this.ancestor != null) {
                this.ancestor.removeIfEmpty();
            } else if (this.delegate.isEmpty()) {
                AbstractMapBasedMultimap.this.map.remove(this.key);
            }
        }

        final void addToMap() {
            if (this.ancestor != null) {
                this.ancestor.addToMap();
            } else {
                AbstractMapBasedMultimap.this.map.put(this.key, this.delegate);
            }
        }

        public int size() {
            refreshIfEmpty();
            return this.delegate.size();
        }

        public boolean equals(@Nullable Object obj) {
            if (obj == this) {
                return true;
            }
            refreshIfEmpty();
            return this.delegate.equals(obj);
        }

        public int hashCode() {
            refreshIfEmpty();
            return this.delegate.hashCode();
        }

        public String toString() {
            refreshIfEmpty();
            return this.delegate.toString();
        }

        public Iterator<V> iterator() {
            refreshIfEmpty();
            return new WrappedIterator();
        }

        public boolean add(V v) {
            refreshIfEmpty();
            boolean isEmpty = this.delegate.isEmpty();
            boolean add = this.delegate.add(v);
            if (add) {
                AbstractMapBasedMultimap.this.totalSize = AbstractMapBasedMultimap.this.totalSize + 1;
                if (isEmpty) {
                    addToMap();
                }
            }
            return add;
        }

        public boolean addAll(Collection<? extends V> collection) {
            if (collection.isEmpty()) {
                return false;
            }
            int size = size();
            boolean addAll = this.delegate.addAll(collection);
            if (!addAll) {
                return addAll;
            }
            AbstractMapBasedMultimap.access$212(AbstractMapBasedMultimap.this, this.delegate.size() - size);
            if (size != 0) {
                return addAll;
            }
            addToMap();
            return addAll;
        }

        public boolean contains(Object obj) {
            refreshIfEmpty();
            return this.delegate.contains(obj);
        }

        public boolean containsAll(Collection<?> collection) {
            refreshIfEmpty();
            return this.delegate.containsAll(collection);
        }

        public void clear() {
            int size = size();
            if (size != 0) {
                this.delegate.clear();
                AbstractMapBasedMultimap.access$220(AbstractMapBasedMultimap.this, size);
                removeIfEmpty();
            }
        }

        public boolean remove(Object obj) {
            refreshIfEmpty();
            boolean remove = this.delegate.remove(obj);
            if (remove) {
                AbstractMapBasedMultimap.this.totalSize = AbstractMapBasedMultimap.this.totalSize - 1;
                removeIfEmpty();
            }
            return remove;
        }

        public boolean removeAll(Collection<?> collection) {
            if (collection.isEmpty()) {
                return false;
            }
            int size = size();
            boolean removeAll = this.delegate.removeAll(collection);
            if (!removeAll) {
                return removeAll;
            }
            AbstractMapBasedMultimap.access$212(AbstractMapBasedMultimap.this, this.delegate.size() - size);
            removeIfEmpty();
            return removeAll;
        }

        public boolean retainAll(Collection<?> collection) {
            Joiner.checkNotNull(collection);
            int size = size();
            boolean retainAll = this.delegate.retainAll(collection);
            if (retainAll) {
                AbstractMapBasedMultimap.access$212(AbstractMapBasedMultimap.this, this.delegate.size() - size);
                removeIfEmpty();
            }
            return retainAll;
        }
    }

    class WrappedList extends WrappedCollection implements List<V> {

        final class WrappedListIterator extends WrappedIterator implements ListIterator<V> {
            WrappedListIterator() {
                super();
            }

            public WrappedListIterator(int i) {
                super(WrappedList.this.getListDelegate().listIterator(i));
            }

            public final boolean hasPrevious() {
                return getDelegateListIterator().hasPrevious();
            }

            public final V previous() {
                return getDelegateListIterator().previous();
            }

            public final int nextIndex() {
                return getDelegateListIterator().nextIndex();
            }

            public final int previousIndex() {
                return getDelegateListIterator().previousIndex();
            }

            public final void set(V v) {
                getDelegateListIterator().set(v);
            }

            public final void add(V v) {
                boolean isEmpty = WrappedList.this.isEmpty();
                getDelegateListIterator().add(v);
                AbstractMapBasedMultimap.this.totalSize = AbstractMapBasedMultimap.this.totalSize + 1;
                if (isEmpty) {
                    WrappedList.this.addToMap();
                }
            }

            private ListIterator<V> getDelegateListIterator() {
                validateIterator();
                return (ListIterator) this.delegateIterator;
            }
        }

        WrappedList(K k, @Nullable List<V> list, WrappedCollection wrappedCollection) {
            super(k, list, wrappedCollection);
        }

        public boolean addAll(int i, Collection<? extends V> collection) {
            if (collection.isEmpty()) {
                return false;
            }
            int size = size();
            boolean addAll = getListDelegate().addAll(i, collection);
            if (!addAll) {
                return addAll;
            }
            AbstractMapBasedMultimap.access$212(AbstractMapBasedMultimap.this, this.delegate.size() - size);
            if (size != 0) {
                return addAll;
            }
            addToMap();
            return addAll;
        }

        public V get(int i) {
            refreshIfEmpty();
            return getListDelegate().get(i);
        }

        public V set(int i, V v) {
            refreshIfEmpty();
            return getListDelegate().set(i, v);
        }

        public void add(int i, V v) {
            refreshIfEmpty();
            boolean isEmpty = this.delegate.isEmpty();
            getListDelegate().add(i, v);
            AbstractMapBasedMultimap.this.totalSize = AbstractMapBasedMultimap.this.totalSize + 1;
            if (isEmpty) {
                addToMap();
            }
        }

        public V remove(int i) {
            refreshIfEmpty();
            V remove = getListDelegate().remove(i);
            AbstractMapBasedMultimap.this.totalSize = AbstractMapBasedMultimap.this.totalSize - 1;
            removeIfEmpty();
            return remove;
        }

        public int indexOf(Object obj) {
            refreshIfEmpty();
            return getListDelegate().indexOf(obj);
        }

        public int lastIndexOf(Object obj) {
            refreshIfEmpty();
            return getListDelegate().lastIndexOf(obj);
        }

        public ListIterator<V> listIterator() {
            refreshIfEmpty();
            return new WrappedListIterator();
        }

        public ListIterator<V> listIterator(int i) {
            refreshIfEmpty();
            return new WrappedListIterator(i);
        }

        public List<V> subList(int i, int i2) {
            WrappedCollection wrappedCollection;
            refreshIfEmpty();
            AbstractMapBasedMultimap abstractMapBasedMultimap = AbstractMapBasedMultimap.this;
            Object obj = this.key;
            List subList = getListDelegate().subList(i, i2);
            if (this.ancestor != null) {
                wrappedCollection = this.ancestor;
            }
            return abstractMapBasedMultimap.wrapList(obj, subList, wrappedCollection);
        }

        final List<V> getListDelegate() {
            return (List) this.delegate;
        }
    }

    final class RandomAccessWrappedList extends WrappedList implements RandomAccess {
        RandomAccessWrappedList(AbstractMapBasedMultimap abstractMapBasedMultimap, @Nullable K k, List<V> list, @Nullable WrappedCollection wrappedCollection) {
            super(k, list, wrappedCollection);
        }
    }

    final class SortedAsMap extends AsMap implements SortedMap<K, Collection<V>> {
        private SortedSet<K> sortedKeySet;

        SortedAsMap(SortedMap<K, Collection<V>> sortedMap) {
            super(sortedMap);
        }

        public final SortedMap<K, Collection<V>> headMap(K k) {
            return new SortedAsMap(((SortedMap) this.submap).headMap(k));
        }

        public final SortedMap<K, Collection<V>> subMap(K k, K k2) {
            return new SortedAsMap(((SortedMap) this.submap).subMap(k, k2));
        }

        public final SortedMap<K, Collection<V>> tailMap(K k) {
            return new SortedAsMap(((SortedMap) this.submap).tailMap(k));
        }

        private SortedSet<K> createKeySet() {
            return new SortedKeySet((SortedMap) this.submap);
        }

        public final Comparator<? super K> comparator() {
            return ((SortedMap) this.submap).comparator();
        }

        public final K firstKey() {
            return ((SortedMap) this.submap).firstKey();
        }

        public final K lastKey() {
            return ((SortedMap) this.submap).lastKey();
        }

        public final /* synthetic */ Set keySet() {
            Set set = this.sortedKeySet;
            if (set != null) {
                return set;
            }
            set = createKeySet();
            this.sortedKeySet = set;
            return set;
        }
    }

    final class SortedKeySet extends KeySet implements SortedSet<K> {
        SortedKeySet(SortedMap<K, Collection<V>> sortedMap) {
            super(sortedMap);
        }

        public final Comparator<? super K> comparator() {
            return sortedMap().comparator();
        }

        public final K first() {
            return sortedMap().firstKey();
        }

        public final SortedSet<K> headSet(K k) {
            return new SortedKeySet(sortedMap().headMap(k));
        }

        public final K last() {
            return sortedMap().lastKey();
        }

        public final SortedSet<K> subSet(K k, K k2) {
            return new SortedKeySet(sortedMap().subMap(k, k2));
        }

        public final SortedSet<K> tailSet(K k) {
            return new SortedKeySet(sortedMap().tailMap(k));
        }

        private SortedMap<K, Collection<V>> sortedMap() {
            return (SortedMap) this.map;
        }
    }

    final class WrappedSet extends WrappedCollection implements Set<V> {
        WrappedSet(K k, @Nullable Set<V> set) {
            super(k, set, null);
        }

        public final boolean removeAll(Collection<?> collection) {
            if (collection.isEmpty()) {
                return false;
            }
            int size = size();
            boolean removeAllImpl = Joiner.removeAllImpl((Set) this.delegate, (Collection) collection);
            if (!removeAllImpl) {
                return removeAllImpl;
            }
            AbstractMapBasedMultimap.access$212(AbstractMapBasedMultimap.this, this.delegate.size() - size);
            removeIfEmpty();
            return removeAllImpl;
        }
    }

    final class WrappedSortedSet extends WrappedCollection implements SortedSet<V> {
        WrappedSortedSet(K k, @Nullable SortedSet<V> sortedSet, WrappedCollection wrappedCollection) {
            super(k, sortedSet, wrappedCollection);
        }

        public final Comparator<? super V> comparator() {
            return getSortedSetDelegate().comparator();
        }

        public final V first() {
            refreshIfEmpty();
            return getSortedSetDelegate().first();
        }

        public final V last() {
            refreshIfEmpty();
            return getSortedSetDelegate().last();
        }

        public final SortedSet<V> headSet(V v) {
            WrappedCollection wrappedCollection;
            refreshIfEmpty();
            AbstractMapBasedMultimap abstractMapBasedMultimap = AbstractMapBasedMultimap.this;
            Object obj = this.key;
            SortedSet headSet = getSortedSetDelegate().headSet(v);
            if (this.ancestor != null) {
                wrappedCollection = this.ancestor;
            }
            return new WrappedSortedSet(obj, headSet, wrappedCollection);
        }

        public final SortedSet<V> subSet(V v, V v2) {
            WrappedCollection wrappedCollection;
            refreshIfEmpty();
            AbstractMapBasedMultimap abstractMapBasedMultimap = AbstractMapBasedMultimap.this;
            Object obj = this.key;
            SortedSet subSet = getSortedSetDelegate().subSet(v, v2);
            if (this.ancestor != null) {
                wrappedCollection = this.ancestor;
            }
            return new WrappedSortedSet(obj, subSet, wrappedCollection);
        }

        public final SortedSet<V> tailSet(V v) {
            WrappedCollection wrappedCollection;
            refreshIfEmpty();
            AbstractMapBasedMultimap abstractMapBasedMultimap = AbstractMapBasedMultimap.this;
            Object obj = this.key;
            SortedSet tailSet = getSortedSetDelegate().tailSet(v);
            if (this.ancestor != null) {
                wrappedCollection = this.ancestor;
            }
            return new WrappedSortedSet(obj, tailSet, wrappedCollection);
        }

        private SortedSet<V> getSortedSetDelegate() {
            return (SortedSet) this.delegate;
        }
    }

    abstract Collection<V> createCollection();

    static /* synthetic */ int access$212(AbstractMapBasedMultimap abstractMapBasedMultimap, int i) {
        int i2 = abstractMapBasedMultimap.totalSize + i;
        abstractMapBasedMultimap.totalSize = i2;
        return i2;
    }

    static /* synthetic */ int access$220(AbstractMapBasedMultimap abstractMapBasedMultimap, int i) {
        int i2 = abstractMapBasedMultimap.totalSize - i;
        abstractMapBasedMultimap.totalSize = i2;
        return i2;
    }

    protected AbstractMapBasedMultimap(Map<K, Collection<V>> map) {
        Joiner.checkArgument(map.isEmpty());
        this.map = map;
    }

    public int size() {
        return this.totalSize;
    }

    public boolean put(@Nullable K k, @Nullable V v) {
        Collection collection = (Collection) this.map.get(k);
        if (collection == null) {
            collection = createCollection();
            if (collection.add(v)) {
                this.totalSize++;
                this.map.put(k, collection);
                return true;
            }
            throw new AssertionError("New Collection violated the Collection spec");
        } else if (!collection.add(v)) {
            return false;
        } else {
            this.totalSize++;
            return true;
        }
    }

    public void clear() {
        for (Collection clear : this.map.values()) {
            clear.clear();
        }
        this.map.clear();
        this.totalSize = 0;
    }

    public Collection<V> get(@Nullable K k) {
        Collection collection = (Collection) this.map.get(k);
        if (collection == null) {
            collection = createCollection();
        }
        return wrapCollection(k, collection);
    }

    final Collection<V> wrapCollection(@Nullable K k, Collection<V> collection) {
        if (collection instanceof SortedSet) {
            return new WrappedSortedSet(k, (SortedSet) collection, null);
        }
        if (collection instanceof Set) {
            return new WrappedSet(k, (Set) collection);
        }
        if (collection instanceof List) {
            return wrapList(k, (List) collection, null);
        }
        return new WrappedCollection(k, collection, null);
    }

    private List<V> wrapList(@Nullable K k, List<V> list, @Nullable WrappedCollection wrappedCollection) {
        return list instanceof RandomAccess ? new RandomAccessWrappedList(this, k, list, wrappedCollection) : new WrappedList(k, list, wrappedCollection);
    }

    final Set<K> createKeySet() {
        return this.map instanceof SortedMap ? new SortedKeySet((SortedMap) this.map) : new KeySet(this.map);
    }

    public Collection<V> values() {
        return super.values();
    }

    final Iterator<V> valueIterator() {
        return new C25481(this);
    }

    public Collection<Entry<K, V>> entries() {
        return super.entries();
    }

    final Iterator<Entry<K, V>> entryIterator() {
        return new C25492(this);
    }

    final Map<K, Collection<V>> createAsMap() {
        return this.map instanceof SortedMap ? new SortedAsMap((SortedMap) this.map) : new AsMap(this.map);
    }

    static /* synthetic */ Iterator access$100(AbstractMapBasedMultimap abstractMapBasedMultimap, Collection collection) {
        return collection instanceof List ? ((List) collection).listIterator() : collection.iterator();
    }

    static /* synthetic */ int access$400(AbstractMapBasedMultimap abstractMapBasedMultimap, Object obj) {
        Collection collection = (Collection) Maps.safeRemove(abstractMapBasedMultimap.map, obj);
        int i = 0;
        if (collection != null) {
            i = collection.size();
            collection.clear();
            abstractMapBasedMultimap.totalSize -= i;
        }
        return i;
    }
}
