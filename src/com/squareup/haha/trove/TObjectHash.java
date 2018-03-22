package com.squareup.haha.trove;

public abstract class TObjectHash<T> extends THash implements TObjectHashingStrategy<T> {
    public static final NULL NULL = new NULL();
    public static final Object REMOVED = new Object();
    protected final TObjectHashingStrategy<T> _hashingStrategy;
    protected transient Object[] _set;

    class NULL {
        NULL() {
        }
    }

    public TObjectHash() {
        this._hashingStrategy = this;
    }

    public TObjectHash(TObjectHashingStrategy<T> tObjectHashingStrategy) {
        this._hashingStrategy = tObjectHashingStrategy;
    }

    public TObjectHash(int i) {
        super(i);
        this._hashingStrategy = this;
    }

    public TObjectHash(int i, TObjectHashingStrategy<T> tObjectHashingStrategy) {
        super(i);
        this._hashingStrategy = tObjectHashingStrategy;
    }

    public TObjectHash(int i, float f) {
        super(i, f);
        this._hashingStrategy = this;
    }

    public TObjectHash(int i, float f, TObjectHashingStrategy<T> tObjectHashingStrategy) {
        super(i, f);
        this._hashingStrategy = tObjectHashingStrategy;
    }

    public TObjectHash<T> clone() {
        TObjectHash<T> tObjectHash = (TObjectHash) super.clone();
        tObjectHash._set = (Object[]) this._set.clone();
        return tObjectHash;
    }

    protected int capacity() {
        return this._set.length;
    }

    protected void removeAt(int i) {
        this._set[i] = REMOVED;
        super.removeAt(i);
    }

    protected int setUp(int i) {
        int up = super.setUp(i);
        this._set = new Object[up];
        return up;
    }

    public boolean forEach(TObjectProcedure<T> tObjectProcedure) {
        Object[] objArr = this._set;
        int length = objArr.length;
        while (true) {
            int i = length - 1;
            if (length <= 0) {
                return true;
            }
            if (objArr[i] != null && objArr[i] != REMOVED && !tObjectProcedure.execute(objArr[i])) {
                return false;
            }
            length = i;
        }
    }

    public boolean contains(Object obj) {
        return index(obj) >= 0;
    }

    protected int index(T t) {
        int i;
        Object obj;
        Object[] objArr = this._set;
        int length = objArr.length;
        int computeHashCode = this._hashingStrategy.computeHashCode(t) & Integer.MAX_VALUE;
        int i2 = computeHashCode % length;
        Object obj2 = objArr[i2];
        if (obj2 != null && (obj2 == REMOVED || !this._hashingStrategy.equals(obj2, t))) {
            computeHashCode = (computeHashCode % (length - 2)) + 1;
            i = i2;
            while (true) {
                i -= computeHashCode;
                if (i < 0) {
                    i += length;
                }
                obj = objArr[i];
                if (obj == null || (obj != REMOVED && this._hashingStrategy.equals(obj, t))) {
                    break;
                }
            }
        } else {
            Object obj3 = obj2;
            i = i2;
            obj = obj3;
        }
        return obj == null ? -1 : i;
    }

    protected int insertionIndex(T t) {
        Object[] objArr = this._set;
        int length = objArr.length;
        int computeHashCode = this._hashingStrategy.computeHashCode(t) & Integer.MAX_VALUE;
        int i = computeHashCode % length;
        Object obj = objArr[i];
        if (obj == null) {
            return i;
        }
        if (obj != REMOVED && this._hashingStrategy.equals(obj, t)) {
            return (-i) - 1;
        }
        Object obj2;
        int i2 = (computeHashCode % (length - 2)) + 1;
        int i3 = obj == REMOVED ? i : -1;
        while (true) {
            computeHashCode = i - i2;
            if (computeHashCode < 0) {
                computeHashCode += length;
            }
            Object obj3 = objArr[computeHashCode];
            if (i3 == -1 && obj3 == REMOVED) {
                i3 = computeHashCode;
            }
            if (obj3 != null && obj3 != REMOVED && !this._hashingStrategy.equals(obj3, t)) {
                i = computeHashCode;
            }
        }
        Object obj4;
        if (obj3 == REMOVED) {
            obj4 = obj3;
            i = computeHashCode;
            obj2 = obj4;
            while (obj2 != null && (obj2 == REMOVED || !this._hashingStrategy.equals(obj2, t))) {
                computeHashCode = i - i2;
                if (computeHashCode < 0) {
                    computeHashCode += length;
                }
                i = computeHashCode;
                obj2 = objArr[computeHashCode];
            }
        } else {
            obj4 = obj3;
            i = computeHashCode;
            obj2 = obj4;
        }
        if (obj2 == null || obj2 == REMOVED) {
            return i3 != -1 ? i3 : i;
        } else {
            return (-i) - 1;
        }
    }

    public final int computeHashCode(T t) {
        return t != null ? t.hashCode() : 0;
    }

    public final boolean equals(T t, T t2) {
        if (t != null) {
            return t.equals(t2);
        }
        return t2 == null;
    }

    protected final void throwObjectContractViolation(Object obj, Object obj2) throws IllegalArgumentException {
        throw new IllegalArgumentException("Equal objects must have equal hashcodes. During rehashing, Trove discovered that the following two objects claim to be equal (as in java.lang.Object.equals() or TObjectHashingStrategy.equals()) but their hashCodes (or those calculated by your TObjectHashingStrategy) are not equal.This violates the general contract of java.lang.Object.hashCode().  See bullet point two in that method's documentation. object #1 =" + obj + (obj == null ? "" : " (" + obj.getClass() + ")") + ", hashCode=" + this._hashingStrategy.computeHashCode(obj) + "; object #2 =" + obj2 + (obj2 == null ? "" : " (" + obj2.getClass() + ")") + ", hashCode=" + this._hashingStrategy.computeHashCode(obj2));
    }
}
