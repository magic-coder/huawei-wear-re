package com.google.zxing;

import java.util.EnumMap;
import java.util.Map;

/* compiled from: Result */
public final class C3934m {
    private final String f15122a;
    private final byte[] f15123b;
    private C3922o[] f15124c;
    private final C3709a f15125d;
    private Map<C3935n, Object> f15126e;
    private final long f15127f;

    public C3934m(String str, byte[] bArr, C3922o[] c3922oArr, C3709a c3709a) {
        this(str, bArr, c3922oArr, c3709a, System.currentTimeMillis());
    }

    public C3934m(String str, byte[] bArr, C3922o[] c3922oArr, C3709a c3709a, long j) {
        this.f15122a = str;
        this.f15123b = bArr;
        this.f15124c = c3922oArr;
        this.f15125d = c3709a;
        this.f15126e = null;
        this.f15127f = j;
    }

    public String m19572a() {
        return this.f15122a;
    }

    public byte[] m19576b() {
        return this.f15123b;
    }

    public C3922o[] m19577c() {
        return this.f15124c;
    }

    public C3709a m19578d() {
        return this.f15125d;
    }

    public Map<C3935n, Object> m19579e() {
        return this.f15126e;
    }

    public void m19573a(C3935n c3935n, Object obj) {
        if (this.f15126e == null) {
            this.f15126e = new EnumMap(C3935n.class);
        }
        this.f15126e.put(c3935n, obj);
    }

    public void m19574a(Map<C3935n, Object> map) {
        if (map == null) {
            return;
        }
        if (this.f15126e == null) {
            this.f15126e = map;
        } else {
            this.f15126e.putAll(map);
        }
    }

    public void m19575a(C3922o[] c3922oArr) {
        Object obj = this.f15124c;
        if (obj == null) {
            this.f15124c = c3922oArr;
        } else if (c3922oArr != null && c3922oArr.length > 0) {
            Object obj2 = new C3922o[(obj.length + c3922oArr.length)];
            System.arraycopy(obj, 0, obj2, 0, obj.length);
            System.arraycopy(c3922oArr, 0, obj2, obj.length, c3922oArr.length);
            this.f15124c = obj2;
        }
    }

    public String toString() {
        return this.f15122a;
    }
}
