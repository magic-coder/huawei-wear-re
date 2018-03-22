package com.fenda.hwbracelet.p262e;

import java.nio.ByteBuffer;

/* compiled from: XMessage */
public abstract class C3598a {
    protected ByteBuffer f13768a;

    public abstract byte[] mo4217b();

    public void mo4216a(byte[] bArr) {
        this.f13768a.put(bArr);
    }

    public ByteBuffer mo4215a() {
        return this.f13768a;
    }
}
