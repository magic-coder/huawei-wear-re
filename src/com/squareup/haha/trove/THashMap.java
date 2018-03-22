package com.squareup.haha.trove;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class THashMap<K, V> extends TObjectHash<K> implements Map<K, V> {
    protected transient V[] _values;

    final class Entry implements java.util.Map.Entry<K, V> {
        private final int index;
        private final K key;
        private V val;

        Entry(K k, V v, int i) {
            this.key = k;
            this.val = v;
            this.index = i;
        }

        public final K getKey() {
            return this.key;
        }

        public final V getValue() {
            return this.val;
        }

        public final V setValue(V v) {
            if (THashMap.this._values[this.index] != this.val) {
                throw new ConcurrentModificationException();
            }
            THashMap.this._values[this.index] = v;
            V v2 = this.val;
            this.val = v;
            return v2;
        }
    }

    abstract class MapBackedView<E> implements Set<E> {
        public abstract boolean containsElement(E e);

        public abstract Iterator<E> iterator();

        public abstract boolean removeElement(E e);

        MapBackedView() {
        }

        public boolean contains(Object obj) {
            return containsElement(obj);
        }

        public boolean remove(Object obj) {
            return removeElement(obj);
        }

        public boolean containsAll(Collection<?> collection) {
            for (Object contains : collection) {
                if (!contains(contains)) {
                    return false;
                }
            }
            return true;
        }

        public boolean removeAll(Collection<?> collection) {
            boolean z = false;
            for (Object remove : collection) {
                if (remove(remove)) {
                    z = true;
                }
            }
            return z;
        }

        public void clear() {
            THashMap.this.clear();
        }

        public boolean add(E e) {
            throw new UnsupportedOperationException();
        }

        public int size() {
            return THashMap.this.size();
        }

        public Object[] toArray() {
            Object[] objArr = new Object[size()];
            Iterator it = iterator();
            int i = 0;
            while (it.hasNext()) {
                objArr[i] = it.next();
                i++;
            }
            return objArr;
        }

        public <T> T[] toArray(T[] tArr) {
            T[] tArr2;
            int size = size();
            if (tArr.length < size) {
                tArr2 = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), size);
            } else {
                tArr2 = tArr;
            }
            Iterator it = iterator();
            for (int i = 0; i < size; i++) {
                tArr2[i] = it.next();
            }
            if (tArr2.length > size) {
                tArr2[size] = null;
            }
            return tArr2;
        }

        public boolean isEmpty() {
            return THashMap.this.isEmpty();
        }

        public boolean addAll(Collection<? extends E> collection) {
            throw new UnsupportedOperationException();
        }

        public boolean retainAll(Collection<?> collection) {
            boolean z = false;
            Iterator it = iterator();
            while (it.hasNext()) {
                if (!collection.contains(it.next())) {
                    it.remove();
                    z = true;
                }
            }
            return z;
        }
    }

    public final class EntryView extends MapBackedView<java.util.Map.Entry<K, V>> {

        final class EntryIterator extends THashIterator<java.util.Map.Entry<K, V>> {
            EntryIterator(THashMap<K, V> tHashMap) {
                super(tHashMap);
            }

            public final /* synthetic */ Object objectAtIndex(int i) {
                return new Entry(THashMap.this._set[i], THashMap.this._values[i], i);
            }
        }

        public final /* synthetic */ boolean containsElement(Object obj) {
            java.util.Map.Entry entry = (java.util.Map.Entry) obj;
            Object obj2 = THashMap.this.get(entry.getKey());
            Object value = entry.getValue();
            return value == obj2 || (obj2 != null && obj2.equals(value));
        }

        public final /* synthetic */ boolean removeElement(Object obj) {
            java.util.Map.Entry entry = (java.util.Map.Entry) obj;
            int index = THashMap.this.index(entry.getKey());
            if (index >= 0) {
                Object value = entry.getValue();
                if (value == THashMap.this._values[index] || (value != null && value.equals(THashMap.this._values[index]))) {
                    THashMap.this.removeAt(index);
                    return true;
                }
            }
            return false;
        }

        EntryView() {
            super();
        }

        public final Iterator<java.util.Map.Entry<K, V>> iterator() {
            return new EntryIterator(THashMap.this);
        }
    }

    final class EqProcedure<K, V> implements TObjectObjectProcedure<K, V> {
        private final Map<K, V> _otherMap;

        EqProcedure(Map<K, V> map) {
            this._otherMap = map;
        }

        public final boolean execute(K k, V v) {
            V v2 = this._otherMap.get(k);
            return v2 == v || (v2 != null && v2.equals(v));
        }
    }

    final class HashProcedure implements TObjectObjectProcedure<K, V> {
        int f9078h;

        HashProcedure() {
        }

        public final boolean execute(K k, V v) {
            this.f9078h = ((v == null ? 0 : v.hashCode()) ^ THashMap.this._hashingStrategy.computeHashCode(k)) + this.f9078h;
            return true;
        }
    }

    public final class KeyView extends MapBackedView<K> {
        KeyView() {
            super();
        }

        public final Iterator<K> iterator() {
            return new TObjectHashIterator(THashMap.this);
        }

        public final boolean removeElement(K k) {
            return THashMap.this.remove(k) != null;
        }

        public final boolean containsElement(K k) {
            return THashMap.this.contains(k);
        }
    }

    public final class ValueView extends MapBackedView<V> {
        protected ValueView() {
            super();
        }

        public final Iterator<V> iterator() {
            return new THashIterator<V>(THashMap.this) {
                protected final V objectAtIndex(int i) {
                    return THashMap.this._values[i];
                }
            };
        }

        public final boolean containsElement(V v) {
            return THashMap.this.containsValue(v);
        }

        public final boolean removeElement(V v) {
            Object[] objArr = THashMap.this._values;
            Object[] objArr2 = THashMap.this._set;
            int length = objArr.length;
            boolean z = false;
            while (true) {
                int i = length - 1;
                if (length <= 0) {
                    return z;
                }
                if ((objArr2[i] == null || objArr2[i] == TObjectHash.REMOVED || v != objArr[i]) && (objArr[i] == null || !objArr[i].equals(v))) {
                    length = i;
                } else {
                    THashMap.this.removeAt(i);
                    z = true;
                    length = i;
                }
            }
        }
    }

    public THashMap(TObjectHashingStrategy<K> tObjectHashingStrategy) {
        super((TObjectHashingStrategy) tObjectHashingStrategy);
    }

    public THashMap(int i) {
        super(i);
    }

    public THashMap(int i, TObjectHashingStrategy<K> tObjectHashingStrategy) {
        super(i, (TObjectHashingStrategy) tObjectHashingStrategy);
    }

    public THashMap(int i, float f) {
        super(i, f);
    }

    public THashMap(int i, float f, TObjectHashingStrategy<K> tObjectHashingStrategy) {
        super(i, f, tObjectHashingStrategy);
    }

    public THashMap(Map<K, V> map) {
        this(map.size());
        putAll(map);
    }

    public THashMap(Map<K, V> map, TObjectHashingStrategy<K> tObjectHashingStrategy) {
        this(map.size(), (TObjectHashingStrategy) tObjectHashingStrategy);
        putAll(map);
    }

    public THashMap<K, V> clone() {
        THashMap<K, V> tHashMap = (THashMap) super.clone();
        tHashMap._values = (Object[]) this._values.clone();
        return tHashMap;
    }

    protected int setUp(int i) {
        int up = super.setUp(i);
        this._values = new Object[up];
        return up;
    }

    public V put(K k, V v) {
        if (k == null) {
            throw new NullPointerException("null keys not supported");
        }
        V v2 = null;
        int insertionIndex = insertionIndex(k);
        Object obj = insertionIndex < 0 ? 1 : null;
        if (obj != null) {
            insertionIndex = (-insertionIndex) - 1;
            v2 = this._values[insertionIndex];
        }
        Object obj2 = this._set[insertionIndex];
        this._set[insertionIndex] = k;
        this._values[insertionIndex] = v;
        if (obj == null) {
            boolean z;
            if (obj2 == null) {
                z = true;
            } else {
                z = false;
            }
            postInsertHook(z);
        }
        return v2;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Map)) {
            return false;
        }
        Map map = (Map) obj;
        if (map.size() == size()) {
            return forEachEntry(new EqProcedure(map));
        }
        return false;
    }

    public int hashCode() {
        Object hashProcedure = new HashProcedure();
        forEachEntry(hashProcedure);
        return hashProcedure.f9078h;
    }

    public boolean forEachKey(TObjectProcedure<K> tObjectProcedure) {
        return forEach(tObjectProcedure);
    }

    public boolean forEachValue(TObjectProcedure<V> tObjectProcedure) {
        Object[] objArr = this._values;
        Object[] objArr2 = this._set;
        int length = objArr.length;
        while (true) {
            int i = length - 1;
            if (length <= 0) {
                return true;
            }
            if (objArr2[i] != null && objArr2[i] != REMOVED && !tObjectProcedure.execute(objArr[i])) {
                return false;
            }
            length = i;
        }
    }

    public boolean forEachEntry(TObjectObjectProcedure<K, V> tObjectObjectProcedure) {
        Object[] objArr = this._set;
        Object[] objArr2 = this._values;
        int length = objArr.length;
        while (true) {
            int i = length - 1;
            if (length <= 0) {
                return true;
            }
            if (objArr[i] != null && objArr[i] != REMOVED && !tObjectObjectProcedure.execute(objArr[i], objArr2[i])) {
                return false;
            }
            length = i;
        }
    }

    public boolean retainEntries(TObjectObjectProcedure<K, V> tObjectObjectProcedure) {
        Object[] objArr = this._set;
        Object[] objArr2 = this._values;
        stopCompactingOnRemove();
        boolean z = false;
        try {
            int length = objArr.length;
            while (true) {
                int i = length - 1;
                if (length <= 0) {
                    break;
                } else if (objArr[i] == null || objArr[i] == REMOVED || tObjectObjectProcedure.execute(objArr[i], objArr2[i])) {
                    length = i;
                } else {
                    removeAt(i);
                    z = true;
                    length = i;
                }
            }
            return z;
        } finally {
            startCompactingOnRemove(z);
        }
    }

    public void transformValues(TObjectFunction<V, V> tObjectFunction) {
        Object[] objArr = this._values;
        Object[] objArr2 = this._set;
        int length = objArr.length;
        while (true) {
            int i = length - 1;
            if (length <= 0) {
                return;
            }
            if (objArr2[i] == null || objArr2[i] == REMOVED) {
                length = i;
            } else {
                objArr[i] = tObjectFunction.execute$7713a341();
                length = i;
            }
        }
    }

    protected void rehash(int i) {
        int length = this._set.length;
        Object[] objArr = this._set;
        Object[] objArr2 = this._values;
        this._set = new Object[i];
        this._values = new Object[i];
        int i2 = length;
        while (true) {
            length = i2 - 1;
            if (i2 <= 0) {
                return;
            }
            if (objArr[length] == null || objArr[length] == REMOVED) {
                i2 = length;
            } else {
                Object obj = objArr[length];
                int insertionIndex = insertionIndex(obj);
                if (insertionIndex < 0) {
                    throwObjectContractViolation(this._set[(-insertionIndex) - 1], obj);
                }
                this._set[insertionIndex] = obj;
                this._values[insertionIndex] = objArr2[length];
                i2 = length;
            }
        }
    }

    public V get(Object obj) {
        int index = index(obj);
        return index < 0 ? null : this._values[index];
    }

    public void clear() {
        if (size() != 0) {
            super.clear();
            Object[] objArr = this._set;
            Object[] objArr2 = this._values;
            int length = objArr.length;
            while (true) {
                int i = length - 1;
                if (length > 0) {
                    objArr[i] = null;
                    objArr2[i] = null;
                    length = i;
                } else {
                    return;
                }
            }
        }
    }

    public V remove(Object obj) {
        int index = index(obj);
        if (index < 0) {
            return null;
        }
        V v = this._values[index];
        removeAt(index);
        return v;
    }

    protected void removeAt(int i) {
        this._values[i] = null;
        super.removeAt(i);
    }

    public Collection<V> values() {
        return new ValueView();
    }

    public Set<K> keySet() {
        return new KeyView();
    }

    public Set<java.util.Map.Entry<K, V>> entrySet() {
        return new EntryView();
    }

    public boolean containsValue(Object obj) {
        Object[] objArr = this._set;
        Object[] objArr2 = this._values;
        int length;
        int i;
        if (obj != null) {
            length = objArr2.length;
            while (true) {
                i = length - 1;
                if (length <= 0) {
                    break;
                } else if (objArr[i] != null && objArr[i] != REMOVED && (obj == objArr2[i] || obj.equals(objArr2[i]))) {
                    return true;
                } else {
                    length = i;
                }
            }
        } else {
            length = objArr2.length;
            while (true) {
                i = length - 1;
                if (length <= 0) {
                    break;
                } else if (objArr[i] != null && objArr[i] != REMOVED && obj == objArr2[i]) {
                    return true;
                } else {
                    length = i;
                }
            }
        }
        return false;
    }

    public boolean containsKey(Object obj) {
        return contains(obj);
    }

    public void putAll(Map<? extends K, ? extends V> map) {
        ensureCapacity(map.size());
        for (java.util.Map.Entry entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(this._size);
        Object serializationProcedure = new SerializationProcedure(objectOutputStream);
        if (!forEachEntry(serializationProcedure)) {
            throw serializationProcedure.exception;
        }
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        int readInt = objectInputStream.readInt();
        setUp(readInt);
        while (true) {
            int i = readInt - 1;
            if (readInt > 0) {
                put(objectInputStream.readObject(), objectInputStream.readObject());
                readInt = i;
            } else {
                return;
            }
        }
    }
}
