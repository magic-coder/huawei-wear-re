package com.huawei.appmarket.sdk.foundation.p356b.p357a.p358a.p359a;

import com.huawei.appmarket.sdk.foundation.p356b.p357a.p358a.p361d.C4265a;
import com.huawei.appmarket.sdk.foundation.p356b.p357a.p358a.p361d.C4266b;

public class C4239a {
    private byte[] f15885a;
    private int f15886b;

    public C4239a() {
        this(0);
    }

    public C4239a(int i) {
        this.f15885a = new byte[i];
        this.f15886b = 0;
    }

    public C4239a(byte[] bArr) {
        this.f15885a = C4265a.m20636a(bArr, bArr == null ? 0 : bArr.length);
        this.f15886b = this.f15885a.length;
    }

    public String toString() {
        return C4266b.m20638a(this.f15885a, this.f15886b);
    }
}
