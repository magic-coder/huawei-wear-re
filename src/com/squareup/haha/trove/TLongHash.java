package com.squareup.haha.trove;

public abstract class TLongHash extends TPrimitiveHash implements TLongHashingStrategy {
    protected TLongHashingStrategy _hashingStrategy = this;
    protected transient long[] _set;

    public Object clone() {
        TLongHash tLongHash = (TLongHash) super.clone();
        tLongHash._set = (long[]) this._set.clone();
        return tLongHash;
    }

    protected int setUp(int i) {
        int up = super.setUp(i);
        this._set = new long[up];
        return up;
    }

    public final boolean contains(long j) {
        byte[] bArr = this._states;
        long[] jArr = this._set;
        int length = bArr.length;
        int computeHashCode = Integer.MAX_VALUE & this._hashingStrategy.computeHashCode(j);
        int i = computeHashCode % length;
        if (bArr[i] != (byte) 0 && (bArr[i] == (byte) 2 || jArr[i] != j)) {
            computeHashCode = (computeHashCode % (length - 2)) + 1;
            while (true) {
                i -= computeHashCode;
                if (i < 0) {
                    i += length;
                }
                if (bArr[i] == (byte) 0 || (bArr[i] != (byte) 2 && jArr[i] == j)) {
                    break;
                }
            }
        }
        if (bArr[i] == (byte) 0) {
            i = -1;
        }
        return i >= 0;
    }

    public final boolean forEach(TLongProcedure tLongProcedure) {
        byte[] bArr = this._states;
        long[] jArr = this._set;
        int length = jArr.length;
        while (true) {
            int i = length - 1;
            if (length <= 0) {
                return true;
            }
            if (bArr[i] == (byte) 1 && !tLongProcedure.execute(jArr[i])) {
                return false;
            }
            length = i;
        }
    }

    protected void removeAt(int i) {
        this._set[i] = 0;
        super.removeAt(i);
    }

    protected final int insertionIndex(long j) {
        byte[] bArr = this._states;
        long[] jArr = this._set;
        int length = bArr.length;
        int computeHashCode = Integer.MAX_VALUE & this._hashingStrategy.computeHashCode(j);
        int i = computeHashCode % length;
        if (bArr[i] == (byte) 0) {
            return i;
        }
        if (bArr[i] == (byte) 1 && jArr[i] == j) {
            return (-i) - 1;
        }
        int i2 = (computeHashCode % (length - 2)) + 1;
        do {
            i -= i2;
            if (i < 0) {
                i += length;
            }
            if (bArr[i] != (byte) 1) {
                break;
            }
        } while (jArr[i] != j);
        if (bArr[i] != (byte) 2) {
            return bArr[i] == (byte) 1 ? (-i) - 1 : i;
        } else {
            computeHashCode = i;
            while (bArr[computeHashCode] != (byte) 0 && (bArr[computeHashCode] == (byte) 2 || jArr[computeHashCode] != j)) {
                computeHashCode -= i2;
                if (computeHashCode < 0) {
                    computeHashCode += length;
                }
            }
            if (bArr[computeHashCode] == (byte) 1) {
                return (-computeHashCode) - 1;
            }
            return i;
        }
    }

    public final int computeHashCode(long j) {
        return (int) ((j >> 32) ^ j);
    }
}
