package com.google.android.gms.internal;

import java.io.IOException;
import java.lang.reflect.Array;

public class el<M extends ek<M>, T> {
    protected final int f744a;
    protected final Class<T> f745b;
    public final int f746c;
    protected final boolean f747d;

    int m1404a(Object obj) {
        return this.f747d ? m1406b(obj) : m1408c(obj);
    }

    void m1405a(Object obj, ei eiVar) throws IOException {
        if (this.f747d) {
            m1409c(obj, eiVar);
        } else {
            m1407b(obj, eiVar);
        }
    }

    protected int m1406b(Object obj) {
        int i = 0;
        int length = Array.getLength(obj);
        for (int i2 = 0; i2 < length; i2++) {
            if (Array.get(obj, i2) != null) {
                i += m1408c(Array.get(obj, i2));
            }
        }
        return i;
    }

    protected void m1407b(Object obj, ei eiVar) {
        try {
            eiVar.m1402g(this.f746c);
            switch (this.f744a) {
                case 10:
                    eq eqVar = (eq) obj;
                    int b = et.m1451b(this.f746c);
                    eiVar.m1388a(eqVar);
                    eiVar.m1400e(b, 4);
                    return;
                case 11:
                    eiVar.m1394b((eq) obj);
                    return;
                default:
                    throw new IllegalArgumentException("Unknown type " + this.f744a);
            }
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
        throw new IllegalStateException(e);
    }

    protected int m1408c(Object obj) {
        int b = et.m1451b(this.f746c);
        switch (this.f744a) {
            case 10:
                return ei.m1355b(b, (eq) obj);
            case 11:
                return ei.m1364c(b, (eq) obj);
            default:
                throw new IllegalArgumentException("Unknown type " + this.f744a);
        }
    }

    protected void m1409c(Object obj, ei eiVar) {
        int length = Array.getLength(obj);
        for (int i = 0; i < length; i++) {
            Object obj2 = Array.get(obj, i);
            if (obj2 != null) {
                m1407b(obj2, eiVar);
            }
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof el)) {
            return false;
        }
        el elVar = (el) obj;
        return this.f744a == elVar.f744a && this.f745b == elVar.f745b && this.f746c == elVar.f746c && this.f747d == elVar.f747d;
    }

    public int hashCode() {
        return (this.f747d ? 1 : 0) + ((((((this.f744a + 1147) * 31) + this.f745b.hashCode()) * 31) + this.f746c) * 31);
    }
}
