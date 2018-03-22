package com.google.android.gms.common;

import java.lang.ref.WeakReference;

abstract class C0448l extends C0446j {
    private static final WeakReference<byte[]> f463b = new WeakReference(null);
    private WeakReference<byte[]> f464a = f463b;

    C0448l(byte[] bArr) {
        super(bArr);
    }

    byte[] mo1782c() {
        byte[] bArr;
        synchronized (this) {
            bArr = (byte[]) this.f464a.get();
            if (bArr == null) {
                bArr = mo1783d();
                this.f464a = new WeakReference(bArr);
            }
        }
        return bArr;
    }

    protected abstract byte[] mo1783d();
}
