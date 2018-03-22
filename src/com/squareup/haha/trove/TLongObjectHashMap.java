package com.squareup.haha.trove;

import com.squareup.haha.guava.base.Joiner;

public class TLongObjectHashMap<V> extends THash implements TLongHashingStrategy {
    protected final TLongHashingStrategy _hashingStrategy = this;
    private transient long[] _set;
    private transient V[] _values;

    final class EqProcedure<V> implements TLongObjectProcedure<V> {
        private final TLongObjectHashMap<V> _otherMap;

        EqProcedure(TLongObjectHashMap<V> tLongObjectHashMap) {
            this._otherMap = tLongObjectHashMap;
        }

        public final boolean execute(long j, V v) {
            if (this._otherMap.index(j) >= 0) {
                boolean z;
                V v2 = this._otherMap.get(j);
                if (v == v2 || (v != null && v.equals(v2))) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    return true;
                }
            }
            return false;
        }
    }

    final class HashProcedure implements TLongObjectProcedure<V> {
        int f9082h;

        HashProcedure() {
        }

        public final boolean execute(long j, V v) {
            this.f9082h += TLongObjectHashMap.this._hashingStrategy.computeHashCode(j) ^ Joiner.hash(v);
            return true;
        }
    }

    protected int setUp(int i) {
        int up = super.setUp(i);
        this._values = new Object[up];
        this._set = new long[up];
        return up;
    }

    protected int capacity() {
        return this._values.length;
    }

    public final V put(long j, V v) {
        int i;
        V unwrapNull;
        boolean z;
        Object obj = null;
        int insertionIndex = insertionIndex(j);
        if (insertionIndex < 0) {
            i = (-insertionIndex) - 1;
            unwrapNull = unwrapNull(this._values[i]);
            z = false;
        } else {
            boolean isFree = isFree(this._values, insertionIndex);
            i = insertionIndex;
            unwrapNull = null;
            z = isFree;
            int i2 = 1;
        }
        this._set[i] = j;
        Object[] objArr = this._values;
        if (v == null) {
            v = TObjectHash.NULL;
        }
        objArr[i] = v;
        if (obj != null) {
            postInsertHook(z);
        }
        return unwrapNull;
    }

    protected void rehash(int i) {
        int length = this._set.length;
        long[] jArr = this._set;
        Object[] objArr = this._values;
        this._set = new long[i];
        this._values = new Object[i];
        int i2 = length;
        while (true) {
            length = i2 - 1;
            if (i2 <= 0) {
                return;
            }
            if (isFull(objArr, length)) {
                long j = jArr[length];
                i2 = insertionIndex(j);
                this._set[i2] = j;
                this._values[i2] = objArr[length];
                i2 = length;
            } else {
                i2 = length;
            }
        }
    }

    public final V get(long j) {
        int index = index(j);
        return index < 0 ? null : unwrapNull(this._values[index]);
    }

    private static <V> V unwrapNull(V v) {
        return v == TObjectHash.NULL ? null : v;
    }

    public void clear() {
        super.clear();
        long[] jArr = this._set;
        Object[] objArr = this._values;
        int length = jArr.length;
        while (true) {
            int i = length - 1;
            if (length > 0) {
                jArr[i] = 0;
                objArr[i] = null;
                length = i;
            } else {
                return;
            }
        }
    }

    protected final int index(long j) {
        long[] jArr = this._set;
        Object[] objArr = this._values;
        int length = jArr.length;
        int computeHashCode = Integer.MAX_VALUE & this._hashingStrategy.computeHashCode(j);
        int i = computeHashCode % length;
        if (!isFree(objArr, i) && (isRemoved(objArr, i) || jArr[i] != j)) {
            computeHashCode = (computeHashCode % (length - 2)) + 1;
            while (true) {
                i -= computeHashCode;
                if (i < 0) {
                    i += length;
                }
                if (isFree(objArr, i) || (!isRemoved(objArr, i) && jArr[i] == j)) {
                    break;
                }
            }
        }
        return isFree(objArr, i) ? -1 : i;
    }

    private int insertionIndex(long j) {
        Object[] objArr = this._values;
        long[] jArr = this._set;
        int length = jArr.length;
        int computeHashCode = this._hashingStrategy.computeHashCode(j) & Integer.MAX_VALUE;
        int i = computeHashCode % length;
        if (isFree(objArr, i)) {
            return i;
        }
        if (isFull(objArr, i) && jArr[i] == j) {
            return (-i) - 1;
        }
        int i2 = (computeHashCode % (length - 2)) + 1;
        computeHashCode = isRemoved(objArr, i) ? i : -1;
        do {
            i -= i2;
            if (i < 0) {
                i += length;
            }
            if (computeHashCode == -1 && isRemoved(objArr, i)) {
                computeHashCode = i;
            }
            if (!isFull(objArr, i)) {
                break;
            }
        } while (jArr[i] != j);
        if (isRemoved(objArr, i)) {
            while (!isFree(objArr, i) && (isRemoved(objArr, i) || jArr[i] != j)) {
                i -= i2;
                if (i < 0) {
                    i += length;
                }
            }
        }
        if (isFull(objArr, i)) {
            return (-i) - 1;
        }
        return computeHashCode != -1 ? computeHashCode : i;
    }

    private static boolean isFull(Object[] objArr, int i) {
        Object obj = objArr[i];
        return (obj == null || obj == TObjectHash.REMOVED) ? false : true;
    }

    private static boolean isRemoved(Object[] objArr, int i) {
        return objArr[i] == TObjectHash.REMOVED;
    }

    private static boolean isFree(Object[] objArr, int i) {
        return objArr[i] == null;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof TLongObjectHashMap)) {
            return false;
        }
        TLongObjectHashMap tLongObjectHashMap = (TLongObjectHashMap) obj;
        if (tLongObjectHashMap.size() == size()) {
            return forEachEntry(new EqProcedure(tLongObjectHashMap));
        }
        return false;
    }

    public int hashCode() {
        Object hashProcedure = new HashProcedure();
        forEachEntry(hashProcedure);
        return hashProcedure.f9082h;
    }

    protected void removeAt(int i) {
        this._values[i] = TObjectHash.REMOVED;
        super.removeAt(i);
    }

    public final Object[] getValues() {
        Object[] objArr = new Object[size()];
        Object[] objArr2 = this._values;
        int length = objArr2.length;
        int i = 0;
        while (true) {
            int i2 = length - 1;
            if (length <= 0) {
                return objArr;
            }
            if (isFull(objArr2, i2)) {
                length = i + 1;
                objArr[i] = unwrapNull(objArr2[i2]);
                i = length;
                length = i2;
            } else {
                length = i2;
            }
        }
    }

    public final boolean forEachValue(TObjectProcedure<V> tObjectProcedure) {
        Object[] objArr = this._values;
        int length = objArr.length;
        while (true) {
            int i = length - 1;
            if (length <= 0) {
                return true;
            }
            if (isFull(objArr, i) && !tObjectProcedure.execute(unwrapNull(objArr[i]))) {
                return false;
            }
            length = i;
        }
    }

    private boolean forEachEntry(TLongObjectProcedure<V> tLongObjectProcedure) {
        long[] jArr = this._set;
        Object[] objArr = this._values;
        int length = jArr.length;
        while (true) {
            int i = length - 1;
            if (length <= 0) {
                return true;
            }
            if (isFull(objArr, i) && !tLongObjectProcedure.execute(jArr[i], unwrapNull(objArr[i]))) {
                return false;
            }
            length = i;
        }
    }

    public final int computeHashCode(long j) {
        return (int) ((j >> 32) ^ j);
    }

    public /* bridge */ /* synthetic */ Object clone() {
        TLongObjectHashMap tLongObjectHashMap = (TLongObjectHashMap) super.clone();
        tLongObjectHashMap._values = (Object[]) this._values.clone();
        return tLongObjectHashMap;
    }
}
