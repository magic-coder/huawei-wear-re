package com.squareup.haha.trove;

import com.squareup.haha.guava.base.Joiner;

public class TIntObjectHashMap<V> extends THash implements TIntHashingStrategy {
    protected final TIntHashingStrategy _hashingStrategy = this;
    private transient int[] _set;
    private transient V[] _values;

    final class EqProcedure<V> implements TIntObjectProcedure<V> {
        private final TIntObjectHashMap<V> _otherMap;

        EqProcedure(TIntObjectHashMap<V> tIntObjectHashMap) {
            this._otherMap = tIntObjectHashMap;
        }

        public final boolean execute(int i, V v) {
            if (this._otherMap.index(i) >= 0) {
                boolean z;
                V v2 = this._otherMap.get(i);
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

    final class HashProcedure implements TIntObjectProcedure<V> {
        int f9080h;

        HashProcedure() {
        }

        public final boolean execute(int i, V v) {
            this.f9080h += TIntObjectHashMap.this._hashingStrategy.computeHashCode(i) ^ Joiner.hash(v);
            return true;
        }
    }

    protected int setUp(int i) {
        int up = super.setUp(i);
        this._values = new Object[up];
        this._set = new int[up];
        return up;
    }

    protected int capacity() {
        return this._values.length;
    }

    public final V put(int i, V v) {
        int i2;
        V unwrapNull;
        boolean z;
        Object obj = null;
        int insertionIndex = insertionIndex(i);
        if (insertionIndex < 0) {
            i2 = (-insertionIndex) - 1;
            unwrapNull = unwrapNull(this._values[i2]);
            z = false;
        } else {
            boolean isFree = isFree(this._values, insertionIndex);
            i2 = insertionIndex;
            unwrapNull = null;
            z = isFree;
            int i3 = 1;
        }
        this._set[i2] = i;
        Object[] objArr = this._values;
        if (v == null) {
            v = TObjectHash.NULL;
        }
        objArr[i2] = v;
        if (obj != null) {
            postInsertHook(z);
        }
        return unwrapNull;
    }

    protected void rehash(int i) {
        int length = this._set.length;
        int[] iArr = this._set;
        Object[] objArr = this._values;
        this._set = new int[i];
        this._values = new Object[i];
        int i2 = length;
        while (true) {
            length = i2 - 1;
            if (i2 <= 0) {
                return;
            }
            if (isFull(objArr, length)) {
                i2 = iArr[length];
                int insertionIndex = insertionIndex(i2);
                this._set[insertionIndex] = i2;
                this._values[insertionIndex] = objArr[length];
                i2 = length;
            } else {
                i2 = length;
            }
        }
    }

    public final V get(int i) {
        int index = index(i);
        return index < 0 ? null : unwrapNull(this._values[index]);
    }

    private static <V> V unwrapNull(V v) {
        return v == TObjectHash.NULL ? null : v;
    }

    public void clear() {
        super.clear();
        int[] iArr = this._set;
        Object[] objArr = this._values;
        int length = iArr.length;
        while (true) {
            int i = length - 1;
            if (length > 0) {
                iArr[i] = 0;
                objArr[i] = null;
                length = i;
            } else {
                return;
            }
        }
    }

    protected final int index(int i) {
        int[] iArr = this._set;
        Object[] objArr = this._values;
        int length = iArr.length;
        int computeHashCode = Integer.MAX_VALUE & this._hashingStrategy.computeHashCode(i);
        int i2 = computeHashCode % length;
        if (!isFree(objArr, i2) && (isRemoved(objArr, i2) || iArr[i2] != i)) {
            computeHashCode = (computeHashCode % (length - 2)) + 1;
            while (true) {
                i2 -= computeHashCode;
                if (i2 < 0) {
                    i2 += length;
                }
                if (isFree(objArr, i2) || (!isRemoved(objArr, i2) && iArr[i2] == i)) {
                    break;
                }
            }
        }
        return isFree(objArr, i2) ? -1 : i2;
    }

    private int insertionIndex(int i) {
        Object[] objArr = this._values;
        int[] iArr = this._set;
        int length = iArr.length;
        int computeHashCode = this._hashingStrategy.computeHashCode(i) & Integer.MAX_VALUE;
        int i2 = computeHashCode % length;
        if (isFree(objArr, i2)) {
            return i2;
        }
        if (isFull(objArr, i2) && iArr[i2] == i) {
            return (-i2) - 1;
        }
        int i3 = (computeHashCode % (length - 2)) + 1;
        computeHashCode = isRemoved(objArr, i2) ? i2 : -1;
        do {
            i2 -= i3;
            if (i2 < 0) {
                i2 += length;
            }
            if (computeHashCode == -1 && isRemoved(objArr, i2)) {
                computeHashCode = i2;
            }
            if (!isFull(objArr, i2)) {
                break;
            }
        } while (iArr[i2] != i);
        if (isRemoved(objArr, i2)) {
            while (!isFree(objArr, i2) && (isRemoved(objArr, i2) || iArr[i2] != i)) {
                i2 -= i3;
                if (i2 < 0) {
                    i2 += length;
                }
            }
        }
        if (isFull(objArr, i2)) {
            return (-i2) - 1;
        }
        return computeHashCode != -1 ? computeHashCode : i2;
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
        if (!(obj instanceof TIntObjectHashMap)) {
            return false;
        }
        TIntObjectHashMap tIntObjectHashMap = (TIntObjectHashMap) obj;
        if (tIntObjectHashMap.size() == size()) {
            return forEachEntry(new EqProcedure(tIntObjectHashMap));
        }
        return false;
    }

    public int hashCode() {
        Object hashProcedure = new HashProcedure();
        forEachEntry(hashProcedure);
        return hashProcedure.f9080h;
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

    public final int[] keys() {
        int[] iArr = new int[size()];
        int[] iArr2 = this._set;
        Object[] objArr = this._values;
        int length = iArr2.length;
        int i = 0;
        while (true) {
            int i2 = length - 1;
            if (length <= 0) {
                return iArr;
            }
            if (isFull(objArr, i2)) {
                length = i + 1;
                iArr[i] = iArr2[i2];
                i = length;
                length = i2;
            } else {
                length = i2;
            }
        }
    }

    private boolean forEachEntry(TIntObjectProcedure<V> tIntObjectProcedure) {
        int[] iArr = this._set;
        Object[] objArr = this._values;
        int length = iArr.length;
        while (true) {
            int i = length - 1;
            if (length <= 0) {
                return true;
            }
            if (isFull(objArr, i) && !tIntObjectProcedure.execute(iArr[i], unwrapNull(objArr[i]))) {
                return false;
            }
            length = i;
        }
    }

    public final int computeHashCode(int i) {
        return i;
    }

    public /* bridge */ /* synthetic */ Object clone() {
        TIntObjectHashMap tIntObjectHashMap = (TIntObjectHashMap) super.clone();
        tIntObjectHashMap._values = (Object[]) this._values.clone();
        return tIntObjectHashMap;
    }
}
