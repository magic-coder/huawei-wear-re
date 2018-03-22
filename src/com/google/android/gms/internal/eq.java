package com.google.android.gms.internal;

import java.io.IOException;

public abstract class eq {
    protected volatile int f710p = -1;

    public static final <T extends eq> T m1278a(T t, byte[] bArr) throws ep {
        return m1281b(t, bArr, 0, bArr.length);
    }

    public static final void m1279a(eq eqVar, byte[] bArr, int i, int i2) {
        try {
            ei a = ei.m1350a(bArr, i, i2);
            eqVar.mo1871a(a);
            a.m1391b();
        } catch (Throwable e) {
            throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).", e);
        }
    }

    public static final byte[] m1280a(eq eqVar) {
        byte[] bArr = new byte[eqVar.m1287g()];
        m1279a(eqVar, bArr, 0, bArr.length);
        return bArr;
    }

    public static final <T extends eq> T m1281b(T t, byte[] bArr, int i, int i2) throws ep {
        try {
            eh a = eh.m1317a(bArr, i, i2);
            t.mo1875b(a);
            a.m1321a(0);
            return t;
        } catch (ep e) {
            throw e;
        } catch (IOException e2) {
            throw new RuntimeException("Reading from a byte array threw an IOException (should never happen).");
        }
    }

    public void mo1871a(ei eiVar) throws IOException {
    }

    protected int mo1872b() {
        return 0;
    }

    public abstract eq mo1875b(eh ehVar) throws IOException;

    public /* synthetic */ Object clone() throws CloneNotSupportedException {
        return mo1874e();
    }

    public eq mo1874e() throws CloneNotSupportedException {
        return (eq) super.clone();
    }

    public int m1286f() {
        if (this.f710p < 0) {
            m1287g();
        }
        return this.f710p;
    }

    public int m1287g() {
        int b = mo1872b();
        this.f710p = b;
        return b;
    }

    public String toString() {
        return er.m1440a(this);
    }
}
