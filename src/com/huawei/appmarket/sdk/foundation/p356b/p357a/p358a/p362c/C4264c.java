package com.huawei.appmarket.sdk.foundation.p356b.p357a.p358a.p362c;

import com.huawei.appmarket.sdk.foundation.p356b.p357a.p358a.p362c.p363a.C4258k;

public class C4264c {
    private C4258k f15935a;

    public C4264c() {
        this(null, null);
    }

    public C4264c(C4258k c4258k) {
        this.f15935a = c4258k;
    }

    public C4264c(String str, String str2) {
        this(new C4258k(str, str2));
    }

    public C4258k m20632a() {
        if (this.f15935a == null) {
            this.f15935a = new C4258k();
        }
        return this.f15935a;
    }

    public C4258k m20633a(String str) {
        return m20632a().m20610d(str);
    }

    public <T> void m20634a(String str, T t) {
        if (t != null) {
            m20633a(str).m20604a((Object) t);
        }
    }

    public String m20635b() {
        return m20632a().m20614f();
    }

    public String toString() {
        return m20632a().toString();
    }
}
